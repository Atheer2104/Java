package multiplesocketclient;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultipleSocketClient {

    public static void main(String[] args) throws IOException  {
        
        try {
            //getting localhost ip
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Enter ip Address");
            
            String ip = scan.nextLine();
            
            Socket s = new Socket(ip, 1663);
            
            //obtain input and output stream
            DataInputStream input = new DataInputStream(System.in);
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            DataInputStream in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            
            //perform exchange of information between client and client handler
            while (true) { 
                String tosend = "";
                try {
                    tosend = input.readLine();
                    out.writeUTF(tosend);
                }catch(IOException i) 
                { 
                    System.out.println(i); 
                }
                
                // if client sends Exit then close connection and break from while loop
                if (tosend.equals("Exit")) {
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                
                String received = in.readUTF();
                System.out.println(received);
            }
            
            input.close();
            out.close();
            in.close();
            
            
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        
    }
    
}
