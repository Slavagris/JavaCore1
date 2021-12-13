/**
 * JavaCore package Homework1.animal
 *
 * @author Slava Grishin
 * version 13.12.2021
 */
package Homework1.animal;

import Homework1.enums.Color;

public abstract class Animal {

    private String name;
    private Color color;
    private int age;

    public Animal(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    // Перегруженный (overload) конструктор
    public Animal(String name, Color color) {
        this(name, color, 0);
//        this.name = name;
//        this.color = color;
//        this.age = 0;
    }

    public abstract void voice();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
