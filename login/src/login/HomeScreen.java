/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.sun.org.apache.bcel.internal.generic.BALOAD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman
 */
public class HomeScreen {

   number number;
    Stage stage ;
    Scene scene; 
    Login login;
    Transaction transaction;
    Client client;
    
     public HomeScreen (Stage stage) {
        this.stage = stage;
    }

    
    
    public void prepareScene(){
        transaction = new Transaction();
        client = new Client();
        Label welcome = new Label ("The menu");
         Button logout =new Button("logout");
         Button withdraw =new Button("withdraw");
         Button deposit =new Button("deposit");
         Button next =new Button("next");
         Button previous =new Button("previous");
         Button balanceinquiry = new Button("BalanceInquiry");
         Label showlabel = new Label();
     
         
       GridPane grid = new GridPane();
       grid.add(logout,0, 6);
       grid.add(welcome, 0, 0);
       grid.add(deposit, 0, 1);
       grid.add(withdraw, 0, 2);
       grid.add(balanceinquiry, 0, 3);
       grid.add(next, 0, 4);
       grid.add(previous, 0, 5);
       grid.add(showlabel, 1, 3);
       
       deposit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                transaction.setType("Deposit");
             stage.setScene(number.getScene());
            }
        });
       
       withdraw.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
             transaction.setType("Withdraw");
             stage.setScene(number.getScene());
            }
        });
       
       logout.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
               stage.setScene(login.getScene());
            }
        });
       
       balanceinquiry.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               showlabel.setText("Balance = " + client.getBalance());
               client.writehistory("Type:BalanceInquiry,Value: " + client.getBalance());
            }
        });
       previous.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(client.backtest())
                    showlabel.setText(client.previoushistory());
                else{
                     Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setContentText("Error,!!");
                        alertunsucc.showAndWait();
                }
            
            }
        });
       next.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(client.nexttest())
                showlabel.setText(client.nexthistory());
                else
                {
                    Alert alertunsucc = new Alert(Alert.AlertType.INFORMATION);
                        alertunsucc.setTitle("Error");
                        alertunsucc.setContentText("Error,!!");
                        alertunsucc.showAndWait();
                }
            }
        });
       
       
       
       
       scene =new Scene(grid, 600, 400);
    } 

    public Scene getScene() {
        return scene;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setnumber(number number) {
        this.number = number;
    }
    
}
