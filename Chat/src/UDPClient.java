
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pivanovs3
 */
public class UDPClient extends Thread {

    String userName;
    byte[] ipAddress = new byte[4];
    byte[] sendData, receiveData;
    BufferedReader inFromUser;
    DatagramSocket clientSocket;
    InetAddress IPAddress;
    int port;

    public UDPClient(int n1, int n2, int n3, int n4, int port, String userName) throws SocketException, UnknownHostException {
        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        this.userName = userName;
        this.ipAddress[0] = (byte) n1;
        this.ipAddress[1] = (byte) n2;
        this.ipAddress[2] = (byte) n3;
        this.ipAddress[3] = (byte) n4;

        IPAddress = InetAddress.getByAddress(ipAddress);
        this.port = port;
    }

    @Override
    public void run() {
        //sendData = new byte[1024];
        //receiveData = new byte[1024];
        while (true) {
            try {
                clientSocket = new DatagramSocket();
            } catch (SocketException ex) {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sentence;
            try {
                System.out.print("type in sth: ");
                sentence = userName + ": " + inFromUser.readLine();
                sendData = sentence.getBytes();
                DatagramPacket sendPacket
                        = new DatagramPacket(sendData, sendData.length, IPAddress, port);

                clientSocket.send(sendPacket);

                sendData = "".getBytes();

//            DatagramPacket receivePacket
//                    = new DatagramPacket(receiveData, receiveData.length);
//            clientSocket.receive(receivePacket);
//            String modifiedSentence
//                    = new String(receivePacket.getData());
//            System.out.println("FROM SERVER:" + modifiedSentence);
            } catch (IOException ex) {
                Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            clientSocket.close();
        }
    }

}
