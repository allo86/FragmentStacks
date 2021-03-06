package com.allo.fragmentstacks.random;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allo.fragmentstacks.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RandomFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RandomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomFragment extends Fragment {

    private final String TAG_LOG = this.toString();

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
        void performFragmentTransaction(Fragment fragment, boolean addToBackStack);
    }

    private OnFragmentInteractionListener mListener;

    public RandomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RandomFragment.
     */
    public static RandomFragment newInstance() {
        return new RandomFragment();
    }

    private TextView tvGeneratedNumber;

    private int mGeneratedNumber;

    private static final String GENERATED_NUMBER = "GENERATED_NUMBER";

    @Override
    public void onAttach(Context context) {
        Log.d(TAG_LOG, "onAttach");

        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG_LOG, "onCreate");
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            Log.d(TAG_LOG, "onCreate old instance");
        } else {
            Log.d(TAG_LOG, "onCreate new instance");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG_LOG, "onCreateView");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_random, container, false);

        initializeUI(view);

        return view;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        Log.d(TAG_LOG, "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);

        if (savedInstanceState != null) {
            Log.d(TAG_LOG, "onViewStateRestored old instance");
        } else {
            Log.d(TAG_LOG, "onViewStateRestored new instance");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG_LOG, "onActivityCreated");

        if (savedInstanceState != null) {
            initializeDataFromSavedState(savedInstanceState);
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
        showData();
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
    public void onDestroyView() {
        Log.d(TAG_LOG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG_LOG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG_LOG, "onDetach");
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d(TAG_LOG, "onSaveInstanceState");

        outState.putInt(GENERATED_NUMBER, mGeneratedNumber);

        super.onSaveInstanceState(outState);
    }

    protected void initializeDataFromSavedState(Bundle savedInstanceState) {
        mGeneratedNumber = savedInstanceState.getInt(GENERATED_NUMBER, 0);
    }

    protected void initializeUI(View view) {
        tvGeneratedNumber = (TextView) view.findViewById(R.id.tv_generated_number);

        view.findViewById(R.id.bt_generate_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGeneratedNumber = generateRandomNumber();
                showData();
            }
        });

        view.findViewById(R.id.bt_new_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFragment();
            }
        });
    }

    protected void showData() {
        if (mGeneratedNumber != 0) tvGeneratedNumber.setText(String.valueOf(mGeneratedNumber));
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * (20 - 1)) + 1;
    }

    private void addNewFragment() {
        Fragment fragment = RandomFragment.newInstance();
        if (mListener != null) mListener.performFragmentTransaction(fragment, true);
    }
}
