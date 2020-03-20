package com.mobdev.hellonavigationdrawer;

import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Random Number Demo Fragment
 */
public  class RandomNumberFragment extends Fragment {

	private TextView numberTextView = null;
	private Button randomButton = null;
	private int currentRandomNum = 0;

	public RandomNumberFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.random_number_fragment, container, false);
		
		//Retrieve TextView UI Object
		numberTextView  = (TextView) rootView.findViewById(R.id.numberTextView);
		
		//Retrieve a Button UI Object and set an inline listener
		randomButton  = (Button)rootView.findViewById(R.id.randomButton);
		randomButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Random rand = new Random();
				currentRandomNum  = rand.nextInt((1000 - 0) + 1);
				
				NumberManager.getInstance().addNumber(Double.valueOf(currentRandomNum));
				
				numberTextView.setText(""+currentRandomNum);
				
			}
		});
		
		return rootView;
	}

	public int getCurrentRandomNum() {
		return currentRandomNum;
	}

	public void setCurrentRandomNum(int currentRandomNum) {
		this.currentRandomNum = currentRandomNum;
	}
	
	
}