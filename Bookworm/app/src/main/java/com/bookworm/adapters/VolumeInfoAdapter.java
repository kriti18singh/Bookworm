package com.bookworm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookworm.R;
import com.bookworm.model.VolumeInfo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VolumeInfoAdapter extends RecyclerView.Adapter<VolumeInfoAdapter.VolumeInfoViewHolder> {

    private Context mContext;
    private List<VolumeInfo> mList;

    public VolumeInfoAdapter(Context mContext, List<VolumeInfo> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public VolumeInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_volume_info, parent, false);
        return new VolumeInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumeInfoViewHolder holder, int position) {
        VolumeInfo volume = mList.get(position);
        holder.tv.setText(volume.title);
        holder.tv1.setText(volume.authors.get(0));
        //Picasso.get().load(chapter.imageUrl).into(holder.ivChapter);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VolumeInfoViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivVolumeInfo;
        public TextView tv, tv1;

        public VolumeInfoViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tvVolumeName);
            tv1 = (TextView) itemView.findViewById(R.id.tvVolumeAuthorName);
            ivVolumeInfo = (ImageView) itemView.findViewById(R.id.ivChapter);
        }
    }
}
