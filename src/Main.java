import java.util.*;
interface Ingredient { //considered as Abstract methods
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantityInG;
    public SolidIngredient (String n,  double q) { //2-arg Constructor
        _name = n;
        _quantityInG = q;
    }
    public String getName(){
        return  _name;
    }
    public double getQuantity() {
        return _quantityInG;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantityInMl;
    public LiquidIngredient (String n,  double q) { //2-arg Constructor
        _name = n;
        _quantityInMl = q;
    }
    public String getName(){
        return  _name;
    }
    public double getQuantity() {
        return _quantityInMl;
    }
}
class Recipe<T extends Ingredient>{
    private ArrayList<T> _ingredient;
    private String _name;
    private String _instructions;
    public Recipe(String n, String s){//n-arg constructor
        _name = n;
        _instructions = s;
        _ingredient = new ArrayList<T>();
    }
    public void addIngredient(T t){
        _ingredient.add(t);
    }
    public void print(){
        System.out.println("Recipe: "+_name);
        System.out.println("Instructions: "+_instructions);
        System.out.println("Ingredients: ");
        for(T t: _ingredient){
            System.out.println("-" + t.getName() + ": " + t.getQuantity() + ":");
        }
    }
}

public class Main {
    public static void main() {
        Scanner scanner = new Scanner(System.in)
        int choice;
        boolean exit = false;
        while(!exit) {
            System.out.println("Recipe Menu:");
            System.out.println("1. add an ingredient ");
            System.out.println("2. list an ingredients ");
            System.out.println("3. Exit ");
            System.out.println("Enter a number: ");
            try {
                choice = Integer.valueOf(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("invalid data entered" + e.getMessage());
            }
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("Enter the Ingredient: ");
                        String ingredient = scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Listing ingredients");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Exiting....");
                        exit = true;
                        break;
                    default:
                        System.out.println("invalid choice, please enter another choice: ");
                    }
                }
                else {
                    System.out.println("invalid, please enter a number:");
                    scanner.next();
                }

       }
    }
}

//public static void addIngrediesnt(Recipe<Ingredient> recipe, Scanner scan{
//    System.out.println("is it a solid or liquid:");
//    char type = scan.nextLine().charAt(0);
//    System.out.println("enter name:");
//    String name = scan.nextLine();
//    System.out.println("enter quantity:");
//    double quantity = Double.parseDouble(scan.nextLine());
//    Ingredient ingredient; //polymorphic reference
//    if(type =='s')
//        ingredient = new SolidIngredient(name, quantity);
//    else
//        ingredient = new LiquidIngredient(name, quantity);
//    recipe.addIngredient(ingredient);
//}
public static void main(String[] args){

}