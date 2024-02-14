package javatask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class entitiesPage extends AnchorPane {

    Stage parentStage;

    protected final Button userBTN;
    protected final Button permissionBTN;
    protected final Button roleBTN;

    public entitiesPage(Stage stage) {
        parentStage = stage;

        userBTN = new Button();
        permissionBTN = new Button();
        roleBTN = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        userBTN.setLayoutX(187.0);
        userBTN.setLayoutY(80.0);
        userBTN.setMnemonicParsing(false);
        userBTN.setPrefHeight(60.0);
        userBTN.setPrefWidth(194.0);
        userBTN.setText("User");
        userBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        userBTN.setFont(new Font("Arial Black", 23.0));

        permissionBTN.setLayoutX(187.0);
        permissionBTN.setLayoutY(263.0);
        permissionBTN.setMnemonicParsing(false);
        permissionBTN.setPrefHeight(60.0);
        permissionBTN.setPrefWidth(193.0);
        permissionBTN.setText("Permission");
        permissionBTN.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        permissionBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        permissionBTN.setFont(new Font("Arial Black", 23.0));

        roleBTN.setLayoutX(187.0);
        roleBTN.setLayoutY(170.0);
        roleBTN.setMnemonicParsing(false);
        roleBTN.setPrefHeight(60.0);
        roleBTN.setPrefWidth(194.0);
        roleBTN.setText("Role");
        roleBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        roleBTN.setFont(new Font("Arial Black", 23.0));

        getChildren().add(userBTN);
        getChildren().add(permissionBTN);
        getChildren().add(roleBTN);

        userBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddUser root = new AddUser(parentStage);
                Scene scene = new Scene(root);
                parentStage.setScene(scene);

            }
        });
        roleBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddRole root = new AddRole(parentStage);
                Scene scene = new Scene(root);
                parentStage.setScene(scene);

            }
        });
        permissionBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddPermission root = new AddPermission(parentStage);
                Scene scene = new Scene(root);
                parentStage.setScene(scene);

            }
        });

    }

}
