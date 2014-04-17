package pl.marcinmierzejewski;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFragment extends Fragment {

	Boolean onlyLiked=false;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_home, container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		if(getArguments()!=null)
			onlyLiked=getArguments().getBoolean("onlyLiked",false);
		
		
		ListView articleList = (ListView) getView().findViewById(
				R.id.article_list);
		ArticleAdapter adapterListViewMain = new ArticleAdapter(getActivity(),
				onlyLiked);
		articleList.setAdapter(adapterListViewMain);
	}

}
