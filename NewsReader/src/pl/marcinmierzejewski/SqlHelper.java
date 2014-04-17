package pl.marcinmierzejewski;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SqlHelper extends SQLiteOpenHelper {

	public static final String TABLE_ARTICLES = "articles";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_DESCRIPTION = "description";
	public static final String COLUMN_LINK = "link";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_LIKED = "liked";

	private static final String DATABASE_NAME = "articles.db";
	private static final int DATABASE_VERSION = 2;

	private static final String DATABASE_CREATE = "create table "
			+ TABLE_ARTICLES + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_TITLE
			+ " text not null, " + COLUMN_DESCRIPTION + " text not null, "
			+ COLUMN_LINK + " text not null, " + COLUMN_DATE + " text not null, "
			+ COLUMN_LIKED + " integer not null);";

	public SqlHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		
		Log.d("SQL",DATABASE_CREATE);
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ARTICLES);
		onCreate(db);
	}

}