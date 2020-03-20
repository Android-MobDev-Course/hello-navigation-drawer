package com.mobdev.hellonavigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * History Activity used to show the history of generated random numbers through the use
 * of the History Fragment as main activity's content
 */
public class HistoryActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_fragment_activity);
		if (savedInstanceState == null) {
			
			int numberType = -1;
			
			Bundle bundle = this.getIntent().getExtras();
			if(bundle != null)
				numberType = (bundle.getInt("numberType",-1));
			
			getSupportFragmentManager().beginTransaction().add(R.id.container, new HistoryFragment(numberType)).commit();
		}

		Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
		toolbar.setTitle("Numbers History");
		setSupportActionBar(toolbar);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		switch (item.getItemId()) {
		// Respond to the action bar's Up/Home button
		case android.R.id.home:
			//NavUtils.navigateUpFromSameTask(this);
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivityForResult(intent, 0);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
}
