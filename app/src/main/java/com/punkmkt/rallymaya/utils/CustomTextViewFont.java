package com.punkmkt.rallymaya.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextViewFont extends TextView{

	public CustomTextViewFont(Context context) {
		super(context);
		setFont();
		// TODO Auto-generated constructor stub
	}
	
	public CustomTextViewFont(Context context, AttributeSet attrs){
		super(context, attrs);
		setFont();
	} 
	
	public CustomTextViewFont(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		setFont();
	} 

	private void setFont() {
		// TODO Auto-generated method stub
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MyriadPro_Bold.otf");
		setTypeface(tf);
	}
	
	
}
