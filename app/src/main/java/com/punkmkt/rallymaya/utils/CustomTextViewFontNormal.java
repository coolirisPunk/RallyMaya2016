package com.punkmkt.rallymaya.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextViewFontNormal extends TextView{

	public CustomTextViewFontNormal(Context context) {
		super(context);
		setFont();
		// TODO Auto-generated constructor stub
	}
	
	public CustomTextViewFontNormal(Context context, AttributeSet attrs){
		super(context, attrs);
		setFont();
	} 
	
	public CustomTextViewFontNormal(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		setFont();
	} 

	private void setFont() {
		// TODO Auto-generated method stub
		Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/MyriadPro_Regular.otf");
		setTypeface(tf);
	}
	
	
}
