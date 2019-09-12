package com.fociandroid.foci.customer;

import android.os.Bundle;
import android.view.MenuItem;

import com.fociandroid.foci.R;
import com.fociandroid.foci.customer.ui.customerfun.AccountInfoFragment;
import com.fociandroid.foci.customer.ui.customerfun.NoTableFragment;
import com.fociandroid.foci.customer.ui.customerfun.PostsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CustomerFun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_fun_activity);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_customer);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NoTableFragment.newInstance())
                    .commitNow();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_orders:
                            selectedFragment = NoTableFragment.newInstance();
                            break;
                        case R.id.nav_posts:
                            selectedFragment = PostsFragment.newInstance();
                            break;
                        case R.id.nav_settings:
                            selectedFragment = AccountInfoFragment.newInstance();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
