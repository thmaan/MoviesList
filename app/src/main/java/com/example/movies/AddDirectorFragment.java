package com.example.movies;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddDirectorFragment extends Fragment {
    private DirectorFragment.FragmentCommunicator fragmentCommunicator;
    private TextInputEditText name;
    private TextInputEditText year;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button buttonAdd;
        View view = inflater.inflate(R.layout.add_person,container,false) ;
        buttonAdd = view.findViewById(R.id.add);
        name = view.findViewById(R.id.tvNamePerson);
        year = view.findViewById(R.id.tvBirthDate
        );

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Director director = new Director(Objects.requireNonNull(name.getText()).toString(), Objects.requireNonNull(year.getText()).toString());
                ApplicationClass.directors.add(director);
                fragmentCommunicator.fragmentContactActivity(5);
            }
        });
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DirectorFragment.FragmentCommunicator) {
            fragmentCommunicator = (DirectorFragment.FragmentCommunicator) context;
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
