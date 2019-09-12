package com.fociandroid.foci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fociandroid.foci.chef.VerificationActivity;
import com.fociandroid.foci.customer.CustomerFun;
import com.fociandroid.foci.login.SignUpActivity;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private static final String IS_GUEST = "is_guest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button customBtn = (Button) findViewById(R.id.customer_option);
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToSignupView();
            }
        });

        Button serverBtn = (Button) findViewById(R.id.server_option);
        serverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToSignupView();
            }
        });

        Button chefBtn = (Button) findViewById(R.id.chef_option);
        chefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToChefVerify();
            }
        });

        TextView guestBtn = (TextView) findViewById(R.id.guest_option);
        guestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToCustomerFun();
            }
        });
    }

    private void jumpToChefVerify(){
        Intent intent = new Intent(this, VerificationActivity.class);
        intent.putExtra(IS_GUEST, false);
        startActivity(intent);
    }

    private void jumpToSignupView(){
        Intent intent = new Intent(this, SignUpActivity.class);
        intent.putExtra(IS_GUEST, false);
        startActivity(intent);
    }

    private void jumpToCustomerFun(){
        Intent intent = new Intent(this, CustomerFun.class);
        Bundle mBundle = intent.getExtras();
        if (mBundle == null){
            mBundle = new Bundle();
        }

        mBundle.putBoolean(IS_GUEST, true);
        super.onSaveInstanceState(mBundle);
        intent.putExtras(mBundle);
        startActivity(intent);
    }
}
