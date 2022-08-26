package fixRound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class fixround {
    static Scanner scan=new Scanner(System.in);
    static int numberOfTeam;

    public static void main(String[] args) {
        System.out.println("How many teams should our league have?");
        numberOfTeam=scan.nextInt();
        List<String> teams = new ArrayList<String>();
        while(teams.size()!=numberOfTeam) {
            System.out.println("Enter the teams.");
            teams.add(scan.next());
        }
        if(numberOfTeam%2!=0){
            teams.add("BAY");
            numberOfTeam++;
        }
        List<String> mixedTeams = new ArrayList<String>();
        for (int i = 0; i <numberOfTeam; i++) {
            int rnd=new Random().nextInt(teams.size());
            mixedTeams.add(teams.get(rnd));
            teams.remove(teams.get(rnd));

        }weeklyMatch(mixedTeams);

        }

    private static void weeklyMatch(List<String> mixedTeams) {
        int week=1;
        while(week<=2*numberOfTeam-2){
            System.out.println("week= " +week);
            String teamX="",teamY="";
            for (int i = 0; i <numberOfTeam/2; i++) {
                if (i==0&&week%2!=0){
                    teamY=mixedTeams.get(i);
                    teamX=mixedTeams.get(numberOfTeam-i-1);
                }else if (week%2==0){
                    teamX=mixedTeams.get(i);
                    teamY=mixedTeams.get(numberOfTeam-i-1);
                }else{
                    teamY=mixedTeams.get(i);
                    teamX=mixedTeams.get(numberOfTeam-i-1);
                }if (week<numberOfTeam){
                    System.out.println(teamX+ " VS " +teamY);
                }else{
                    System.out.println(teamY + " VS " +teamX);
                }

            }String removedTeam=mixedTeams.get(1);
            mixedTeams.remove(removedTeam);
            mixedTeams.add(removedTeam);
            week++;
        }

    }

}

