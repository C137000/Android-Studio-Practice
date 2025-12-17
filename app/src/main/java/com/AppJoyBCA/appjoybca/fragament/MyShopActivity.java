package com.AppJoyBCA.appjoybca.fragament;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.AppJoyBCA.appjoybca.LoginSystem;
import com.AppJoyBCA.appjoybca.R;

public class MyShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_shop);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button homebtn = findViewById(R.id.Homebtn);
        Button profilebtn = findViewById(R.id.Profilebtn);
        Button settingbtn = findViewById(R.id.Settingbtn);
        Button cartbtn = findViewById(R.id.Cartbtn);



        //home ko kaam
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "Home page opened", Toast.LENGTH_SHORT).show();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                HomeFragment home = new HomeFragment();
                transaction.replace(R.id.frame_id, home);
                transaction.commit();
            }
        });

        //profile option ko bolauni kaam
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "Profile page ko toast", Toast.LENGTH_SHORT).show();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                ProfileFragment profile = new ProfileFragment();
                transaction.replace(R.id.frame_id, profile);
                transaction.commit();
            }
        });

        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "Setting page open vayo", Toast.LENGTH_SHORT).show();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                SettingFragment setting = new SettingFragment();
                transaction.replace(R.id.frame_id, setting);
                transaction.commit();
            }
        });

        cartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyShopActivity.this, "Cart page hai ta", Toast.LENGTH_SHORT).show();

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                CartFragment cart = new CartFragment();
                transaction.replace(R.id.frame_id, cart);
                transaction.commit();
            }
        });

    }
}