package org.example;

import java.util.ArrayList;

public class CalculaterService {
    public double Calculate (double x,double y,char Operator) throws ArithmeticException{
        switch (Operator){

            case '+' :
                return  x + y;
            case '-' :
                return  x - y;
            case '*' :
                return  x * y;
            case '/':
                if (y == 0) throw new ArithmeticException("خطا! تقسیم بر صفر ممکن نیست." );
                return x/y;
            case '%' :
                return  x % y;
            default:
                return 0;
        }



    //pro

    }
    public double sum (ArrayList<Double> numbers){
        double total = 0 ;
        for (double n : numbers)  total += n;
        return total;
    }
    public double average (ArrayList<Double> numbers){
        return sum(numbers) / numbers.size();
    }
    public double findMax (ArrayList<Double> numbers){
        double max = numbers.get(0);
        for (double n : numbers) if (n > max)
            max = n;
        return max;
    }
    public double findMin (ArrayList<Double> numbers){
        double min = numbers.get(0);
        for (double n : numbers) if (n < min) n = min;
        return min;

    }
    }
