/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.12.2021
 */
package Homework1.course;

import Homework1.Participant;


public class Cross extends Obstacle {

    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        participant.run(this.distance);
    }
}