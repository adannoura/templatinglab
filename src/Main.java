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
    public void setInstructions(String instructions){_instructions = instructions;}
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
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner scan){
        System.out.println("Is it a solid or liquid s/l:");
        char type = scan.nextLine().charAt(0);
        System.out.println("enter name:");
        String name = scan.nextLine();
        System.out.println("enter quantity:");
        double quantity = Double.parseDouble(scan.nextLine());
        Ingredient ingredient; //polymorphic reference
        if(type =='s')
            ingredient = new SolidIngredient(name, quantity);
        else
            ingredient = new LiquidIngredient(name, quantity);
        recipe.addIngredient(ingredient);
    }
    public static void addInstructions(Recipe<Ingredient> recipe, Scanner scan){
        System.out.println("Enter Instructions:" );
        String instructions = scan.nextLine();
        recipe.setInstructions(instructions);
        int choice = menu(scan);
        while (choice != 3){
            switch (choice){
                case 1:
                    addIngredient(recipe, scan);
                    break;
                case 2:
                    recipe.print();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
            choice = menu(scan);
        }
    }
    public static int menu(Scanner scanner) {
        int choice = 0;
        System.out.println("Recipe Menu:");
        System.out.println("1. add an ingredient ");
        System.out.println("2. list ingredients ");
        System.out.println("3. Exit ");
        System.out.println("Enter a number: ");
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("invalid data entered" + e.getMessage());
        }
        return choice;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter recipe name: ");
        String name = scanner.nextLine();
        Recipe<Ingredient> recipe = new Recipe<>(name, "");
        addInstructions(recipe, scanner);
    }

}

//try{
//sout(----)
// int choice = scan....
//while(choice != sentinal)
//if 1
//else if 2
//else 3 invalid
//sout(----)
//choice = scan
// }
//}catch(----){}