package com.mobdev.hellonavigationdrawer;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Android example of RecyclerView Adapter
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private ArrayList<Double> mDataset;

	//First ViewHolder for
	public class EvenNumberViewHolder extends RecyclerView.ViewHolder {

		private View v = null;

		public EvenNumberViewHolder(View v) {
			super(v);
			this.v = v;

			v.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					int position = getPosition();
					NumberManager.getInstance().removeNumber(position);
					notifyItemRemoved(position);
					return false;
				}
			});
		}

		public void setText(String text){
			TextView tView = (TextView)v.findViewById(R.id.myTextView);
			tView.setText(text);
		}
	}

	//Second ViewHolder for
	public class OddNumberViewHolder extends RecyclerView.ViewHolder {

		private View v = null;

		public OddNumberViewHolder(View v) {
			super(v);
			this.v = v;

			v.setOnLongClickListener(new OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					int position = getPosition();
					NumberManager.getInstance().removeNumber(position);
					notifyItemRemoved(position);
					return false;
				}
			});
		}

		public void setText(String text){
			TextView tView = (TextView)v.findViewById(R.id.myTextView);
			tView.setText(text);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(ArrayList<Double> myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

		if(viewType == 0){
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.evennumber_listview_element, parent, false);
			return new EvenNumberViewHolder(v);
		}
		else if(viewType == 1){	
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.oddnumber_listview_element, parent, false);
			return new OddNumberViewHolder(v);
		}
		else{
			View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.oddnumber_listview_element, parent, false);
			return new EvenNumberViewHolder(v);
		}
	}
	
	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
		
		if(getItemViewType(position) == 0){
			EvenNumberViewHolder evenNumberViewHolder = (EvenNumberViewHolder)holder;
			evenNumberViewHolder.setText(""+mDataset.get(position));
		}
		else if(getItemViewType(position) == 1){	
			OddNumberViewHolder oddNumberViewHolder = (OddNumberViewHolder)holder;
			oddNumberViewHolder.setText(""+mDataset.get(position));
		}		
	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.size();
	}

	@Override
	public int getItemViewType(int position) {
		
		Double number = mDataset.get(position);
		
		if(number%2 == 0)
			return 0;
		else
			return 1;
	}
}