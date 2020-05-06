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


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMovieFragment extends Fragment {
    MoviesListFragment.FragmentCommunicator fragmentCommunicator;

    private Button buttonAdd;
    private TextInputEditText genre;
    private TextInputEditText year;
    private TextInputEditText title;
    public Spinner director;
    public Spinner protagonist;
    Actor newActor;
    Director newDirector;
    public interface FragmentCommunicator {
        public void fragmentContactActivity(int a);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_movie, container, false);
        buttonAdd = view.findViewById(R.id.addNewMovie);
        genre = view.findViewById(R.id.genre);
        year = view.findViewById(R.id.year);
        title = view.findViewById(R.id.titleMovie);
        director = view.findViewById(R.id.director);
        protagonist = view.findViewById(R.id.protagonist);

        ArrayAdapter<Actor> adapter = new ArrayAdapter<Actor>(getActivity(), android.R.layout.simple_spinner_item, ApplicationClass.actors);
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
        ArrayAdapter<Director> adapter1 = new ArrayAdapter<Director>(getActivity(), android.R.layout.simple_spinner_item, ApplicationClass.directors);
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
                ApplicationClass.movies.add(new Movie(title.getText().toString(), year.getText().toString(), genre.getText().toString(),newDirector,newActor));
                fragmentCommunicator.fragmentContactActivity(3);
            }
        });
        return view;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCommunicator) {
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
