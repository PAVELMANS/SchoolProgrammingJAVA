
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pivanovs3
 */
public class UDPServer extends Thread {
//    String userName;
//    BufferedReader inFromUser;
    int port;
    UDPServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket socket = new DatagramSocket(port);

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String text = new String(packet.getData());
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
                System.out.println("recieved from " + text);
               

                //DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, address, port);
                //socket.send(sendPacket);
            }
        } catch (IOException e) {
        }
    }

    /*public static void main(String args[]) throws SocketException, IOException {
        BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Type your username: ");
        String username = inFromUser.readLine();
        (new UDPServer()).start();

        while (true) {
            DatagramSocket clientSocket = new DatagramSocket();

        InetAddress IPAddress = InetAddress.getByName("DX02021862");
            byte[] sendData = new byte[1024];
            //byte[] receiveData = new byte[1024];

            String sentence = username + ": " + inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, 41235);

            clientSocket.send(sendPacket);
            sendData = "".getBytes();
            clientSocket.close();
        }
//
//        DatagramPacket receivePacket
//                = new DatagramPacket(receiveData, receiveData.length);

//        clientSocket.receive(receivePacket);
//
//        String modifiedSentence
//                = new String(receivePacket.getData());
//
//        System.out.println("FROM SERVER:" + modifiedSentence);
        
    }
*/

}
