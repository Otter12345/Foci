package com.fociandroid.foci.chef.ui.cheffun;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fociandroid.foci.R;
import com.fociandroid.foci.customer.CustomerFun;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChefAccountInfoFragment} interface
 * to handle interaction events.
 * Use the {@link ChefAccountInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChefAccountInfoFragment extends Fragment {
    public ChefAccountInfoFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static ChefAccountInfoFragment newInstance() {
        return new ChefAccountInfoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chef_account_info, container, false);
        Button customerBtn = (Button) view.findViewById(R.id.switch_customer);
        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToCustomerFun();
            }
        });
        return view;
    }

    private void jumpToCustomerFun(){
        Intent intent = new Intent(getActivity(), CustomerFun.class);
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }
}