package Model;

	import java.util.ArrayList;

	public class Bakery {
	    private ArrayList<Item> items;

	    public Bakery() {
	        items = new ArrayList<>();
	    }

	    public void addNewItem(Item item) {
	        items.add(item);
	    }

	    public ArrayList<Item> getItems() {
	        return items;
	    }
	}


