package com.AppJoyBCA.appjoybca.classwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.AppJoyBCA.appjoybca.R;

public class TestRecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test_recycle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rv = findViewById(R.id.Recycle_view);
        RecycleKoAdapter adapter = new RecycleKoAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}

class RecycleKoAdapter extends RecyclerView.Adapter<RecycleKoAdapter.MeroViewHolder> {
    String[] name = {"Abhash", "Anjali", "Bimal", "Dipen", "Joyesh",
            "Mallika", "Manisa", "Manjit", "Nabaraj", "Nayan",
            "Nirjala", "Pratiksha", "Rashmi", "Ritika", "Sangam",
            "Sebak", "Srijana", "Sudip", "Sushil", "Swostika"
    };
    String[] nickName = {"Hallankari", "Hasmati", "Silent", "Chasmis", "Legend",
            "Motax", "Small", "Galatey", "LoverBoi", "Mote",
            "Gayab", "Danger", "Dancer", "Don", "Chattu",
            "Neta", "Boxer", "Lamo Kapal Boy", "Commando", "Presenter"
    };
    int[] images = {R.drawable.avatar1,
            R.drawable.img,
            R.drawable.img_1, R.drawable.img_2, R.drawable.img_1,
            R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.img,
    };

    @NonNull
    @Override
    public RecycleKoAdapter.MeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_grid_item, parent, false);
        return new MeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleKoAdapter.MeroViewHolder holder, int position) {
        holder.img.setImageResource(images[position]);
        holder.tvName.setText(name[position]);
        holder.tvNickName.setText(nickName[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MeroViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvName;
        TextView tvNickName;

        public MeroViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.grid_img);
            tvName = itemView.findViewById(R.id.grid_name);
            tvNickName = itemView.findViewById(R.id.grid_nick);
        }
    }
}