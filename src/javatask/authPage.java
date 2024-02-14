package javatask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class authPage extends AnchorPane {

    Stage parentStage;
    protected final Text userID;
    protected final Text userPass;
    protected final TextField userNameValue;
    protected final PasswordField passwordValue;
    protected final Button loginBtn;
    static Connection con = null;

    public authPage(Stage stage) {

        parentStage = stage;
        userID = new Text();
        userPass = new Text();
        userNameValue = new TextField();
        passwordValue = new PasswordField();
        loginBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        userID.setFill(javafx.scene.paint.Color.valueOf("#da4242"));
        userID.setLayoutX(69.0);
        userID.setLayoutY(137.0);
        userID.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userID.setStrokeWidth(0.0);
        userID.setText("UserName");
        userID.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        userID.setFont(new Font("Arial Black", 23.0));

        userPass.setFill(javafx.scene.paint.Color.valueOf("#da4242"));
        userPass.setLayoutX(69.0);
        userPass.setLayoutY(225.0);
        userPass.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        userPass.setStrokeWidth(0.0);
        userPass.setText("Password");
        userPass.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        userPass.setWrappingWidth(137.8765869140625);
        userPass.setFont(new Font("Arial Black", 23.0));

        userNameValue.setLayoutX(236.0);
        userNameValue.setLayoutY(112.0);
        userNameValue.setPrefHeight(32.0);
        userNameValue.setPrefWidth(298.0);
        userNameValue.setFont(new Font(13.0));

        passwordValue.setLayoutX(236.0);
        passwordValue.setLayoutY(200.0);
        passwordValue.setPrefHeight(32.0);
        passwordValue.setPrefWidth(298.0);
        passwordValue.setFont(new Font(13.0));

        loginBtn.setLayoutX(236.0);
        loginBtn.setLayoutY(276.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(51.0);
        loginBtn.setPrefWidth(122.0);
        loginBtn.setText("Login");
        loginBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginBtn.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        loginBtn.setFont(new Font("Arial Black", 23.0));

        getChildren().add(userID);
        getChildren().add(userPass);
        getChildren().add(userNameValue);
        getChildren().add(passwordValue);
        getChildren().add(loginBtn);
        connect();

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                isUserExist();
            }
        });

        loginBtn.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    isUserExist();
                }
            }
        });

    }

    public static void connect() {
        try {
            DriverManager.registerDriver(new ClientDriver());
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(authPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void handleLogin() {

    }

    void isUserExist() {
        try {
            // boolean isExist = false ;
            String userNam = userNameValue.getText();
            System.out.println(userNam);

            PreparedStatement pst = con.prepareStatement("Select * from USERS where USERNAME = ?");
            pst.setString(1, userNam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                entitiesPage root = new entitiesPage(parentStage);
                Scene scene = new Scene(root);
                parentStage.setScene(scene);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setHeaderText(null);
                alert.setContentText("ops!! wrong user or password");
                alert.showAndWait();

            }
        } catch (SQLException ex) {
            Logger.getLogger(authPage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
