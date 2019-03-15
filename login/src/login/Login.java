/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class Login  {
    Stage stage;
HomeScreen homeScreen;  
    Scene scene;
    
   public Login(Stage stage){
   this.stage=stage;    
   }
   
    public void prepareScene()  {
        
        Client client = new Client();
       

        
        Label PasswordLabel = new Label(" Password: ");
        PasswordField passwordField = new PasswordField();
        Button submit =new Button("Submit");
        
        
        
        
        
        GridPane grid = new GridPane();
  
        grid.add(PasswordLabel, 0, 0);     
        grid.add(passwordField, 0, 1);
        grid.add(submit, 0, 2);
        
        
     submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String password =passwordField.getText();
                
            boolean valid=client.validatepassword(password);
            if(valid){
              passwordField.clear();
                stage.setScene(homeScreen.getScene());
                        }
            else{
                Alert loginalert = new Alert(Alert.AlertType.INFORMATION);
                loginalert.setTitle("Error");
                loginalert.showAndWait();
                  
            }
            }
        });
        
        
         scene = new Scene (grid ,600,400);
    }
public Scene getScene(){
    return this.scene;
}

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    

}
