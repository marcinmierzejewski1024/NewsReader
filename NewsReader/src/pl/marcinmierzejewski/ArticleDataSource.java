package pl.marcinmierzejewski;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ArticleDataSource {
	private SQLiteDatabase database;
	private SqlHelper dbHelper;
	private String[] allColumns = { SqlHelper.COLUMN_ID,
			SqlHelper.COLUMN_TITLE, SqlHelper.COLUMN_DESCRIPTION,
			SqlHelper.COLUMN_LINK, SqlHelper.COLUMN_DATE,
			SqlHelper.COLUMN_LIKED };

	public ArticleDataSource(Context context) {
		dbHelper = new SqlHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Article createArticle(String title,String desc,String link,String date,int liked) {
		ContentValues values = new ContentValues();
		values.put(SqlHelper.COLUMN_TITLE, title);
		values.put(SqlHelper.COLUMN_DESCRIPTION, desc);
		values.put(SqlHelper.COLUMN_LINK, link);
		values.put(SqlHelper.COLUMN_DATE, date);
		values.put(SqlHelper.COLUMN_LIKED, liked);
		
		long insertId = database.insert(SqlHelper.TABLE_ARTICLES, null,
				values);
		Cursor cursor = database.query(SqlHelper.TABLE_ARTICLES,
				allColumns, SqlHelper.COLUMN_ID + " = " + insertId, null,
				null, null, null);
		cursor.moveToFirst();
		Article newArt = cursorToArt(cursor);
		cursor.close();
		return newArt;
	}

	public void deleteArt(Article art) {
		long id = art.id;
		
		database.delete(SqlHelper.TABLE_ARTICLES, SqlHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Article> getAllArts(Boolean onlyLiked) {
		List<Article> arts = new ArrayList<Article>();

		Cursor cursor = database.query(SqlHelper.TABLE_ARTICLES,
				allColumns, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Article art = cursorToArt(cursor);
			if(!(onlyLiked && art.liked==0))
				arts.add(art);
			
			cursor.moveToNext();
		}
		
		cursor.close();
		return arts;
	}

	private Article cursorToArt(Cursor cursor) {
		Article art = new Article();
		art.id=cursor.getLong(0);
		art.title=cursor.getString(1);
		art.description=cursor.getString(2);
		art.link=cursor.getString(3);
		art.date=cursor.getString(4);
		art.liked=cursor.getInt(5);
		
		return art;
	}
}
