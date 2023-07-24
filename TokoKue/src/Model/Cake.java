package Model;

public class Cake extends Item {
	
	private String flavor;

    public Cake(String name, double price, String flavor) {
        super(name, price);
        this.flavor = flavor;
    }

    @Override
    public String getDescription() {
        return name + " - " + flavor + " - $" + price;
    }

}
