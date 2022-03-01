package socketserver;

import java.net.*;
import java.io.*;

public class SocketServer {

    private Socket socket = null;
    private ServerSocket server = null; 
    private DataInputStream in = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    
    
    //construct with port
    public SocketServer(int port) {
        
        //start server and wait for a connection
        try {
        
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client");

            socket = server.accept();
            System.out.println("Client accepted");

            //take input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            input = new DataInputStream(System.in);
            
            // sends output to the clientsocket
            out = new DataOutputStream(socket.getOutputStream());

            String line = "";

            //read message from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line);
                }catch(IOException i) 
                { 
                        System.out.println(i); 
                } 
                
                try {
                    line = input.readLine();
                    out.writeUTF(line);
                }catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            }
            System.out.println("Closing connection");

            //close connection
            socket.close();
            in.close();
            input.close();
            out.close();
            }
        
                catch(IOException i) 
                { 
                    System.out.println(i); 
                }
    }
    
    public static void main(String[] args) {
        
        SocketServer server = new SocketServer(1663);
        
    }
    
}
