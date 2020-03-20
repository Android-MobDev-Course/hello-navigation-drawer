package com.mobdev.hellonavigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Main Application Demo Activity
 */
public class MainActivity extends AppCompatActivity {

	public static String TAG = "HelloActionBar";
	private RandomNumberFragment randomFragment = null;
	private DrawerLayout mDrawerLayout = null;
	private ActionBarDrawerToggle toggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.navigation_drawer_layout);
	
		if (savedInstanceState == null) {	
			randomFragment  = new RandomNumberFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container, randomFragment).commit();
		}

		Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
		setSupportActionBar(toolbar);  

		mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawer_layout);

		toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
		toggle.setDrawerIndicatorEnabled(true);
		
		mDrawerLayout.setDrawerListener(toggle);
		
		setupDrawerUI();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		toggle.syncState();
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

		if (id == R.id.action_info) {
			openInfoActivity();
			return true;
		}
		if (id == R.id.action_history) {
			openHistoryActivity(-1);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setupDrawerUI(){
		
		Button oddBuutton = (Button)findViewById(R.id.oddButton);
		oddBuutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mDrawerLayout.closeDrawers();	
				openHistoryActivity(0);
			}
		});
		
		Button evenBuutton = (Button)findViewById(R.id.evenButton);
		evenBuutton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mDrawerLayout.closeDrawers();	
				openHistoryActivity(1);
			}
		});
	}
	
	private void openInfoActivity(){
		Log.d(MainActivity.TAG,"openInfoActivity() called !");

		int currentRandomNum = 0;

		if(randomFragment != null)
			currentRandomNum = randomFragment.getCurrentRandomNum();

		Bundle bundle = new Bundle();
		bundle.putInt("randomNumber", currentRandomNum);

		Intent newIntent = new Intent(new Intent(this,InfoActivity.class));
		newIntent.putExtras(bundle);
		startActivity(newIntent);
	}

	private void openHistoryActivity(int numberType){
		Log.d(MainActivity.TAG,"openHistoryActivity() called !");
		
		Bundle bundle = new Bundle();
		bundle.putInt("numberType", numberType);

		Intent newIntent = new Intent(new Intent(this,HistoryActivity.class));
		newIntent.putExtras(bundle);
		startActivity(newIntent);
	}

}
