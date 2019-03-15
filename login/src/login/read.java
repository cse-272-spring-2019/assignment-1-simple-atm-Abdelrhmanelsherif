/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.HashMap;

/**
 *
 * @author abdelrahman
 */
public class read {
    
  HashMap usersDictionary;
    
    public read(){
    usersDictionary= new HashMap();
    usersDictionary.put("Ahmed", "1234");
    usersDictionary.put("Abdo", "000");
    usersDictionary.put("nadiah", "044");
    
    }
    


public boolean validate(String username ,String password){
boolean validationResult=false; 
    String fetchedPassword =  (String) usersDictionary.get(username);
if(fetchedPassword!=null){
    validationResult =fetchedPassword.equals(password);
    
}

return validationResult;
}

}
