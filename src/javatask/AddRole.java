package javatask;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddRole extends AnchorPane {

    Stage parentStage;
    protected final Button backBTN;
    protected final Text text;
    protected final Text text0;
    protected final TextArea idRoleValue;
    protected final TextArea nameRoleValue;
    protected final Button addRoleBTN;
    private Role newRole = new Role();

    public AddRole(Stage stage) {
        parentStage = stage;
        backBTN = new Button();
        text = new Text();
        text0 = new Text();
        idRoleValue = new TextArea();
        nameRoleValue = new TextArea();
        addRoleBTN = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backBTN.setLayoutX(24.0);
        backBTN.setLayoutY(24.0);
        backBTN.setMnemonicParsing(false);
        backBTN.setText("Back");
        backBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        backBTN.setFont(new Font("Arial Black", 16.0));

        text.setLayoutX(67.0);
        text.setLayoutY(152.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Role ID");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(46.0074462890625);
        text.setFont(new Font(14.0));

        text0.setLayoutX(52.0);
        text0.setLayoutY(224.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Role Name");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(77.20745849609375);
        text0.setFont(new Font(14.0));

        idRoleValue.setLayoutX(168.0);
        idRoleValue.setLayoutY(128.0);
        idRoleValue.setPrefHeight(19.0);
        idRoleValue.setPrefWidth(335.0);

        nameRoleValue.setLayoutX(168.0);
        nameRoleValue.setLayoutY(200.0);
        nameRoleValue.setPrefHeight(19.0);
        nameRoleValue.setPrefWidth(335.0);

        addRoleBTN.setLayoutX(222.0);
        addRoleBTN.setLayoutY(279.0);
        addRoleBTN.setMnemonicParsing(false);
        addRoleBTN.setPrefHeight(50.0);
        addRoleBTN.setPrefWidth(114.0);
        addRoleBTN.setText("Add Role");
        addRoleBTN.setFont(new Font("Arial Black", 18.0));

        getChildren().add(backBTN);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(idRoleValue);
        getChildren().add(nameRoleValue);
        getChildren().add(addRoleBTN);

        addRoleBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((!idRoleValue.getText().isEmpty()) && (Integer.parseInt(idRoleValue.getText()) != 0)) {
                    try {
                        newRole.setID(Integer.parseInt(idRoleValue.getText()));
                        newRole.setName(nameRoleValue.getText());
                        int result = DataAccessLayer.addRole(newRole);
                        if (result == 1) {
                            Dialog d = new Dialog();
                            d.setTitle("Done");
                            d.setContentText("Added successfully.");
                            ButtonType closeButton = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                            d.getDialogPane().getButtonTypes().add(closeButton);
                            d.showAndWait();
                            idRoleValue.clear();
                            nameRoleValue.clear();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AddRole.class.getName()).log(Level.SEVERE, null, ex);
                         Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Duplication in id ");
                        a.show();
                    }

                } else if (Integer.parseInt(idRoleValue.getText()) == 0) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id can't be zero");
                    a.show();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id is must");
                    a.show();
                }

            }
        });

        backBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                entitiesPage root = new entitiesPage(parentStage);
                Scene scene = new Scene(root);
                parentStage.setScene(scene);

            }
        });

    }
}
