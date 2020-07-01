package com.example.myapplication.ui.graph;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.calculator.parser.ParserCalc;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class GraphFragment extends Fragment {
    private ParserCalc parser = new ParserCalc();
    private static int i = 0;
    private static boolean start = false;
    private static String lastNumber = "", lastCommand = "";
    private static TextView graphText;
    private static GraphView graph;
    private static double counter;
    private static double fixed = 100.0;
    private static double xLeft = -30.0;
    private static double xRight = 30.0;
    private static double step = 0.015625;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_graph, container, false);

        graph = root.findViewById(R.id.graph);
        graphText = root.findViewById(R.id.graphInput);


        View.OnClickListener btn0 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start) {
                    graphText.setText("");

                    //start=true;
                }

                switch (v.getId()) {
                    case R.id.graphBX:
                        if (lastCommand != ")" && lastNumber == "") {
                            start = true;
                            lastCommand = "";
                            lastNumber = "X";
                            graphText.setText(graphText.getText() + "X");
                        }
                        break;
                    case R.id.graphB0:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastCommand = "";
                            lastNumber += "0";
                            graphText.setText(graphText.getText() + "0");
                        }
                        break;
                    case R.id.graphB1:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "1");
                        }
                        break;
                    case R.id.graphB2:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "2");
                        }
                        break;
                    case R.id.graphB3:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "3");
                        }
                        break;
                    case R.id.graphB4:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "4");
                        }
                        break;
                    case R.id.graphB5:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "5");
                        }
                        break;
                    case R.id.graphB6:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "6");
                        }
                        break;
                    case R.id.graphB7:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "7");
                        }
                        break;
                    case R.id.graphB8:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "8");
                        }
                        break;
                    case R.id.graphB9:
                        if (lastCommand != ")" && lastNumber != "X") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "9");
                        }
                        break;
                    case R.id.graphBPi:
                        if (lastCommand != ")" && lastNumber == "") {
                            start = true;
                            lastCommand = "";
                            graphText.setText(graphText.getText() + "p");
                            lastNumber += "p";
                        }
                        break;
                    case R.id.graphBMinus:
                        if (lastCommand == "" || lastCommand == "(" || lastCommand == ")") {
                            start = true;
                            graphText.setText(graphText.getText() + "-");
                            lastNumber = "";
                            lastCommand = "-";
                        }
                        break;
                    case R.id.graphBSum:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            graphText.setText(graphText.getText() + "+");
                            lastNumber = "";
                            lastCommand = "+";
                        }
                        break;
                    case R.id.graphBDivision:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            graphText.setText(graphText.getText() + "/");
                            lastNumber = "";
                            lastCommand = "/";
                        }
                        break;
                    case R.id.graphBMulti:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            graphText.setText(graphText.getText() + "*");
                            lastNumber = "";
                            lastCommand = "*";
                        }
                        break;
                    case R.id.graphBPoint:
                        if (!lastNumber.contains(".") && lastNumber != "pi" && lastNumber != "X" && start && lastCommand == "") {
                            graphText.setText(graphText.getText() + ".");
                            lastNumber += ".";
                            lastCommand = ".";
                        }
                        break;
                    case R.id.graphBBracketClose: {

                        if (i > 0 && (lastCommand == "" || lastCommand == ")")) {
                            graphText.setText(graphText.getText() + ")");
                            i--;
                            lastNumber = "";
                            lastCommand = ")";
                        }

                    }
                    break;
                    case R.id.graphBBracketOpen: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")") {
                            start = true;
                            i++;
                            graphText.setText(graphText.getText() + "(");
                            lastNumber = "";
                            lastCommand = "(";
                        }
                    }
                    break;
                    case R.id.graphBC: {
                        graphText.setText("0.00");
                        i = 0;
                        start = false;
                        lastNumber = "";
                        lastCommand = "";
                    }
                    break;

                    case R.id.graphBSin: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            graphText.setText(graphText.getText() + "sin");
                            lastNumber = "";
                            lastCommand = "sin";
                        }
                    }
                    break;
                    case R.id.graphBCos: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            graphText.setText(graphText.getText() + "cos");
                            lastNumber = "";
                            lastCommand = "cos";
                        }
                    }
                    break;
                    case R.id.graphBTan: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            graphText.setText(graphText.getText() + "tan");
                            lastNumber = "";
                            lastCommand = "tan";
                        }
                    }
                    break;
                    case R.id.graphBLn: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            graphText.setText(graphText.getText() + "ln");
                            lastNumber = "";
                            lastCommand = "ln";
                        }
                    }
                    break;
                    case R.id.graphBExp: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            graphText.setText(graphText.getText() + "exp");
                            lastNumber = "";
                            lastCommand = "e";
                        }
                    }
                    break;
                    case R.id.graphBPow:
                        if (start && (lastCommand == "" || lastCommand == ")" && lastCommand.length() <= 1)) {
                            graphText.setText(graphText.getText() + "^");
                            lastNumber = "";
                            lastCommand = "^";
                        }
                        break;
                    case R.id.graphBClear:
                        graph.removeAllSeries();
                        break;
                    case R.id.graphBPaint:
                        if (i == 0 && (lastCommand == "" || lastCommand == ")")) {
                            String s = graphText.getText().toString();
                            counter = xLeft;
                            while (counter < xRight) {
                                LineGraphSeries<DataPoint> Dots = formulaToDots(s);
                                if (!Dots.isEmpty()) graph.addSeries(Dots);
                            }

                            graph.getViewport().setYAxisBoundsManual(true);
                            graph.getViewport().setMinY(-100);
                            graph.getViewport().setMaxY(100);

                            graph.getViewport().setXAxisBoundsManual(true);
                            graph.getViewport().setMinX(-30);
                            graph.getViewport().setMaxX(30);

                            graph.getViewport().setScalable(true);
                            graph.getViewport().setScalableY(true);
                            i = 0;
                            start = false;
                            lastNumber = "";
                            lastCommand = "";
                        } else if (i != 0)
                            Toast.makeText(getActivity(), "Количество скобок не совпадает", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Введите выражение", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + v.getId());
                }
            }


        };

        root.findViewById(R.id.graphBPaint).setOnClickListener(btn0);
        root.findViewById(R.id.graphBClear).setOnClickListener(btn0);
        root.findViewById(R.id.graphBX).setOnClickListener(btn0);
        root.findViewById(R.id.graphB0).setOnClickListener(btn0);
        root.findViewById(R.id.graphB1).setOnClickListener(btn0);
        root.findViewById(R.id.graphB2).setOnClickListener(btn0);
        root.findViewById(R.id.graphB3).setOnClickListener(btn0);
        root.findViewById(R.id.graphB4).setOnClickListener(btn0);
        root.findViewById(R.id.graphB5).setOnClickListener(btn0);
        root.findViewById(R.id.graphB6).setOnClickListener(btn0);
        root.findViewById(R.id.graphB7).setOnClickListener(btn0);
        root.findViewById(R.id.graphB8).setOnClickListener(btn0);
        root.findViewById(R.id.graphB9).setOnClickListener(btn0);
        root.findViewById(R.id.graphBBracketClose).setOnClickListener(btn0);
        root.findViewById(R.id.graphBBracketOpen).setOnClickListener(btn0);
        root.findViewById(R.id.graphBC).setOnClickListener(btn0);
        root.findViewById(R.id.graphBDivision).setOnClickListener(btn0);
        root.findViewById(R.id.graphBMinus).setOnClickListener(btn0);
        root.findViewById(R.id.graphBMulti).setOnClickListener(btn0);
        root.findViewById(R.id.graphBSum).setOnClickListener(btn0);
        root.findViewById(R.id.graphBPoint).setOnClickListener(btn0);
        root.findViewById(R.id.graphBPow).setOnClickListener(btn0);
        root.findViewById(R.id.graphBPi).setOnClickListener(btn0);
        root.findViewById(R.id.graphBSin).setOnClickListener(btn0);
        root.findViewById(R.id.graphBCos).setOnClickListener(btn0);
        root.findViewById(R.id.graphBTan).setOnClickListener(btn0);
        root.findViewById(R.id.graphBExp).setOnClickListener(btn0);
        root.findViewById(R.id.graphBLn).setOnClickListener(btn0);
        return root;
    }

    LineGraphSeries<DataPoint> formulaToDots(String str) {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();

        for (; counter <= xRight; counter += step) {
            String buf = str.replace("X", "(" + String.valueOf(counter) + ")");
            double y = Double.parseDouble(parser.start(buf));
            if (Math.abs(y) > fixed) {
                counter += step;
                return series;
            }
            series.appendData(new DataPoint(counter, y), true, (int) ((xRight - xLeft) / step + 1));

        }

        return series;
    }
}