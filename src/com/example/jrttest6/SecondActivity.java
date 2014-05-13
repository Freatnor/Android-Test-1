package com.example.jrttest6;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class SecondActivity extends ActionBarActivity {
	
	private Handler mHandler = new Handler();
	private EditText edittext;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		edittext = (EditText) findViewById(R.id.editText1);
		intent = getIntent();
		
		mHandler.postDelayed(new Runnable() {
           public void run() {
            	changeEditText();
            }
        }, 1000);
		
	}
	
	/*method to send back the user input changes */
	public void forwardMessage(View v){
		System.out.println("testing if forward works...");
		intent.putExtra(MainActivity.EXTRA_MESSAGE, edittext.getText().toString());
		setResult(Activity.RESULT_OK, intent);
		finish();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	public void changeEditText(){
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		edittext.setText(message);
	}

}
