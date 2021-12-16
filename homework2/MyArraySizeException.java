/** 
* JavaCore package homework2 
* @author Slava Grishin
* version 16.12.2021
*/
package Homework2;

public class MyArraySizeException extends RuntimeException{
    int size;
    public MyArraySizeException(int size){
        this.size = size;
    }

    @Override
    public String toString(){
        return "Не корретный размер массива " + size;
    }

}
