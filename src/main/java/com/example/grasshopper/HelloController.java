package com.example.grasshopper;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {

    @FXML
    private AnchorPane fieldPane;
    @FXML
    private Arc frogFX;

    @FXML
    private Circle grasshopperFX;

    @FXML
    private Line tongue;



    public void initialize() throws IOException {
        Grasshopper g = GReadFromFile();
        Circle dangerZone = new Circle();
        fieldPane.getChildren().add(dangerZone);
        Frog frog = FrogReadFromFile();
        String result = g.isAlive(frog);
        writeToFile(result);
        frogFX.setCenterX(frog.b.x);
        frogFX.setCenterY(frog.b.y);
        dangerZone.setFill(Color.DARKRED);
        dangerZone.setCenterX(frogFX.getCenterX());
        dangerZone.setCenterY(frogFX.getCenterY());
        dangerZone.setRadius(frog.l);
        dangerZone.setLayoutX(frogFX.getLayoutX());
        dangerZone.setLayoutY(frogFX.getLayoutY());
    dangerZone.setOpacity(0.5);
    dangerZone.toBack();
        tongue.setStartX(frogFX.getCenterX());
        tongue.setStartY(frogFX.getCenterY());
        tongue.setEndX(frogFX.getCenterX());
        tongue.setEndY(frogFX.getCenterY());



    }


public Frog FrogReadFromFile() throws FileNotFoundException {
    Scanner sc = new Scanner(new File("INPUT.TXT"));
    int n = sc.nextInt();
    Point b = new Point(sc.nextInt(),sc.nextInt());
    int l = sc.nextInt();
    Frog frog = new Frog(b,l);
    return frog;
}
    public Grasshopper GReadFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("INPUT.TXT"));
        ArrayList<Point> destinations = new ArrayList<>();
        sc.nextLine();
        for (int i=0; sc.hasNextLine();i++){
            Point a = new Point(sc.nextInt(),sc.nextInt());
            destinations.add(a);
        }
        Grasshopper g = new Grasshopper(destinations);
        return g;
    }
    public void writeToFile(String result) throws IOException {
        Files.writeString(Path.of("OUTPUT.TXT"), result);
    }
    public String GisAlive(Frog frog, Grasshopper g){
        boolean isEaten = false;
        for (int i =0; i<g.destinations.size();i++){
            double distance = g.calculateDistance(g.destinations.get(i), frog.b);
            if(distance<=frog.l) {
                System.out.println("oops, the Grasshopper is eaten");
                isEaten = true;
                double x=g.destinations.get(i).x;
               // tongue.setEndX(x-());
             //   tongue.resize(x-);
                tongue.setEndY(frogFX.getCenterY());
            }
            tongue.setEndX(g.destinations.get(i).x);

        }
        return "Yes";
    }

//    public double newX(double x){
//        x-(frog.l)*Math.cos(x/x)
//    }
}