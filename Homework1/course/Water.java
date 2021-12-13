/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.12.2021
 */
package Homework1.course;

import Homework1.Participant;
public class Water extends Obstacle {

    private int pooldist;

    public Water(int pooldist) {
        this.pooldist = pooldist;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(this.pooldist);
    }
}