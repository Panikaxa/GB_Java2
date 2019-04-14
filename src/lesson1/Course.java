package lesson1;

import lesson1.challenges.Challenge;
import lesson1.challenges.Jump;
import lesson1.challenges.Run;
import lesson1.challenges.Swim;

public class Course {
    private Challenge[] challenges;

    public Course() {
        challenges = new Challenge[3];
        challenges[0] = new Run(200);
        challenges[1] = new Jump(1);
        challenges[2] = new Swim(100);
    }

    public void doIt(Team team){
        for (int i = 0; i < challenges.length; i++) {
            for (int j = 0; j < team.getTeamMemberArray().length; j++) {
                challenges[i].start(team.getTeamMemberArray()[j]);
            }
        }
    }

    public void showResult(Team team){
        System.out.println("Результаты испытания");
        for (int i = 0; i < challenges.length; i++) {
            for (int j = 0; j < team.getTeamMemberArray().length; j++) {
                challenges[i].start(team.getTeamMemberArray()[j]);
                if (challenges[i].isCheckPass()){
                    System.out.println(team.getTeamMemberArray()[j].getType() + " " +
                            team.getTeamMemberArray()[j].getName() +
                            " have passed a challenge " + challenges[i].getName());
                } else {
                    System.out.println(team.getTeamMemberArray()[j].getType() + " " +
                            team.getTeamMemberArray()[j].getName() +
                            " have not passed a challenge " + challenges[i].getName());
                }
            }
        }
    }
}