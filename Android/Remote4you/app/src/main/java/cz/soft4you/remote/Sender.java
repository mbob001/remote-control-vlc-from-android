package cz.soft4you.remote;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {
    private final String HOST = "10.0.0.11";
    private final int PORT = 1866;

    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public Sender() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        try {
            address = InetAddress.getByName(HOST);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String msg) {
        buf = msg.getBytes();
        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, address, PORT);
        try {
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        socket.close();
    }
}
