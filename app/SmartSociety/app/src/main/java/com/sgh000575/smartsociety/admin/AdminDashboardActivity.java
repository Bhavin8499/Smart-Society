package com.sgh000575.smartsociety.admin;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sgh000575.smartsociety.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

public class AdminDashboardActivity extends AppCompatActivity implements     AdminHomeFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        AdminEventFragment.OnFragmentInteractionListener,
        AdminMaintanceFragment.OnFragmentInteractionListener,
        SettingFragment.OnFragmentInteractionListener {

    Fragment homeFragment,profileFragment, eventFragment, settingFragment, activeFragment, maintanceFragment;
    FragmentTransaction transaction;
    FragmentManager manager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        BottomNavigationView navigationView = findViewById(R.id.adminNavBar);

        navigationView.setOnNavigationItemSelectedListener(itemSelectedListener);

        homeFragment = new AdminHomeFragment();
        profileFragment = new ProfileFragment();
        eventFragment = new AdminEventFragment();
        maintanceFragment = new AdminMaintanceFragment();
        settingFragment = new SettingFragment();


        transaction = getSupportFragmentManager().beginTransaction();
        manager = getSupportFragmentManager();

        manager.beginTransaction().add(R.id.frame_container, profileFragment,"profile").hide(profileFragment).commit();
        manager.beginTransaction().add(R.id.frame_container, eventFragment,"EventFragment").hide(eventFragment).commit();
        manager.beginTransaction().add(R.id.frame_container, maintanceFragment,"maintance").hide(maintanceFragment).commit();
        manager.beginTransaction().add(R.id.frame_container, settingFragment,"setting").hide(settingFragment).commit();
        manager.beginTransaction().add(R.id.frame_container, homeFragment,"home").commit();
        activeFragment = homeFragment;

    }

    private BottomNavigationView.OnNavigationItemSelectedListener itemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch(menuItem.getItemId()){
                case R.id.navigation_home:
                    manager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                    activeFragment = homeFragment;
                    return true;
                case R.id.navigation_profile:
                    manager.beginTransaction().hide(activeFragment).show(profileFragment).commit();
                    activeFragment = profileFragment;
                    return true;
                case R.id.navigation_event:
                    manager.beginTransaction().hide(activeFragment).show(eventFragment).commit();
                    activeFragment = eventFragment;
                    return true;
                case R.id.navigation_maintance:
                    manager.beginTransaction().hide(activeFragment).show(maintanceFragment).commit();
                    activeFragment = maintanceFragment;
                    return true;
                case R.id.navigation_setting:
                    manager.beginTransaction().hide(activeFragment).show(settingFragment).commit();
                    activeFragment = settingFragment;
                    return true;
            }


            return false;
        }
    };

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
