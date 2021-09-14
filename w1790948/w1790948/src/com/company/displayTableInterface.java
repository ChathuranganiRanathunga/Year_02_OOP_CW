package com.company;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class displayTableInterface {


    //Create a public method for Viewing GUI
    public void viewingInterface(){
        //Create new Stage
        Stage ViewStage = new Stage();
        //Set window title
        ViewStage.setTitle("View Club Member Details");

        //Set Table View
        TableView F_tableView = new TableView();
        F_tableView.setPrefSize(900,450);
        F_tableView.setLayoutX(50);
        F_tableView.setLayoutY(40);

        //Initialise table column details
        TableColumn<sports_club, String> clmClubName ;
        TableColumn<sports_club, String> clmClubLocation ;
        TableColumn<footBall_club, Integer> clmWins ;
        TableColumn<footBall_club, Integer> clmDraws ;
        TableColumn<footBall_club, Integer> clmDefeat ;
        TableColumn<footBall_club, Double> clmPoints ;
        TableColumn<footBall_club, Integer> clmGoalDifference ;
        TableColumn<footBall_club, Integer> clmGoalScored ;
        TableColumn<footBall_club, Integer> clmGoalReceived ;
        TableColumn<footBall_club, Integer> clmPlayedMatches ;

        //Create TableColumn
        clmClubName = new TableColumn<>();
        clmClubLocation = new TableColumn<>();
        clmWins = new TableColumn<>();
        clmDraws = new TableColumn<>();
        clmDefeat = new TableColumn<>();
        clmPoints = new TableColumn<>();
        clmGoalDifference = new TableColumn<>();
        clmGoalScored = new TableColumn<>();
        clmGoalReceived = new TableColumn<>();
        clmPlayedMatches = new TableColumn<>();

        //set columns attributes
        clmClubName.setPrefWidth(150.0);
        clmClubName.setText("Club Name");

        clmClubLocation.setPrefWidth(150.0);
        clmClubLocation.setText("Location");

        clmWins.setPrefWidth(75.0);
        clmWins.setText("Wins");

        clmDraws.setPrefWidth(75.0);
        clmDraws.setText("Draws");

        clmDefeat.setPrefWidth(75.0);
        clmDefeat.setText("Defeat");

        clmPoints.setPrefWidth(75.0);
        clmPoints.setText("Points");

        clmGoalDifference.setPrefWidth(75.0);
        clmGoalDifference.setText("GoalDifference");

        clmGoalScored.setPrefWidth(75.0);
        clmGoalScored.setText("G_Scored");

        clmGoalReceived.setPrefWidth(75.0);
        clmGoalReceived.setText("G_Received");

        clmPlayedMatches.setPrefWidth(75.0);
        clmPlayedMatches.setText("Played Matches ");

        //Set Values to the Columns those are in the file
        clmClubName.setCellValueFactory(new PropertyValueFactory<>("S_ClubName")) ;
        clmClubLocation.setCellValueFactory(new PropertyValueFactory<>("S_ClubLocation")) ;
        clmWins.setCellValueFactory(new PropertyValueFactory<>("F_Wins")) ;
        clmDraws.setCellValueFactory(new PropertyValueFactory<>("F_Draws")) ;
        clmDefeat.setCellValueFactory(new PropertyValueFactory<>("F_Defeat")) ;
        clmPoints.setCellValueFactory(new PropertyValueFactory<>("F_NumOfPoints")) ;
        clmGoalDifference.setCellValueFactory(new PropertyValueFactory<>("GoalDifference")) ;
        clmGoalScored.setCellValueFactory(new PropertyValueFactory<>("F_GScored")) ;
        clmGoalReceived.setCellValueFactory(new PropertyValueFactory<>("F_GReceived")) ;
        clmPlayedMatches.setCellValueFactory(new PropertyValueFactory<>("F_NumOfMatchesPayed")) ;

        //method calling to sort data according to Points Club have and add data to the table
        addAndSortDataAccordingPoints(F_tableView);

        //Add Columns to table
        F_tableView.getColumns().addAll(clmClubName,clmClubLocation,clmWins,clmDraws,clmDefeat,clmPoints,clmGoalDifference,clmGoalScored,clmGoalReceived,clmPlayedMatches);

        //Create image view and set a image to viewing window
        Image imageM=new Image("/img/fireFootBall.jpg");
        ImageView MImage=new ImageView();
        MImage.setImage(imageM);
        MImage.setFitWidth(1000);
        MImage.setFitHeight(900);

        //Set text field attributes
        TextField txtClubName = new TextField();
        txtClubName.setPrefWidth(300);
        txtClubName.setPrefHeight(40);
        txtClubName.setPromptText("Enter Club Name");
        txtClubName.setLayoutX(50);
        txtClubName.setLayoutY(520);

        //create a button for find club details from the text file
        Button btnFind =new Button("Find");
        btnFind.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:30; -fx-border-size:20; -fx-background-radius:30; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnFind.setPrefHeight(50);
        btnFind.setPrefWidth(100);
        btnFind.setLayoutX(400);
        btnFind.setLayoutY(520);

        btnFind.setOnAction(event -> {
            //Method calling to find clubs in the league
            findClubInTheFile(F_tableView,txtClubName);
        });


        //create a button for back
        Button btnBack =new Button("Back");
        btnBack.setStyle("-fx-background-color:Transparent; -fx-border-color:#0000CC;-fx-border-radius:30; -fx-border-size:20; -fx-background-radius:30; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnBack.setPrefHeight(50);
        btnBack.setPrefWidth(100);
        btnBack.setLayoutX(870);
        btnBack.setLayoutY(820);

        //Set back button action
        btnBack.setOnAction(event -> {
            try {
                //Method calling to start menu
                startMenu.displayPremierLeagueMenuDetails();
                //Close main window
                ViewStage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        /*Create a button to sort the club details
         according to the goals scored(ASC order)*/
        Button btnAccordingToGScored =new Button("Sort According to Goal Scored");
        btnAccordingToGScored.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:15; -fx-border-size:20; -fx-background-radius:15; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnAccordingToGScored.setPrefHeight(50);
        btnAccordingToGScored.setPrefWidth(450);
        btnAccordingToGScored.setLayoutX(50);
        btnAccordingToGScored.setLayoutY(590);

        //Set Sort According to goal scored button action
        btnAccordingToGScored.setOnAction(event -> {
            try {
                //method calling to sort according to gall scored
                sortAccordingToGoalScored(F_tableView);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        /*Create a button to sort the club details
         according to the largest number of wins(ASC order)*/
        Button btnAccordingToWins =new Button("Sort According to Wins");
        btnAccordingToWins.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:15; -fx-border-size:20; -fx-background-radius:15; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnAccordingToWins.setPrefHeight(50);
        btnAccordingToWins.setPrefWidth(450);
        btnAccordingToWins.setLayoutX(50);
        btnAccordingToWins.setLayoutY(660);

        //Set Sort According to Wins button action
        btnAccordingToWins.setOnAction(event -> {
            try {
                //Method calling to sort according to wins
                sortAccordingToWins(F_tableView);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        //Create a button to get randomly played matches
        Button btnRandomlyPlayed =new Button("Random Matches");
        btnRandomlyPlayed.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:15; -fx-border-size:20; -fx-background-radius:15; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnRandomlyPlayed.setPrefHeight(50);
        btnRandomlyPlayed.setPrefWidth(450);
        btnRandomlyPlayed.setLayoutX(50);
        btnRandomlyPlayed.setLayoutY(730);

        //Set Sort According to Wins button action
        btnRandomlyPlayed.setOnAction(event -> {
            try {
                //Method calling to randomly played matches
                getRandomlyPlayedMatches();
                //Method calling to set the table according to the points they got
                addAndSortDataAccordingPoints(F_tableView);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        /*Create a button for display matches
        according to the played date*/
        Button btnAccordingToDate =new Button("Sort According to Played Date");
        btnAccordingToDate.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:15; -fx-border-size:20; -fx-background-radius:15; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnAccordingToDate.setPrefHeight(50);
        btnAccordingToDate.setPrefWidth(450);
        btnAccordingToDate.setLayoutX(50);
        btnAccordingToDate.setLayoutY(800);

        //Set Sort according to date action
        btnAccordingToDate.setOnAction(event -> {
            try {
                //Method calling to Sort according to Played date
                sortAccordingToPlayedDate();
                //to Close Main window
                ViewStage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        //Set anchor pane to window
        AnchorPane guiAnchor = new AnchorPane();
        guiAnchor.setPrefWidth(1000);
        guiAnchor.setPrefHeight(900);

        //Add all elements to the anchor pane
        guiAnchor.getChildren().addAll(MImage,F_tableView,btnFind, btnBack,btnAccordingToGScored,btnAccordingToWins,btnRandomlyPlayed,btnAccordingToDate,txtClubName);
        //set anchor pane to the scene
        Scene ViewScene = new Scene(guiAnchor,1000,900);
        ViewStage.setScene(ViewScene);
        ViewStage.showAndWait();
    }

    //========================================================================================================================================================================================================================================

    //Create method for Array list reading from a file

    private static ArrayList readFromFile(){

        //Get already entered data to the array list
        List<footBall_club> clubDetails = new ArrayList<>();

        try {

            FileInputStream fileIn = new FileInputStream("ClubsInLeague.txt");
            ObjectInputStream oin = new ObjectInputStream(fileIn);

            clubDetails = (ArrayList<footBall_club>)oin.readObject();

            //Close file input stream and output stream
            oin.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //return club details array list
        return (ArrayList) clubDetails;
    }

    //====================================================================================================================================================================================================================================

    //Create a method for sort table according to wins

    private static void sortAccordingToWins(TableView<footBall_club> tableView){

        //Clear already entered data in the table
        tableView.getItems().clear();

        //Create observable arraylist to get data from a file
        ObservableList<footBall_club> WinsObservableArrayList = FXCollections.observableArrayList();

        //Load array List and read it
        ArrayList<footBall_club> WinsArrayList = readFromFile();

        //Create an object for wins comparator
        winsAndGoalScoredComparator WinsComparator = new winsAndGoalScoredComparator();

        //Get collection and sort according to wins
        Collections.sort (WinsArrayList , WinsComparator .SortAccordingToWins);

        for(footBall_club clubFootBall :  WinsArrayList){
            //sorted clubs add to the observable arraylist
            WinsObservableArrayList.add(clubFootBall);
        }

        //set observable array list to the table
        tableView.setItems(WinsObservableArrayList);
    }

    //=========================================================================================================================================================================================================================

    //Create a method for Sort table according to wins and add data to table

    private static void addAndSortDataAccordingPoints(TableView<footBall_club> tableView){

        //Clear table data that already have in the table
        tableView.getItems().clear();

        //Load array List and read it
        ArrayList<footBall_club> ClubDetails = readFromFile();

        //To compare statistics
        Collections.sort(ClubDetails,new footballPointsComparator());

        //get it into observable array list
        ObservableList<footBall_club> observableList = FXCollections.observableArrayList();

        for (footBall_club footballCLub: ClubDetails) {
            //add foot ball club details to observable array list
            observableList.add(footballCLub);
        }
        //Add observable list to the table
        tableView.setItems(observableList);
    }

    //=========================================================================================================================================================================================================================

    //Method calling to sort table data according to goal scored
    private static void sortAccordingToGoalScored(TableView<footBall_club> tableView){

        //Clear already entered data in the table
        tableView.getItems().clear();

        ObservableList<footBall_club> GSObservableArrayList = FXCollections.observableArrayList();

        //Create an array list and call file reading method
        ArrayList<footBall_club> GSArrayList = readFromFile();

        //Create an object for goal scored comparator
        winsAndGoalScoredComparator winsAndGoalScoredComparator = new winsAndGoalScoredComparator();

        //Get collection and sort according to the Goal Scored
        Collections.sort ( GSArrayList , winsAndGoalScoredComparator.SortAccordingToGoalScored);

        for(footBall_club clubFootBall :  GSArrayList){

            //Add Sorted football club to the observable array list
            GSObservableArrayList.add(clubFootBall);

        }
        //Add observable list to table view
        tableView.setItems(GSObservableArrayList);

    }

    //===========================================================================================================================================================================================================================

    //Create a method to get a randomly played matches
    public void getRandomlyPlayedMatches() {

        //Clear already entered data in the table
        ArrayList<footBall_club> randomArrayList = readFromFile();

        ArrayList<addMatch> matchArrayList = readMatches();

        //Create object for random
        Random objRandomGenerator = new Random();

        //initialise int variables for random generated two clubs to get their index
        int randomlyGeneratedClub01;
        int randomlyGeneratedClub02;

        while (true) {

            //get two football clubs from the arraylist randomly
            randomlyGeneratedClub01 = objRandomGenerator.nextInt(randomArrayList.size());
            randomlyGeneratedClub02 = objRandomGenerator.nextInt(randomArrayList.size());

            //Checking conditions randomly generated clubs are same or not
            if (randomlyGeneratedClub01 != randomlyGeneratedClub02) {
                break;
            }
        }

        //get randomly generated clubs to array list
        footBall_club rGeneratedTeam01 = randomArrayList.get(randomlyGeneratedClub01);
        footBall_club rGeneratedTeam02 = randomArrayList.get(randomlyGeneratedClub02);

        //Create variables for get random goal score
        int randomGoalClub01  = objRandomGenerator.nextInt(18);
        int randomGoalClub02  = objRandomGenerator.nextInt(18);

        //Create variable for get random goal scored
        int randomGReceivedClub01 = objRandomGenerator.nextInt(18);
        int randomGReceivedClub02 = objRandomGenerator.nextInt(18);

        //Initialise integer variables to get random date for random played matches
        int randomPlayedDay;
        int randomPlayedMonth;
        int randomYear = 2020;

        while (true) {
            randomPlayedDay = objRandomGenerator.nextInt(32);
            randomPlayedMonth = objRandomGenerator.nextInt(13);

            if (randomPlayedDay != 0 && randomPlayedMonth != 0){
                break;
            }
        }
        //Create date object for get random Played date
        playedDate randomPlayedDate = new playedDate(randomPlayedDay,randomPlayedMonth,randomYear);

        //Create an object for add new Match
        addMatch match = new addMatch();

        //Add match to the array list
        match.setTeam_1(rGeneratedTeam01);
        match.setTeam_2(rGeneratedTeam02);
        match.setTeam_1_Score(randomGoalClub01);
        match.setTeam_2_Score(randomGoalClub02);
        match.setPlayedDate(randomPlayedDate);

        //Add match to match array list
        matchArrayList.add(match);

        //Add randomly added goal score to already have
        rGeneratedTeam01.setF_GScored(rGeneratedTeam01.getF_GScored() + randomGoalClub01);
        rGeneratedTeam02.setF_GScored(rGeneratedTeam02.getF_GScored() + randomGoalClub02);
        //Add randomly added goal receive to already have
        rGeneratedTeam01.setF_GReceived(rGeneratedTeam01.getF_GReceived() + randomGReceivedClub01);
        rGeneratedTeam02.setF_GReceived(rGeneratedTeam02.getF_GReceived() + randomGReceivedClub02);

        //add played matches
        rGeneratedTeam01.setF_NumOfMatchesPayed(rGeneratedTeam01.getF_NumOfMatchesPayed()+1);
        rGeneratedTeam02.setF_NumOfMatchesPayed(rGeneratedTeam02.getF_NumOfMatchesPayed()+1);

        //Conditions checking to add
        //If Team A Scored Goals higher than Team B Scored goals
        if (randomGoalClub01 > randomGoalClub02) {
            rGeneratedTeam01.setF_NumOfPoints(rGeneratedTeam01.getF_NumOfPoints()+3);
            rGeneratedTeam01.setF_Wins(rGeneratedTeam01.getF_Wins()+1);
            rGeneratedTeam02.setF_Defeat(rGeneratedTeam02.getF_Defeat()+1);

            //save to array list
            randomArrayList.set(randomlyGeneratedClub01,rGeneratedTeam01);
            randomArrayList.set(randomlyGeneratedClub02,rGeneratedTeam02);
            //Method calling to write entered data to the file
            writeToFile(randomArrayList);
            writeMatches(matchArrayList);

            //If Team B Scored Goals higher than Team A Scored goals
        } else if (randomGoalClub01 < randomGoalClub02) {
            rGeneratedTeam02.setF_NumOfPoints(rGeneratedTeam02.getF_NumOfPoints()+3);
            rGeneratedTeam02.setF_Wins(rGeneratedTeam02.getF_Wins()+1);
            rGeneratedTeam01.setF_Defeat(rGeneratedTeam01.getF_Defeat()+1);

            //save to array list
            randomArrayList.set(randomlyGeneratedClub01,rGeneratedTeam01);
            randomArrayList.set(randomlyGeneratedClub02,rGeneratedTeam02);
            //Method calling to write entered data to the file
            writeToFile(randomArrayList);
            writeMatches(matchArrayList);

            //if team A goals equals to tam B goals
        } else {
            rGeneratedTeam01.setF_NumOfPoints(rGeneratedTeam01.getF_NumOfPoints()+1);
            rGeneratedTeam02.setF_NumOfPoints(rGeneratedTeam02.getF_NumOfPoints()+1);
            rGeneratedTeam01.setF_Draws(rGeneratedTeam01.getF_Draws()+1);
            rGeneratedTeam02.setF_Draws(rGeneratedTeam02.getF_Draws()+1);

            //save to array list
            randomArrayList.set(randomlyGeneratedClub01,rGeneratedTeam01);
            randomArrayList.set(randomlyGeneratedClub02,rGeneratedTeam02);
            //Method calling to write entered data to the file
            writeToFile(randomArrayList);
            writeMatches(matchArrayList);
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Create a method to write data to the file
    public void writeToFile(ArrayList arrayList){
        try {

            FileOutputStream fos = new FileOutputStream("ClubsInLeague.txt");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(arrayList);
            out.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //===============================================================================================================================================================================================================================================

    //Create a method for sort played matches according to the played date
    public void sortAccordingToPlayedDate(){

        //Create new Stage
        Stage ViewStage02 = new Stage();
        //Set window title
        ViewStage02.setTitle("Sort Played Matches According to the Date");

        //Set Table View
        TableView matchTableView = new TableView();
        matchTableView.setPrefSize(750,450);
        matchTableView.setLayoutX(50);
        matchTableView.setLayoutY(40);

        //Initialise table column details
        TableColumn<addMatch, String> clmTeam01 ;
        TableColumn<addMatch, String> clmTeam02 ;
        TableColumn<addMatch, Integer> clmTeamScore01 ;
        TableColumn<addMatch, Integer> clmTeamScore02 ;
        TableColumn<addMatch, playedDate> clmPlayedDate ;

        //Create TableColumn
        clmTeam01 = new TableColumn<>();
        clmTeam02 = new TableColumn<>();
        clmTeamScore01 = new TableColumn<>();
        clmTeamScore02 = new TableColumn<>();
        clmPlayedDate = new TableColumn<>();

        //set columns attributes
        clmTeam01.setPrefWidth(150.0);
        clmTeam01.setText("Team_1");

        clmTeamScore01.setPrefWidth(150.0);
        clmTeamScore01.setText("Team_1_Score");

        clmTeam02.setPrefWidth(150.0);
        clmTeam02.setText("Team_2");

        clmTeamScore02.setPrefWidth(150.0);
        clmTeamScore02.setText("Team_2_Score");

        clmPlayedDate.setPrefWidth(150.0);
        clmPlayedDate.setText("PlayedDate");

        //Set Values to the Columns those are in the file
        clmTeam01.setCellValueFactory(new PropertyValueFactory<>("Team_1")) ;
        clmTeamScore01.setCellValueFactory(new PropertyValueFactory<>("Team_1_Score")) ;
        clmTeam02.setCellValueFactory(new PropertyValueFactory<>("Team_2")) ;
        clmTeamScore02.setCellValueFactory(new PropertyValueFactory<>("Team_2_Score")) ;
        clmPlayedDate.setCellValueFactory(new PropertyValueFactory<>("PlayedDate"));

        //Add Columns to table
        matchTableView.getColumns().addAll(clmTeam01,clmTeamScore01,clmTeam02,clmTeamScore02,clmPlayedDate);

        //Load array List and read it
        ArrayList<addMatch> matchDetails = readMatches();

        //To compare statistics
        dateComparator CompareDate = new dateComparator();
        Collections.sort ( matchDetails , CompareDate.sortByDate);

        //get it into observable array list
        ObservableList<addMatch> observableList = FXCollections.observableArrayList();

        for (addMatch match: matchDetails) {
            //add foot ball club details to observable array list
            observableList.add(match);
        }
        //Add observable list to the table
        matchTableView.setItems(observableList);

        //create a button for back
        Button btnBack =new Button("Back");
        btnBack.setStyle("-fx-background-color:#000000; -fx-border-color:#0000CC;-fx-border-radius:30; -fx-border-size:20; -fx-background-radius:30; -fx-text-fill:#FEFEFE;-fx-font-size:22px;");
        btnBack.setPrefHeight(50);
        btnBack.setPrefWidth(100);
        btnBack.setLayoutX(700);
        btnBack.setLayoutY(525);

        //Set back button action
        btnBack.setOnAction(event -> {
            try {
                viewingInterface();
                ViewStage02.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        //Create image view and set a image to viewing window
        Image imageM=new Image("/img/ball.jpg");
        ImageView MImage=new ImageView();
        MImage.setImage(imageM);
        MImage.setFitWidth(850);
        MImage.setFitHeight(600);

        //Set anchor pane to window
        AnchorPane guiAnchor = new AnchorPane();
        guiAnchor.setPrefWidth(850);
        guiAnchor.setPrefHeight(600);

        //Add all elements to the anchor pane
        guiAnchor.getChildren().addAll(MImage,matchTableView,btnBack);
        //set anchor pane to the scene
        Scene ViewScene = new Scene(guiAnchor,850,600);
        ViewStage02.setScene(ViewScene);
        ViewStage02.showAndWait();
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Method calling to sort table data according to goal scored
    private  void findClubInTheFile (TableView<footBall_club> tableView , TextField textField){

        //Clear already entered data in the table
        tableView.getItems().clear();

        //get value from the text Field
        String ClubName = textField.getText();

        //Initialise Boolean variable to find the Club Name
        Boolean foundClubName = false;

        //if Text Field is Empty
        if (ClubName.equals("")) {
            //Alert message to empty Field
            Alert msg1 = new Alert(Alert.AlertType.NONE);
            msg1.setAlertType(Alert.AlertType.ERROR);
            msg1.setContentText("You didn't enter the club name.Please enter the Club Name and then find.");
            msg1.showAndWait();

            //If club is entered then find it from the text file
        } else {

            //get file data to array list
            ArrayList <footBall_club> findClubArray = readFromFile();

            //create observable array list
            ObservableList<footBall_club> observableFindArraylist = FXCollections.observableArrayList();

            for (footBall_club club :findClubArray) {

                //When entered club name is in the text file
                if(club.getS_ClubName().equals(ClubName)){
                    foundClubName = true;
                    //Add that club to observable array list
                    observableFindArraylist.add(club);
                }
            }
            //If that Entered number is not in the database give alert message
            if (!foundClubName) {
                Alert msg2 = new Alert(Alert.AlertType.NONE) ;
                msg2.setAlertType(Alert.AlertType.ERROR) ;
                msg2.setContentText("The club you entered is not in the League..........") ;
                msg2.showAndWait() ;

            } else {
                //Then Set observable array list to the table
                tableView.setItems(observableFindArraylist);
                /*If it is in the file first give a alert message and then click ok.
                             after this it shows relevant details in the relevant table columns*/
                Alert msg3 = new Alert(Alert.AlertType.INFORMATION) ;
                msg3.setAlertType(Alert.AlertType.INFORMATION) ;
                msg3.setContentText("This Club Details is in the league.Please Ok the alert Massage..") ;
                msg3.showAndWait() ;
            }
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Create method for Array list reading from a file

    private static ArrayList readMatches(){

        //Get already entered data to the array list
        List<addMatch> clubDetails = new ArrayList<>();

        try {

            FileInputStream fileIn = new FileInputStream("PlayedMatches.txt");
            ObjectInputStream oin = new ObjectInputStream(fileIn);

            clubDetails = (ArrayList<addMatch>)oin.readObject();

            //Close file input stream and output stream
            oin.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //return club details array list
        return (ArrayList) clubDetails;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Create a method for add played matches array list to the text file
    private static void writeMatches(ArrayList matchArrayList){
        try {

            FileOutputStream fOutS = new FileOutputStream("PlayedMatches.txt");
            ObjectOutputStream ObjectOt = new ObjectOutputStream(fOutS);
            ObjectOt.writeObject(matchArrayList);
            ObjectOt.close();
            fOutS.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

