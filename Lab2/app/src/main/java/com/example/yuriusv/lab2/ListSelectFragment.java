package com.example.yuriusv.lab2;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListSelectFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListSelectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListSelectFragment extends Fragment {

    Button _buttonOk, _buttonCancel;
    Spinner _spinnerMessageType;

    private OnFragmentInteractionListener mListener;
    private View view;

    public ListSelectFragment() {
        // Required empty public constructor
    }


    public static ListSelectFragment newInstance(String message) {
        ListSelectFragment fragment = new ListSelectFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.view = view;

        initItems();
        initHandlers();
        initValues();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list_select, container, false);
    }

    private void initItems() {

        _buttonOk = (Button)view.findViewById(R.id.buttonOk);
        _buttonCancel = (Button)view.findViewById(R.id.buttonCancel);

        _spinnerMessageType = (Spinner)view.findViewById(R.id.spinner);
    }

    private void initHandlers() {
        _buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClicked(true);
            }
        });

        _buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClicked(false);
            }
        });
    }

    protected String[] getSpinnerValues() {
        return new String[] {"C#", "Java", "Python"};
    }

    private void initValues() {
        String spinnerValues[] = getSpinnerValues();
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (getView().getContext(), android.R.layout.simple_spinner_item,
                        spinnerValues);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        _spinnerMessageType.setAdapter(spinnerArrayAdapter);
    }

    private String getSelectedValue() {
        return _spinnerMessageType.getSelectedItem().toString();
    }

    private void handleButtonClicked(boolean isOk) {
        String textToShow = String.format("%s is %s", getSelectedValue(), isOk ? "Ok": "Canceled");
        mListener.onFragmentInteraction("ListSelectFragment", textToShow);
    }

    @Override
        public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener)activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String fragmentName, String message);
    }
}
