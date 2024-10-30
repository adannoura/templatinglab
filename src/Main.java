import java.util.*;
interface Ingredient {
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public String getName(){
        return  _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public String getName(){
        return  _name;
    }
    public double getQuantity() {
        return _quantity;
    }
}
class Recipe<T extends Ingredient>{
    private ArrayList<T> _ingredient;
    public Stuff(){
        _ingredient = new ArrayList<T>();
    }
    public String name;
    public String instructions;
    public void addIngredient(T t){
        _ingredient.add(t);
    }
    public void print(){
        if(_ingredient != null)
            System.out.println();
        else
            System.out.println("null member variable");
    }



// n-arg constructor,
}

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner;

        System.out.println("1. add an ingredient ");
        System.out.println("2. list an ingredient ");
        System.out.println("3. Exit ");
        System.out.println("Enter a number: ");
        //        get user data
//        while( != 3){
//            process
//            show menu
//            get user data
        }

    }
}