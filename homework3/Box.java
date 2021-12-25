package homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> box = new ArrayList<>();
    //    public Box(T...fruits){
//        box = new ArrayList<>(Arrays.asList(fruits));
//    }
    public Box(){

    }
    
   
    public float getWeight(){
        float weight = 0.0f;

//        for (int i = 0; i < box.length; i++) {}
        for(T o : box){
            weight += o.getWeight();
        }return weight;
    }
    public boolean compare(Box anotherBox) {
        if(getWeight() == anotherBox.getWeight()) return true;
        return false;
    }
    public void pourTo(Box <T>anotherBox){
        anotherBox.box.addAll(box);
        box.clear();
    }
    
    public void addFruit(T fruit, int amount){
        for(int i=0;i<amount;i++){
            box.add(fruit);
        }
    }
}
