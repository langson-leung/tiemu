package com.michaelpardo.tiemu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.michaelpardo.tiemu.R;
import com.michaelpardo.tiemu.thread.ProcessorThread;

public class TIEmuActivity extends Activity {
	private static final int RESET = 0;
	
	private ProcessorThread mProcessorThread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mProcessorThread = new ProcessorThread();
        mProcessorThread.start();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, RESET, 0, "Open").setIcon(android.R.drawable.ic_menu_revert);

		return true;
	}
    
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case RESET:
				resetProcessor();
				return true;
		}

		return false;
	}
	
	private void resetProcessor() {
		mProcessorThread.reset();
	}
}