/** 
* JavaCore package homework2 
* @author Slava Grishin
* version 16.12.2021
*/
package Homework2;

public class MyArrayDataException extends RuntimeException{
    int i, j;
    public MyArrayDataException(int i, int j){
        this.i = i;
        this.j = j;
    }
    @Override
    public String toString(){
        return "Ошибка значения в ячейке [" + i + "]["+j+"]";
    }
}
