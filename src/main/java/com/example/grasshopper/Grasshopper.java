package com.example.grasshopper;

import java.util.ArrayList;

public class Grasshopper {
    ArrayList<Point> destinations;

    public Grasshopper(ArrayList<Point> destinations) {
        this.destinations = destinations;
    }

    public String isEaten(Frog frog){
        boolean isEaten = false;
        for (int i =0; i<destinations.size();i++){
            double distance = calculateDistance(destinations.get(i), frog.b);
            if(distance<=frog.l) {
                System.out.println("oops, the Grasshopper is eaten");
                isEaten = true;
                return String.valueOf(i+1);
            }


        }
        return "Yes";
    }
    public static double calculateDistance(Point p1, Point p2){
        double distance = Math.sqrt(Math.pow((p2.x- p1.x),2)+Math.pow((p2.y-p1.y), 2));
        return distance;
    }
}
