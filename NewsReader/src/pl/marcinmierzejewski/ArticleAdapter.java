package pl.marcinmierzejewski;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ArticleAdapter extends BaseAdapter {

	private LayoutInflater layoutInflater;
	private List<Article> articles;
	private ArticleDataSource datasource;
	private Context context;

	public ArticleAdapter(Context acontext, Boolean onlyLiked) {

		context = acontext;
		articles = new ArrayList<Article>();
		
		
		datasource = new ArticleDataSource(context);
		datasource.open();
		
		
		
		articles = datasource.getAllArts(onlyLiked);

		layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		convertView = layoutInflater.inflate(R.layout.article_list_item, null);

		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView date = (TextView) convertView.findViewById(R.id.date);
		ImageView star = (ImageView) convertView.findViewById(R.id.star);

		title.setText(articles.get(position).title);
		date.setText(articles.get(position).date);

		if (articles.get(position).liked != 0)
			star.setBackgroundResource(R.drawable.favo_on);

		convertView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "TODO intent", Toast.LENGTH_SHORT).show();
				Intent i=new Intent(v.getContext(),ArticlePreviewAcivity.class);
				//v.getContext().startActivity(i);
			}
		});
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return articles.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
