package com.AppJoyBCA.appjoybca;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MeroCustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mero_custom_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        new HamroCustomAdapter(MeroCustomListActivity.this);
    }
}

class HamroCustomAdapter extends BaseAdapter {

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
    int[] images = {R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2, R.drawable.ktm, R.drawable.img,
            R.drawable.plus, R.drawable.guy, R.drawable.star, R.drawable.avatar1,
    };
    Context context;

    HamroCustomAdapter(Context c) {
        this.context = c;
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
            view = LayoutInflater.from(context).inflate(R.layout.row_new_list, parent, false);
            ImageView myImage = view.findViewById(R.id.img);
            TextView myName = view.findViewById(R.id.tv_name);
            TextView myNickName = view.findViewById(R.id.tv_nick);
//set data
            myName.setText(name[i]);
            myNickName.setText(nickName[i]);
            myImage.setImageResource(images[i]);
        }
        return view;
    }
}
