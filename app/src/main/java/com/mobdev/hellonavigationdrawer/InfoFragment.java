package com.mobdev.hellonavigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Information Fragment to show a generated random number provided through Intent
 */
public  class InfoFragment extends Fragment {

	private int randomNumber;

	public InfoFragment(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.info_fragment, container, false);
		
		TextView numberTextView = (TextView)rootView.findViewById(R.id.numberTextView);
		numberTextView.setText(""+randomNumber);
		
		return rootView;
	}
	
}