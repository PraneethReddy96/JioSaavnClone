package com.example.saavn_app_praneeth;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;


public class HomeFragment extends Fragment {


   private TextView tvMusic;
   private TextView tvPodCasts;
   private TextView tvMusicBackground;
   private TextView tvPodCastBackground;
   private Button btnGoPro;
   private FragmentLauncher fragmentLauncher;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentLauncher= (FragmentLauncher) context;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }



    private void initViews(View view) {
        tvMusic=view.findViewById(R.id.tvSelectMusic);
        tvMusicBackground=view.findViewById(R.id.tvSelectMusicBackground);
        tvPodCasts=view.findViewById(R.id.tvSelectPodcast);
        tvPodCastBackground=view.findViewById(R.id.tvSelectPodcastBackground);
        btnGoPro=view.findViewById(R.id.btnGoPro);

        defaultView();
        
        tvPodCastBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMusic.setVisibility(View.INVISIBLE);
                tvMusicBackground.setVisibility(View.VISIBLE);
                tvPodCastBackground.setVisibility(View.INVISIBLE);
                tvPodCasts.setVisibility(View.VISIBLE);
                launchPodCasts();
            }

            private void launchPodCasts() {
                Bundle bundle= new Bundle();
               fragmentLauncher.launchPodCastFragment(bundle);
            }
            
            
        });
        
        tvMusicBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMusicBackground.setVisibility(View.INVISIBLE);
                tvMusic.setVisibility(View.VISIBLE);
                tvPodCasts.setVisibility(View.INVISIBLE);
                tvPodCastBackground.setVisibility(View.VISIBLE);
                launchMusic();
            }

            private void launchMusic() {
                Bundle bundle= new Bundle();
                fragmentLauncher.launchMusicFragment(bundle);
            }
        });
    }

    private void defaultView() {
        tvMusic.setVisibility(View.VISIBLE);
        tvMusicBackground.setVisibility(View.INVISIBLE);
        tvPodCastBackground.setVisibility(View.VISIBLE);
        tvPodCasts.setVisibility(View.INVISIBLE);
        Bundle initialBundle= new Bundle();
       fragmentLauncher.launchMusicFragment(initialBundle);

    }
}