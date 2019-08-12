package com.example.livedateprac;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GobolAdapter extends RecyclerView.Adapter<GobolViewHolder> {
    private List<Gobol> mGobolo;
    private GobolClickListener mListener;
    private Context mContext;

    public GobolAdapter(Context context, GobolClickListener mListener) {
        this.mContext = context;
        this.mListener = mListener;
    }
    public void setGobolo(List<Gobol> gobolo) {
        this.mGobolo = gobolo;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GobolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.gobol_list, parent, false);

        return new GobolViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull GobolViewHolder holder, int position) {
        holder.bind(mGobolo.get(position));
    }

    @Override
    public int getItemCount() {
        return mGobolo == null ? 0 : mGobolo.size();
    }
}
