/**
 * JavaCore Homework1
 *
 * @author Slava Grishin
 * version 13.12.2021
 */
package Homework1;

public interface Participant {
    boolean isOnDistance();

    void run(int distance);

    void jump(int height);

    void swim(int distance);
}
