package its.my.time.pages.editable.events.task.details;

import its.my.time.data.bdd.events.eventBase.EventBaseBean;
import its.my.time.pages.editable.events.event.details.DetailsFragment;
import android.view.View;

public class TaskDetailsFragment extends DetailsFragment {


	public TaskDetailsFragment(EventBaseBean event, int typeEvent) {
		super(event, typeEvent);
	}
	
	public View getCustomView() {
		return null;
	}
	
	@Override
	public void launchEdit() {
		super.launchEdit();
	}

	@Override
	public void launchSave() {
		super.launchSave();
	}

	@Override
	public void launchCancel() {
		super.launchSave();
	}
}