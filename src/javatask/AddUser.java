package javatask;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddUser extends AnchorPane {

    Stage parentStage;
    protected final Button backBTN;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final Text text4;
    protected final TextArea idTXTValue;
    protected final TextArea nameTXTValue;
    protected final TextArea emailTXTValue;
    protected final TextArea phoneTXTValue;
    protected final TextArea roleTXTValue;
    protected final TextArea permissionTXTValue;
    protected final Button addUserBTN;
    protected final Button editBTN;
    protected final Button deleteBTN;
    protected final Button previousBTN;
    protected final Button nextBTN;
    private Users currentUser = new Users();

    public AddUser(Stage stage) {
        parentStage = stage;
        backBTN = new Button();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        text4 = new Text();
        idTXTValue = new TextArea();
        nameTXTValue = new TextArea();
        emailTXTValue = new TextArea();
        phoneTXTValue = new TextArea();
        roleTXTValue = new TextArea();
        permissionTXTValue = new TextArea();

        addUserBTN = new Button();
        editBTN = new Button();
        deleteBTN = new Button();
        previousBTN = new Button();
        nextBTN = new Button();

        setId("AnchorPane");
        setPrefHeight(443.0);
        setPrefWidth(600.0);

        backBTN.setLayoutX(14.0);
        backBTN.setLayoutY(14.0);
        backBTN.setMnemonicParsing(false);
        backBTN.setText("Back");
        backBTN.setTextFill(javafx.scene.paint.Color.valueOf("#da4242"));
        backBTN.setFont(new Font("Arial Black", 16.0));

        text.setLayoutX(58.0);
        text.setLayoutY(79.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ID");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(46.0074462890625);
        text.setFont(new Font(14.0));

        text0.setLayoutX(58.0);
        text0.setLayoutY(135.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Name");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(46.0074462890625);
        text0.setFont(new Font(14.0));

        text1.setLayoutX(58.0);
        text1.setLayoutY(187.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Email");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(46.0074462890625);
        text1.setFont(new Font(14.0));

        text2.setLayoutX(32.0);
        text2.setLayoutY(246.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("phone Number");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text2.setWrappingWidth(112.79997558593755);
        text2.setFont(new Font(14.0));

        text3.setLayoutX(35.0);
        text3.setLayoutY(314.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Role");
        text3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text3.setWrappingWidth(46.0074462890625);
        text3.setFont(new Font(14.0));

        text4.setLayoutX(315.0);
        text4.setLayoutY(314.0);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("permission");
        text4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text4.setWrappingWidth(76.40740966796875);
        text4.setFont(new Font(14.0));

        idTXTValue.setLayoutX(159.0);
        idTXTValue.setLayoutY(54.0);
        idTXTValue.setPrefHeight(19.0);
        idTXTValue.setPrefWidth(335.0);

        nameTXTValue.setLayoutX(159.0);
        nameTXTValue.setLayoutY(110.0);
        nameTXTValue.setPrefHeight(19.0);
        nameTXTValue.setPrefWidth(335.0);

        emailTXTValue.setLayoutX(159.0);
        emailTXTValue.setLayoutY(163.0);
        emailTXTValue.setPrefHeight(19.0);
        emailTXTValue.setPrefWidth(335.0);

        phoneTXTValue.setLayoutX(159.0);
        phoneTXTValue.setLayoutY(222.0);
        phoneTXTValue.setPrefHeight(19.0);
        phoneTXTValue.setPrefWidth(335.0);

        roleTXTValue.setLayoutX(80.0);
        roleTXTValue.setLayoutY(289.0);
        roleTXTValue.setPrefHeight(38.0);
        roleTXTValue.setPrefWidth(200.0);

        permissionTXTValue.setLayoutX(395.0);
        permissionTXTValue.setLayoutY(290.0);
        permissionTXTValue.setPrefHeight(38.0);
        permissionTXTValue.setPrefWidth(200.0);

        addUserBTN.setLayoutX(55.0);
        addUserBTN.setLayoutY(382.0);
        addUserBTN.setMnemonicParsing(false);
        addUserBTN.setText("Add User");

        editBTN.setLayoutX(165.0);
        editBTN.setLayoutY(382.0);
        editBTN.setMnemonicParsing(false);
        editBTN.setText("Edit");

        deleteBTN.setLayoutX(257.0);
        deleteBTN.setLayoutY(382.0);
        deleteBTN.setMnemonicParsing(false);
        deleteBTN.setText("delete");

        previousBTN.setLayoutX(353.0);
        previousBTN.setLayoutY(382.0);
        previousBTN.setMnemonicParsing(false);
        previousBTN.setText("previous");

        nextBTN.setLayoutX(463.0);
        nextBTN.setLayoutY(382.0);
        nextBTN.setMnemonicParsing(false);
        nextBTN.setText("next");

        getChildren().add(backBTN);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(text3);
        getChildren().add(text4);
        getChildren().add(idTXTValue);
        getChildren().add(nameTXTValue);
        getChildren().add(emailTXTValue);
        getChildren().add(phoneTXTValue);
        getChildren().add(roleTXTValue);
        getChildren().add(permissionTXTValue);

        getChildren().add(addUserBTN);
        getChildren().add(editBTN);
        getChildren().add(deleteBTN);
        getChildren().add(previousBTN);
        getChildren().add(nextBTN);

        try {

            currentUser = DataAccessLayer.selectAll();
            idTXTValue.setText(String.valueOf(currentUser.getID()));
            nameTXTValue.setText(String.valueOf(currentUser.getName()));
            emailTXTValue.setText(String.valueOf(currentUser.getEmail()));
            phoneTXTValue.setText(String.valueOf(currentUser.getPhone()));
            roleTXTValue.setText(String.valueOf(currentUser.getRoles()));
            permissionTXTValue.setText(String.valueOf(currentUser.getPermission()));
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
             addUserBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((!idTXTValue.getText().isEmpty()) && (Integer.parseInt(idTXTValue.getText()) != 0)) {
                   currentUser=new Users();
                    currentUser.setID(Integer.parseInt(idTXTValue.getText()));
                    currentUser.setName(nameTXTValue.getText());
                  
                    currentUser.setEmail(emailTXTValue.getText());
                    currentUser.setPhone(phoneTXTValue.getText());
                    try {
                        int result = DataAccessLayer.addUser(currentUser);
                        if (result == 1) {
                            Dialog d = new Dialog();
                            d.setTitle("Done");
                            d.setContentText("Added successfully.");
                            ButtonType closeButton = new ButtonType("OK", ButtonBar.ButtonData.CANCEL_CLOSE);
                            d.getDialogPane().getButtonTypes().add(closeButton);
                            d.showAndWait();
                        }
                    } catch (SQLException ex) {
                       // Logger.getLogger(FXMLContactList.class.getName()).log(Level.SEVERE, null, ex);
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Duplication in id ");
                        a.show();
                    }
                } else if (Integer.parseInt(idTXTValue.getText()) == 0) {
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
               nextBTN.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                                try {
                    currentUser= DataAccessLayer.next(currentUser);
                     if (currentUser.getID() != 0){
                    idTXTValue.setText(String.valueOf(currentUser.getID()));
                        phoneTXTValue.setText(String.valueOf(currentUser.getPhone()));
                        nameTXTValue.setText(currentUser.getName());
                        emailTXTValue.setText(currentUser.getEmail());
                        roleTXTValue.setText(currentUser.getRoles());
                        permissionTXTValue.setText(currentUser.getPermission());
                        
                }
                    
                } catch (SQLException ex) {
                    //Logger.getLogger(FXMLContactList.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            }
        });  
         
              previousBTN.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    currentUser= DataAccessLayer.previous(currentUser);
                    if(currentUser !=null)
                    if (currentUser.getID() != 0){
                    idTXTValue.setText(String.valueOf(currentUser.getID()));
                        phoneTXTValue.setText(String.valueOf(currentUser.getPhone()));
                        nameTXTValue.setText(currentUser.getName());
                        
                        emailTXTValue.setText(currentUser.getEmail());
                }
                    
                } catch (SQLException ex) {
                    //Logger.getLogger(FXMLContactList.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }); 
             
             
          /*  editBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              if ((!idTXTValue.getText().isEmpty())) {
                    currentUser.setID(Integer.parseInt(idTXTValue.getText()));
                    currentUser.setName(nameTXTValue.getText());
                 
                    currentUser.setEmail(emailTXTValue.getText());
                    currentUser.setPhone(phoneTXTValue.getText());
                    try {
                        int result = DataAccessLayer.editUser(currentUser);
                        if (result == 1) {
                            Dialog d = new Dialog();
                            d.setTitle("Done");
                            d.setContentText("updated successfully.");
                            ButtonType closeButton = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
                            d.getDialogPane().getButtonTypes().add(closeButton);
                            d.showAndWait();
                        }
                    } catch (SQLException ex) {
                        //Logger.getLogger(FXMLContactList.class.getName()).log(Level.SEVERE, null, ex);
                        Alert a = new Alert(AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Duplication in id ");
                        a.show();
                    }
                } else if (Integer.parseInt(idTXTValue.getText()) == 0) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id can't be zero");
                    a.show();
                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id is must");
                    a.show();
                }
                

            }
        });*/
        
           deleteBTN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if ((!idTXTValue.getText().isEmpty())) {
                   
                    try {
                        System.out.println(currentUser.getID());
                        int result = DataAccessLayer.delete(currentUser.getID());
                        
                        if (result == 1) {
                            Dialog d = new Dialog();
                            d.setTitle("Done");
                            d.setContentText("deleted successfully.");
                            ButtonType closeButton = new ButtonType("OK", ButtonData.CANCEL_CLOSE);
                            d.getDialogPane().getButtonTypes().add(closeButton);
                            d.showAndWait();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
                        Alert a = new Alert(AlertType.ERROR);
                        a.setTitle("Error");
                        a.setContentText("Duplication in deleted id ");
                        a.show();
                    }
                } else if (Integer.parseInt(idTXTValue.getText()) == 0) {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id doesn`t exist");
                    a.show();
                } else {
                    Alert a = new Alert(AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("Id is must");
                    a.show();
                }
                  idTXTValue.clear();
                  nameTXTValue.clear();
                
                  emailTXTValue.clear();
                  phoneTXTValue.clear();
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
