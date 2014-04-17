package pl.marcinmierzejewski;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class GetRss extends BroadcastReceiver {
	private ArticleDataSource ads;
	long lastTimeStamp;

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("GETRSS","ON recive");
		//ads = new ArticleDataSource(context);
		//AddNewArticles task = new AddNewArticles();
		//task.execute(ads);
	}

	private class AddNewArticles extends AsyncTask<ArticleDataSource, Integer, String> {

		@Override
		protected String doInBackground(ArticleDataSource... arg) {
			//arg[0].createArticle("New", "Art", "1asdads", "asdasdasd", 1);
			//Log.d("GETRSS","AS TASK");
			return null;
		}

		
	

	}

}
