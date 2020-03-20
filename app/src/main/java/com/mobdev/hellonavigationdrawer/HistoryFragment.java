package com.mobdev.hellonavigationdrawer;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Android Fragment used to show the list of random number generated
 */
public  class HistoryFragment extends Fragment {

	private RecyclerView mRecyclerView = null;
	private LinearLayoutManager mLayoutManager = null;
	private MyAdapter mAdapter = null;
	private ImageButton addButton = null;
	private int numberType = -1;

	public HistoryFragment(int numberType){
		this.numberType  = numberType;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.history_fragment, container, false);

		mRecyclerView  = (RecyclerView)rootView.findViewById(R.id.my_recycler_view);

		// use a linear layout manager
		mLayoutManager  = new LinearLayoutManager(getActivity());
		mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		mLayoutManager.scrollToPosition(0);

		mRecyclerView.setLayoutManager(mLayoutManager);

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		mRecyclerView.setHasFixedSize(true);

		// specify an adapter (see also next example)

		ArrayList<Double> numberList = null;

		if(numberType == 0)
			numberList = NumberManager.getInstance().getOddNumberList();
		else if(numberType == 1)
			numberList = NumberManager.getInstance().getEvenNumberList();
		else
			numberList = NumberManager.getInstance().getNumberList();

		mAdapter  = new MyAdapter(numberList);
		mRecyclerView.setAdapter(mAdapter);

		mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
			@Override
			public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
				return false;
			}

			@Override
			public void onTouchEvent(RecyclerView rv, MotionEvent e) {

			}

			@Override
			public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

			}
		});

		addButton  = (ImageButton)rootView.findViewById(R.id.addButton);
		
		if(numberType != -1)
			addButton.setVisibility(View.GONE);
		
		addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.d(MainActivity.TAG,"Add Button CLicked !");

				Random rand = new Random();
				int number = rand.nextInt((1000 - 0) + 1);
				NumberManager.getInstance().addNumberToHead(Double.valueOf(number));
				mAdapter.notifyItemInserted(0);

				mLayoutManager.scrollToPosition(0);
			}
		});

		return rootView;
	}

}