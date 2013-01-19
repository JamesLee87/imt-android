package its.my.time.pages.editable.events.event;

import java.util.ArrayList;

import its.my.time.pages.editable.events.BaseEventActivity;
import its.my.time.view.menu.MenuGroupe;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

import com.actionbarsherlock.R;
import com.actionbarsherlock.app.ActionBar;

public class EventActivity extends BaseEventActivity {

	@Override
	public  void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		mPager.setAdapter(new EventPagerAdapter(getSupportFragmentManager(),
				event));
	}

	@Override
	protected void onViewCreated() {
	}
	@Override
	protected CharSequence getActionBarTitle() {
		return "Nouvel �v�nement";
	}

	@Override
	protected void initialiseActionBar() {

		super.initialiseActionBar();

		ActionBar mActionBar = getSupportActionBar();

		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		String[] items = new String[] { EventPagerAdapter.TITLE_PAGE_DETAILS,
				EventPagerAdapter.TITLE_PAGE_PARTICIPANTS,
				EventPagerAdapter.TITLE_PAGE_COMMENTAIRES,
				EventPagerAdapter.TITLE_PAGE_PJ };
		mActionBar.setListNavigationCallbacks(new ArrayAdapter<String>(this,
				R.layout.navigation_spinner_item, items), navigationListener);
	}

	
	
	
	
	
	
	
	
	
	@Override
	protected void onMenuGroupSwitch(View v, int positionGroup,
			boolean isChecked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMenuItemSwitch(View v, int positionGroup,
			int positionObjet, boolean isChecked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMenuGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMenuChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<MenuGroupe> onMainMenuCreated(
			ArrayList<MenuGroupe> menuGroupes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean onBackButtonPressed() {
		// TODO Auto-generated method stub
		return false;
	}

}
