
import java.sql.*;
import java.util.Scanner;
public class Ingredients {
    final private int ingredient_id;
    private String ingredient_name;
    private int quantity_available;
    private String unit;
    public Ingredients(int ingredient_id, String ingredient_name, int quantity_available, String unit){
        this.ingredient_id = ingredient_id;
        this.ingredient_name = ingredient_name;
        this.quantity_available = quantity_available;
        this.unit = unit;
    }
    public static void ingredientCreator(String ingredientName){
        Scanner sc = new Scanner(System.in);
        int quantityAvailable;
        String unit;
        String dbUrl = "jdbc:mysql://localhost:3306/vending";
        String dbUser = "root";
        String dbPassword = "";
        Connection conn = null;
        String myQuery;
        myQuery = "INSERT INTO Ingredients (ingredient_name, quantity_available, unit) VALUES (?, ?, ?)";
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            PreparedStatement ps = conn.prepareStatement(myQuery);
            System.out.println("Enter the available quantity:");
            quantityAvailable = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the unit measurement");
            unit = sc.nextLine();
            ps.setString(1, ingredientName);
            ps.setInt(2, quantityAvailable);
            ps.setString(3, unit);
            ps.executeUpdate();
            System.out.println("Ingredient inserted successfully!");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public int getIngredient_id() {
        return ingredient_id;
    }
    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public int getQuantity_available() {
        return quantity_available;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantity_available = quantity_available;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
