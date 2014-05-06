package com.example.standroidapp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

   private EditText  username=null;
   private EditText  password=null;
   private TextView attempts;
   private Button login,Register1;
   int counter = 3;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      username = (EditText)findViewById(R.id.editText1);
      password = (EditText)findViewById(R.id.editText2);
      attempts = (TextView)findViewById(R.id.textView5);
      attempts.setText(Integer.toString(counter));
      login = (Button)findViewById(R.id.button1);
 Register1 =(Button)findViewById(R.id.button2);
 login.setOnClickListener(this);
 Register1.setOnClickListener(this);
  }

   public void login(View view){
      if(username.getText().toString().equals("Shubham") && 
      password.getText().toString().equals("12345")){
      Toast.makeText(getApplicationContext(), "Redirecting...", 
      Toast.LENGTH_SHORT).show();
   }	
   else{
      Toast.makeText(getApplicationContext(), "Wrong Credentials",
      Toast.LENGTH_SHORT).show();
      attempts.setBackgroundColor(Color.RED);	
      counter--;
      attempts.setText(Integer.toString(counter));
      if(counter==0){
         login.setEnabled(false);
      }

   }

}
   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.main, menu);
      return true;
   }

@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub

if(arg0.getId()==R.id.button2){
	Intent i=new Intent("com.example.standroidapp.REGISTER");
	startActivity(i);
}

	
}

}
