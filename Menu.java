import java.util.HashMap;

public class Menu {
    private HashMap<String, Food> menu;

    public Menu() {
        menu  = new HashMap<String, Food>();
    }

    public void addToMenu (Food newFood) {
        menu.put(newFood.getName(), newFood);
    }

    public void removeFromMenu(String rm) {
        try {
            menu.remove(rm);

        } catch (UnknownError e){
            System.out.println("Could not remove");
        }
    }

    public Food searchMenu(String search) {
        return menu.get(search);
    }

}

