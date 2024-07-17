import java.sql.*;

public class StudentDatabase {

    public static void main(String[] args) throws SQLException {
        Student student1 = new Student(1, "kartik", 21, "kartik456@gmail.com");
        Student student2 = new Student(2, "manav", 19, "manav678@gmail.com");
        Student student3 = new Student(3, "maulik", 21, "maulik234@gmail.com");
        Student student4 = new Student(4, "mayank", 20, "mayank234@gmail.com");
        Student student5 = new Student(5, "tirth", 20, "tirthpatel67@gmail.com");
        insert(student1);
        insert(student2);
        insert(student3);
        insert(student4);

        delete("mayank234@gmail.com");

        update(20,"manav");

        fetchData();
        insert(student5);

    }

    public static void insert(Student student) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        PreparedStatement checkStatement = connection.prepareStatement("SELECT COUNT(*) FROM student WHERE rollNo = ?");
        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO student (rollNo, name, age, email) VALUES (?, ?, ?, ?)");

        // Check if the student ID already exists
        checkStatement.setInt(1, student.getRolNo());
        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();

        if (resultSet.getInt(1) > 0) {
            System.out.println("A student with ID " + student.getRolNo() + " already exists.");
            return;
        }

        // If not exists, insert the new student
        insertStatement.setInt(1, student.getRolNo());
        insertStatement.setString(2, student.getName());
        insertStatement.setInt(3, student.getAge());
        insertStatement.setString(4, student.getEmail());

        int rowsInserted = insertStatement.executeUpdate();
        System.out.println(rowsInserted > 0 ? "A new student was inserted successfully!" : "Failed to insert the student.");
    }

    public static void delete(String email) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("delete from student where email=?");

        preparedStatement.setString(1, email);

        int row = preparedStatement.executeUpdate();
        if (row > 0) {
            System.out.println("delete user successfully");
        } else {
            System.out.println("deletion failed");
        }
    }

    public static void update(int age, String name) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
        PreparedStatement ps = connection.prepareStatement("update student set age=? where name=?");

        ps.setInt(1, age);
        ps.setString(2, name);

        int c = ps.executeUpdate();
        if (c > 0){
            System.out.println("update successfully");
        } else {
            System.out.println("update failed");
        }
    }

    public static void fetchData() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "root");
        PreparedStatement ps = connection.prepareStatement("select * from student");

        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.print("rollNo : " + rs.getInt("rollNo") + " name : " + rs.getString("name") + " age " + rs.getInt("age") + " email : " + rs.getString("email"));
            System.out.println();
        }
    }
}

