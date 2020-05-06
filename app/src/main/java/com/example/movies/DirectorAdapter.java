package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DirectorAdapter extends RecyclerView.Adapter<DirectorAdapter.ViewHolder> {

    private ArrayList<Director> directors;

    DirectorAdapter(ArrayList<Director> list){
        directors = list;
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
    public DirectorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DirectorAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(directors.get(position));

        holder.profile.setImageResource(directors.get(position).getPicture());
        holder.tvNamePerson.setText(directors.get(position).getName());
        holder.tvBirthDate.setText(directors.get(position).getBirthDate());

    }

    @Override
    public int getItemCount() {
        return directors.size();
    }
}
