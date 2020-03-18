package com.example.myapplication.MathFeatures;

public class accuracy {
    public double val_round (double value,int accuracy_order)
    {
        if ((value == Double.POSITIVE_INFINITY)||(value == Double.NEGATIVE_INFINITY)||(value == Double.NaN))
        {
            return value;
        }
        value*=power(10,accuracy_order);
        if ((value-((int)value))>=0.5)
        {
            value++;
        }
        int buf = (int)value;
        return ((double)buf)/power(10,accuracy_order);
    }
    public long power (long value, int exp) {
        long result = value;
        for (int i = 1; i < exp; i++) {
            result *= value;
        }
        return result;
    }

    public double error_sum_sub() {
        return Math.pow(2,-52);
    }

    public double error_multi_div(double x, double y, double er1,double er2) {
       if(er1!=0&&er2!=0) return x*Math.pow(2,-53)+y*Math.pow(2,-53);
       else return x*er2+y*er1;
    }



}
