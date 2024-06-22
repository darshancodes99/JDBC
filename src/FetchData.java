import java.sql.*;

public class FetchData {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","root");

        PreparedStatement ps = con.prepareStatement("select * from register");
        ResultSet rs =  ps.executeQuery();

        while (rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("email"));
            System.out.println(rs.getString("city"));
        }
    }
}
