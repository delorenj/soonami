package epc.labs.soonami;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TorrentSearch extends AsyncTask<String, Integer, String> {
	private static String TAG = "Soonami";
	private Activity mActivity;

	@Override
	protected String doInBackground(String... params) {
		Log.i(TAG, "Starting query in background: " + params[0]);
		return query(params[0]);
	}
	
	private String query(String string) {
		return "test.torrent";
	}

	@Override
	protected void onPostExecute(String match) {
		ProgressBar pb = (ProgressBar) mActivity.findViewById(R.id.progress);
		pb.setVisibility(ProgressBar.GONE);
		TextView tv =(TextView) mActivity.findViewById(R.id.result);
		tv.setText(match);
	}
	
	public void setActivity(Activity a) {
		mActivity = a;
	}
	
}
