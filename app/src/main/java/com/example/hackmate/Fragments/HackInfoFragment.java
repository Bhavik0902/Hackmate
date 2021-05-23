package com.example.hackmate.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hackmate.MainActivity;
import com.example.hackmate.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HackInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HackInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button joinTeam;
    Button createTeam;
    BottomNavigationView bottomNavigationView;
    Fragment JoinTeam,CreateTeam;

    public HackInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HackInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HackInfoFragment newInstance(String param1, String param2) {
        HackInfoFragment fragment = new HackInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hack_info, container, false);
    }

    @Override
   /* public void onPause() {
        super.onPause();
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setVisibility(View.VISIBLE);
    }*/

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//MainActivity mainActivity = (MainActivity) getActivity();
        joinTeam = view.findViewById(R.id.joinTeam);
        createTeam=view.findViewById(R.id.createTeam);

        bottomNavigationView = getActivity().findViewById(R.id.bottom_nav_bar);

        joinTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomNavigationView.setVisibility(View.GONE);
                Log.d("ERROR","button click  worked");
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                Log.d("ERROR","transaction started!");
                fragmentTransaction.replace(R.id.nav_host_fragment, new JoinTeamFragment());
                Log.d("ERROR","transaction replacement!");
                fragmentTransaction.commit();
                /*bottomNavigationView.setVisibility(View.GONE);

                mainActivity.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,JoinTeamFragment.class,null)
                        .addToBackStack(null)
                        .commit();*/
            }
        });

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.setVisibility(View.GONE);
                Log.d("ERROR","button click  worked");
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                Log.d("ERROR","transaction started!");
                fragmentTransaction.replace(R.id.nav_host_fragment, new CreateTeamFragment());
                Log.d("ERROR","transaction replacement!");
                fragmentTransaction.commit();
               /* FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, CreateTeamFragment.class, null);
                fragmentTransaction.commit();
                fragmentTransaction.replace(R.id.nav_host_fragment,new CreateTeamFragment())
                        .addToBackStack(null)
                        .commit();
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment,new CreateTeamFragment())
                        .addToBackStack(null)
                        .commit();*/
            }
        });
    }
}