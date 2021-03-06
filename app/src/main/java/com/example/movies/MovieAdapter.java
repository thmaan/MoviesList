package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movies;

    MovieAdapter(ArrayList<Movie> list){
        movies = list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvGenre;
        TextView tvDirector;
        TextView tvYear;
        TextView tvProtagonist;
        ImageView picture;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvProtagonist = itemView.findViewById(R.id.tvProtagonist);
            picture = itemView.findViewById(R.id.picture);
        }
    }
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(movies.get(position));

        holder.picture.setImageResource(movies.get(position).getPicture());
        holder.tvName.setText(movies.get(position).getTitle());
        holder.tvGenre.setText(movies.get(position).getGenre());
        holder.tvDirector.setText(movies.get(position).getDirector().getName());
        holder.tvYear.setText(movies.get(position).getReleaseDate());
        holder.tvProtagonist.setText(movies.get(position).getProtagonist().getName());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
