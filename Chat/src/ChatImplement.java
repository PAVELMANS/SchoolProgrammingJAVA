
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class ChatImplement {
    
    public static void main(String args[]) throws SocketException, UnknownHostException {
        int port = 41235;
        UDPClient client = new UDPClient(10, 1, 14, 58, port, "Pavels");
        UDPServer server = new UDPServer(port);
        client.start(); server.start();
        
    }
    
}
