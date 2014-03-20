package com.example.tabletapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	Boolean opened = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView content = (ImageView) findViewById(R.id.content);
		final RelativeLayout topRlay = (RelativeLayout) findViewById(R.id.toplay);
		
		content.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	new CountDownTimer(3000, 100) {

            	     public void onTick(long millisUntilFinished) {
            	    	 topRlay.setVisibility(View.VISIBLE);
            	     }

            	     public void onFinish() {
            	         topRlay.setVisibility(View.GONE);
            	     }
            	  }.start();
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar actions click
        switch (item.getItemId()) {
        case R.id.action_edit:
        	RelativeLayout rlay = (RelativeLayout) findViewById(R.id.rlay);
        	if(!opened){
        		rlay.setVisibility(View.VISIBLE);
        		opened = true;
        	}else{
        		rlay.setVisibility(View.GONE);
        		opened = false;
        	}
        	
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

}
