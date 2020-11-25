package com.example.unibudget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignupActivity";
    private EditText tvFname;
    private EditText tvLname;
    private EditText logPassword;
    private EditText tvStudentE;
    private Button btnNewmem;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tvFname = findViewById(R.id.tvFname);
        tvLname = findViewById(R.id.tvLname);
        logPassword = findViewById(R.id.logPassword);
        tvStudentE = findViewById(R.id.tvStudentE);
        btnNewmem = findViewById(R.id.btnNewmem);
        btnLogin = findViewById(R.id.btnLogin);


        btnNewmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername(tvFname.getText().toString());
                user.setUsername(tvLname.getText().toString());
                user.setPassword(logPassword.getText().toString());
                user.setEmail(tvStudentE.getText().toString());
                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e != null) {
                            final Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent R = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(R);
                finish();
            }
        });

    }
}