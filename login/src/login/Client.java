/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author abdelrahman
 */
public class Client {
    private String [] history = new String[5];
    private String password = "4234";
    private int balance;
    private int arrow=-1;
    private  int next=0;
    public Client() {
        balance = 0;
    }
     public void writehistory(String string){
        if(arrow +1 >4){
            for(int i=0;i<4;i++){
                history[i]=history[i+1];
            }
            history[4]=string;
        }
        else{
          arrow++;
          history[arrow]=string;
          next++;
        }
     }
     public String previoushistory(){
       return history[--arrow];
     } 
      public String nexthistory(){
        
        return history[++ arrow];

   }
      public boolean nexttest(){
        if (arrow +1 >=next)
            return false;
        else
            return true;      
    }
    public boolean backtest(){
        if(this.arrow -1 <0)
            return false;
        else
            return true;
    }
    public boolean validatepassword(String password){
        if(password.equals(this.password))
            return true;
        else 
            return false;
    }
    
    public void setbalance(int balance){
        
        this.balance += balance;
    }

    public int getBalance() {
        return balance;
    }
    public boolean validation(int amount){
        if(amount > balance)
            return false;
        else
            return true;
    }
}

