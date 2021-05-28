package com.example.saavn_app_praneeth;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saavn_app_praneeth.Adapters.EnglishAdapter;
import com.example.saavn_app_praneeth.Adapters.HindiAdapter;
import com.example.saavn_app_praneeth.Adapters.MalayalamAdapter;
import com.example.saavn_app_praneeth.Adapters.NewReleasesAdapter;
import com.example.saavn_app_praneeth.Adapters.RadioStationAdapter;
import com.example.saavn_app_praneeth.Adapters.TamilAdapter;
import com.example.saavn_app_praneeth.Adapters.TeluguAdapter;
import com.example.saavn_app_praneeth.Adapters.TrendingAdapter;
import com.example.saavn_app_praneeth.Response.ResponseModel;
import com.example.saavn_app_praneeth.Response.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicFragment extends Fragment {

    private RecyclerView EnglishRecyclerView;
    private RecyclerView TeluguRecyclerView;
    private RecyclerView HindiRecyclerView;
    private RecyclerView MalayalamRecyclerView;
    private RecyclerView TrendingRecyclerView;
    private RecyclerView TamilRecyclerView;
    private RecyclerView NewReleasesRecyclerView;
    private List<ResultsItem> resultsItemList = new ArrayList<>();
    private EnglishAdapter englishAdapter;
    private TeluguAdapter teluguAdapter;
    private HindiAdapter hindiAdapter;
    private TrendingAdapter trendingAdapter;
    private NewReleasesAdapter newReleasesAdapter;
    private TamilAdapter tamilAdapter;
    private MalayalamAdapter malayalamAdapter;
    private RecyclerView RadioStationRecyclerView;
    private RadioStationAdapter radioStationAdapter;
    private final String Radio="Radio Stations";
    private final String English = "Pop songs";
    private final String Hindi = " BollyWood Music";
    private final String Tamil = "Tamil Music";
    private final String Telugu = "Telugu";
    private final String Malayalam = "Malayalam Music";
    private final String Trending = "Trending Songs";
    private final String NewReleases = "New Songs";


    private FragmentLauncher fragmentLauncher;

    public MusicFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentLauncher = (FragmentLauncher) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        EnglishRecyclerView = view.findViewById(R.id.topEnglishRecyclerView);
        TeluguRecyclerView = view.findViewById(R.id.topTeluguRecyclerView);
        HindiRecyclerView = view.findViewById(R.id.topHindiRecyclerView);
        MalayalamRecyclerView = view.findViewById(R.id.malayalamRecyclerView);
        TrendingRecyclerView = view.findViewById(R.id.trendingRecyclerView);
        TamilRecyclerView = view.findViewById(R.id.topTamilRecyclerView);
        NewReleasesRecyclerView = view.findViewById(R.id.newReleasesRecyclerView);
        RadioStationRecyclerView= view.findViewById(R.id.RadioStationRecyclerView);
        startTeluguSongs();
        StartEnglishSongs();
        startTrending();
        startHindiSongs();
        startTamilSongs();
        startMalayalamSongs();
        startNewReleases();
startRadioStation();


    }

    private void startRadioStation() {
        callMRadioApi();
        setRadioAdapter();
    }

    private void setRadioAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        RadioStationRecyclerView.setLayoutManager(gridLayoutManager);
        radioStationAdapter = new RadioStationAdapter(resultsItemList);
        RadioStationRecyclerView.setAdapter(radioStationAdapter);

    }

    private void callMRadioApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Radio).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    radioStationAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void startMalayalamSongs() {
        callMalayalamApi();
        setMalayalamAdapter();
    }

    private void setMalayalamAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        MalayalamRecyclerView.setLayoutManager(linearLayoutManager);
        malayalamAdapter = new MalayalamAdapter(resultsItemList);
        MalayalamRecyclerView.setAdapter(malayalamAdapter);

    }

    private void callMalayalamApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Malayalam).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    malayalamAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void startTamilSongs() {
        callTamilApi();
        setTamilAdapter();
    }

    private void setTamilAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        TamilRecyclerView.setLayoutManager(linearLayoutManager);
        tamilAdapter = new TamilAdapter(resultsItemList);
        TamilRecyclerView.setAdapter(tamilAdapter);

    }

    private void callTamilApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Tamil).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    tamilAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void startNewReleases() {
        callNewReleasesApi();
        setNewReleasesAdapter();
    }

    private void callNewReleasesApi() {
        ApiService apiService=ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(NewReleases).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    newReleasesAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    private void setNewReleasesAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        NewReleasesRecyclerView.setLayoutManager(gridLayoutManager);
        newReleasesAdapter = new NewReleasesAdapter(resultsItemList);
       NewReleasesRecyclerView.setAdapter(newReleasesAdapter);


    }

    private void startTrending() {
        callTrendingApi();
        setTrendingAdapter();
    }

    private void setTrendingAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.HORIZONTAL, false);
        TrendingRecyclerView.setLayoutManager(gridLayoutManager);
        trendingAdapter = new TrendingAdapter(resultsItemList);
        TrendingRecyclerView.setAdapter(trendingAdapter);

    }

    private void callTrendingApi() {
        ApiService apiService = ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Trending).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    trendingAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void startHindiSongs() {
        callHindiApi();
        setHindiAdapter();
    }

    private void setHindiAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        HindiRecyclerView.setLayoutManager(linearLayoutManager);
        hindiAdapter = new HindiAdapter(resultsItemList);
        HindiRecyclerView.setAdapter(hindiAdapter);

    }

    private void callHindiApi() {
        ApiService apiService = ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Hindi).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    hindiAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void startTeluguSongs() {
        callTeluguApi();
        setTeluguAdapter();
    }

    private void setTeluguAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        TeluguRecyclerView.setLayoutManager(linearLayoutManager);
        teluguAdapter = new TeluguAdapter(resultsItemList);
        TeluguRecyclerView.setAdapter(teluguAdapter);

    }

    private void callTeluguApi() {
        ApiService apiService = ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(Telugu).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    teluguAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void StartEnglishSongs() {
        callEnglishApi();
        setEnglishAdapter();
    }

    private void callEnglishApi() {

        ApiService apiService = ApiNetwork.getRetrofitInstance().create(ApiService.class);
        apiService.getSongs(English).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    resultsItemList = response.body().getResults();
                    englishAdapter.updateAdapter(resultsItemList);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });

    }

    private void setEnglishAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        EnglishRecyclerView.setLayoutManager(linearLayoutManager);
        englishAdapter = new EnglishAdapter(resultsItemList);
        EnglishRecyclerView.setAdapter(englishAdapter);

    }
}