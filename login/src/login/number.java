/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman
 */
public class number {
    Scene scene;
    HomeScreen homeScreen; 
    Stage stage;
    
    public number (Stage stage) {
    this .stage = stage;
}
    public void prepareScene(){
        homeScreen= new HomeScreen(stage);
        TextField textfield = new TextField();
        Button no0 =new Button("0");
        Button no1 =new Button("1");
        Button no2 =new Button("2");
        Button no3 =new Button("3");
        Button no4 =new Button("4");
        Button no5 =new Button("5");
        Button no6 =new Button("6");
        Button no7 =new Button("7");
        Button no8 =new Button("8");
        Button no9 =new Button("9");
        Button Next =new Button("Next");
        Button Back =new Button("Back");
        
        
        GridPane grid =new GridPane();        
       
        grid.add(no0,1 , 3);
        grid.add(no1, 0, 0);
        grid.add(no2, 1, 0);
        grid.add(no3, 2, 0);
        grid.add(no4, 0, 1);
        grid.add(no5, 1, 1);
        grid.add(no6, 2, 1);
        grid.add(no7, 0, 2);
        grid.add(no8, 1, 2);
        grid.add(no9, 2, 2);
        
        
        StackPane stackpane = new StackPane();
        stackpane.setAlignment(Pos.TOP_LEFT);
        stackpane.getChildren().add(grid);
        StackPane.setMargin(grid,new Insets (25,15,15,0));
        stackpane.getChildren().addAll(textfield,Next,Back);
        StackPane.setMargin(Next,new Insets (125,15,15,0));
        StackPane.setMargin(Back,new Insets (275,15,15,0));


        
        
        
        
        
        
        scene =new Scene(stackpane,600,300);
        
        
        
        
        
        
    no0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no0.getText();
    textfield.setText(textFieldNewString);
            }
        });
    no1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no1.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no2.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no3.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no4.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no5.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no6.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no7.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no8.getText();
    textfield.setText(textFieldNewString);
     }
        });
    no9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
    String textFieldNewString=textfield.getText()+no9.getText();
    textfield.setText(textFieldNewString);
            }
        });
    Back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
             stage.setScene(homeScreen.getScene());
            }
        });
    Next.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               
                if(homeScreen.transaction.getType()== "Deposit"){
                   int balance = Integer.parseInt(textfield.getText());                  
                    homeScreen.client.setbalance(balance);
                    homeScreen.transaction.setAmount(balance);
                 homeScreen.client.writehistory("Type: " +homeScreen.transaction.getType() + ",Value : " + homeScreen.transaction.getAmount());
                            
                        textfield.clear();
                    stage.setScene(homeScreen.getScene());
                    
                }
                else {
                    int balance =Integer.parseInt(textfield.getText());
                    if(homeScreen.client.validation(balance)){
                        homeScreen.client.setbalance(- balance);
                        homeScreen.transaction.setAmount(balance);
                        homeScreen.client.writehistory("Type: " +homeScreen.transaction.getType() + ",Value : " + homeScreen.transaction.getAmount()); 
                            
                        textfield.clear();
                        stage.setScene(homeScreen.getScene());
                    }
                    else {
                        Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setContentText("No Enough balance");
                        alertunsucc.showAndWait();
                       
                    }
                        
                     
                   
                    
                
                }
                    
                    
            }
        });
    
    }

  public Scene getScene(){
    return this.scene;
   }
    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }
   
}
