package com.company;

import javafx.application.Application;
import javafx.stage.Stage;

public class mainStart extends Application {

    @Override
    public void start(Stage primaryStage) throws  Exception{

        //Method calling to Premier league menu details
        startMenu.displayPremierLeagueMenuDetails();
    }

    //Create main method here
    public static void main(String[] args){
        launch(args);
    }
}

