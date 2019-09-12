package com.fociandroid.foci.customer.ui.customerfun;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fociandroid.foci.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static androidx.constraintlayout.widget.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NoTableFragment} interface
 * to handle interaction events.
 * Use the {@link NoTableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoTableFragment extends Fragment {
    private static final String HAS_TABLE = "has_table";
    private static final String TRANS_CODE = "trans_code";
    private static final String ORDER_ID = "order_id";

    private FirebaseFirestore mDatabase;
    private EditText mTableCode;
    private View focusView;

    public NoTableFragment() {
        // Required empty public constructor
    }

    public static NoTableFragment newInstance() {
        return new NoTableFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (savedInstanceState != null && getArguments() != null){
            if (getArguments().containsKey(HAS_TABLE) && getArguments().getBoolean(HAS_TABLE)){
                @Nullable String transCode = getArguments().getString(TRANS_CODE);
                @Nullable String orderId = getArguments().getString(ORDER_ID);
                if (transCode != null && orderId != null && getFragmentManager() != null) {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container, CustomerFunFragment.newInstance())
                            .commitNow();
                }
            }
        }
    }

    private void onCodeSubmit(){
        mTableCode = (EditText)getView().findViewById(R.id.tableCode_field);
        mTableCode.setError(null);
        focusView = null;
        Boolean cancel = false;
        final String code = mTableCode.getText().toString();

        if (TextUtils.isEmpty(code)) {
            mTableCode.setError(getString(R.string.error_field_required));
            focusView = mTableCode;
            focusView.requestFocus();
        }
        else{
            validateCode(code);
        }
    }

    private void validateCode(String codeInput)
    {
        mDatabase =  FirebaseFirestore.getInstance();
        DocumentReference transactionRef = mDatabase.collection("transactions").document(codeInput);
        transactionRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {
                        try {
                            if (document.getBoolean("is_completed")) {
                                mTableCode.setError("Code has expired.");
                                focusView = mTableCode;
                                focusView.requestFocus();
                            }
                            else{
                                getArguments().putBoolean(HAS_TABLE, true);
                                jumpToCustomerFun();
                            }
                        }
                        catch (Exception e){
                            Log.println(Log.ERROR,TAG,"null in table code validation");
                        }
                    }
                    else {
                        mTableCode.setError("Invalid code.");
                        focusView = mTableCode;
                        focusView.requestFocus();
                    }
                } else {
                    mTableCode.setError("Unable to validate the code.");
                    focusView = mTableCode;
                    focusView.requestFocus();
                }
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_no_table, container, false);
        Button submitBtn = (Button) view.findViewById(R.id.code_confirm_action);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCodeSubmit();
            }
        });

        TextView skipBtn = (TextView) view.findViewById(R.id.skip_table_action);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToCustomerFun();
            }
        });

        return view;
    }

    private void jumpToCustomerFun(){
        getFragmentManager().beginTransaction()
                .replace(R.id.container, CustomerFunFragment.newInstance())
                .commitNow();
    }
}
