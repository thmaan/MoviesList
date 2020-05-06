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

public class DirectorFragment extends Fragment implements View.OnClickListener {
    private FragmentCommunicator fragmentCommunicator;
    private View view;

    public interface FragmentCommunicator {
         void fragmentContactActivity(int a);
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_director_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView;
        RecyclerView.Adapter myAdapter;
        RecyclerView.LayoutManager layoutManager;

        Button newDirector;

        recyclerView = view.findViewById(R.id.directorList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new DirectorAdapter(ApplicationClass.directors);
        recyclerView.setAdapter(myAdapter);

        newDirector = Objects.requireNonNull(getActivity()).findViewById(R.id.newDirector);
        newDirector.setOnClickListener(this);

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
        if(v.getId() == R.id.newDirector)
            fragmentCommunicator.fragmentContactActivity(2);
    }
}
