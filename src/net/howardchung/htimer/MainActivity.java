package net.howardchung.htimer;

import java.util.HashMap;

import net.howardchung.htimer.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.chungsnet.htimer.MESSAGE";
	LayoutInflater inflater;
	ScrollView sv;
	LinearLayout ll;
	HashMap<StopwatchPanel, Stopwatch> stopwatches;

	// TODO start all, stop all, reset all
	// TODO add/remove timers

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		sv = (ScrollView) inflater.inflate(R.layout.activity_main, null);
		ll = (LinearLayout) sv.findViewById(R.id.linearlayout);
		stopwatches = new HashMap<StopwatchPanel, Stopwatch>();
		this.setContentView(sv);
		// first one added by default, all others require button
		addStopwatch();
	}

	public void addStopwatch() {
		StopwatchPanel newsw = new StopwatchPanel(this);
		ll.addView(newsw);
		stopwatches.put(newsw, newsw.getHandler().getTimer());
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
