package net.howardchung.htimer;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StopwatchPanel extends LinearLayout {

	Context myContext;
	private UpdateHandler handler;

	public StopwatchPanel(Context context) {
		super(context);
		myContext = context;
		createPanel();
	}

	public UpdateHandler getHandler() {
		return handler;
	}

	public void createPanel() {
		TextView tv = new TextView(myContext);
		tv.setText("00:00:00.000", null);
		tv.setTextSize(40);
		handler = new UpdateHandler(tv);
		this.addView(tv);

		Button b = new Button(myContext);
		b.setText(R.string.start_stop);
		View.OnClickListener myhandler1 = new View.OnClickListener() {
			public void onClick(View v) {
				startStopTimer(handler);
			}
		};
		b.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT, (float) 0.5));
		b.setOnClickListener(myhandler1);
		this.addView(b);

		Button r = new Button(myContext);
		r.setText(R.string.reset);
		View.OnClickListener myhandler2 = new View.OnClickListener() {
			public void onClick(View v) {
				reset(handler);
			}
		};
		r.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT, (float) 0.5));
		r.setOnClickListener(myhandler2);
		this.addView(r);
	}

	public void startStopTimer(UpdateHandler handler) {
		boolean started = handler.getTimer().isRunning();
		if (!started) {
			handler.sendEmptyMessage(UpdateHandler.MSG_START_TIMER);
		} else {
			handler.sendEmptyMessage(UpdateHandler.MSG_STOP_TIMER);
		}
		vibrate(75);
	}

	public void reset(UpdateHandler handler) {
		handler.sendEmptyMessage(UpdateHandler.MSG_RESET_TIMER);
		vibrate(100);
	}

	private void vibrate(int time) {
		Vibrator v = (Vibrator) myContext
				.getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(time);
	}

}
