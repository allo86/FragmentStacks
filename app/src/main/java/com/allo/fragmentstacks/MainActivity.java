package com.allo.fragmentstacks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.allo.fragmentstacks.random.RandomFragment;

public class MainActivity extends AppCompatActivity implements RandomFragment.OnFragmentInteractionListener {

    private final String TAG_LOG = this.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG_LOG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            performFragmentTransaction(RandomFragment.newInstance(), false);
        }
    }

    @Override
    public void onStart() {
        Log.d(TAG_LOG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG_LOG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG_LOG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG_LOG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG_LOG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG_LOG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG_LOG, "onBackPressed");
        super.onBackPressed();
    }

    @Override
    public void performFragmentTransaction(Fragment fragment, boolean addToBackStack) {
        Log.d(TAG_LOG, "performFragmentTransaction: " + fragment.toString());

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        if (addToBackStack) ft.addToBackStack(fragment.toString());
        ft.commit();
    }
}
