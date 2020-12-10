package com.killer.myapplication.ui.gallery;

import android.content.Intent;
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
import com.killer.myapplication.UpdateProfile;

public class GalleryFragment extends Fragment {

    DBHelper db;
    TextView name,mail,number,address;
    Button update;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        db = new DBHelper(getActivity());
       // db = new DBHelper(this);
        name = root.findViewById(R.id.name);
        number = root.findViewById(R.id.mobile);
        mail = root.findViewById(R.id.mail);
        address = root.findViewById(R.id.address);
        update = root.findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = name.getText().toString();
                String mobile = number.getText().toString();
                String email = mail.getText().toString();
                String addres = address.getText().toString();



                /*long val = db.addUser(fname, email, mobile, addres);
                if(val > 0){
                    Toast.makeText(getContext(),"registered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), UpdateProfile.class);
                    //Intent moveToLogin = new Intent(SendFragment.,SendFragment.class);
                    startActivity(intent);
                   // Toast.makeText(GalleryFragment.this,"You have registered",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"Registeration Error",Toast.LENGTH_SHORT).show();
                }*/



            }
        });



        return root;
    }

}