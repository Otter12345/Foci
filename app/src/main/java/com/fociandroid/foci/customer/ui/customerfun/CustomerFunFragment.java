package com.fociandroid.foci.customer.ui.customerfun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.fociandroid.foci.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class CustomerFunFragment extends Fragment {
    private static final String TRANS_CODE = "transaction_code";
    private static final String ORDER_ID = "order_id";
    private static final Map<String, String> simple_menu;
    static {
        simple_menu = new HashMap<>();
        simple_menu.put("First Course", "Smoked Sea Scouts*");
        simple_menu.put("Second Course", "WALL GREEN");
        simple_menu.put("Third Course", "CAPPELLETTI28");
        simple_menu.put("Fourth Course", "CHOCOLATE BOMBE");
    }

    private FirebaseFirestore mDatabase;
    private CustomerFunViewModel mViewModel;

    public static CustomerFunFragment newInstance() {
        return new CustomerFunFragment();
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customer_fun_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        ImageButton closeBtn = view.findViewById(R.id.close_action);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissCommuteSection();
            }
        });

        for (int i = 1; i < 5; i++) {
            String s = "item"+i;
            CardView menu_item = (CardView) view.findViewWithTag(s);
            menu_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showCommuteSection();
                }
            });
        }
    }

    private void showCommuteSection(){
        View commentView = getView().findViewById(R.id.comment_section);
        commentView.setVisibility(View.VISIBLE);
    }

    private void dismissCommuteSection(){
        View commentView = getView().findViewById(R.id.comment_section);
        commentView.setVisibility(View.GONE);
    }
}
