package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ezz.androiddisplayjokemodule.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.ezz.androiddisplayjokemodule.DisplayActivity.JOKE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Button btnSeeJoke;
    private Context context;
    private RelativeLayout rlProgress;


    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        context = getActivity();
        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        btnSeeJoke = (Button) view.findViewById(R.id.btnSeeJoke);
        rlProgress = (RelativeLayout) view.findViewById(R.id.rlProgress);

        btnSeeJoke.setOnClickListener(btnSeeJokeClickListener);
        return view;
    }

    private View.OnClickListener btnSeeJokeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            rlProgress.setVisibility(View.VISIBLE);
            btnSeeJoke.setEnabled(false);
            new JokesEndPointAsyncTask() {
                @Override
                protected void onPostExecute(String joke) {
                    super.onPostExecute(joke);
                    rlProgress.setVisibility(View.GONE);
                    btnSeeJoke.setEnabled(true);
                    if (!TextUtils.isEmpty(joke)) {
                        Intent intent = new Intent(context, DisplayActivity.class);
                        intent.putExtra(JOKE, joke);
                        startActivity(intent);
                    } else {
                        Toast.makeText(context, R.string.someThingWentWrong, Toast.LENGTH_LONG).show();
                    }
                }
            }.execute();
        }
    };

}
