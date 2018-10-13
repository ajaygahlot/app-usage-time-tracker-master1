package com.quirodev.usagestatsmanagersample;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quirodev.usagestatsmanagersample.R;

public class OrangeFragment extends Fragment {


    public OrangeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragmentorange, container, false);
        ImageView appicon=(ImageView) v.findViewById(R.id.appicon);
        //Log.v("testing1",pkname);
        Bundle extras = this.getArguments().getBundle("extras");
        Bitmap bmp=(Bitmap) extras.getParcelable("icon");
        appicon.setImageBitmap(bmp);
        String myValue2 = this.getArguments().getString("usage");
        TextView t2= (TextView) v.findViewById(R.id.usagetime);
        t2.setText(myValue2);
        String myValue = this.getArguments().getString("appname");
        TextView t1= (TextView) v.findViewById(R.id.appname);
        t1.setText(myValue);
        return v;
    }

}