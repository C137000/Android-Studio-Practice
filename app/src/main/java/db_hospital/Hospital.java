package db_hospital;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.AppJoyBCA.appjoybca.R;

public class Hospital extends AppCompatActivity {

    HospitalDbHelper dbHelper;
    EditText nameEt, specEt, expEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        dbHelper = new HospitalDbHelper(this);

        nameEt = findViewById(R.id.doc_name);
        specEt = findViewById(R.id.doc_spec);
        expEt = findViewById(R.id.doc_exp);

        Button addBtn = findViewById(R.id.doc_add_btn);
        Button viewBtn = findViewById(R.id.doc_view_btn);
        Button deleteBtn = findViewById(R.id.doc_delete_btn);
        Button updateBtn = findViewById(R.id.doc_update_btn);

        addBtn.setOnClickListener(v -> {
            String name = nameEt.getText().toString().trim();
            String spec = specEt.getText().toString().trim();
            String expStr = expEt.getText().toString().trim();

            if (name.isEmpty() || spec.isEmpty() || expStr.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double exp = Double.parseDouble(expStr);
            long result = dbHelper.insertDoctor(name, spec, exp);

            if (result != -1)
                Toast.makeText(this, "Doctor Added", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();
        });

        viewBtn.setOnClickListener(v -> {
            Cursor cursor = dbHelper.getAllDoctor();
            if (cursor.getCount() == 0) {
                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                return;
            }

            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String spec = cursor.getString(2);
                double exp = cursor.getDouble(3);

                Log.d("DOCTOR_DATA", id + " | " + name + " | " + spec + " | " + exp);
            }
            cursor.close();
        });

        deleteBtn.setOnClickListener(v -> {
            int rows = dbHelper.deleteDoctor(1); // example ID
            Toast.makeText(this, rows > 0 ? "Deleted" : "Delete Failed", Toast.LENGTH_SHORT).show();
        });

        updateBtn.setOnClickListener(v -> {
            int rows = dbHelper.updateDoctor(1, "Updated Name", "Updated Spec", 5.5);
            Toast.makeText(this, rows > 0 ? "Updated" : "Update Failed", Toast.LENGTH_SHORT).show();
        });
    }
}
