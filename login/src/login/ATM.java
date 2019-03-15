/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author abdelrahman
 */
public class ATM extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
         primaryStage.setTitle("login");
         
         Login login = new Login (primaryStage);
         HomeScreen homeScreen =new HomeScreen(primaryStage);
         number number=new number(primaryStage);
         
         login.prepareScene(); 
         homeScreen.prepareScene();
         number.prepareScene();
         
        login.setHomeScreen(homeScreen);
        homeScreen.setLogin(login);
        
       homeScreen.setnumber(number);     
        number.setHomeScreen(homeScreen);
        
        
        primaryStage.setScene(login.getScene());
        primaryStage.show();

    }
    
}
