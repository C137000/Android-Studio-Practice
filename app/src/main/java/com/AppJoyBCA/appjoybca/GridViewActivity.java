package com.AppJoyBCA.appjoybca;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.AppJoyBCA.appjoybca.R;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView grid = findViewById(R.id.grid_view);
        grid.setAdapter(grid.getAdapter());

    }

    public class HamroCustomAdapter extends BaseAdapter {

        String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh",
                "Mallika", "Manisa", "Manjit", "Nabaraj", "Nayan",
                "Nirjala", "Pratiksha", "Rashmi", "Ritika", "Sangam",
                "Sebak", "Srijana", "Sudip", "Sushil", "Swostika"
        };
        String[] nickName = {"Hallankari", "Hasmati", "Silent", "Chasmis", "Joker",
                "Motax", "Small", "Galatey", "LoverBoi", "Mote",
                "Gayab", "Danger", "Dancer", "Don", "Chattu",
                "Neta", "Boxer", "Lamo Kapal Boy", "Commando", "Presenter"
        };
        int[] images = {R.drawable.ktm, R.drawable.avatar1,
                R.drawable.img,R.drawable.avatar2,R.drawable.img_2,
                R.drawable.ktm, R.drawable.avatar1,
                R.drawable.img,R.drawable.avatar2,R.drawable.img_2,
                R.drawable.ktm, R.drawable.avatar1,
                R.drawable.img,R.drawable.avatar2,R.drawable.img_2
        };

        Context context;
        LayoutInflater inflater;

        HamroCustomAdapter(Context c) {
            this.context = c;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            if (view == null) {
                view = inflater.inflate(R.layout.custom_tow, parent, false);
            }

            ImageView myImage = view.findViewById(R.id.img);
            TextView myName = view.findViewById(R.id.tv_name);
            TextView myNickName = view.findViewById(R.id.tv_nick);

            // Set data
            myName.setText(name[i]);
            myNickName.setText(nickName[i]);
            myImage.setImageResource(images[i]);

            return view;
        }
    }
}