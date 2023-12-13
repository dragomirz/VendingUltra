import java.util.ArrayList;
import java.util.Map;

public class Vending {
    private ArrayList<Products> products;
    private ArrayList<Ingredients> ingredients;
    private Coins vendingWallet;
    public Vending(ArrayList<Products> products, ArrayList<Ingredients> ingredients, Coins vendingWallet){
        this.products = products;
        this.ingredients = ingredients;
        this.vendingWallet = vendingWallet;
    }



    public static void getVendingCash(Coins wallet){
        System.out.println("  Money:");
        for(Map.Entry<Integer, Integer> entry : wallet.getNominationsAmount().entrySet()){
            System.out.println(String.format("%.2f", entry.getKey() / 100.0) + " => " + entry.getValue());
        }

    }
}