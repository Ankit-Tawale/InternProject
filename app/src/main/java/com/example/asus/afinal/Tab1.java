package com.example.asus.afinal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View root;
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mTest = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Tab1.OnFragmentInteractionListener mListener;

    RelativeLayout r1,r2;
    ImageButton btn,btn2;
    RelativeLayout jb,Ca;
    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_tab1, container, false);
        r1 = (RelativeLayout) root.findViewById(R.id.id1);
        r2 = (RelativeLayout) root.findViewById(R.id.id2);
        btn = (ImageButton) root.findViewById(R.id.btn1);
        btn2 = (ImageButton) root.findViewById(R.id.btn2);

        jb = (RelativeLayout) root.findViewById(R.id.rll1);

        Ca = (RelativeLayout) root.findViewById(R.id.rll3);
        btn.setVisibility(View.INVISIBLE);
        r2.setVisibility(View.INVISIBLE);

        //  r2.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setVisibility(View.GONE);
                btn2.setVisibility(View.VISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r2.setVisibility(View.VISIBLE);
                btn.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.GONE);
            }

        });

        RelativeLayout jb =(RelativeLayout) root.findViewById(R.id.rll1);
        jb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getContext(),Physics.class);
                startActivity(intent);
            }
        });

        RelativeLayout Ca =(RelativeLayout) root.findViewById(R.id.rll3);
        Ca.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getContext(),CurrentAffairs.class);
                startActivity(intent);
            }
        });

        getData();
        
        return root;
    }

    private void getData() {

        mImageUrls.add(String.valueOf(R.id.image));
        mName.add("IAS Prelims 2018-Free...");
        mTest.add("Go to my Test");

        mImageUrls.add(String.valueOf(R.id.image));
        mName.add("IAS Prelims 2018-Free...");
        mTest.add("Go to my Test");

        mImageUrls.add(String.valueOf(R.id.image));
        mName.add("IAS Prelims 2018-Free...");
        mTest.add("Go to my Test");

        mImageUrls.add(String.valueOf(R.id.image));
        mName.add("IAS Prelims 2018-Free...");
        mTest.add("Go to my Test");

        initRecycler();
    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), HORIZONTAL,false);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(mName,mImageUrls,mTest,getContext());
        recyclerView.setAdapter(adapter);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (Tab1.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

