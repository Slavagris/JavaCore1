/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.11.2021
 */
package Homework1;

import Homework1.animal.Cat;
import Homework1.course.Course;
import Homework1.course.Cross;
import Homework1.course.Wall;
import Homework1.course.Water;
import Homework1.animal.Dog;
import Homework1.animal.Human;
import Homework1.animal.Robot;
import Homework1.enums.Color;

public class Main {
    public static void main(String[] args) {
        Team team = new Team(
                new Cat("Барсик", Color.BLACK, 1, 100, 5),
                new Cat("Барсик", Color.BLACK, 1, 80, 7),
                new Dog("Бобик", Color.BROWN, 2, 90, 8, 18),
                new Human("Слава",Color.WHITE,23,100,3,100),
                new Robot("Bot",Color.RED,23,100,3)

        );

        Course course = new Course(
                new Cross(50),
                new Wall(2),
                new Cross(90),
                new Water(19)
        );

        course.doIt(team);
    }
}
