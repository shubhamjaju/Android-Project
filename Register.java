package com.example.standroidapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity{
EditText username,mail,address,mobile1,mobile2,mobile3;
private Button go;
String x,name,mailid,m1,m2,m3,add;
@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_log);
		go=(Button)findViewById(R.id.data);
		//x="Name: "+name+"\nE-mailid: "+mailid+ "\nFirst Mobile no "+m1 +"\nSecond mobile no"+m2+"\nThird Mobile no"+m3+"\nAddress: "+add;
		//String mobile_no=et.getText().toString();
	//	t=(TextView)findViewById(R.id.tvName);
	//	System.out.println(Name);
//t.setText(Name);
		go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				username=(EditText) findViewById(R.id.username);
				mail=(EditText)findViewById(R.id.email);
				mobile1=(EditText)findViewById(R.id.firstmobile);
				mobile2=(EditText)findViewById(R.id.secondmobile);
				mobile3=(EditText)findViewById(R.id.thirdmobile);
				address=(EditText) findViewById(R.id.et_address);
				name=username.getText().toString();
				mailid=mail.getText().toString();
				m1=mobile1.getText().toString();
				m2=mobile2.getText().toString();
				m3=mobile3.getText().toString();
				add=address.getText().toString();
				     generateNoteOnSD("ABC.txt");
				}
		});
}
public void generateNoteOnSD(String sFileName){
    try
    {
        File root = new File(Environment.getExternalStorageDirectory(), "Notes");
        if (!root.exists()) {
            root.mkdirs();
        }
        File gpxfile = new File(root, sFileName);
        FileWriter writer = new FileWriter(gpxfile);
        writer.append(name+"\n");
        writer.append(mailid+"\n");
        writer.append(m1+"\n");
        writer.append(m2+"\n");
        writer.append(m3+"\n");
        writer.append(add);
        writer.flush();
        writer.close();
        Toast.makeText(this, "Your Data is Saved", Toast.LENGTH_SHORT).show();
    }
    catch(IOException e)
    {
         e.printStackTrace();
    }
   } 
}
