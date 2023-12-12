import java.sql.*;

public class AdminMethods {
    public static void getProductsIngredients(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/vending";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM productsingredientslink";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int column1Value = resultSet.getInt("column1");
                String column2Value = resultSet.getString("column2");
                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static void fillVending(){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    String url = "jdbc:mysql://localhost:3306/vending";
                    String username = "root";
                    String password = "";
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String query = "SELECT product.product_name, ingredient.ingredient_id, ingredient.ingredient_name " +
                            "FROM product " +
                            "JOIN product_ingredient ON product.product_id = product_ingredient.product_id " +
                            "JOIN ingredient ON product_ingredient.ingredient_id = ingredient.ingredient_id " +
                            "WHERE product.product_id = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    int yourVariableValue = 123;
                    preparedStatement.setInt(1, yourVariableValue);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String productName = resultSet.getString("product_name");
                        int ingredientId = resultSet.getInt("ingredient_id");
                        String ingredientName = resultSet.getString("ingredient_name");
                        System.out.println("Product Name: " + productName + ", Ingredient ID: " + ingredientId +
                                ", Ingredient Name: " + ingredientName);
                    }

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
            }
        }

    }
    //TODO CREATE BASIC METHOLOGY WORKING THIS WAY: 1.CODE STARTS 2.GET ALL INFO FROM DATABASE AND PUT INSIDE DIFFERENT DATA STRUCTURES AND VARIABLES
    //todo 3.USABLE VENDING MACHINE, 4AFTER USER/ADMIN FINISHES USING VENDING MACHINE UPDATE SQL AND DONE.
~