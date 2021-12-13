/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.11.2021
 */
package Homework1.course;

import Homework1.Participant;
import Homework1.Team;

public class Course {

    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Participant participant : team.getParticipants()) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);

                // если участник сошел с дистанции, то нет смысла двигать его дальше
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
