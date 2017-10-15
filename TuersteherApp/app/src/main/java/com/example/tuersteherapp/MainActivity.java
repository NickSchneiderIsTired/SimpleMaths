package com.example.tuersteherapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;

import java.io.BufferedInputStream;


public class MainActivity extends Activity {

	  TextView textView1;
	double x,y,z;

	public void calcZeros (View a) {
		EditText text = (EditText) findViewById(R.id.xField);
		EditText text2 = (EditText) findViewById(R.id.yField);
		EditText text3 = (EditText) findViewById(R.id.zField);

		if(text.getText().length() != 0 &&
				text2.getText().length() != 0 &&
				text3.getText().length() != 0) {

			x = Double.parseDouble(text.getText().toString());
			y = Double.parseDouble(text2.getText().toString());
			z = Double.parseDouble(text3.getText().toString());

			double underSqrt = y*y - 4*x*z;
			if(underSqrt >= 0) {

				double ns1 = ((-1 * y) + Math.sqrt(underSqrt)) / (2*x);
				double ns2 = ((-1 * y) - Math.sqrt(underSqrt)) / (2*x);

				textView1.setText("");
				textView1.setTextSize(20);
				textView1.setText("Ns1 = " + ns1  + "\n" + "Ns2 = " + ns2);
			} else {
				textView1.setText("");
				textView1.setTextSize(30);
				textView1.setText("Keine Nullstellen!");
			}


		} else {
			textView1.setText("");
			textView1.setTextSize(30);
			textView1.setText("Ungültige Eingabe!");
		}
	}
	
	public void calcPyth (View a) {
		EditText text = (EditText) findViewById(R.id.xField);
		EditText text2 = (EditText) findViewById(R.id.yField);
		EditText text3 = (EditText) findViewById(R.id.zField);
		if (text.getText().length() == 0 &&
				text2.getText().length() != 0 &&
				text3.getText().length() != 0) {
			y = Double.parseDouble(text2.getText().toString());
			z = Double.parseDouble(text3.getText().toString());

			calcX(y,z);

		} else if (text2.getText().length() == 0 &&
				text.getText().length() != 0 &&
				text3.getText().length() != 0) {

			x = Double.parseDouble(text.getText().toString());
			z = Double.parseDouble(text3.getText().toString());

			calcY(x, z);

		} else if(text3.getText().length() == 0 &&
				text.getText().length() != 0 &&
				text2.getText().length() != 0) {

			x = Double.parseDouble(text.getText().toString());
			y = Double.parseDouble(text2.getText().toString());

			calcZ(x,y);
		} else {
			textView1.setText("");
			textView1.setTextSize(25);
			textView1.setText("Zu wenig/viele Seiten gegeben");
		}

	}


	public void calcX(double y, double z) {
		if(y != z) {
			x = Math.sqrt(Math.abs(z * z - y * y));

			textView1.setText("");
			textView1.setTextSize(30);
			textView1.setText("a =" + x);
		} else {
			textView1.setText("");
			textView1.setTextSize(30);
			textView1.setText("Ungültige Eingabe");
		}

	}

	public void calcY(double x, double z) {
		if(x != z) {
			y = Math.sqrt(Math.abs(z * z - x * x));

			textView1.setText("");
			textView1.setTextSize(30);
			textView1.setText("b =" + y);
		} else {
			textView1.setText("");
			textView1.setTextSize(30);
			textView1.setText("Ungültige Eingabe");
		}

	}

	public void calcZ(double x, double y) {
		z = Math.sqrt(Math.abs(x*x + y*y));

		textView1.setText("");
		textView1.setTextSize(30);
		textView1.setText("c =" + z);
	}
	
	public void dontgetit() {

	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 textView1 = (TextView) findViewById (R.id.solutionView);
		
		 // EditText editText1 = (EditText) findViewById (R.id.textView1);
		
		   
		 //  String s = textView1.getText().toString();
		   
		   //int Anzahl = Integer.parseInt(s);
		   //Anzahl = Anzahl +1;
		   textView1.setText("0");
		   //textView1.append(Anzahl + "");
		
	}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		

		return true;
	}

}
