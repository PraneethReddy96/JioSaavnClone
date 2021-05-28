package com.example.saavn_app_praneeth;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LanguagesViewModel extends ViewModel {
    //init variable
    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    // Create set text method
    public void setText (String s){
        //set value
        mutableLiveData.setValue(s);
    }

    // Create get text method
    public MutableLiveData<String> getText() {
        return mutableLiveData;
    }
}
