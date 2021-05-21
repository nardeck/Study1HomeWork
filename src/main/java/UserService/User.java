package UserService;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;
import java.util.Scanner;

public class User {

    public static final String USER_NAME = "root";
    public static final String PASSWORD = "g145101988Q";
    public static final String URL = "jdbc:mysql://localhost:3306/data_users";
    public static  Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }
    static {
        try {
            statement = connection.createStatement();
        }catch (SQLException throwables){
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }



    public static void main( String[] args ) throws NoSuchAlgorithmException, InvalidKeySpecException, SQLException {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException classNotFoundException){
            System.out.println(classNotFoundException.getMessage());
        }


//        Scanner sc = new Scanner (System.in);
//
//        System.out.println("Введите login");
//
//        String login = sc.next();
//
//        System.out.println("Введите password");
//
//        String password = sc.next();
//
//        byte [] salt = new byte[16];
//
//        KeySpec keySpec = new PBEKeySpec(password.toCharArray(),salt,65536,128);
//
//        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//
//        byte[] hash = factory.generateSecret(keySpec).getEncoded();

        statement.executeUpdate("INSERT INTO user_table (id,Login,Password) values"+ "(99999,'login','password')");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM user_table"); // получение данных из таблицы


        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) + " " + // вывод полученных данных
                    resultSet.getString(3)+ " " +
                    resultSet.getString(4));
        }

    }
}
