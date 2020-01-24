package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    TextView nameTextView;
    EditText emailEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nameTextView = findViewById(R.id.emailGet);
        emailEditText = findViewById(R.id.login_Email);
        loginButton = findViewById(R.id.emailLogin);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            nameTextView.setText(bundle.getString("key"));

        }

        }
    public void onClick(View view) {
        Intent intent = new Intent();
        String email = emailEditText.getText().toString();
        intent.putExtra("login_Email",email);
        setResult(RESULT_OK,intent);
        super.finish();

    }

}
