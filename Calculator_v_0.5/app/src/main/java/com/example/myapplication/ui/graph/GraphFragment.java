package com.example.myapplication.ui.graph;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.example.myapplication.ui.calculator.parser.ParserCalc;

public class GraphFragment extends Fragment {
    private ParserCalc parser=new ParserCalc();
    private static TextView graphText;
    private static GraphView graph;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_graph, container, false);
         graph =  root.findViewById(R.id.graph);
         graphText = root.findViewById(R.id.graphFormulaInput);


        View.OnClickListener btn0 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = graphText.getText().toString();
                LineGraphSeries<DataPoint> Dots = formulaToDots(s);
                graph.addSeries(Dots);
            }
        };

        root.findViewById(R.id.graphFragButton).setOnClickListener(btn0);
        return root;
    }
    LineGraphSeries<DataPoint> formulaToDots(String str)
    {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (double x = 0;x<20.0;x+=0.1)
        {
            String buf = str.replace("x","("+String.valueOf(x)+")");
            double y = Double.parseDouble(parser.start(buf));
            series.appendData(new DataPoint(x,y),true,200);
        }

        return series;
    }
}