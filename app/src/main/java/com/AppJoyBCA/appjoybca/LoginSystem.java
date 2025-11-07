package com.AppJoyBCA.appjoybca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginSystem extends AppCompatActivity {

    EditText st_Email;
    EditText st_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_system);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnForgetPass = findViewById(R.id.btn_forget);
        st_Email = findViewById(R.id.st_email);
        st_password = findViewById(R.id.st_password);



        btnForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Forget Button", "Forget have been clicked");
                /* 1. 1ota activity banauna paryo
                * 2. tyo class ko design ni banauna paryo
                * 3.tyo class ma switch huni code yo button click garda lekhna paryo
                * 4.switvh garda data ni send hunna paryo*/


                Intent intent = new Intent(LoginSystem.this, ForgetPasswordActivity.class) ;
                intent.putExtra("data","hello");
                intent.putExtra("Roll","10");
                intent.putExtra("is logged in",true );
                startActivity(intent);

            }
        });
    }

    public void onLoginClick(View view) {

        String email = st_Email.getText().toString();
        String password = st_password.getText().toString();
        Log.e("Email Log",email);
        Log.e("Password Log",password);

         if(st_Email.getText().toString().isEmpty()){
             st_Email.setError("This field is required");
         }

        if(!email.isEmpty() && !password.isEmpty()){
            Intent intent = new Intent(LoginSystem.this, Dashboard.class) ;
            startActivity(intent);
            Toast.makeText(LoginSystem.this, "You have been summoned", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(LoginSystem.this, "Email and password required", Toast.LENGTH_LONG).show();
        }
        //TODO: login logic goes here

        }

    public void RegisterClick(View view) {
        Intent intent = new Intent(LoginSystem.this, RegisterActivity.class) ;
        startActivity(intent);

    }
}
