package lesson1;

import lesson1.animal.Animal;

public class Team {
    private String teamName;
    private Animal[] teamMemberArray;

    public Team(String teamName, Animal ... member){
        this.teamName = teamName;
        teamMemberArray = new Animal[4];
        for (int i = 0; i < teamMemberArray.length; i++){
            teamMemberArray[i] = member[i];
        }
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Animal[] getTeamMemberArray() {
        return teamMemberArray;
    }

    public void infoTeamMember(){
        for (int i = 0; i < teamMemberArray.length; i++) {
            System.out.println("Member " + (i + 1) + " of team: ");
            teamMemberArray[i].info();
        }
    }
}