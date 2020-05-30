package sample;

import java.sql.*;

public class DB {
    public static void AddUser(User a, Connection conn) {
        try {
            String query2 = " insert into users (first_name, last_name, is_admin)"
                    + " values (?, ?, ?)";

            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setString(1, a.getName());
            preparedStmt2.setString(2, a.getSurname());

            preparedStmt2.setInt(3, a.getLevel());
            preparedStmt2.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    /*public static void ShowUsers() {
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
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

                int isAdmin = rs.getInt("is_Admin");


                // print the results
                System.out.format("%s, %s, %s, %s, \n", id, firstName, lastName, isAdmin);

            }

            st.close();
            conn.close();



        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }



    }
    */
}
