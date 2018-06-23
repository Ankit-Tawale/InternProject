package com.example.asus.afinal.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.asus.afinal.Change1Activity;
import com.example.asus.afinal.Change2Activity;
import com.example.asus.afinal.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    View root;
    Button upgrade;
    Button change1,change2;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_profile, container, false);

        upgrade = (Button)root.findViewById(R.id.upgrade);
        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),Upgrade.class);
                startActivity(intent);
            }
        });

        change1 = (Button) root.findViewById(R.id.change1);
        change1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Change1Activity.class);
                startActivity(i);
            }
        });

        change2 = (Button) root.findViewById(R.id.change2);
        change2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Change2Activity.class);
                startActivity(i);
            }
        });
        return root;
    }

}
