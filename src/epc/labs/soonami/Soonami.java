package epc.labs.soonami;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Soonami extends Activity {
	private static final String TAG = "Soonami";

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		EditText tv = (EditText) findViewById(R.id.query_text);
		Button button = (Button) findViewById(R.id.query_button);

		tv.setOnKeyListener(new OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if ((event.getAction() == KeyEvent.ACTION_DOWN)
						&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
					executeQuery();
					return true;
				}
				return false;
			}
		});

		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				executeQuery();
			}
		});
	}

	protected void executeQuery() {
		ProgressBar pb = (ProgressBar) findViewById(R.id.progress);
		pb.setVisibility(1);
		EditText tv = (EditText) findViewById(R.id.query_text);
		TorrentSearch query = new TorrentSearch();
		query.setActivity(this);
		query.execute(tv.getText().toString());
		InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(tv.getWindowToken(), 0);
	}
	
}
