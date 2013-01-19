package its.my.time.pages.editable;

import its.my.time.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.fonts.mooncake.MooncakeIcone;

public abstract class BaseActivity extends SherlockFragmentActivity {

	private Menu menu;

	public static final int INDEX_MENU_EDIT = 0;
	public static final int INDEX_MENU_SAVE = 1;
	public static final int INDEX_MENU_CANCEL = 2;

	@Override
	protected void onCreate(Bundle bundle) {
		initialiseActionBar();
		super.onCreate(bundle);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);
	}

	protected void initialiseActionBar() {
		ActionBar mActionBar = getSupportActionBar();
		mActionBar.setTitle(getActionBarTitle());
		mActionBar.setDisplayHomeAsUpEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_header));
	}

	protected abstract CharSequence getActionBarTitle();

	private OnClickListener mOnIconeClickLIstener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.menu_edit:
				launchEdit();
				return;
			case R.id.menu_cancel:
				launchCancel();
				return;
			case R.id.menu_save:
				launchSave();
				return;
			case android.R.id.home:
				finish();
				return;
			default:
				return;
			}	
		}
	};

	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_editable, menu);

		MooncakeIcone icone = new MooncakeIcone(this);
		icone.setTextSize(30);
		icone.setIconeRes(MooncakeIcone.icon_edit);
		icone.setTextColor(getResources().getColor(R.color.grey));
		icone.setId(R.id.menu_edit);
		icone.setPadding(20, 0, 20, 0);
		icone.setOnClickListener(mOnIconeClickLIstener);
		menu.getItem(INDEX_MENU_EDIT).setActionView(icone);

		icone = new MooncakeIcone(this);
		icone.setTextSize(30);
		icone.setIconeRes(MooncakeIcone.icon_install);
		icone.setTextColor(getResources().getColor(R.color.grey));
		icone.setId(R.id.menu_save);
		icone.setPadding(20, 0, 20, 0);
		icone.setOnClickListener(mOnIconeClickLIstener);
		menu.getItem(INDEX_MENU_SAVE).setActionView(icone);

		icone = new MooncakeIcone(this);
		icone.setTextSize(30);
		icone.setIconeRes(MooncakeIcone.icon_remove_circle);
		icone.setTextColor(getResources().getColor(R.color.grey));
		icone.setId(R.id.menu_cancel);
		icone.setPadding(20, 0, 20, 0);
		icone.setOnClickListener(mOnIconeClickLIstener );
		menu.getItem(INDEX_MENU_CANCEL).setActionView(icone);

		this.menu = menu;
		boolean res = super.onCreateOptionsMenu(menu);
		onViewCreated();
		return res;
	}

	private void launchEdit() {
		menu.getItem(INDEX_MENU_EDIT).setVisible(false);
		menu.getItem(INDEX_MENU_SAVE).setVisible(true);
		menu.getItem(INDEX_MENU_CANCEL).setVisible(true);
		showEdit();
	}

	private void launchSave() {
		menu.getItem(INDEX_MENU_EDIT).setVisible(true);
		menu.getItem(INDEX_MENU_SAVE).setVisible(false);
		menu.getItem(INDEX_MENU_CANCEL).setVisible(false);
		showSave();
	}

	private void launchCancel() {
		menu.getItem(INDEX_MENU_EDIT).setVisible(true);
		menu.getItem(INDEX_MENU_SAVE).setVisible(false);
		menu.getItem(INDEX_MENU_CANCEL).setVisible(false);
		showCancel();
	}

	public void launchEditMode() {
		launchEdit();
	}
	
	protected abstract void showEdit();
	protected abstract void showSave();
	protected abstract void showCancel();
	protected abstract void onViewCreated();
}
