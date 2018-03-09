package com.example.root.tabview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Call extends Fragment {
    EditText fname, lname;
    Button b1;
    String name1, name2;

    public Call() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fname = (EditText)getActivity().findViewById(R.id.fname);
        lname = (EditText)getActivity().findViewById(R.id.lname);
        b1 = (Button)getActivity().findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = fname.getText().toString();
                name2 = lname.getText().toString();
                Toast.makeText(getActivity(), name1+" "+name2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_call, container, false);
    }

}
