package com.example.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movies;

    public MovieAdapter(Context context, ArrayList<Movie> list){
        movies = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvGenre;
        TextView tvDirector;
        TextView tvYear;
        TextView tvProtagonist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDirector = itemView.findViewById(R.id.tvDirector);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvProtagonist = itemView.findViewById(R.id.tvProtagonist);
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
