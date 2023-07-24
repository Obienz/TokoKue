package Model;

public class Cookie extends Item {
	
	 private String[] ingredients;

	    public Cookie(String name, double price, String[] ingredients) {
	        super(name, price);
	        this.ingredients = ingredients;
	    }

	    public String getDescription() {
	        StringBuilder ingredientsStr = new StringBuilder();
	        for (int i = 0; i < ingredients.length; i++) {
	            ingredientsStr.append(ingredients[i]);
	            if (i < ingredients.length - 1) {
	                ingredientsStr.append(", ");
	            }
	        }
	        return name + " - Ingredients: " + ingredientsStr.toString() + " - $" + price;
	    }

}
