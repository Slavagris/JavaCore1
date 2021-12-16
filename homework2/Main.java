/** 
* JavaCore package homework2 
* @author Slava Grishin
* version 16.12.2021
*/
package Homework2;

public class Main {
    private final static int SIZE = 4;
    public static void main(String[] args){

        String[][] array = {{"1","2","asd","1"},{"1","1","saa","3"},{"1","1","1","8"},{"1","1","1","7"}};
        String[][] array2 = {{"1","1","asd","1"},{"1","1","asd","1"},{"1","1","saa","1"},{"1","1","1","1"},{"1","1","1","1"}};

        try{
            sumArray(array);
        }catch(MyArrayDataException e){
            e.printStackTrace();
        }

        try{
            sumArray(array2);
        }catch(MyArrayDataException e){
            e.printStackTrace();
        }
    }
    public static void sumArray(String[][] array) throws MyArrayDataException {
        int sum = 0;
        if(array.length != SIZE) throw new MyArraySizeException(array.length);
        for(int i = 0; i < array.length; i++){
            if(array[i].length != SIZE) throw new MyArraySizeException(array[i].length);
            for(int j = 0; j < array[i].length; j++){
                try{
                    sum+= convert(array[i][j], i, j);
                }catch(MyArrayDataException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Сумма: " + sum);
    }

    public static int convert(String s, int i, int j) throws MyArrayDataException {
        try{
            return Integer.parseInt(s);
        }catch(NumberFormatException e){
            throw new MyArrayDataException(i, j);
        }
    }
}
