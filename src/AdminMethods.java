import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminMethods {
    public static void productCreator(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("What type of product do you want to insert:\n1:Food 2:Drink\n");
        int check = Integer.parseInt(sc.nextLine());
        String drinkName;
        String drinkType;
        int drinkPrice;
        int quantityRequired;
        String ingredientName;
        String foodType;
        String foodName;
        int foodPrice;
        String dbUrl = "jdbc:mysql://localhost:3306/vending";
        String dbUser = "root";
        String dbPassword = "";
        String myQuery;
        Connection conn = null;
        switch (check){
            case 1:
                myQuery = "INSERT INTO Products (product_name, product_type, price) VALUES (?, ?, ?)";
                try {
                    conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                    PreparedStatement ps = conn.prepareStatement(myQuery);
                    System.out.println("Enter the food name:");
                    foodName = sc.nextLine();
                    foodType = "food";
                    System.out.println("Enter the food price:");
                    foodPrice = Integer.parseInt(sc.nextLine());
                    ps.setString(1, foodName);
                    ps.setString(2, foodType);
                    ps.setDouble(3, foodPrice);
                    ps.executeUpdate();
                    System.out.println("Food inserted successfully!");
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                myQuery = "INSERT INTO Products (product_name, product_type, price) VALUES (?, ?, ?)";
                try {
                    conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                    PreparedStatement ps = conn.prepareStatement(myQuery);
                    System.out.println("Enter the drink name:");
                    drinkName = sc.nextLine();
                    drinkType = "drink";
                    System.out.println("Enter the drink price:");
                    drinkPrice = Integer.parseInt(sc.nextLine());
                    ps.setString(1, drinkName);
                    ps.setString(2, drinkType);
                    ps.setDouble(3, drinkPrice);
                    ps.executeUpdate();
                    System.out.println("Drink inserted successfully!");
                    ps.close();

                    // Get the last inserted product id
                    int drinkId = 0;
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
                    if (rs.next()) {
                        drinkId = rs.getInt(1);
                    }
                    rs.close();
                    st.close();

                    // Prompt the user to enter the number of ingredients
                    System.out.println("Enter the number of ingredients for the drink:");
                    int numIngredients = Integer.parseInt(sc.nextLine());

                    // Loop through the ingredients
                    for (int i = 1; i <= numIngredients; i++) {
                        // Prompt the user to enter the ingredient name
                        System.out.println("Enter the name of ingredient " + i + ":");
                        ingredientName = sc.nextLine();

                        // Check if the ingredient already exists in the Ingredients table
                        boolean ingredientExists = false;
                        int ingredientId = 0;
                        st = conn.createStatement();
                        rs = st.executeQuery("SELECT ingredient_id FROM Ingredients WHERE ingredient_name = '" + ingredientName + "'");
                        if (rs.next()) {
                            // The ingredient exists, get its id
                            ingredientExists = true;
                            ingredientId = rs.getInt(1);
                        }
                        rs.close();
                        st.close();

                        // If the ingredient does not exist, create it
                        if (!ingredientExists) {
                            // Prompt the user to enter the ingredient information
                            Ingredients.ingredientCreator(ingredientName);
                            // Get the last inserted ingredient id
                            st = conn.createStatement();
                            rs = st.executeQuery("SELECT LAST_INSERT_ID()");
                            if (rs.next()) {
                                ingredientId = rs.getInt(1);
                            }
                            rs.close();
                            st.close();
                        }

                        // Prompt the user to enter the quantity required for the ingredient
                        System.out.println("Enter the quantity required for the ingredient:");
                        quantityRequired = Integer.parseInt(sc.nextLine());

                        // Insert the drink and ingredient ids and the quantity required into the productsingredients table
                        myQuery = "INSERT INTO productsingredients (product_id, ingredient_id, quantity_required) VALUES (?, ?, ?)";
                        ps = conn.prepareStatement(myQuery);
                        ps.setInt(1, drinkId);
                        ps.setInt(2, ingredientId);
                        ps.setInt(3, quantityRequired);
                        ps.executeUpdate();
                        System.out.println("Drink and ingredient linked successfully!");
                        ps.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Try again");
                break;

        }
    }
}

















































//    public static void getProductsIngredients(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/vending";
//            String username = "root";
//            String password = "";
//            Connection connection = DriverManager.getConnection(url, username, password);
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM productsingredientslink";
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                int column1Value = resultSet.getInt("column1");
//                String column2Value = resultSet.getString("column2");
//                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
//            }
//            resultSet.close();
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
//






























//    public static void fillVending() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/vending";
//            String username = "root";
//            String password = "";
//            Connection connection = DriverManager.getConnection(url, username, password);
//
//            String query = "SELECT products.product_name, ingredients.ingredient_name, products.product_id\n" +
//                    "FROM products\n" +
//                    "JOIN productsingredientslink ON products.product_id = productsingredientslink.product_id\n" +
//                    "JOIN ingredients ON productsingredientslink.ingredient_id = ingredients.ingredient_id\n" +
//                    "ORDER BY products.product_id;";
//
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            int currentProductId = -1;
//            while (resultSet.next()) {
//                String productName = resultSet.getString("product_name");
//                String ingredientName = resultSet.getString("ingredient_name");
//                int productId = resultSet.getInt("product_id");
//                if (productId != currentProductId) {
//                    System.out.println("Product Name: " + productName);
//                    currentProductId = productId;
//                }
//                System.out.println("Ingredient Name: " + ingredientName);
//            }
//
//            resultSet.close();
//            preparedStatement.close();
//            connection.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }




    //TODO CREATE BASIC METHOLOGY WORKING THIS WAY: 1.CODE STARTS 2.GET ALL INFO FROM DATABASE AND PUT INSIDE DIFFERENT DATA STRUCTURES AND VARIABLES
    //todo 3.USABLE VENDING MACHINE, 4AFTER USER/ADMIN FINISHES USING VENDING MACHINE UPDATE SQL AND DONE.
