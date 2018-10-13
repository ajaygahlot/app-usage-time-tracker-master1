package com.quirodev.usagestatsmanagersample;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quirodev.data.dbcontract;
import com.quirodev.data.dbhelper;
import com.quirodev.usagestatsmanagersample.R;

import static com.quirodev.usagestatsmanagersample.appitemdisplay.appname1;

public class OrangeFragment extends Fragment {

    public String usage,pkname2;
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
       appicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetail();
            }
        });
        String myValue = this.getArguments().getString("appname1");
        TextView t1= (TextView) v.findViewById(R.id.appname);
        t1.setText(myValue);
    //    displaydatabaseinfo(myValue);
        pkname2=this.getArguments().getString("pkname");
        //Log.v("testing1",pkname);
        Bundle extras = this.getArguments().getBundle("extras");
        Bitmap bmp=(Bitmap) extras.getParcelable("icon");
        appicon.setImageBitmap(bmp);
        usage = this.getArguments().getString("usage");
        TextView t2= (TextView) v.findViewById(R.id.usagetime);
        t2.setText(usage);
        return v;
    }
   private void openDetail() {

        Intent intent = new Intent(
                android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + pkname2));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void displaydatabaseinfo(String name){
        dbhelper mdbhelper= new dbhelper(getActivity());
        SQLiteDatabase db= mdbhelper.getReadableDatabase();
        //Cursor cursor=db.rawQuery("Select * from "+appdata.TABLE_NAME,null);
        String[] projection={
                dbcontract.appdata.APP_NAME,
                dbcontract.appdata._AL,
                dbcontract.appdata.APP_DURATION,
                dbcontract.appdata._ID
        };
        //String selection=dbcontract.appdata.APP_NAME+"=?";
        String [] args={name,};

        Cursor cursor = db.query(
                dbcontract.appdata.TABLE_NAME,
                projection,dbcontract.appdata.APP_NAME+"=?",args
                ,null,
                null,
                null
        );
        if (cursor!=null) {
            int appcolumnindex = cursor.getColumnIndex(dbcontract.appdata.APP_NAME);
            int appduration = cursor.getColumnIndex(dbcontract.appdata.APP_DURATION);
            int date=cursor.getColumnIndex(dbcontract.appdata._AL);
            TextView displayview = (TextView) getView().findViewById(R.id.database);
            displayview.setText("Number of rows in database table: " + cursor.getCount());
            while (cursor.moveToNext()) {
                String appname = cursor.getString(appcolumnindex);
                String duration = cursor.getString(appduration);
                String datecol=cursor.getString(date);
                displayview.append("\n"+appname+"  "+duration+" "+datecol+"\n");
            }
            cursor.close();
        }
    }
}