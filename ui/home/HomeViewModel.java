package com.killer.myapplication.ui.home;

import android.app.AppComponentFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.killer.myapplication.R;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter Postal Code: ");
        //btnSearch=findViewById(R.id.button);
        //edtPC=findViewById(R.id.editText);
    }

    public LiveData<String> getText() {
        return mText;
    }
    /*public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch=findViewById(R.id.button);
        edtPC=findViewById(R.id.editText);
    }*/
}