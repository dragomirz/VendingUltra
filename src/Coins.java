import java.sql.*;
import java.util.LinkedHashMap;

public class Coins {
    private LinkedHashMap<Integer, Integer> NominationsAmount;
    public Coins(LinkedHashMap<Integer, Integer> NominationAmount){
        this.NominationsAmount = NominationAmount;
    }

    public LinkedHashMap<Integer, Integer> getNominationsAmount() {
        return NominationsAmount;
    }

    public void setNominationsAmount(LinkedHashMap<Integer, Integer> nominationsAmount) {
        NominationsAmount = nominationsAmount;
    }
    public static Coins generateMoneyContainer() {
        LinkedHashMap<Integer, Integer> Container = new LinkedHashMap<>();
        String myQuery = "SELECT * FROM coins ORDER BY nominals DESC";
        String connectionUrl = "jdbc:mysql://localhost:3306/vending";

        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
             PreparedStatement ps = conn.prepareStatement(myQuery);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int nominal = rs.getInt("nominals");
                int amount = rs.getInt("amount");
                Container.put(nominal, amount);
            }
        } catch (SQLException e) {
            // handle the exception
        }
        return new Coins(Container);
    }

}
