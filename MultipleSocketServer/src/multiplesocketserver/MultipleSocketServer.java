package multiplesocketserver;

import java.io.*;
import java.net.*;

public class MultipleSocketServer {

    public static void main(String[] args) throws IOException {
        
        //server listen to port 1663
        ServerSocket server = new ServerSocket(1663);
        
        while (true) {
        
            Socket socket = null;
            
            try {
            
                // accept incoming clients
                socket = server.accept();
                
                System.out.println("A new client is connected : " + socket);
                
                //obtain input and out streams
                DataInputStream input = new DataInputStream(System.in);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                
                System.out.println("Assign new thread for this client");
                
                Thread thread = new ClientHandler(socket, input, out, in);
                
                thread.start();
            }
            catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
            
        }
        
    }
    
}

//clientHandler class
class ClientHandler extends Thread {
    
    final DataInputStream input; 
    final DataInputStream in;
    final DataOutputStream out; 
    final Socket s;
    
    //constructor
    
    public ClientHandler(Socket s,DataInputStream input, DataOutputStream out, DataInputStream in) {
        
        this.s = s;
        this.input = input;
        this.out = out;
        this.in = in;
    }
    
    public void run() {
        
        String received;
        String tosend;
        
        while (true) {
            try {
                
                // get message from user
                received = in.readUTF();
                System.out.println(received);
                
                // when the user wants to exit
                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
               
                //send back message 
                try {
                    tosend = input.readLine();
                    out.writeUTF(tosend);
                }catch(IOException i) 
                { 
                    System.out.println(i); 
                }
                        
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        }
        try {
            this.input.close();
            this.out.close();
            this.in.close();
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
        
    }
}
