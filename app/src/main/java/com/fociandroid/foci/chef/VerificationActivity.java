package com.fociandroid.foci.chef;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fociandroid.foci.R;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        TextView skipView = (TextView) findViewById(R.id.skip_action);
        skipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToChefFun();
            }
        });
    }

    private void jumpToChefFun(){
        Intent intent = new Intent(this, ChefFunActivity.class);
        startActivity(intent);
    }
}
