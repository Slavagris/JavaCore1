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