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
import javax.swing.*;
import java.awt.*;

public class Bank {
    private JFrame frame = new JFrame("CrimeBank");
    private JPanel background = new JPanel();
    private JLabel l_accNo, l_holder, l_dep, l_with, l_bal;
    private JTextField tf_accNo, tf_holder, tf_dep, tf_with, tf_bal;
    private JButton b_create, b_find, b_dep, b_with;
    
    public Bank(){
        l_accNo = new JLabel("AccountNo");
        l_holder = new JLabel("Holder");
        l_dep = new JLabel("Deposit");
        l_with = new JLabel("Withdraw");
        l_bal= new JLabel("Balance");
        tf_accNo = new JTextField(12);
        tf_holder = new JTextField(12);
        tf_dep = new JTextField(12);
        tf_with = new JTextField(12);
        tf_bal = new JTextField(12);
        b_create = new JButton("Create");
        b_find = new JButton("Find");
        b_dep = new JButton("Deposit"); 
        b_with = new JButton("Withdraw");
        background.setLayout(new GridLayout(7,2));
        background.add(l_accNo);
        background.add(tf_accNo);
        background.add(l_holder);
        background.add(tf_holder);
        background.add(l_dep);
        background.add(tf_dep);
        background.add(l_with);
        background.add(tf_with);
        background.add(l_bal);
        background.add(tf_bal);
        background.add(b_find);
        background.add(b_create);
        background.add(b_dep);
        background.add(b_with);
        frame.setContentPane(background);
        frame.pack();
        frame.setVisible(true);
    }
 }

