package com.example.unibudget;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private Button Edtbutton;
    private Button logOtbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_image);

        Edtbutton = (Button) findViewById(R.id.Edtbutton);
        Edtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EdtProfile();
            }
        });
        logOtbutton = findViewById(R.id.logOtbutton);
        logOtbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(ProfileActivity.this,"Successfully Logout" ,Toast.LENGTH_SHORT).show();
            }
        });


        //Initialize
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        //Set home selected
        bottomNavigationView.setSelectedItemId(R.id.action_profile);
        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_location:
                        startActivity(new Intent(getApplicationContext(), LocationActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.action_profile:
                        return true;
                }
                return false;
            }
            });


        }



    private void EdtProfile() {
        Intent intent = new Intent(this,EditProfileActivity.class);
        startActivity(intent);
    }
}