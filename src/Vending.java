import java.util.ArrayList;

public class Vending {
    private ArrayList<Products> products;
    private ArrayList<Ingredients> ingredients;
    private Coins vendingWallet;
    public Vending(ArrayList<Products> products, ArrayList<Ingredients> ingredients, Coins vendingWallet){
        this.products = products;
        this.ingredients = ingredients;
        this.vendingWallet = vendingWallet;
    }
}