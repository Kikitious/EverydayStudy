package com.katherine.du.everydaystudy.up20171226.container;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katherine.du.everydaystudy.R;

/**
 * Created by du on 17/12/26.
 */

public class FragmentA extends Fragment {

    private static final String TAG = "FragmentA";

    @Override
    public void onAttach(Context context) {
        Log.i(TAG, "onAttach: FragmentA");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: FragmentA");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: FragmentA");
        View view = inflater.inflate(R.layout.activity_empty, null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated: FragmentA");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart: FragmentA");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume: FragmentA");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause: FragmentA");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop: FragmentA");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: FragmentA");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: FragmentA");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach: FragmentA");
        super.onDetach();
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        Log.i(TAG, "onAttachFragment: FragmentA");
        super.onAttachFragment(childFragment);
    }

}
