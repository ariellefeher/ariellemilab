package com.example.ex_02;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    Context context;
    String[] programNameList;
    int[] programImages;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleName;
        ImageView rowImage;

        public ViewHolder( @NotNull View view) {
            super(view);
            titleName = view.findViewById(R.id.titleView);
            rowImage = view.findViewById(R.id.imageView);
        }
    }

    public ListAdapter(Context context, String[] programNameList, int[] programImages) {
        this.context = context;
        this.programNameList = programNameList;
        this.programImages = programImages;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        String textForDisplay = programNameList[position];

        ((ViewHolder)holder).titleName.setText(textForDisplay);

        ((ViewHolder) holder).rowImage.setImageResource(programImages[position]);
    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }

}
