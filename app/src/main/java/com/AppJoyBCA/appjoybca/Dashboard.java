package com.AppJoyBCA.appjoybca;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btndialog = findViewById(R.id.dialog_box);
        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button btnContextMenu = findViewById(R.id.forContextMenu);
        registerForContextMenu(btnContextMenu);

        Button btnPopUp = findViewById(R.id.popupbutton);
        btnPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Dashboard.this, v);
                popup.getMenuInflater().inflate(R.menu.pop_up_menu_hai, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.pop_menu_1){
                            Toast.makeText(Dashboard.this, "Pop UP", Toast.LENGTH_SHORT).show();
                        }
                        if (id == R.id.pop_menu_2){
                            Toast.makeText(Dashboard.this, "Pop UP 2", Toast.LENGTH_SHORT).show();
                        }
                        if (id == R.id.pop_menu_3){
                            Toast.makeText(Dashboard.this, "Pop UP 3", Toast.LENGTH_SHORT).show();
                        }
                        if (id == R.id.pop_menu_4){
                            Toast.makeText(Dashboard.this, "Pop UP 4", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int menu1Id = item.getItemId();
        if (menu1Id == R.id.menu_context_item1){
           // Toast.makeText(this,"Hello context menu", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"Hello from context menu 1",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_burger,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        if (menuId==R.id.menu_item1){

        }else if(menuId==R.id.menu_item2){

        }else if(menuId==R.id.menu_item3){

        }else if(menuId==R.id.menu_item4){

        }
        return true;
    }
}