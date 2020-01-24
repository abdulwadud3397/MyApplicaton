package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//    String msg = "Android : ";

    EditText nameEditText;
    EditText emailEditText;
    EditText idEditText;
    EditText passwordEditText;
    EditText genderEditText;
    Button signupbutton;

    SQLDao sqlDao;
   static  final int REQUEST_CODE = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
//        Log.d(msg,"The onCreate() event is running");

//        idEditText=findViewById(R.id.userId);
        nameEditText = findViewById(R.id.name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        genderEditText = findViewById(R.id.gender);
        signupbutton = findViewById(R.id.btnSignUp);


        //database instance;
        sqlDao = new SQLDao(getBaseContext());
        // button.set

        signupbutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                final String name = nameEditText.getText().toString();
//                final String userId = idEditText.getText().toString();
                final String gender = emailEditText.getText().toString();
                final String password = passwordEditText.getText().toString();

                final String email = genderEditText.getText().toString();

                sqlDao.insertUser(name,password,gender,email);
//                Log.d("result",name);
//                Toast.makeText( MainActivity.this,name,Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(MainActivity.this,SignUp.class);
//                intent.putExtra("key",name);
//                startActivity(intent);
//                startActivityForResult(intent,REQUEST_CODE);
                //Implicit Intent
//               Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.facebook.com"));
//                startActivity(intent);
            }

        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK && requestCode == REQUEST_CODE){
            if (data.hasExtra("login_Email")){

                emailEditText.setText(data.getExtras().getString("login_Email"));

            }
        }
    }
}
