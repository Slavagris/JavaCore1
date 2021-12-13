/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.12.2021
*/
package Homework1;

public class Team {
    private Participant[] participants;

    public Team(Participant... participants) {
        // внутри метода переменное число параметров интерпретируется как массив
        this.participants = participants;
    }
    public Participant[] getParticipants() {
        return participants;
    }

}
