package com.quirodev.usagestatsmanagersample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class AppleFragment extends Fragment {

    public AppleFragment() {
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
       View v = inflater.inflate(R.layout.fragmentapple, container, false);
        TextView title1= (TextView) v.findViewById(R.id.title1);
        title1.setText("DAILY");
        TextView title2= (TextView) v.findViewById(R.id.title2);
        title2.setText("WEEKLY");
        TextView title3= (TextView) v.findViewById(R.id.title3);
        title3.setText("MONTHLY");
        TextView title4= (TextView) v.findViewById(R.id.title4);
        title4.setText("YEARLY");

        LineChart lineChart1 = (LineChart) v.findViewById(R.id.chart1);
        // creating list of entry<br />

        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        entries.add(new Entry(5f,7));
        LineDataSet dataset = new LineDataSet(entries,"app usage");
        ArrayList<String>labels = new ArrayList<String>();
        labels.add("today");
        labels.add("yesterday");
        labels.add("thurday");
        labels.add("wednesday");
        labels.add("tuesday");
        labels.add("monday");
        labels.add("sunday");
        LineData data = new LineData(labels, dataset);
        lineChart1.setData(data);
        lineChart1.setDescription("days");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        lineChart1.animateY(5000);
        LineChart lineChart2 = (LineChart) v.findViewById(R.id.chart2);
        lineChart2.setData(data);
        lineChart2.setDescription("weeks");
        lineChart2.animateY(5000);
        LineChart lineChart3 = (LineChart) v.findViewById(R.id.chart3);
        lineChart3.setData(data);
        lineChart3.setDescription("monthly");
        lineChart3.animateY(5000);
        LineChart lineChart4 = (LineChart) v.findViewById(R.id.chart4);
        lineChart4.setData(data);
        lineChart4.setDescription("yearly");
        lineChart4.animateY(5000);
        return v;
    }

}