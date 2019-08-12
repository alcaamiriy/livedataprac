package com.example.livedateprac;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GobolViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView mGoblolTextView;
    private GobolClickListener mClickListener;
    private Gobol mGobol;

    public GobolViewHolder(@NonNull View itemView, GobolClickListener listener) {
        super(itemView);
        mGoblolTextView = itemView.findViewById(R.id.gobol_text_view);
        mGoblolTextView.setOnClickListener(this);
        mClickListener = listener;
    }

    public void bind(Gobol gobol) {
        mGobol = gobol;
        mGoblolTextView.setText(gobol.getName());
    }

    @Override
    public void onClick(View view) {
        mClickListener.OnClick(mGobol.getName());
    }
}
