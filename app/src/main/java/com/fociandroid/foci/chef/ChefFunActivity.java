package com.fociandroid.foci.chef;

import android.os.Bundle;
import android.view.MenuItem;

import com.fociandroid.foci.R;
import com.fociandroid.foci.chef.ui.cheffun.ChefAccountInfoFragment;
import com.fociandroid.foci.chef.ui.cheffun.ChefFunFragment;
import com.fociandroid.foci.chef.ui.cheffun.ChefPostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ChefFunActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_fun_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_chef);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ChefFunFragment.newInstance())
                    .commitNow();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_food:
                            selectedFragment = ChefFunFragment.newInstance();
                            break;
                        case R.id.nav_posts_chef:
                            selectedFragment = ChefPostsFragment.newInstance();
                            break;
                        case R.id.nav_settings_chef:
                            selectedFragment = ChefAccountInfoFragment.newInstance();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
