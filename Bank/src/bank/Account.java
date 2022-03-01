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
public class Account {
    private String name;
   
    private double balance;
    private int accountNo;
    private static int no = 1000;
    
    /** Konstruktorn sätter namn och initialt saldo på kontot*/
    public Account(String name, double initBalance){
        this.name = name;
        this.balance = initBalance;
        accountNo=++no;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
    public int getAccNo(){
        return accountNo;
    }
      /** Metoden ökar saldot på kontot*/
    public void deposit(double amount){
        balance += amount;
    }
    /** Metoden minskar saldot på kontot*/
    public void withdraw(double amount){
        balance -= amount;
    }
}
