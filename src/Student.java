public class Student {
    private int rolNo;
    private String name;
    private int age;
    private String email;

    public Student(int rolNo, String name, int age, String email) {
        this.rolNo = rolNo;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getRolNo() {
        return rolNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
