package hospital;

public class index {
    public static void main(String[] args) throws Exception {
        Connection connection = new Connection();
        connection.get();
        System.out.println("Hello, World!");
        System.out.println("This is a test of the Java program.");
    }
}
