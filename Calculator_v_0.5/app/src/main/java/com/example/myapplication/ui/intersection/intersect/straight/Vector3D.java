package com.example.myapplication.ui.intersection.intersect.straight;

import java.util.ArrayList;


public class Vector3D {
    protected  final ArrayList<Double>  coordination= new ArrayList<Double>();

    Vector3D(double x,double y,double z){
        coordination.add(x);
        coordination.add(y);
        coordination.add(z); }
    public  ArrayList<Double> getCoordination(){
        return coordination;
    }


}
