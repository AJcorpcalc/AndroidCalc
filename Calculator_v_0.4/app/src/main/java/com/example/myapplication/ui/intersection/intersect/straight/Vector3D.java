package com.example.myapplication.ui.intersection.intersect.straight;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Vector3D {
    private double X;
    private double Y;
    private double Z;
    Vector3D(double x,double y,double z){X=x;Y=y;Z=z; }
    public ArrayList<Double> getCoordination(){
        ArrayList<Double> coordination= new ArrayList<Double>();
        coordination= (ArrayList<Double>) Arrays.asList(new Double[]{X,Y,Z});
        return coordination;
    }


}
