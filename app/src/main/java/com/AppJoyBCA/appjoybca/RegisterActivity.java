package com.AppJoyBCA.appjoybca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onLoginClick(View view) {
        //TODO: login logic goes here
        Intent intent = new Intent(RegisterActivity.this, Dashboard.class) ;
        startActivity(intent);
//        Toast.makeText(LoginSystem.this, "You have been summoned", Toast.LENGTH_LONG).show();
    }

    public void onSignUpClick(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginSystem.class) ;
        startActivity(intent);
    }
}