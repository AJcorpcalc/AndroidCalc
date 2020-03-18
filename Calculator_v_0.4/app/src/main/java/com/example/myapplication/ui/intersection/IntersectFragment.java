package com.example.myapplication.ui.intersection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.ui.intersection.intersect.IntersectionVector;
import com.example.myapplication.ui.intersection.intersect.straight.Straight;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class IntersectFragment extends Fragment {

    private static TextView intersectionText;
    private static EditText first_dot_x;
    private static EditText first_dot_y;
    private static EditText first_dot_z;
    private static EditText first_vector_x;
    private static EditText first_vector_y;
    private static EditText first_vector_z;

    private static EditText second_dot_x;
    private static EditText second_dot_y;
    private static EditText second_dot_z;
    private static EditText second_vector_x;
    private static EditText second_vector_y;
    private static EditText second_vector_z;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_intersection, container, false);

        intersectionText = (TextView) root.findViewById(R.id.Intersection_result_textview);

        first_dot_x = (EditText) root.findViewById(R.id.input_first_dot_x);
        first_dot_y = (EditText) root.findViewById(R.id.input_first_dot_y);
        first_dot_z = (EditText) root.findViewById(R.id.input_first_dot_z);
        first_vector_x = (EditText) root.findViewById(R.id.input_first_vector_x);
        first_vector_y = (EditText) root.findViewById(R.id.input_first_vector_y);
        first_vector_z = (EditText) root.findViewById(R.id.input_first_vector_z);

        second_dot_x = (EditText) root.findViewById(R.id.input_second_dot_x);
        second_dot_y = (EditText) root.findViewById(R.id.input_second_dot_y);
        second_dot_z = (EditText) root.findViewById(R.id.input_second_dot_z);
        second_vector_x = (EditText) root.findViewById(R.id.input_second_vector_x);
        second_vector_y = (EditText) root.findViewById(R.id.input_second_vector_y);
        second_vector_z = (EditText) root.findViewById(R.id.input_second_vector_z);

        View.OnClickListener btn0 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double f_dot_x = Double.parseDouble(first_dot_x.getText().toString());
                double f_dot_y = Double.parseDouble(first_dot_y.getText().toString());
                double f_dot_z = Double.parseDouble(first_dot_z.getText().toString());

                double f_vec_x = Double.parseDouble(first_vector_x.getText().toString());
                double f_vec_y = Double.parseDouble(first_vector_y.getText().toString());
                double f_vec_z = Double.parseDouble(first_vector_z.getText().toString());

                double s_dot_x = Double.parseDouble(second_dot_x.getText().toString());
                double s_dot_y = Double.parseDouble(second_dot_y.getText().toString());
                double s_dot_z = Double.parseDouble(second_dot_z.getText().toString());

                double s_vec_x = Double.parseDouble(second_vector_x.getText().toString());
                double s_vec_y = Double.parseDouble(second_vector_y.getText().toString());
                double s_vec_z = Double.parseDouble(second_vector_z.getText().toString());
                Straight str_first = new Straight(f_vec_x, f_vec_y, f_vec_z, f_dot_x, f_dot_y, f_dot_z);
                Straight str_second = new Straight(s_vec_x, s_vec_y, s_vec_z, s_dot_x, s_dot_y, s_dot_z);

                intersectionText.setText(new IntersectionVector(str_first, str_second).getCoordination());

            }
        };

        TextView.OnTouchListener btnText= new TextView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    switch (v.getId()) {
                        case R.id.input_first_dot_x:
                            first_dot_x.setText("");
                            break;
                        case R.id.input_first_dot_y:
                            first_dot_y.setText("");
                            break;
                        case R.id.input_first_dot_z:
                            first_dot_z.setText("");
                            break;
                        case R.id.input_second_dot_x:
                            second_dot_x.setText("");
                            break;
                        case R.id.input_second_dot_y:
                            second_dot_y.setText("");
                            break;
                        case R.id.input_second_dot_z:
                            second_dot_z.setText("");
                            break;
                        case R.id.input_second_vector_x:
                            second_vector_x.setText("");
                            break;
                        case R.id.input_second_vector_y:
                            second_vector_y.setText("");
                            break;
                        case R.id.input_second_vector_z:
                            second_vector_z.setText("");
                            break;
                        case R.id.input_first_vector_x:
                            first_vector_x.setText("");
                            break;
                        case R.id.input_first_vector_y:
                            first_vector_y.setText("");
                            break;
                        case R.id.input_first_vector_z:
                            first_vector_z.setText("");
                            break;

                    }
                    InputMethodManager service= (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
                    service.hideSoftInputFromWindow(v.getWindowToken(),0);
                    v.requestFocus();

                }
return true;
            }
        };
        root.findViewById(R.id.Button_intersection_result).setOnClickListener(btn0);
        root.findViewById(R.id.input_first_dot_x).setOnTouchListener(btnText);
       /* root.findViewById(R.id.input_first_dot_y).setOnClickListener(btnText);
        root.findViewById(R.id.input_first_dot_z).setOnClickListener(btnText);
        root.findViewById(R.id.input_first_vector_x).setOnClickListener(btnText);
        root.findViewById(R.id.input_first_vector_y).setOnClickListener(btnText);
         root.findViewById(R.id.input_first_vector_z).setOnClickListener(btnText);

        root.findViewById(R.id.input_second_dot_x).setOnClickListener(btnText);
        root.findViewById(R.id.input_second_dot_y).setOnClickListener(btnText);
        root.findViewById(R.id.input_second_dot_z).setOnClickListener(btnText);
        root.findViewById(R.id.input_second_vector_x).setOnClickListener(btnText);
        root.findViewById(R.id.input_second_vector_y).setOnClickListener(btnText);
        root.findViewById(R.id.input_second_vector_z).setOnClickListener(btnText);
*/
        return root;
    }
}