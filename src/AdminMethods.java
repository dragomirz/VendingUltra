import java.sql.*;

public class AdminMethods {















































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



}
    //TODO CREATE BASIC METHOLOGY WORKING THIS WAY: 1.CODE STARTS 2.GET ALL INFO FROM DATABASE AND PUT INSIDE DIFFERENT DATA STRUCTURES AND VARIABLES
    //todo 3.USABLE VENDING MACHINE, 4AFTER USER/ADMIN FINISHES USING VENDING MACHINE UPDATE SQL AND DONE.
