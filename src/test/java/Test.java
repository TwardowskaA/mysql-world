import java.sql.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);


        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwe miasta:");
        String city = scan.nextLine();
        System.out.println("Podaj populacje:");
        String population = scan.nextLine();
        System.out.println("Podaj kod kraju");
        String code = scan.nextLine();

        Statement statement = connection.createStatement();
        String query = "insert into city (Name , Population, CountryCode) values ("  + "'" + city + "'" + "," + "'" + population + "'" + "," + "'" + code + "'" + ")";
        int inserted = statement.executeUpdate(query);
        System.out.println("Zaktualizowane rekordy " + inserted);

        String query1 = "SELECT * FROM city";
        ResultSet resultSet = statement.executeQuery(query1);
        while (resultSet.getString(2).equals(city)) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int pop = resultSet.getInt(5);
            System.out.println(id + " " + name + " " + pop);
        }
    }
}
//        String query = "select * from city";
//        String query1 = "SELECT * FROM city c JOIN countrylanguage cl ON cl.language = c.CountryCode";
//        ResultSet resultSet = statement.executeQuery(query);
//        ResultSet resultSet1 = statement.executeQuery(query1);
//        while (resultSet.next()) {
//            if (resultSet.getString(3).equals(code)) {
//                int id = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                System.out.println(id + " " + name + " ");
//            }
//        }
//
//    }
//}

