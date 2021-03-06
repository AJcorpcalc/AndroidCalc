package com.example.myapplication.ui.intersection.intersect;

import com.example.myapplication.MathFeatures.accuracy;
import com.example.myapplication.ui.intersection.intersect.straight.Straight;

import java.util.ArrayList;

public final class IntersectionVector {
    private accuracy err = new accuracy();
    private final int n = 3;
    private double x, y, z;
    private Straight first, second;
    private ArrayList<Double> vector1 = new ArrayList<Double>(), vector2 = new ArrayList<Double>(), vector3 = new ArrayList<Double>();

    public IntersectionVector(Straight first, Straight second) {
        this.first = first;
        this.second = second;
        initial();
    }

    private void initial() {
        ArrayList<Double> vfirst = new ArrayList<Double>();
        ArrayList<Double> vsecond = new ArrayList<Double>();
        vfirst = first.getCoordination();
        vsecond = second.getCoordination();
        for (int i = 0; i < n; i++) {
            vector1.add(vfirst.get(i));
            vector2.add(vsecond.get(i));
            vector3.add(vsecond.get(i + n) - vfirst.get(i + n) - err.error_sum_sub());
        }
    }

    private boolean intersection() {
        double div1 = 0, div2 = 0, div3 = 0, div4 = 0, div5 = 0, div6 = 0, t;
        if (vector1.get(0) != 0) {
            div1 = (vector2.get(1) - (vector2.get(0) * vector1.get(1)) / vector1.get(0));
            div2 = (vector2.get(2) - (vector2.get(0) * vector1.get(2)) / vector1.get(0));
        }
        if (vector1.get(1) != 0) {
            div3 = (vector2.get(0) - (vector2.get(1) * vector1.get(0)) / vector1.get(1));
            div4 = (vector2.get(2) - (vector2.get(1) * vector1.get(2)) / vector1.get(1));
        }
        if (vector1.get(2) != 0) {
            div5 = (vector2.get(0) - (vector2.get(2) * vector1.get(0)) / vector1.get(2));
            div6 = (vector2.get(1) - (vector2.get(2) * vector1.get(1)) / vector1.get(2));
        }
        if (div1 != 0) {
            t = (vector1.get(1) * vector3.get(0) / vector1.get(0) - vector3.get(1)) / div1;
        } else if (div2 != 0) {
            t = (vector1.get(2) * vector3.get(0) / vector1.get(0) - vector3.get(2)) / div2;
        } else if (div3 != 0)
            t = (vector1.get(0) * vector3.get(1) / vector1.get(1) - vector3.get(0)) / div3;
        else if (div4 != 0)
            t = (vector1.get(2) * vector3.get(1) / vector1.get(1) - vector3.get(2)) / div4;
        else if (div5 != 0)
            t = (vector1.get(0) * vector3.get(2) / vector1.get(2) - vector3.get(0)) / div5;
        else if (div6 != 0)
            t = (vector1.get(1) * vector3.get(2) / vector1.get(2) - vector3.get(1)) / div6;
        else return false;

        this.x = vector2.get(0) * t + second.getCoordination().get(0 + n);
        this.y = vector2.get(1) * t + second.getCoordination().get(1 + n);
        this.z = vector2.get(2) * t + second.getCoordination().get(2 + n);
        return true;
    }

    private boolean onOneLine() {
        double constant1 = vector3.get(0) * vector2.get(1),
                constant2 = vector3.get(1) * vector2.get(0),
                constant3 = vector3.get(2) * vector2.get(0),
                constant4 = vector3.get(0) * vector2.get(2),
                constant5 = vector3.get(1) * vector2.get(2),
                constant6 = vector3.get(2) * vector2.get(1);
        double error_1 = err.error_multi_div(vector3.get(0), vector2.get(1), 0, 0)
                + err.error_multi_div(vector3.get(1), vector2.get(0), 0, 0);
        double error_2 = err.error_multi_div(vector3.get(2), vector2.get(0), 0, 0)
                + err.error_multi_div(vector3.get(0), vector2.get(2), 0, 0);
        double error_3 = err.error_multi_div(vector3.get(2), vector2.get(1), 0, 0)
                + err.error_multi_div(vector3.get(1), vector2.get(2), 0, 0);
        if (Math.abs(constant1 - constant2) <= 10 * error_1
                && Math.abs(constant4 - constant3) <= 10 * error_2
                && Math.abs(constant6 - constant5) <= 10 * error_3) {
            return true;
        }
        return false;
    }

    private boolean isParralel() {
        double constant1 = vector1.get(0) * vector2.get(1),
                constant2 = vector1.get(1) * vector2.get(0),
                constant3 = vector1.get(2) * vector2.get(0),
                constant4 = vector1.get(0) * vector2.get(2),
                constant5 = vector1.get(1) * vector2.get(2),
                constant6 = vector1.get(2) * vector2.get(1);
        double error_1 = err.error_multi_div(vector1.get(0), vector2.get(1), 0, 0)
                + err.error_multi_div(vector1.get(1), vector2.get(0), 0, 0);
        double error_2 = err.error_multi_div(vector1.get(2), vector2.get(0), 0, 0)
                + err.error_multi_div(vector1.get(0), vector2.get(2), 0, 0);
        double error_3 = err.error_multi_div(vector1.get(2), vector2.get(1), 0, 0)
                + err.error_multi_div(vector1.get(1), vector2.get(2), 0, 0);
        if (Math.abs(constant1 - constant2) <= 10 * error_1
                && Math.abs(constant4 - constant3) <= 10 * error_2
                && Math.abs(constant6 - constant5) <= 10 * error_3) {
            return true;
        }
        return false;

    }

    private boolean location() {
        double deg = vector1.get(0) * (vector2.get(1) * vector3.get(2) - vector2.get(2) * vector3.get(1))
                - vector1.get(1) * (vector2.get(0) * vector3.get(2) - vector2.get(2) * vector3.get(0))
                + vector1.get(2) * (vector2.get(0) * vector3.get(1) - vector2.get(1) * vector3.get(0));
        double error_1 = err.error_multi_div(vector2.get(0), vector3.get(1), 0, 0)
                + err.error_multi_div(vector2.get(1), vector3.get(0), 0, 0);
        double error_2 = err.error_multi_div(vector2.get(2), vector3.get(0), 0, 0)
                + err.error_multi_div(vector2.get(0), vector3.get(2), 0, 0);
        double error_3 = err.error_multi_div(vector2.get(2), vector3.get(1), 0, 0)
                + err.error_multi_div(vector2.get(1), vector3.get(2), 0, 0);
        double error = err.error_multi_div(vector1.get(0),
                (vector2.get(1) * vector3.get(2) - vector2.get(2) * vector3.get(1)), Math.pow(2, -53), error_3)
                + err.error_multi_div(vector1.get(1),
                (vector2.get(0) * vector3.get(2) - vector2.get(2) * vector3.get(0)), Math.pow(2, -53), error_2)
                + err.error_multi_div(vector1.get(2), (vector2.get(0) * vector3.get(1) - vector2.get(1) * vector3.get(0)),
                Math.pow(2, -53), error_1);

        if (Math.abs(deg) <= 10 * error) return true;
        return false;
    }

    public String getCoordination() {
        if (location()) {
            if (isParralel()) {
                if (onOneLine())
                    return "Прямые совпадают";
                return "Прямые параллельны";
            }

            if (intersection())
                return err.val_round(x, 5) + "," + err.val_round(y, 5) + "," + err.val_round(z, 5);
            else return "Ошибка ввода";
        }
        return "Прямые скрещиваются";

    }
}