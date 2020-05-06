package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder> {

    private ArrayList<Actor> actors;

    ActorAdapter(ArrayList<Actor> list){
        actors = list;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamePerson;
        TextView tvBirthDate;
        ImageView profile;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamePerson = itemView.findViewById(R.id.tvNamePerson);
            tvBirthDate = itemView.findViewById(R.id.tvBirthDate);
            profile = itemView.findViewById(R.id.profile);
        }
    }
    @NonNull
    @Override
    public ActorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(actors.get(position));

        holder.profile.setImageResource(actors.get(position).getPicture());
        holder.tvNamePerson.setText(actors.get(position).getName());
        holder.tvBirthDate.setText(actors.get(position).getBirthDate());

    }

    @Override
    public int getItemCount() {
        return actors.size();
    }
}
