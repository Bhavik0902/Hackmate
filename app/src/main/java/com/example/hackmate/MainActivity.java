package com.example.hackmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.example.hackmate.Fragments.HomeFragment;
import com.example.hackmate.Fragments.MyTeamsFragment;
import com.example.hackmate.Fragments.ProfileFragment;
import com.example.hackmate.Fragments.TeamsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    //Fragments
    private Fragment activeFragment;
    private HomeFragment homeFragment = new HomeFragment();
    private MyTeamsFragment myTeamsFragment = new MyTeamsFragment();
    private TeamsFragment teamsFragment = new TeamsFragment();
    private ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_bar);
        bottomNavigation();

    }

    private void bottomNavigation() {
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,homeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,teamsFragment).hide(teamsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,myTeamsFragment).hide(myTeamsFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,profileFragment).hide(profileFragment).commit();

        activeFragment = homeFragment;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        Fragment selectedFragment = homeFragment;
                        switch (item.getItemId()) {
                            case R.id.nav_home:
                                selectedFragment = homeFragment;
                                break;
                            case R.id.nav_teams:
                                selectedFragment = teamsFragment;
                                break;
                            case R.id.nav_myTeams:
                                selectedFragment = myTeamsFragment;
                                break;
                            case R.id.nav_profile:
                                selectedFragment = profileFragment;
                                break;
                        }
                        if(selectedFragment!=activeFragment) {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .show(selectedFragment)
                                    .hide(activeFragment)
                                    .commit();
                            activeFragment = selectedFragment;
                        }
                    }
                });
                return true;
            }
        });

    }
}