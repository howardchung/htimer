package com.chungsnet.htimer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Button;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.chungsnet.htimer.MESSAGE";
	LayoutInflater inflater;
	ScrollView sv;
	LinearLayout ll;
	ArrayList<StopwatchPanel> stopwatches;

	// TODO start all, stop all, reset all
	// TODO add/remove timers
	// TODO wakelock

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		sv = (ScrollView) inflater.inflate(R.layout.activity_main, null);
		ll = (LinearLayout) sv.findViewById(R.id.linearlayout);
		stopwatches = new ArrayList<StopwatchPanel>();
		this.setContentView(sv);
		//first one added by default, all others require button
		addStopwatch();
	}

	public void addStopwatch() {
		StopwatchPanel newsw = new StopwatchPanel(this);
		ll.addView(newsw);
		stopwatches.add(newsw);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void resetAll(View view) {
		// TODO loop through, reset all
		// this should go through a list of stopwatches, calling reset on each
		// one
	}

	public void stopAll(View view) {
		// TODO
	}

	public void startAll(View view) {
		// TODO
	}

}
