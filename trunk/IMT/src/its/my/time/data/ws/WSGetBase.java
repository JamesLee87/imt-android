package its.my.time.data.ws;

import its.my.time.util.PreferencesUtil;

import java.lang.reflect.ParameterizedType;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

import android.app.Activity;
import android.util.Log;

public abstract class WSGetBase<T> extends WSBase{
	Class<T> persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	private int id;
	private GetCallback<T> callback;

	public WSGetBase(Activity context, int id, GetCallback<T> callBack) {
		super(context, callBack);
		this.id = id;
		this.callback = callBack;
	}

	@Override
	protected Exception run() {
		if(retreiveObject() != null){
			return null;
		} else {
			return null;
		}
	}
	
	

	public T retreiveObject() {
		try {
			HttpClient client = createClient();
			String urlStr = getUrl();
			URI website;
			if(urlStr.startsWith("/")) {
				urlStr = urlStr.substring(1);
			}
			if(!urlStr.endsWith("/")) {
				urlStr = urlStr + "/";
			}
			website = new URI(URL_BASE + urlStr + id + ".json");	

			HttpGet request = new HttpGet();
			String accessToken = PreferencesUtil.getCurrentAccessToken();
			request.setHeader("Authorization", "Bearer "+accessToken);
			request.setURI(website);
			HttpResponse response = client.execute(request);
			String result = EntityUtils.toString(response.getEntity());
			Log.d("WS",result);
			ObjectMapper mapper = new ObjectMapper();
			T object = mapper.readValue(result, persistentClass);
			if(callback != null) {
				callback.onGetObject(object);
			}
			return object;
		} catch (Exception e) {
			return null;
		}
	}

	public abstract String getUrl();

	public interface GetCallback<T> extends Callback {
		public void done(Exception e);
		public void onGetObject(T object);
	}
}
