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


public class HackInfoFragment extends Fragment {

    Button joinTeam, createTeam;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hack_info, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        joinTeam = view.findViewById(R.id.joinTeam);
        createTeam = view.findViewById(R.id.createTeam);

        joinTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,new JoinTeamsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,new CreateTeamsFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}