package com.example.movies;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddActorFragment extends Fragment {
    ActorFragment.FragmentCommunicator fragmentCommunicator;
    private Button buttonAdd;
    private TextInputEditText name;
    private TextInputEditText year;

    public interface FragmentCommunicator {
        public void fragmentContactActivity(int a);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_person,container,false) ;
        buttonAdd = view.findViewById(R.id.add);
        name = view.findViewById(R.id.tvNamePerson);
        year = view.findViewById(R.id.tvBirthDate
        );

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actor actor = new Actor(name.getText().toString(),year.getText().toString());
                ApplicationClass.actors.add(actor);
                fragmentCommunicator.fragmentContactActivity(4);
            }
        });
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof AddMovieFragment.FragmentCommunicator) {
            fragmentCommunicator = (ActorFragment.FragmentCommunicator) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement fragmentCommunicator");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentCommunicator = null;
    }
}
