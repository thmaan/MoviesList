package com.example.movies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class MoviesListFragment extends Fragment implements View.OnClickListener {
    private FragmentCommunicator fragmentCommunicator;
    private View view;

    public interface FragmentCommunicator {
        void fragmentContactActivity(int a);
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        view = inflater.inflate(R.layout.fragment_list_movies, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView;
        RecyclerView.Adapter myAdapter;
        RecyclerView.LayoutManager layoutManager;
        Button newMovie;

        recyclerView = view.findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new MovieAdapter(ApplicationClass.movies);
        recyclerView.setAdapter(myAdapter);

        newMovie = Objects.requireNonNull(getActivity()).findViewById(R.id.newMovie);
        newMovie.setOnClickListener(this);

    }
    @Override
    public void onAttach(@NonNull Context activity) {
        super.onAttach(activity);
        try {
            fragmentCommunicator = (FragmentCommunicator) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentCommunicator");
        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.newMovie)
            fragmentCommunicator.fragmentContactActivity(0);
    }
}
