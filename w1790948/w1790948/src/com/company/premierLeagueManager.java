package com.company;

import java.io.*;
import java.util.*;

public class premierLeagueManager implements leagueManager {

    public Scanner add = new Scanner(System.in);

    //Create a new Array list to Football Club
    private static List<footBall_club> ClubFootBall = new ArrayList<>();

    //To Save played match Create an array List
    private  static ArrayList<addMatch>  toSaveMatchArray = new ArrayList<>();

    //Default Constructor for premier league manager
    public premierLeagueManager() {
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Method for add club to League
    public void addClubToLeague(footBall_club sportClubFootBall) {

        //Method calling to the reading data from file those are already entered
        readFromFile();

        //checking conditions to add club to the league
        if (ClubFootBall.contains(sportClubFootBall)) {
            System.out.println("This Club is Already in the league.");
        } else {
            ClubFootBall.add((footBall_club)sportClubFootBall);
            //Method calling to file writing
            writeToFile();
        }
    }




    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //method for delete club from the league
    public int deleteClubFromLeague(String S_ClubName) {

        //Create new array list to get clubs those are already entered
        ArrayList<String> DeleteNArrayList = new ArrayList<>();

        //Method calling to read file
        readFromFile();

        for (footBall_club club : ClubFootBall) {
            //get club name from the array list
            DeleteNArrayList.add(club.getS_ClubName());
        }
        if (DeleteNArrayList.contains(S_ClubName)) {
            //Checking index
            int index = DeleteNArrayList.indexOf(S_ClubName);
            //remove the club from the league
            ClubFootBall.remove(index);

            //Method calling to file writing
            writeToFile();

            //If the club is already in the system  return 1 if not return 0
            return 1;
        } else {
            return 0;
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //method to display Premier League Details
    @Override
    public  void showTheClubsInLeague() {

        //Create new array list to get the clubs those are already in he league
        ArrayList<footBall_club> clubNamesArray = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream("ClubsInLeague.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            //for read objects which are in array list
            ClubFootBall = (ArrayList<footBall_club>) objectInputStream.readObject();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //To compare statistics
        Collections.sort(ClubFootBall,new footballPointsComparator());


        for (footBall_club club : ClubFootBall) {
            //get club name from the array list
            clubNamesArray.add(club);
            System.out.println("ClubName : "+club.getS_ClubName()+
                    "   ClubLocation : "+club.getS_ClubLocation()+"     |    " +
                    "   PlayedMatches : "+club.getF_NumOfMatchesPayed()+
                    "   Points : "+club.getF_NumOfPoints()+
                    "   GoalDifference : "+(club.getF_GScored()-club.getF_GReceived())+
                    "   Wins : "+club.getF_Wins()+
                    "   Draws : "+club.getF_Draws()+
                    "   Defeat : "+club.getF_Defeat() +
                    "   GS : "+club.getF_GScored()+
                    "   GR : "+club.getF_GReceived());

        }
    }

    //==================================================================================================================================================================================================

    //Method for display related details about entered club
    @Override
    public void ShowRelatedDetailsEnteredClub(String S_ClubName) {

        //Create new array list to get clubs those are already entered
        ArrayList<String> ShowDArrayList = new ArrayList<>();

        //Method calling to read file
        readFromFile();


        for (footBall_club club : ClubFootBall) {
            //get club name from the array list
            ShowDArrayList.add(club.getS_ClubName());
        }

        if (ShowDArrayList.contains(S_ClubName)) {
            int index = ShowDArrayList.indexOf(S_ClubName);
            System.out.println(ClubFootBall.get(index).toString());
            //remove the club from the league
            System.out.println(index);

        }else{
            System.out.println("Entered Club is not in the league.....");
        }
    }

    //==================================================================================================================================================================================

    // Create a method for file writing
    public static void writeToFile()  {

        try {

            FileOutputStream fOutS = new FileOutputStream("ClubsInLeague.txt");
            ObjectOutputStream out = new ObjectOutputStream(fOutS);
            out.writeObject(ClubFootBall);
            out.close();
            fOutS.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //=====================================================================================================================================================================================================

    //Create a method for read entered data from the file
    public static void readFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream("ClubsInLeague.txt");
            ObjectInputStream oInputS = new ObjectInputStream(fileIn);

            ClubFootBall = (ArrayList<footBall_club>)oInputS.readObject();

            oInputS.close();
            fileIn.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    //========================================================================================================================================================================================================================
    //create method to add played match to the league
    public static void addPlayedMatch() {

        Scanner addM = new Scanner(System.in);

        //Create array list to add a played match
        List<addMatch> playedMatches = new ArrayList<>();


        int IndexOfTeamA ;
        int IndexOfTeamB ;


        System.out.println("\n" + "--------------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ || Update Football Club Score || $$$$$$$$$$$$$$$$$$$$$$" + "\n");

        //Method calling to read data those are already in the file
        readFromFile();
        readPlayedMatchFromFile();
        //Enter team name A
        System.out.print("Enter Team A : ");
        String T_A = addM.nextLine();

        footBall_club TeamA = null;

        for(footBall_club club : ClubFootBall){
            if(club.getS_ClubName().equals(T_A))
                TeamA = club;
        }

        IndexOfTeamA = ClubFootBall.indexOf(TeamA);

        //If its not in the league show this massage to the user
        if(TeamA==null) {
            System.out.println("Entered Club is not in the league.....");
            return;
        } else
            IndexOfTeamA = ClubFootBall.indexOf(TeamA);

        //Method calling to read data those are already in the file
        readFromFile();
        //Enter name team B
        System.out.print("\n"+"Enter Team B : ");
        String T_B = addM.nextLine();
        footBall_club TeamB = null;

        for(footBall_club club : ClubFootBall){
            if(club.getS_ClubName().equals(T_B))
                TeamB = club;
        }
        IndexOfTeamB =ClubFootBall.indexOf(TeamB);

        if(TeamB==null) {
            System.out.println("Entered Club is not in the league.....");
            return;
        } else
            IndexOfTeamB = ClubFootBall.indexOf(TeamB);

        //Enter Goals
        System.out.print("\n"+"Enter Team A Goals : ");
        int GTA = Integer.parseInt(addM.nextLine());

        int T_AGoals = -1;
        try {
            T_AGoals = GTA;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //error massage
        if(T_AGoals == -1) {
            System.out.println("Enter number of goals...");
            return;
        }
        //Enter Goals
        System.out.print("\n"+"Enter Team B Goals : ");
        int GTB = Integer.parseInt(addM.nextLine());

        int T_BGoals = -1;
        try {
            T_BGoals = GTB;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(T_BGoals == -1) {
            System.out.println("Enter number of goals here...");
            return;

        }
        playedDate P_date = new playedDate();
        while (true) {
            //Enter date that match played
            System.out.print("\n" + ">> Enter Match played date(format DD/MM/YYYY) : ");
            String playedDate = addM.nextLine();


            try {
                P_date.setMatchDay(playedDate);
                P_date.setMatchMonth(playedDate);
                P_date.setMatchYear(playedDate);
                break;
            } catch (com.company.playedDate.InvalidDate e) {
                System.out.println("Invalid Date follow the DD/MM/YYYY format");
            }
        }
        //Add match to the array list
        addMatch match = new addMatch();
        match.setPlayedDate(P_date);
        match.setTeam_1(TeamA);
        match.setTeam_2(TeamB);
        match.setTeam_1_Score(T_AGoals);
        match.setTeam_2_Score(T_BGoals);
        playedMatches.add(match);

        //To Save Played Match to the Array List
        toSaveMatchArray.add(match);
        writePlayedMatchesToFile();

        //Add new values to already have values
        TeamA.setF_GScored(TeamA.getF_GScored()+T_AGoals);
        TeamB.setF_GScored(TeamB.getF_GScored()+T_BGoals);
        TeamA.setF_GScored(TeamA.getF_GReceived()+T_AGoals);
        TeamB.setF_GScored(TeamB.getF_GReceived()+T_BGoals);
        TeamA.setF_NumOfMatchesPayed(TeamA.getF_NumOfMatchesPayed()+1);
        TeamB.setF_NumOfMatchesPayed(TeamB.getF_NumOfMatchesPayed()+1);

        //Conditions checking to add
        //If Team A Scored Goals higher than Team B Scored goals
        if (T_AGoals > T_BGoals) {
            TeamA.setF_NumOfPoints(TeamA.getF_NumOfPoints()+3);
            TeamA.setF_Wins(TeamA.getF_Wins()+1);
            TeamB.setF_Defeat(TeamB.getF_Defeat()+1);

            //save to array list
            ClubFootBall.set(IndexOfTeamA,TeamA);
            ClubFootBall.set(IndexOfTeamB,TeamB);
            //Method calling to write entered data to the file
            writeToFile();

            //If Team B Scored Goals higher than Team A Scored goals
        } else if (T_AGoals < T_BGoals) {
            TeamB.setF_NumOfPoints(TeamB.getF_NumOfPoints()+3);
            TeamB.setF_Wins(TeamB.getF_Wins()+1);
            TeamA.setF_Defeat(TeamA.getF_Defeat()+1);

            //save to array list
            ClubFootBall.set(IndexOfTeamA,TeamA);
            ClubFootBall.set(IndexOfTeamB,TeamB);
            //Method calling to write entered data to the file
            writeToFile();

            //if team A goals equals to tam B goals
        } else {
            TeamA.setF_NumOfPoints(TeamA.getF_NumOfPoints()+1);
            TeamB.setF_NumOfPoints(TeamB.getF_NumOfPoints()+1);
            TeamA.setF_Draws(TeamA.getF_Draws()+1);
            TeamB.setF_Draws(TeamB.getF_Draws()+1);

            //save to array list
            ClubFootBall.set(IndexOfTeamA,TeamA);
            ClubFootBall.set(IndexOfTeamB,TeamB);
            //Method calling to write entered data to the file
            writeToFile();
        }

    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Create a method for file writing
    public static void writePlayedMatchesToFile()  {

        try {

            FileOutputStream fOutS = new FileOutputStream("PlayedMatches.txt");
            ObjectOutputStream ObjectOt = new ObjectOutputStream(fOutS);
            ObjectOt.writeObject(toSaveMatchArray);
            ObjectOt.close();
            fOutS.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Create a method for read entered data from the file
    public static void readPlayedMatchFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream("PlayedMatches.txt");
            ObjectInputStream oin = new ObjectInputStream(fileIn);

            toSaveMatchArray = (ArrayList<addMatch>)oin.readObject();

            oin.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


