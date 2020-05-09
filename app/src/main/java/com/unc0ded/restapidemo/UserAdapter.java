package com.unc0ded.restapidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unc0ded.restapidemo.models.RandomUser;
import com.unc0ded.restapidemo.models.Result;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {

    ArrayList<Result> userList;

    public UserAdapter(ArrayList<Result> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        holder.populate(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UserVH extends RecyclerView.ViewHolder {

        private TextView name,gender,email,phone;
        public UserVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
            gender=itemView.findViewById(R.id.gender);
            phone=itemView.findViewById(R.id.phone);
        }

        public void populate(Result result){
            String nameString=result.getName().getTitle() + " " + result.getName().getFirst() + " " + result.getName().getLast();
            name.setText(nameString);
            gender.setText(result.getGender());
            phone.setText(result.getPhone());
            email.setText(result.getEmail());
        }
    }
}

