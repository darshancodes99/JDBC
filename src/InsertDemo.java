import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {
    public static void main(String[] args) throws Exception {
        String name = "amit";
        String email = "amit@gmail.com";
        String password = "amit123";
        String gender = "male";
        String city = "surat";

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");
        PreparedStatement pac = con.prepareStatement("insert into register values(?,?,?,?,?)");

        pac.setString(1, name);
        pac.setString(2, email);
        pac.setString(3, password);
        pac.setString(4, gender);
        pac.setString(5, city);

        int i = pac.executeUpdate();

        if (i > 0){
            System.out.println("success");
        } else {
            System.out.println("fail");
        }



    }
}
