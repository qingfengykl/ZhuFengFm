package com.example.kelin.zhufengfm.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kelin.zhufengfm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoveryRatingFragment extends Fragment {


    public DiscoveryRatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.discovery_rating_fragment, container, false);
    }

}