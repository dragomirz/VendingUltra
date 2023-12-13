import java.sql.*;
import java.util.HashMap;
import java.util.Scanner;

public class Products {
    final private int product_id;
    private String product_name;
    private String product_type;
    private int price;
    private HashMap<Ingredients,Integer> ingredients;
    public Products(int product_id, String product_name, String product_type, HashMap<Ingredients,Integer> ingredients, int price ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.ingredients = ingredients;
        this.price = price;
    }
    public Products(int product_id, String product_name, String product_type, int price ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_type = product_type;
        this.price = price;
    }

    //create food product creator first
//    public ArrayList<Products> prepareProductsArrayList(){
//        LinkedHashMap<Integer, Integer> Container = new LinkedHashMap<>();
//        String myQuery = "SELECT * FROM ";
//        String connectionUrl = "jdbc:mysql://localhost:3306/vending";
//
//        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
//             PreparedStatement ps = conn.prepareStatement(myQuery);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//                int nominal = rs.getInt("nominals");
//                int amount = rs.getInt("amount");
//                Container.put(nominal, amount);
//            }
//        } catch (SQLException e) {
//            // handle the exception
//        }
//    }












    public int getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public HashMap<Ingredients, Integer> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredients,Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
