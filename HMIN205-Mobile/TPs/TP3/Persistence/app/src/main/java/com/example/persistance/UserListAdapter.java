package com.example.persistance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final LayoutInflater inflater;
    private List<User> users;

    UserListAdapter(Context context) { inflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (users != null) {
            User current = users.get(position);
            holder.userItemView.setText(current.getUser());
        } else {
            holder.userItemView.setText("No User");
        }
    }

    void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        } else {
            return 0;
        }
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView userItemView;

        public UserViewHolder(View itemView) {
            super(itemView);
            this.userItemView = itemView.findViewById(R.id.textView);
        }
    }
}
