package com.example.unibudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LoginActivity";
    private EditText logPassword;
    private EditText logUsername;
    private Button btnLogin;
    private Button btnNewmem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        logPassword = findViewById(R.id.logPassword);
        logUsername = findViewById(R.id.logUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnNewmem = findViewById(R.id.btnNewmem);

        btnNewmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick login button");
                String username = logPassword.getText().toString();
                String password = logUsername.getText().toString();
                loginUser(username,password);
            }

        });
    }

    private void loginUser(String username, String password) {
        Log.i(TAG, "Attempting to login user " + username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e == null) {
                    Toast.makeText(getApplicationContext(), "Log in successful", Toast.LENGTH_SHORT).show();
                    final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Log in failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}