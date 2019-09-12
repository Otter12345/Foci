package com.fociandroid.foci.customer.ui.customerfun;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fociandroid.foci.R;
import com.fociandroid.foci.chef.ChefFunActivity;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountInfoFragment} interface
 * to handle interaction events.
 * Use the {@link AccountInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountInfoFragment extends Fragment {
    private static final String IS_GUEST = "is_guest";

    public AccountInfoFragment() {
        // Required empty public constructor
    }

    public static AccountInfoFragment newInstance(){return new AccountInfoFragment();}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_account_info, container, false);
        Button chefBtn = (Button) view.findViewById(R.id.switch_chef);
        chefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToChefFun();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.onSaveInstanceState(savedInstanceState);
        View view = getView();
        EditText mNameView = (EditText) view.findViewById(R.id.username_edit_view);
        TextView fakeNameView = (TextView) view.findViewById(R.id.name_text_view);

        mNameView.setVisibility(View.INVISIBLE);
        fakeNameView.setVisibility(View.VISIBLE);
    }

    private void jumpToChefFun(){
        Intent intent = new Intent(getActivity(), ChefFunActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(0, 0);
    }
}
