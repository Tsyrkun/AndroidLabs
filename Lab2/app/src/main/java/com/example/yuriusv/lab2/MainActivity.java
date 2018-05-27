package com.example.yuriusv.lab2;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuriusv.lab2.ListSelectFragment.OnFragmentInteractionListener;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    ListSelectFragment fragmentListBox;
    MessageFragment fragmentMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFragments();
    }

    private void createFragments() {
        // Listbox
        fragmentListBox = new ListSelectFragment();
        addFragment(fragmentListBox, R.id.list);
        //Message
        fragmentMessage = new MessageFragment();
        addFragment(fragmentMessage, R.id.message);
    }

    private void addFragment(Fragment fragment, int id) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.add(id, fragment);
        //transaction.addToBackStack(null);

        transaction.commit();
    }

    private void replaceFragment(Fragment fragment, int id) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(id, fragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(String fragmentName, String message) {
        if (fragmentName.equals("ListSelectFragment")) {

            fragmentMessage.showMessage(message);
        }
    }
}
