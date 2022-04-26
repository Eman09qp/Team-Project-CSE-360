
public class Food {
    private String foodName = "";
    private String foodType = "";
    private String ingredients = "";
    private double price = 0.0;
    private String image = "";
    
    public Food(String newFoodName, String newFoodType, String newIngredients, double newPrice, String newImage){
        foodName = newFoodName;
        foodType = newFoodType;
        ingredients = newIngredients;
        price = newPrice;
        image = newImage;
    }

    //Getters and Setters
    public String getName() {
        return foodName;
    }

    public void setName(String newFoodName){
        this.foodName = newFoodName;
    }


    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return  "\nFood Name:\t\t\t" + foodName +
                "\nFood Type\t\t\t" + foodType +
                "\nIngredients:\t\t\t" + ingredients +
                "\nPrice:\t\t\t" + price;
    }

    public String getImage() {
        return image;
    }
}
