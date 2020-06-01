package sample;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    //table view variables
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, Integer> ID;
    @FXML
    private TableColumn<User, String> NameColumn;
    @FXML
    private TableColumn<User, String> SurnameColumn;
    @FXML
    private TableColumn<User, Integer> Level;


    //text field variables
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField SurnameTextField;
    @FXML
    private ChoiceBox LevelChoiceBox;
    @FXML
    private TextField DeletIDTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML private TextField UpdateNameTextField;
    @FXML private TextField UpdateSurnameTextField;
    @FXML private PasswordField UpdatePasswordField;
    @FXML private ComboBox UpdateLevelChoiceBox;
    @FXML private TextField IdUpdateTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            NameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
            SurnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));
            ID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));
            Level.setCellValueFactory(new PropertyValueFactory<User, Integer>("Level"));
            tableView.setItems(getUser());
        } catch (Exception a) {
            System.out.println(a);
        }
    }
    public void refreshTableview () throws Exception{
    tableView.setItems(getUser());
    }


    public ObservableList<User> getUser() throws Exception {
        ObservableList<User> people = FXCollections.observableArrayList();
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT id,first_name,last_name,is_Admin FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            people.removeAll(people);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                int isAdmin = rs.getInt("is_Admin");


                // print the results
                people.add(new User(id, firstName, lastName, isAdmin));

            }

            st.close();
            conn.close();


        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return people;


    }
    // select user from table

    public void selectUser() throws Exception {
        User SelectedUser = tableView.getSelectionModel().getSelectedItem();
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query3 = "SELECT * FROM users WHERE id="+SelectedUser.getID();
        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query3);

        // iterate through the java resultset
        while (rs.next()) {
            int id = rs.getInt("id");

            IdUpdateTextField.setText(""+id);
            DeletIDTextField.setText(""+id);
            String firstName = rs.getString("first_name");
            UpdateNameTextField.setText(firstName);

            String lastName = rs.getString("last_name");
            UpdateSurnameTextField.setText(lastName);

            int isAdmin = rs.getInt("is_Admin");
            UpdateLevelChoiceBox.setValue(isAdmin);
            String password = rs.getString("password");
            UpdatePasswordField.setText(password);

        }
        st.close();
        conn.close();






    }

    //Update User
    public void updateUserButtonPushed() throws Exception{
        System.out.println("Çalışıom");
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

       int i = Integer.parseInt((String) UpdateLevelChoiceBox.getValue());


        int b = Integer.parseInt( IdUpdateTextField.getText());

        User newUser = new User(b, UpdateNameTextField.getText(), UpdateSurnameTextField.getText(), i, UpdatePasswordField.getText());

        DB.UpdateUser(newUser,conn);

        conn.close();
        refreshTableview();

    }

    // Add New user

    public void newUserButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        int i = Integer.parseInt((String) LevelChoiceBox.getValue());
        User newUser = new User(0, NameTextField.getText(), SurnameTextField.getText(), i, PasswordTextField.getText());
        DB.AddUser(newUser, conn);
        getUser();

        conn.close();
        refreshTableview();
    }


    //table config


    //Kullanıcı ayarları için sahne değiştirme
    public void changeScreenButtonPushed(ActionEvent event) throws Exception {
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("usersettings.fxml"));
        Scene UserSettingsScene = new Scene(UserSettingsParent, 1000, 500);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);
        window.show();
    }

    public void changeScreenToMainMenu(ActionEvent event) throws Exception {
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene UserSettingsScene = new Scene(UserSettingsParent);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);
        window.show();
    }

    //Delete User by ID
    public void DeletUserButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from users where id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int i = Integer.parseInt(DeletIDTextField.getText());
        preparedStmt.setInt(1, i);
        preparedStmt.execute();


        conn.close();
        refreshTableview();

    }

}



