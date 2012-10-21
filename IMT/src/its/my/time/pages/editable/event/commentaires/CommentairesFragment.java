package its.my.time.pages.editable.event.commentaires;

import its.my.time.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;

public class CommentairesFragment extends SherlockFragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		RelativeLayout mView = (RelativeLayout) inflater.inflate(R.layout.activity_event_commentaires, null);
		ListView mListView = (ListView)mView.findViewById(R.id.event_coment_listeComent);
		mListView.setAdapter(new CommentairesAdapter(getSherlockActivity()));
		
		return mView;
	}
}
