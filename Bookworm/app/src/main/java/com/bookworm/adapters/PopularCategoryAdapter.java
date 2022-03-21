package com.bookworm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bookworm.R;
import com.bookworm.model.PopularCategory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PopularCategoryAdapter extends RecyclerView.Adapter<PopularCategoryAdapter.ViewHolder> {

    private Context mContext;
    private List<PopularCategory> mCategories;

    public PopularCategoryAdapter(List<PopularCategory> list, Context context) {
        mContext = context;
        mCategories = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recyclerView.setAdapter(new VolumeInfoAdapter(mContext, mCategories.get(position).getmList()));
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setHasFixedSize(true);
        holder.tvHeading.setText(mCategories.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView tvHeading;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvCategories);
            tvHeading = (TextView) itemView.findViewById(R.id.tvCategoryName);
        }
    }
}
