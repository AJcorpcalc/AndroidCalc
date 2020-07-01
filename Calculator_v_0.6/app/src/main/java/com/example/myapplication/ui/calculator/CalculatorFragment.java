package com.example.myapplication.ui.calculator;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ui.calculator.parser.ParserCalc;

public class CalculatorFragment extends Fragment {
    private ParserCalc parser = new ParserCalc();
    private static int i = 0;
    private static boolean start = false;
    private static TextView calcText;
    private static String lastNumber = "", lastCommand = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_calculator, container, false);
        calcText = (TextView) root.findViewById(R.id.text);


        View.OnClickListener btn0 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!start) {
                    calcText.setText("");

                    //start=true;
                }

                switch (v.getId()) {
                    case R.id.B0:
                        if (lastCommand != ")") {
                            start = true;
                            lastCommand = "";

                            lastNumber += "0";
                            calcText.setText(calcText.getText() + "0");
                        }
                        break;
                    case R.id.B1:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "1");
                        }
                        break;
                    case R.id.B2:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "2");
                        }
                        break;
                    case R.id.B3:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "3");
                        }
                        break;
                    case R.id.B4:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "4");
                        }
                        break;
                    case R.id.B5:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "5");
                        }
                        break;
                    case R.id.B6:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "6");
                        }
                        break;
                    case R.id.B7:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "7");
                        }
                        break;
                    case R.id.B8:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "8");
                        }
                        break;
                    case R.id.B9:
                        if (lastCommand != ")") {
                            start = true;
                            lastNumber += "0";
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "9");
                        }
                        break;
                    case R.id.BPi:
                        if (lastCommand != ")" && lastNumber == "") {
                            start = true;
                            lastCommand = "";
                            calcText.setText(calcText.getText() + "p");
                            lastNumber += "p";
                        }
                        break;
                    case R.id.BMinus:
                        if (lastCommand == "" || lastCommand == "(" || lastCommand == ")") {
                            start = true;
                            calcText.setText(calcText.getText() + "-");
                            lastNumber = "";
                            lastCommand = "-";
                        }
                        break;
                    case R.id.BSum:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            calcText.setText(calcText.getText() + "+");
                            lastNumber = "";
                            lastCommand = "+";
                        }
                        break;
                    case R.id.BDivision:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            calcText.setText(calcText.getText() + "/");
                            lastNumber = "";
                            lastCommand = "/";
                        }
                        break;
                    case R.id.BMulti:
                        if (start && (lastCommand == "" || lastCommand == ")")) {
                            calcText.setText(calcText.getText() + "*");
                            lastNumber = "";
                            lastCommand = "*";
                        }
                        break;
                    case R.id.BPoint:
                        if (!lastNumber.contains(".") && lastNumber != "pi" && start && lastCommand == "") {
                            calcText.setText(calcText.getText() + ".");
                            lastNumber += ".";
                            lastCommand = ".";
                        }
                        break;
                    case R.id.BBracketClose: {

                        if (i > 0 && (lastCommand == "" || lastCommand == ")")) {
                            calcText.setText(calcText.getText() + ")");
                            i--;
                            lastNumber = "";
                            lastCommand = ")";
                        }

                    }
                    break;
                    case R.id.BBracketOpen: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")") {
                            start = true;
                            i++;
                            calcText.setText(calcText.getText() + "(");
                            lastNumber = "";
                            lastCommand = "(";
                        }
                    }
                    break;
                    case R.id.BC: {
                        calcText.setText("0.00");
                        i = 0;
                        start = false;
                        lastNumber = "";
                        lastCommand = "";
                    }
                    break;
                    case R.id.BEqual:
                        if (i == 0 && (lastCommand == "" || lastCommand == ")")) {
                            calcText.setText(parser.start(calcText.getText().toString()));
                            i = 0;
                            start = false;
                            lastNumber = "";
                            lastCommand = "";
                        } else if (i != 0)
                            Toast.makeText(getActivity(), "Количество скобок не совпадает", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getActivity(), "Введите выражение", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.BSin: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            calcText.setText(calcText.getText() + "sin");
                            lastNumber = "";
                            lastCommand = "sin";
                        }
                    }
                    break;
                    case R.id.BCos: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            calcText.setText(calcText.getText() + "cos");
                            lastNumber = "";
                            lastCommand = "cos";
                        }
                    }
                    break;
                    case R.id.BTan: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            calcText.setText(calcText.getText() + "tan");
                            lastNumber = "";
                            lastCommand = "tan";
                        }
                    }
                    break;
                    case R.id.BLn: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            calcText.setText(calcText.getText() + "ln");
                            lastNumber = "";
                            lastCommand = "ln";
                        }
                    }
                    break;
                    case R.id.BExp: {
                        if (lastCommand != "." && (lastCommand != "" || !start) && lastCommand != ")" && lastCommand.length() <= 1) {
                            start = true;

                            calcText.setText(calcText.getText() + "exp");
                            lastNumber = "";
                            lastCommand = "e";
                        }
                    }
                    break;
                    case R.id.BPow:
                        if (start && (lastCommand == "" || lastCommand == ")" && lastCommand.length() <= 1)) {
                            calcText.setText(calcText.getText() + "^");
                            lastNumber = "";
                            lastCommand = "^";
                        }
                        break;
                }
            }
        };

        root.findViewById(R.id.B0).setOnClickListener(btn0);
        root.findViewById(R.id.B1).setOnClickListener(btn0);
        root.findViewById(R.id.B2).setOnClickListener(btn0);
        root.findViewById(R.id.B3).setOnClickListener(btn0);
        root.findViewById(R.id.B4).setOnClickListener(btn0);
        root.findViewById(R.id.B5).setOnClickListener(btn0);
        root.findViewById(R.id.B6).setOnClickListener(btn0);
        root.findViewById(R.id.B7).setOnClickListener(btn0);
        root.findViewById(R.id.B8).setOnClickListener(btn0);
        root.findViewById(R.id.B9).setOnClickListener(btn0);
        root.findViewById(R.id.BBracketClose).setOnClickListener(btn0);
        root.findViewById(R.id.BBracketOpen).setOnClickListener(btn0);
        root.findViewById(R.id.BC).setOnClickListener(btn0);
        root.findViewById(R.id.BDivision).setOnClickListener(btn0);
        root.findViewById(R.id.BEqual).setOnClickListener(btn0);
        root.findViewById(R.id.BMinus).setOnClickListener(btn0);
        root.findViewById(R.id.BMulti).setOnClickListener(btn0);
        root.findViewById(R.id.BSum).setOnClickListener(btn0);
        root.findViewById(R.id.BPoint).setOnClickListener(btn0);
        root.findViewById(R.id.BPow).setOnClickListener(btn0);
        root.findViewById(R.id.BPi).setOnClickListener(btn0);
        root.findViewById(R.id.BSin).setOnClickListener(btn0);
        root.findViewById(R.id.BCos).setOnClickListener(btn0);
        root.findViewById(R.id.BTan).setOnClickListener(btn0);
        root.findViewById(R.id.BExp).setOnClickListener(btn0);
        root.findViewById(R.id.BLn).setOnClickListener(btn0);

        return root;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Activity root = getActivity();
            if (root != null)
                root.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        }
    }

    public void onSaveInstanceState(Bundle out) {
        super.onSaveInstanceState(out);
        out.putString("text", calcText.getText().toString());
    }

    public void onActivityCreated(Bundle save) {
        super.onActivityCreated(save);
        if (save != null) calcText.setText(save.getString("text"));
    }
}