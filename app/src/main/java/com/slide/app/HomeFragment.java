package com.slide.app;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.slide.app.adapter.ContactsAdapter;
import com.slide.app.model.Contact;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView rv_list;
    private ConstraintLayout mConstraintLayout;

    private ArrayList<Contact> contacts=new ArrayList<Contact>();
    private BottomNavigationView mBottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard

        View view=inflater.inflate(R.layout.fragment_home, null);

       /* DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;*/

        rv_list=view.findViewById(R.id.rv_list);

        // Initialize contacts
        contacts = Contact.createContactsList(19);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rv_list.setAdapter(adapter);
        // Set layout manager to position the items
        rv_list.setLayoutManager(new LinearLayoutManager(getActivity()));
        // That's all!


        return view;
    }
}