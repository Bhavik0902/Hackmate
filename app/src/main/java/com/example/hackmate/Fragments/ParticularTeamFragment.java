package com.example.hackmate.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hackmate.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ParticularTeamFragment extends Fragment {

    Button particularTeamDetails, profileParticipant;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_particular_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        particularTeamDetails = view.findViewById(R.id.particularTeamDetailsButton);
        profileParticipant = view.findViewById(R.id.profileParticipantButton);

        particularTeamDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "This fragment shows fragment about particular hack teams", Toast.LENGTH_SHORT).show();
            }
        });

        profileParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,new ParticipantProfileFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}