package pl.marcinmierzejewski;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ArticlePreviewAcivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.article_preview);
		
		
		if(savedInstanceState!=null)
		{
			TextView pdate=(TextView)findViewById(R.id.pdate);
			TextView pdesc=(TextView)findViewById(R.id.pdesc);
			TextView ptitle=(TextView)findViewById(R.id.ptitle);
			Button plink=(Button)findViewById(R.id.plink);
		
			ArticleDataSource ads= new ArticleDataSource(this);
			Article art=ads.getAllArts(false).get(0);
			
			pdate.setText(art.date);
			pdesc.setText(art.description);
			ptitle.setText(art.title);
			
			
			plink.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO intent to browser
					Toast.makeText(getApplicationContext(), "TODO Intent", Toast.LENGTH_SHORT).show();					
				}
			});
			
		}


	}
}
