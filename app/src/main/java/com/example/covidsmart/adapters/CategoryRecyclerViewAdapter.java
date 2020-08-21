package com.example.covidsmart.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidsmart.ChatBotActivity;
import com.example.covidsmart.DetectorActivity;
import com.example.covidsmart.SocialDistancingActivity;
import com.example.covidsmart.databinding.StaggerredListItemBinding;
import com.example.covidsmart.models.Category;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder> {
    Context mContext;
    ArrayList<Category> categoryArrayList;

    public CategoryRecyclerViewAdapter(ArrayList<Category> categories, Context context) {
        categoryArrayList = categories;
        mContext = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        StaggerredListItemBinding itemBinding = StaggerredListItemBinding.inflate(layoutInflater, parent, false);
        return new CategoryRecyclerViewAdapter.CategoryViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryArrayList.get(position);
        holder.binding.cardName.setText(category.getmName());
        holder.binding.icon.setBackground(mContext.getDrawable(category.getmIconAddress()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    Intent maskIntent = new Intent(mContext, DetectorActivity.class);
                    mContext.startActivity(maskIntent);
                } else if (position == 1) {
                    Intent chatbotIntent = new Intent(mContext, ChatBotActivity.class);
                    mContext.startActivity(chatbotIntent);
                } else {
                    Intent socialDistancingIntent = new Intent(mContext, SocialDistancingActivity.class);
                    mContext.startActivity(socialDistancingIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categoryArrayList == null || categoryArrayList.size() == 0)
            return -1;
        return categoryArrayList.size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        StaggerredListItemBinding binding;

        public CategoryViewHolder(@NonNull StaggerredListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }
}
