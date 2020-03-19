package com.example.myapplication.ui.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import java.util.Random;

public class GraphFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_graph, container, false);
        final ConstraintLayout constraintLayout = (ConstraintLayout)root.findViewById(R.id.rect);

        View.OnClickListener btn0 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.addView(new Rectangle(getActivity()));
            }
        };
        root.findViewById(R.id.Button_rect).setOnClickListener(btn0);
        return root;
    }
   private class Rectangle extends View {
        Paint paint = new Paint();

        public Rectangle (Context context) {
            super(context);
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
       public void onDraw (Canvas canvas)
        {
            Random random = new Random();
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            paint.setColor( Color.rgb(r,g,b));
            int a = (int) ((Math.random()*500)+60);
            Rect rect = new Rect(20,56,200,a);
            canvas.drawRect (rect,paint);
        }
   }
}

