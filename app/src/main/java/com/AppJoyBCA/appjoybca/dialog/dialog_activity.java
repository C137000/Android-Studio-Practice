package com.AppJoyBCA.appjoybca.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.AppJoyBCA.appjoybca.Dashboard;
import com.AppJoyBCA.appjoybca.R;
import com.AppJoyBCA.appjoybca.RegisterActivity;

public class dialog_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dialog);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //onclick dialog box show huni
        Button btnShowDialog =findViewById(R.id.dialog_box1);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(dialog_activity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Kta ho ??");
                dialog.setMessage("Kta haru mutang ma ");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(dialog_activity.this, "Hello re", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(dialog_activity.this, "negative hello", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(dialog_activity.this, "Hello vanam ki nai hola ?", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });
    }

    public void dialog2_shown(View view) {
        Button btn_dialog = findViewById(R.id.dialog_box2);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog merodialog = new Dialog(dialog_activity.this);
                merodialog.setContentView(R.layout.activity_dialog_quit);
                //start referencinh views
                Button btncancel1 = merodialog.findViewById(R.id.btn_cancel);
                Button btnconfirm1 = merodialog.findViewById(R.id.btn_confirm);

                btncancel1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(dialog_activity.this, "Cancel vayo", Toast.LENGTH_SHORT).show();
                        merodialog.dismiss();

                    }
                });
                btnconfirm1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(dialog_activity.this, "Confirm vayo", Toast.LENGTH_SHORT).show();
                        merodialog.dismiss();

                    }
                });

                merodialog.show();
            }
        });
    }
}