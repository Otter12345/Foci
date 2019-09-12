package com.fociandroid.foci.chef.ui.cheffun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fociandroid.foci.R;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChefPostsFragment} interface
 * to handle interaction events.
 * Use the {@link ChefPostsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChefPostsFragment extends Fragment {
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChefPostsFragment() {
        // Required empty public constructor
    }

    public static ChefPostsFragment newInstance() { return new ChefPostsFragment(); }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chef_posts, container, false);
    }
}