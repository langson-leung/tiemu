package com.michaelpardo.tiemu.thread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.util.Log;

public class ProcessorThread extends Thread {
	// ######################################################################
	// ### PROPERTIES
	
	private boolean mIsRunning;
	public boolean isRunning() { return mIsRunning; }	
	
	// ######################################################################
	// ### MAIN PROCCESS
	
	@Override
	public void run() {
		setup();
		
		while(mIsRunning) {
			
		}
		
		cleanUp();
	}
	
	// ######################################################################
	// ### HELPER METHODS
	
	public void cleanUp() {
		
	}
	
	public void reset() {
		
	}
	
	private void setup() {
		try {
			
			InputStream is = new FileInputStream("/sdcard/ti92.rom");
			
			int read = -1;
			
			do {
				
				read = is.read();
				
			} while(read > -1);
			
		} catch (FileNotFoundException e) {
			Log.d("TIEmu", e.getMessage());
		} catch (IOException e) {
			Log.d("TIEmu", e.getMessage());
		}
		
		// start running
		mIsRunning = true;
	}
	
	public void shutDown() {
		// stop running
		mIsRunning = false;
	}
}
