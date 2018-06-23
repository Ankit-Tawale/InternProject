package com.example.asus.afinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private static final String TAG = "RecyclerviewAdapter";

    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mTest = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(ArrayList<String> Name, ArrayList<String> Test, ArrayList<String> ImageUrls, Context context) {
        this.mName = Name;
        this.mTest = Test;
        this.mImageUrls = ImageUrls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("TAG", "OnCreateViewHolder called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t1.setText(mName.get(position));
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView t1,t2;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            t1 = itemView.findViewById(R.id.textView4);
            t2 = itemView.findViewById(R.id.textView7);
        }
    }
}
