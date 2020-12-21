package com.cronocode.materialloginpage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment  {


  /*  @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,
                container, false);
        ImageView scanbtn = (ImageView) view.findViewById(R.id.scanbtn);
        scanbtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(Intent.ACTION_MAIN);
                i.setComponent(new ComponentName("com.learntodroid.androidqrcodescanner", "com.learntodroid.androidqrcodescanner.MainActivity"));
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
        });
        return view;
    }
}


