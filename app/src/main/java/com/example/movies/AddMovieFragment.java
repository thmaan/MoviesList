package com.example.movies;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMovieFragment extends Fragment {
    private MoviesListFragment.FragmentCommunicator fragmentCommunicator;
    private TextInputEditText genre;
    private TextInputEditText year;
    private TextInputEditText title;
    private Actor newActor;
    private Director newDirector;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button buttonAdd;
        Spinner director;
        Spinner protagonist;
        View view = inflater.inflate(R.layout.fragment_add_movie, container, false);
        buttonAdd = view.findViewById(R.id.addNewMovie);
        genre = view.findViewById(R.id.genre);
        year = view.findViewById(R.id.year);
        title = view.findViewById(R.id.titleMovie);
        director = view.findViewById(R.id.director);
        protagonist = view.findViewById(R.id.protagonist);

        ArrayAdapter<Actor> adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()),
                android.R.layout.simple_spinner_item, ApplicationClass.actors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        protagonist.setAdapter(adapter);

        protagonist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               newActor = (Actor) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<Director> adapter1 = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, ApplicationClass.directors);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        director.setAdapter(adapter1);

        director.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newDirector = (Director) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationClass.movies.add(new Movie(Objects.requireNonNull(title.getText()).toString(),
                        Objects.requireNonNull(year.getText()).toString(),
                        Objects.requireNonNull(genre.getText()).toString(),
                        newDirector,newActor));
                fragmentCommunicator.fragmentContactActivity(3);
            }
        });
        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MoviesListFragment.FragmentCommunicator) {
            fragmentCommunicator = (MoviesListFragment.FragmentCommunicator) context;
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
