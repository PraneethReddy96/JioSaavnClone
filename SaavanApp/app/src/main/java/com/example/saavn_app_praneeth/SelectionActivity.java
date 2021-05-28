package com.example.saavn_app_praneeth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

public class SelectionActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvJioLogo;
    private Button mBtnHindi, mBtnEnglish;
    private Button mBtnDone;
    private TextView mTvSelectLanguages, mTvOtherLanguages;
    private ImageView mIvPunjabi, mIvTamil, mIvTelgu;
    private RecyclerView mRecyclerView;
    private ArrayList<String> arrayList = new ArrayList<>();
    private SelectLanguagesAdapter languagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        initViews();

        // add languages in arraylist using arraylist
        arrayList.addAll(Arrays.asList("English","Hindi","Telugu","Malayalam","Tamil",
                "Kannada","Bhojpuri","Assamese"));
        // set Layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        languagesAdapter = new SelectLanguagesAdapter(this,arrayList);
        mRecyclerView.setAdapter(languagesAdapter);
        mBtnDone = findViewById(R.id.btnDone);
        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
// assign variable
        mIvJioLogo = findViewById(R.id.ivJioLogo);
//        mBtnHindi = findViewById(R.id.btnHindi);
//        mBtnEnglish = findViewById(R.id.btnEnglish);
        mTvSelectLanguages = findViewById(R.id.tvSelectLanguage);
        mTvOtherLanguages = findViewById(R.id.tvOtherLanguages);
//        mIvPunjabi = findViewById(R.id.ivPunjabi);
//        mIvTamil = findViewById(R.id.ivTamil);
//        mIvTelgu = findViewById(R.id.ivTelgu);
        mRecyclerView = findViewById(R.id.recyclerViewMainActivity);

        //-------------------------OnClick Listener-------------------------------------------//
//        mBtnHindi.setOnClickListener(this);
//        mBtnEnglish.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
//        switch (id){
//            case R.id.btnHindi:
//                break;
//            case R.id.btnEnglish:
//                break;
//        }
    }
}