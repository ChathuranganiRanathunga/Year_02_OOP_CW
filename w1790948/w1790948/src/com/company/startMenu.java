package com.company;
import java.util.Scanner;

public class startMenu {

    //create a public scanner to get user inputs
    public static Scanner startMenu = new Scanner(System.in);

    // Private Method to Display League Menu Details
    public static void displayPremierLeagueMenuDetails(){

        while (true) {

            System.out.println("\n"+"************************************||*****  Premier League Manager Menu  *****||************************************" + "\n" + "\n");
            System.out.println("      **---------------------------------------------------------------------------------------------**"+"\n");
            System.out.println("      *         1 . Add Club to the League(Press Number 1)                                            *" + "\n");
            System.out.println("      *         2 . Delete Club from the League (Press Number 2)                                      *" + "\n");
            System.out.println("      *         3 . Display Club Details (Press Number 3)                                             *" + "\n");
            System.out.println("      *         4 . Display related statistics to the Selected FootBall Clubs (Press Number 4)        *" + "\n");
            System.out.println("      *         5 . Add played match3(Press Number 5)                                                 *" + "\n");
            System.out.println("      *         6 . Open GUI  (Press Number 6)                                                        *" + "\n");
            System.out.println("      *         7 . Exit the Programme (Press Number 7)                                               *" + "\n");
            System.out.println("      **---------------------------------------------------------------------------------------------**"+"\n");

            while (true) {
                //Input Option you want
                System.out.print("What Option do you want :  ");
                String MainOption = startMenu.nextLine();
                System.out.println("\n");

                //Checking Conditions
                if ((MainOption).equals("1")) {
                    //Method calling to add new Foot Ball Club
                    addFootBallClubToLeague();
                    break;

                } else if ((MainOption).equals("2")) {
                    //Method calling to delete football club from the league
                    deleteFootBallClub();
                    break;

                } else if ((MainOption).equals("3")) {
                    //Method calling to print clubs those are already in the league
                    printClubs();
                    break;
                } else if ((MainOption).equals("4")) {
                    //Method calling to show details about entered club
                    showRelatedDetailsEnteredClub();
                    break;
                } else if ((MainOption).equals("5")) {
                    //Method calling to update current Score
                    premierLeagueManager.addPlayedMatch();
                    break;
                } else if ((MainOption).equals("6")) {
                    //Method calling to display gui window
                    displayTableInterface displayTable_interface = new displayTableInterface();
                    displayTable_interface.viewingInterface();
                    break;
                } else if(MainOption.equals("7")){
                    System.exit(0);
                } else {
                    System.out.println("Invalid Data Entered.Please Enter Valid Option " +
                            "in to the System");
                }
            }
             /*Ask from user want to continue programme or not
            If not press key n.Then you can exit the programme*/
            System.out.println();
            System.out.print("If you want to break the program enter key (N or n)..");
            System.out.println("If you want to exit the Program print (E or e)");
            System.out.print("Do You Want to Continue the program : ");

            String reOption = startMenu.nextLine();

            //Get option N entered break  the programme and if e entered exit the program
            if ((reOption).equals("N") || reOption.equals("n")) {
                break;

            } else if (reOption.equals("E") || reOption.equals("e")) {
                System.exit(0);
            }
        }
    }

    //========================================================================================================================================================================================

    //Create a method to Add Club to the league
    private static void addFootBallClubToLeague(){

        System.out.println("\n"+"------------------------------------------------------------------------------------------------------------------------------------------"+"\n");

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ || Add a Club to the League || $$$$$$$$$$$$$$$$$$$$$$"+"\n");

        System.out.print("> Enter the name of the Foot Ball Club : ");
        String SCName = startMenu.nextLine();

        System.out.print("\n"+"> Enter the Location of the Foot Ball Club : ");
        String SCLocation = startMenu.nextLine();

        System.out.println("\n");

        /*get more details about the club if club members are school then get their school details
         * if they are university then get university details and if not leave it*/
        System.out.println("        >> If the club is school club (Club members are Under 18)(Press S ) ");
        System.out.println("        >> If the club is University club (Club members are Under 23)(Press U )");
        System.out.println("        >> If club members are not belongs to any of it (Press X )"+"\n");

        //select option
        System.out.print("> Select option what entered club related to : ");
        String choiceType = startMenu.nextLine();

        //Checking conditions
        if(choiceType.equalsIgnoreCase("S")){

            //Add more details about the School club
            System.out.print("\n"+"> Enter School Name :  ");
            String sclName = startMenu.nextLine();
            System.out.print("\n"+"> Enter School Type (Government or Private)(   G || P   ) : ");
            String sclType = startMenu.nextLine();

            footBall_club sclClub = new school_footBallClub(SCName,SCLocation,sclName,sclType);
            addStatisticsToClub(sclClub);

            // sportClubFootBall.addClubToLeague(ClubFootBall);
        }else if(choiceType.equalsIgnoreCase("U")){

            //Add more details about University Club
            System.out.print("\n"+"> Enter University Name :  ");
            String uniName = startMenu.nextLine();

            //uniClub.setUniversityName(add.nextLine());
            System.out.print("\n"+"> Enter University Type (Government or Private)(   G || P   ) :  ");
            String uniType = startMenu.nextLine();

            footBall_club uniClub = new uni_footBallClub(SCName,SCLocation,uniName,uniType);
            addStatisticsToClub(uniClub);

            //uniClub.setUniversityType(add.nextLine());
        }else if (choiceType.equalsIgnoreCase("X")) {

            footBall_club footBall_club = new footBall_club(SCName,SCLocation);
            addStatisticsToClub(footBall_club);

        }else{
            System.out.println("Invalid Input Entered...........");
        }


    }

    //====================================================================================================================================================================================

    //Create a method for delete foot ball club
    private static void deleteFootBallClub() {

        System.out.println("\n" + "--------------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ || Delete a Club from the League || $$$$$$$$$$$$$$$$$$$$$$" + "\n");

        System.out.print("> Enter the Name of the football club you want to delete : ");
        String S_ClubName = startMenu.nextLine();
        premierLeagueManager sportClubFootBall = new premierLeagueManager();
        int ans = sportClubFootBall.deleteClubFromLeague(S_ClubName);

        //Checking Conditions about Clubs
        if (ans == 1){
            System.out.println("Entered club deleted Successfully");
        } else {
            System.out.println("The club you entered is not available in the league. ");
        }

        System.out.print(">>> Do you want to delete club again (Y/N) : ");
        String Choice02 = startMenu.nextLine();
        if(Choice02.equalsIgnoreCase("Y")){
            deleteFootBallClub();
        } else if (Choice02.equalsIgnoreCase("N")){
            displayPremierLeagueMenuDetails();
        } else {
            System.out.println("Invalid input entered!!!!!!!!!!");
            new startMenu();
        }

    }

    //========================================================================================================================================================================================

    //Create a method for Show details related to entered sport club
    private static void showRelatedDetailsEnteredClub(){
        System.out.println("\n" + "--------------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ || Show All Details About the Entered Club || $$$$$$$$$$$$$$$$$$$$$$" + "\n");

        System.out.print("> Enter the Name of the football club that you want to know more details : ");
        String S_ClubName = startMenu.nextLine();

        //Create an object for premier League manager
        premierLeagueManager sportClubFootBall = new premierLeagueManager();

        sportClubFootBall.ShowRelatedDetailsEnteredClub(S_ClubName);

        System.out.print(">>> Do you want to know more details about another club again (Y/N) : ");
        String Choice02 = startMenu.nextLine();
        //Checking conditions
        if(Choice02.equalsIgnoreCase("Y")){
            showRelatedDetailsEnteredClub();

        } else if (Choice02.equalsIgnoreCase("N")){
            displayPremierLeagueMenuDetails();

        } else {
            System.out.println("Invalid input entered!!!!!!!!!!");
            new startMenu();
        }

    }

    //==============================================================================================================================================================================

    //Create method for print clubs those are already in the league
    private static void printClubs(){

        System.out.println("\n" + "--------------------------------------------------------------------------------------------------------------------------------" + "\n");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$ || Print Clubs already in the League || $$$$$$$$$$$$$$$$$$$$$$" + "\n");

        //Method calling to the premier league manager class
        premierLeagueManager ClubFootBall = new premierLeagueManager();

        ClubFootBall.showTheClubsInLeague();

    }

    //=======================================================================================================================================================================================

    private static void addStatisticsToClub(footBall_club footBall_club){

        System.out.print("\n"+"> Do you want to add more details related to the club ?(Y/N) :"+"\n");
        String choice = startMenu.nextLine();

        premierLeagueManager sportClubFootBall = new premierLeagueManager();

        //Checking choices
        if(choice.equalsIgnoreCase("Y")){

            //If you entered "Y" Add more details to the club
            System.out.print("> Number of wins in the season : ");
            footBall_club.setF_Wins(startMenu.nextInt());

            System.out.print("> Number of draws in the season : ");
            footBall_club.setF_Draws(startMenu.nextInt());

            System.out.print("> Number of defeats in the season : ");
            footBall_club.setF_Defeat(startMenu.nextInt());

            System.out.print("> Number of Goals scored in the season : ");
            footBall_club.setF_GScored(startMenu.nextInt());

            System.out.print("> Number of Goals received in the season : ");
            footBall_club.setF_GReceived(startMenu.nextInt());

            System.out.print("> Number of Points Club currently has : ");
            double points = footBall_club.getF_Wins()*3+ footBall_club.getF_Draws();
            System.out.print(points+"\n");
            footBall_club.setF_NumOfPoints(points);

            System.out.print("> Number of matches that club played : ");
            int matches = footBall_club.getF_Wins()+ footBall_club.getF_Defeat()+ footBall_club.getF_Draws();
            System.out.print(matches+"\n");
            footBall_club.setF_NumOfMatchesPayed(matches);

            //all the inputs add to the club
            premierLeagueManager premierLeagueManager = new premierLeagueManager();
            premierLeagueManager.addClubToLeague(footBall_club);
            //Print entered details about the club
            System.out.println();
            //Ask from user his choice continue adding or not
            System.out.print(">>> Do You want to add club again (Y/N) : ");
            String choice01 = startMenu.nextLine();

            if(choice01.equalsIgnoreCase("Y")){
                //Method calling to add club to the league
                addFootBallClubToLeague();

            } else if (choice01.equalsIgnoreCase("N")){
                //If your choice is no again call a method to display menu details
                displayPremierLeagueMenuDetails();

            } else {
                System.out.println("Invalid input entered.........");
                //Method calling to display menu details again
                displayPremierLeagueMenuDetails();
            }

        } else if (choice.equalsIgnoreCase("N")){

            sportClubFootBall.addClubToLeague(footBall_club);
            //Method calling to Display Menu details again
            displayPremierLeagueMenuDetails();

        } else {
            System.err.println("Invalid Data Entered!!!!!!!!!!!");
            //Method calling to Display Menu details again
            new startMenu();

        }
    }
}
