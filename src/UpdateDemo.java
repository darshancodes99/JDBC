import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    public static void main(String[] args) throws SQLException {

        String city1 = "ahmedabad";
        String email1 = "amit@gmail.com";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
        PreparedStatement pac = con.prepareStatement("update register set city=? where email=?");

        pac.setString(1, city1);
        pac.setString(2, email1);

        int c = pac.executeUpdate();
        if (c > 0){
            System.out.println("success");
        } else {
            System.out.println("not");
        }
    }
}
