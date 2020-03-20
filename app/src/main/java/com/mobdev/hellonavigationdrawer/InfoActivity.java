package com.mobdev.hellonavigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Information Activity showing a InfoFragment as main content
 */
public class InfoActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_fragment_activity);
		if (savedInstanceState == null) {

			InfoFragment infoFragemnt = null;

			Bundle bundle = this.getIntent().getExtras();
			if(bundle != null)
				infoFragemnt = new InfoFragment(bundle.getInt("randomNumber",0));
			else
				infoFragemnt = new InfoFragment(0);

			getSupportFragmentManager().beginTransaction().add(R.id.container, infoFragemnt).commit();
		}

		Toolbar toolbar = (Toolbar)findViewById(R.id.my_awesome_toolbar);
		toolbar.setTitle("App Info");
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
