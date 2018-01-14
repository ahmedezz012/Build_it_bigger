package com.ezz.androiddisplayjokemodule;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {


    private static final String JOKE = "JOKE";
    private String joke;
    private TextView txtJoke;

    public DisplayFragment() {
        // Required empty public constructor
    }

    public static DisplayFragment newInstance(String joke) {
        Bundle bundle = new Bundle();
        bundle.putString(JOKE, joke);
        DisplayFragment mainFragment = new DisplayFragment();
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            joke = getArguments().getString(JOKE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);
        txtJoke = view.findViewById(R.id.txtJoke);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtJoke.setText(joke);
    }
}
