package com.example.hackmate.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hackmate.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MyTeamsFragment extends Fragment {

    Button particularTeam;
    BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        particularTeam = view.findViewById(R.id.particularTeamButton);
        bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);

        particularTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.setVisibility(View.GONE);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,new ParticularTeamFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}