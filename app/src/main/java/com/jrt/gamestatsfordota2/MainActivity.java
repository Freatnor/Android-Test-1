package com.jrt.gamestatsfordota2;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;


public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "my.TESTERINO";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		//private TextView text;
		public Intent intent;
		
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			//text = (TextView) rootView.findViewById(R.id.textView1);
			Button button = (Button) rootView.findViewById(R.id.signInButton);
	        /*button.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                sendMessage(v);
	                
	            }
	        });*/  //Uncomment later when you figure out how to fix this...
			return rootView;
		}
		
		/** Called when the user clicks the Send button */
		public void sendMessage(View view) {
		    Intent intent = new Intent(getActivity(), SecondActivity.class);
		    
		    //String message = text.getText().toString();
		    //intent.putExtra(EXTRA_MESSAGE, message);
		    startActivityForResult(intent, 1);
		}
		
		public void onActivityResult(int requestCode, int resultCode, Intent data) {
		    if(requestCode == 1){
		    	if(resultCode == Activity.RESULT_OK){
		    		intent = data;
		    		//String message = intent.getStringExtra(EXTRA_MESSAGE);
		    		//text.setText(message);
		    	}
		    }
		}
	}
	
	

}
