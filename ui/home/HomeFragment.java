package com.killer.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.killer.myapplication.MainActivity;
import com.killer.myapplication.R;
import com.killer.myapplication.Selection;
import com.killer.myapplication.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeFragment extends Fragment {
    Button search;
    EditText txt;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        search= root.findViewById(R.id.button);
        txt= root.findViewById(R.id.editText);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String PostalStr=txt.getText().toString();
                if(!isCodeValidation(PostalStr)) {
                    search.setVisibility(View.GONE);
                    txt.setError("Invalid Postal Code");
                }
                else {
                    search.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), Selection.class);
                startActivity(intent);
            }
        });

        return root;

    }

    private boolean isCodeValidation(String postalStr) {
        String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(postalStr);
        System.out.println(matcher.matches());

        return matcher.matches();
    }

}