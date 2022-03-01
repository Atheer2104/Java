package socketclient;

import java.net.*;
import java.io.*;
import java.util.*;

public class SocketClient {

    //initalize socket and input, output streams
    
    private Socket socket = null;
    private DataInputStream input = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    
    public SocketClient(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the ip adress");
        
        String ip = scan.nextLine();
       
        socketToServer(ip, 1663);
        
    }
    // a constractor to put ip adress and port
    public void socketToServer(String address, int port) {
        // trying to establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            
            // gets input from terminal 
            input = new DataInputStream(System.in);
            
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
            
        }catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        }catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        
        // read message from input
        String line = "";
        
        //keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            }catch(IOException i) 
            { 
                System.out.println(i); 
            } 
            
            try {
                    line = in.readUTF();
                    System.out.println(line);
                }catch(IOException i) 
                { 
                        System.out.println(i); 
                } 
            
        }
        
        //close connection
        try {
            input.close();;
            out.close();
            in.close();
            socket.close();
        } catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        
    }
    
    public static void main(String[] args) {
        SocketClient sc1 = new SocketClient();
       //SocketClient sc2 = new SocketClient();
        
        
        
    }
    
}
