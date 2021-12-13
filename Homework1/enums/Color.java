/**
 * JavaCore package Homework1
 *
 * @author Slava Grishin
 * version 13.12.2021
 */
package Homework1.enums;

public enum Color {
    WHITE("Белый"),
    BLACK("Черный"),
    BROWN("Коричневый"),
    GRAY("Серый"),
    YELLOW("Желтый"),
    RED("Рыжий");

    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName()  {
        return name;
    }
}
