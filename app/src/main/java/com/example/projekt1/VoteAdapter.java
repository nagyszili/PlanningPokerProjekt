package com.example.projekt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class VoteAdapter extends RecyclerView.Adapter<VoteAdapter.ViewHolder> {

    private Context context;
    private ArrayList<User> votedUsers = new ArrayList<>();

    public VoteAdapter() {
    }

    public VoteAdapter(Context context, ArrayList<User> votedUsers) {
        this.context = context;
        this.votedUsers = votedUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_vote_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userName.setText(votedUsers.get(position).getName());
        holder.voteValue.setText(votedUsers.get(position).getVotedValue());

    }

    @Override
    public int getItemCount() {
        return votedUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout parent;
        TextView userName;
        TextView voteValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.voteItemParent);
            userName = itemView.findViewById(R.id.userName);
            voteValue = itemView.findViewById(R.id.voteValue);
        }
    }
}
