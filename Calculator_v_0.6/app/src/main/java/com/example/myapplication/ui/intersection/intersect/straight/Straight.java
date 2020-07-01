package com.example.myapplication.ui.intersection.intersect.straight;

import java.util.ArrayList;

public final class Straight extends Vector3D {

    public Straight(double x, double y, double z,double x0,double y0,double z0) {
        super(x, y, z);
        coordination.add(x0);
        coordination.add(y0);
        coordination.add(z0);
    }

    @Override
    public ArrayList<Double> getCoordination() { return coordination;
    }
}
