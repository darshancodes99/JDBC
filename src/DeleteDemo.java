import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) throws SQLException {
        String email1 = "amit@gmail.com";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
        PreparedStatement pac = con.prepareStatement("delete from register where email=?");

        pac.setString(1, email1);

        int c = pac.executeUpdate();
        if (c > 0){
            System.out.println("success");
        } else {
            System.out.println("not");
        }
    }
}
