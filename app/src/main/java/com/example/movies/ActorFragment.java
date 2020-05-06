package com.example.movies;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActorFragment extends Fragment implements View.OnClickListener {
    FragmentCommunicator fragmentCommunicator;
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    Button newActor;

    public interface FragmentCommunicator {
        public void fragmentContactActivity(int a);
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_first, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.actorList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new ActorAdapter(this.getActivity(), ApplicationClass.actors);
        recyclerView.setAdapter(myAdapter);

        newActor = getActivity().findViewById(R.id.newActor);
        newActor.setOnClickListener(this);

    }
    @Override
    public void onAttach(Context activity) {
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
        switch (v.getId()){
            case R.id.newActor:
                fragmentCommunicator.fragmentContactActivity(1);
                break;
            default:
                break;
        }
    }
}