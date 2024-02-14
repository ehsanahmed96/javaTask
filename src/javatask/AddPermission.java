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

public class AddPermission extends AnchorPane {

    Stage parentStage;
    protected final Button backBTN;
    protected final Text text;
    protected final Text text0;
    protected final TextArea idPermissionValue;
    protected final TextArea namePermissionValue;
    protected final Button addPermissionBTN;
    private Permission newpermission = new Permission();

    public AddPermission(Stage stage) {
        parentStage = stage;
        backBTN = new Button();
        text = new Text();
        text0 = new Text();
        idPermissionValue = new TextArea();
        namePermissionValue = new TextArea();
        addPermissionBTN = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backBTN.setLayoutX(34.0);
        backBTN.setLayoutY(34.0);
        backBTN.setMnemonicParsing(false);
        backBTN.setText("Back");
        backBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        backBTN.setFont(new Font("Arial Black", 16.0));

        text.setLayoutX(54.0);
        text.setLayoutY(162.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Permission ID");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(94.0074462890625);
        text.setFont(new Font(14.0));

        text0.setLayoutX(44.0);
        text0.setLayoutY(234.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Permission Name");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(114.40000000000009);
        text0.setFont(new Font(14.0));

        idPermissionValue.setLayoutX(178.0);
        idPermissionValue.setLayoutY(138.0);
        idPermissionValue.setPrefHeight(19.0);
        idPermissionValue.setPrefWidth(335.0);

        namePermissionValue.setLayoutX(178.0);
        namePermissionValue.setLayoutY(210.0);
        namePermissionValue.setPrefHeight(19.0);
        namePermissionValue.setPrefWidth(335.0);

        addPermissionBTN.setLayoutX(204.0);
        addPermissionBTN.setLayoutY(291.0);
        addPermissionBTN.setMnemonicParsing(false);
        addPermissionBTN.setPrefHeight(50.0);
        addPermissionBTN.setPrefWidth(192.0);
        addPermissionBTN.setText("Add Permission");
        addPermissionBTN.setFont(new Font("Arial Black", 18.0));

        getChildren().add(backBTN);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(idPermissionValue);
        getChildren().add(namePermissionValue);
        getChildren().add(addPermissionBTN);

        
          addPermissionBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((!idPermissionValue.getText().isEmpty()) && (Integer.parseInt(idPermissionValue.getText()) != 0)) {
                    try {
                        newpermission.setID(Integer.parseInt(idPermissionValue.getText()));
                        newpermission.setName(namePermissionValue.getText());
                        newpermission.setDescription("follow up ");
                        int result = DataAccessLayer.addPermission(newpermission);
                        if (result == 1) {
                            Dialog d = new Dialog();
                            d.setTitle("Done");
                            d.setContentText("Added successfully.");
                            ButtonType closeButton = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                            d.getDialogPane().getButtonTypes().add(closeButton);
                            d.showAndWait();
                            idPermissionValue.clear();
                            namePermissionValue.clear();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AddRole.class.getName()).log(Level.SEVERE, null, ex);
                         Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Duplication in id ");
                        a.show();
                    }

                } else if (Integer.parseInt(idPermissionValue.getText()) == 0) {
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
