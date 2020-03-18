package com.example.myapplication.ui.intersection.intersect.straight;

import java.util.ArrayList;
import java.util.Arrays;

public final class Straight {//extends Vector3D {
    private ArrayList<Double> point= new ArrayList<Double>();

    public Straight(double x, double y, double z,double x0,double y0,double z0) {
      //  super(x, y, z);

        point.add(x);
        point.add(y);
        point.add(z);
        point.add(x0);
        point.add(y0);
        point.add(z0);
       // point= (ArrayList<Double>) Arrays.asList(new Double[]{x,y,z,x0,y0,z0});
    }

    //@Override
    public ArrayList<Double> getCoordination() {
        ArrayList<Double> coordination= new ArrayList<Double>();
       // coordination= super.getCoordination();
       // coordination.addAll(point);
       return point;//coordination;

    }
}
