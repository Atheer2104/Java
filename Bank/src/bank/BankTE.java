/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author elev
 */
import java.util.HashMap;
public class BankTE {
    private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();
    
    public void addAccount(Account a){
         accounts.put(a.getAccNo(), a);
    }
    public Account findAccount(int accNo){
        return accounts.get(accNo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankTE banken = new BankTE();
        
        Account a1 = new Account("Ture", 50000);
        banken.addAccount(a1);
        Account a2 = new Account("Eva", 150000);
        banken.addAccount(a2);
         
        Account find = banken.findAccount(1002);
        System.out.println(find.getName());
        System.out.println(find.getBalance());
        new Bank();
        
       
        
    }
    
}

