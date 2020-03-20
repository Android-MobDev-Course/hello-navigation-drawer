package com.mobdev.hellonavigationdrawer;

import java.util.ArrayList;

import android.util.Log;

/**
 * Created by Marco Picone (picone.m@gmail.com) 12/03/2020
 * Singleton for Application data Management
 */
public class NumberManager {

	/*
	 * The instance is static so it is shared among all instances of the class. It is also private
	 * so it is accessible only within the class.
	 */
	private static NumberManager instance = null;

	private ArrayList<Double> numberList = null;

	/*
	 * The constructor is private so it is accessible only within the class.
	 */
	private NumberManager(){
		Log.d(MainActivity.TAG,"Number Manager Created !");
		this.numberList = new ArrayList<Double>();
	}

	public static NumberManager getInstance(){
		/*
		 * The constructor is called only if the static instance is null, so only the first time 
		 * that the getInstance() method is invoked.
		 * All the other times the same instance object is returned.
		 */
		if(instance == null)
			instance = new NumberManager();
		return instance;
	}

	public void addNumber(Double number){
		this.numberList.add(number);
	}

	public void addNumberToHead(Double number){
		this.numberList.add(0,number);
	}

	public void replaceNumber(int position, Double number){
		this.numberList.set(position, number);
	}

	public void removeNumber(int position){
		this.numberList.remove(position);
	}

	public void removeNumber(Double number){
		this.numberList.remove(number);
	}

	public ArrayList<Double> getNumberList(){
		return numberList;
	}

	public ArrayList<Double> getOddNumberList(){

		ArrayList<Double> newList = new ArrayList<Double>();

		for(Double number : numberList)
			if(number % 2 == 0)
				newList.add(number);

		return newList;
	}

	public ArrayList<Double> getEvenNumberList(){

		ArrayList<Double> newList = new ArrayList<Double>();

		for(Double number : numberList)
			if(number % 2 != 0)
				newList.add(number);

		return newList;
	}

}

