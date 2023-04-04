package com.congnghephanmem.filmhay.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.congnghephanmem.filmhay.Interface.InterfaceAnime;
import com.congnghephanmem.filmhay.Model.DanhMuc;
import com.congnghephanmem.filmhay.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAnimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DanhMuc> danhMucList;
    private InterfaceAnime interfaceAnime;

    public RecyclerAnimeAdapter(Context context, List<DanhMuc> danhMucList, InterfaceAnime interfaceAnime) {
        this.context = context;
        this.danhMucList = danhMucList;
        this.interfaceAnime = interfaceAnime;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, null);
        return new MyRecyclerAnimeHolder(view, interfaceAnime);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyRecyclerAnimeHolder myRecyclerAnimeHolder = (MyRecyclerAnimeHolder) holder;
        myRecyclerAnimeHolder.img.setImageResource(danhMucList.get(position).getImg());
        myRecyclerAnimeHolder.tv_name.setText(danhMucList.get(position).getTenTheLoai());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceAnime.onClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return danhMucList.size();
    }
}

class MyRecyclerAnimeHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_anime)
    ImageView img;
    @BindView(R.id.tv_name_anime)
    TextView tv_name;
    InterfaceAnime interfaceAnime;
    public MyRecyclerAnimeHolder(@NonNull View itemView, InterfaceAnime interfaceAnime) {
        super(itemView);
        this.interfaceAnime = interfaceAnime;
        ButterKnife.bind(this, itemView);
    }
}
