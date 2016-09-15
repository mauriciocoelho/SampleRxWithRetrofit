package com.example.mauricio.samplerxwithretrofit;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mauricio.samplerxwithretrofit.models.Weather;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private ArrayList<User> mUserList;

    public RecyclerViewAdapter(ArrayList<User> userList) {
        mUserList = userList;
    }

    public void  addItem(User user){
        mUserList.add(user);
        this.notifyDataSetChanged();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        User user = mUserList.get(position);

        holder.getDescription().setText(user.getDescription());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView description;


        public ItemViewHolder(View v) {
            super(v);
            description = (TextView)v.findViewById(R.id.textView);
        }

        public TextView getDescription() {
            return description;
        }

    }
}
