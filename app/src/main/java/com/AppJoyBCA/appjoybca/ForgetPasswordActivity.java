package com.AppJoyBCA.appjoybca;

import android.content.Intent;   // <-- add this
import android.os.Bundle;
import android.os.Handler;       // <-- add this
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String data = getIntent().getDataString();
        int myroll = getIntent().getIntExtra("Roll",0);
        boolean loggedin = getIntent().getBooleanExtra("ISLoggedIn",false);

    }

    public void onLoginClickOTP(View view) {
        // Show OTP Toast
        Toast.makeText(ForgetPasswordActivity.this, "OTP has been sent", Toast.LENGTH_LONG).show();

        // Delay for 3 seconds (3000 ms) before redirecting
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent to redirect (replace OTPConfirm.class with your target activity)
                Intent intent = new Intent(ForgetPasswordActivity.this, OTPConfirm.class);
                startActivity(intent);
                finish(); // optional: finish current activity so user can't go back
            }
        }, 10000);
    }
}
