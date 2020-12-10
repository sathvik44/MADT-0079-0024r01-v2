package com.killer.myapplication.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.killer.myapplication.DBHelper;
import com.killer.myapplication.R;

public class SlideshowFragment extends Fragment {

    DBHelper db;
    EditText cardName;
    EditText cardNumber;
    EditText expiry;
    EditText cvv;
    Button save;


    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        db = new DBHelper(getActivity());
        // db = new DBHelper(this);
        cardName = root.findViewById(R.id.cardName);
        cardNumber = root.findViewById(R.id.cardNumber);
        expiry = root.findViewById(R.id.expiry);
        cvv = root.findViewById(R.id.cvv);
        save = root.findViewById(R.id.update);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = cardName.getText().toString();
                String number = cardNumber.getText().toString();
                String expiry1 = expiry.getText().toString();
                String cvv1 = cvv.getText().toString();



                long val = db.addPayment(name, number, expiry1, cvv1);
                if(val > 0){
                    Toast.makeText(getContext(),"registered",Toast.LENGTH_LONG).show();
                    // Toast.makeText(GalleryFragment.this,"You have registered",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"Registeration Error",Toast.LENGTH_SHORT).show();
                }



            }
        });

        return root;
    }
}