package sample;

import java.io.IOException;
import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Calendar;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        System.out.println("Scene Başı");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Giriş Yap");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("Scene sonu");
    }



    public static void main(String[] args) {
        try {
            // create a mysql database connection
            //String myDriver = "com.mysql.jdbc.driver";

            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            //Class.forName(myDriver);
             Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            //Connection conn = DriverManager.getConnection("jdbc:mysql:localhost:3306","root","root");

            // create a sql date object so we can use it in our INSERT statement


            // the mysql insert statement
            //String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
            //      + " values (?, ?, ?, ?, ?)";
            //USER DB----------------------------------------
            String query = "create table if not exists users  (\n" +
                    "  id int unsigned auto_increment not null,\n" +
                    "  first_name varchar(32) not null,\n" +
                    "  last_name varchar(32) not null,\n" +

                    "  is_admin int,\n" +
                    "  password varchar(32) not null,\n"+
                    "  primary key (id)\n" +
                    ");";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);


            // execute the preparedstatement
            // Firma DB--------------------------
            preparedStmt.execute();

            String query2 = "create table if not exists firmalar  (\n" +
                    "  id int unsigned auto_increment not null,\n" +
                    "  firma_name varchar(32) not null,\n" +
                    "  firma_Il varchar(32) not null,\n" +

                    "  firma_Ilce varchar(32),\n" +
                    "  firma_OfferNo varchar(32) not null,\n" +
                    "  firma_JobOrderNo varchar(32) not null,\n" +
                    "  primary key (id)\n" +
                    ");";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.execute();
            //CihazDB---------------------------------------------------

            String query3 = "create table if not exists cihazlar  (\n" +
                    "  id int unsigned auto_increment not null,\n" +
                    "  cihaz_name varchar(32) not null,\n" +
                    "  kutup_mesafesi int,\n" +
                    "  mp_ortam varchar(32),\n" +
                    "  magnet_teknik varchar(32) not null,\n" +
                    "  uv varchar(32) not null,\n" +
                    "  light_mesafesi varchar(32) not null,\n" +
                    "  primary key (id)\n" +
                    ");";
            PreparedStatement preparedStmt3 = conn.prepareStatement(query3);
            preparedStmt3.execute();
            //user ekleme
/*
            String query2 = " insert into users (first_name, last_name, is_admin)"
                    + " values (?, ?, ?)";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setString(1, "Barney");
            preparedStmt2.setString(2, "Rubble");

            preparedStmt2.setInt(3, 0);
            preparedStmt2.execute();
            */
//userları gösterme
            /*
            String query3 = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                int isAdmin = rs.getInt("is_admin");


                // print the results
                System.out.format("%s, %s, %s, %s, \n", id, firstName, lastName, isAdmin);
            }
            st.close();*/

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }




        launch(args);
    }

}
