package com.shashank.navigationdrawer.Dashboard;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.shashank.navigationdrawer.R;

public class ProfileFragment extends Fragment {


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_profile, container, false);

        }
    }