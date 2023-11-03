package com.example.grasshopper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    public void initialize() throws IOException {
        Grasshopper g = GReadFromFile();
        Frog frog = FrogReadFromFile();
        String result = g.isEaten(frog);
        writeToFile(result);
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

}