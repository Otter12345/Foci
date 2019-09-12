package com.fociandroid.foci.login;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.fociandroid.foci.HomeActivity;
import com.fociandroid.foci.R;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String[] prefixChoices = {"Mr", "Ms", "Miss", "Dr"};
    private static final String[] genderChoices = {"Female", "Male", "Others", "Prefer not say"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner prefixSpin = (Spinner) findViewById(R.id.prefix_field);
        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter<String> aa = new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_item, prefixChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        prefixSpin.setAdapter(aa);
        prefixSpin.setOnItemSelectedListener(this);

        Spinner genderSpin = (Spinner) findViewById(R.id.gender_field);
        //Creating the ArrayAdapter instance having the bank name list
        aa = new ArrayAdapter<String>(SignUpActivity.this, android.R.layout.simple_spinner_item, genderChoices);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        genderSpin.setAdapter(aa);
        genderSpin.setOnItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button cancelBtn = (Button)findViewById(R.id.cancel_action);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToHome();
            }
        });
    }

    private void returnToHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        switch (position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}
