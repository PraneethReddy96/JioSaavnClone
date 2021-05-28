package com.example.saavn_app_praneeth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.saavn_app_praneeth.Response.ResultsItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FragmentLauncher{

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentLauncher fragmentLauncher;
    private ImageView ivSearch;
    private EditText etSearch;
    private List<ResultsItem> resultsItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        etSearch=findViewById(R.id.etSearch);
        fragmentManager= getSupportFragmentManager();
        bottomNavigationView=findViewById(R.id.BottomNavigationBar);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        defaultFragment();

    }

    private void defaultFragment() {
        HomeFragment homeFragment= new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,homeFragment,"Home").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment= null;
            switch (item.getItemId()){
                case R.id.HomeIcon:
                    selectedFragment= new HomeFragment();
                    break;
                case R.id.SearchIcon:
                    searchBar();
                    selectedFragment= new SearchFragment();
                    break;
                case R.id.BrowseIcon:
                    selectedFragment= new BrowseFragment();
                    break;
                case R.id.MyLibraryIcon:
                    selectedFragment= new MyLibraryFragment();
                    break;



            }
            getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,selectedFragment).commit();
            return true;
        }


    };

    @Override
    public void launchMusicFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        MusicFragment musicFragment= new MusicFragment();
        musicFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flHomeContainer,musicFragment,"Music fragment").commit();
    }

    @Override
    public void launchPodCastFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        PodcastFragment podcastFragment=new PodcastFragment();
        podcastFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.flHomeContainer,podcastFragment,"PodCast Fragment").commit();
    }


    private void searchBar() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                MainActivity.this, R.style.BottomSheetDialogueTheme);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.bottom_search_bar, findViewById(R.id.bottomSearchContainer));
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        ivSearch = bottomSheetView.findViewById(R.id.searchIcon);
        etSearch = bottomSheetView.findViewById(R.id.etSearch);

        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Search_activity.class);
                intent.putExtra("SearchKey", etSearch.getText().toString());
                startActivity(intent);
                etSearch.setText("");

            }
        });
    }


    @Override
    public void launchMusicPlayer(Bundle bundle) {
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setArguments(bundle);
        fragmentTransaction.replace(R.id.flContainer,musicPlayer,"Music Player").commit();

    }
}