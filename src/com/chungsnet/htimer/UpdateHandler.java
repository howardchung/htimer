package com.chungsnet.htimer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Given a textView, updates that view with the elapsed time.
 * 
 * @author Howard
 * 
 */
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
public class UpdateHandler extends Handler {
	static final int MSG_START_TIMER = 0;
	static final int MSG_STOP_TIMER = 1;
	final int MSG_UPDATE_TIMER = 2;
	static final int MSG_RESET_TIMER = 3;
	final int REFRESH_RATE = 10; // 1000=one second, 1=1/1000 second
	Stopwatch timer = new Stopwatch();
	TextView tv;
	SimpleDateFormat time;

	public UpdateHandler(TextView textview) {
		tv = textview;
		time = new SimpleDateFormat("HH:mm:ss.SSS");
		time.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	public Stopwatch getTimer() {
		return timer;
	}

	@Override
	public void handleMessage(Message msg) {
		super.handleMessage(msg);
		long millis = timer.getElapsedTime();
		switch (msg.what) {
		case MSG_START_TIMER:
			timer.start();
			sendEmptyMessage(MSG_UPDATE_TIMER);
			break;
		case MSG_UPDATE_TIMER:
			tv.setText(time.format(new Date(millis)).toString());
			sendEmptyMessageDelayed(MSG_UPDATE_TIMER, REFRESH_RATE);
			break;
		case MSG_STOP_TIMER:
			removeMessages(MSG_UPDATE_TIMER); // no more updates.
			timer.stop();// stop timer
			tv.setText(time.format(new Date(millis)).toString());
			break;
		case MSG_RESET_TIMER:
			timer.reset();
			tv.setText(time.format(new Date(0)).toString());
			break;

		default:
			break;
		}
	}
}
