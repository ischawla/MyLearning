package com.isc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//This server serves only ONE client. If multiple client sends request to it , it will throw an exception for second client.
public class SocketServer {
    public static void main(String[] a) throws IOException {
        Socket socket = null;
        try {
            @SuppressWarnings("resource")
            ServerSocket serversocket = new ServerSocket(9999);
            System.out.println("Server started...");
            socket = serversocket.accept();

            java.io.InputStream input = socket.getInputStream();
            byte[] b = new byte[1024];
            int num = input.read(b);
            String msg = new String(b, 0, num);
            System.out.println("Client says:" + msg);

            java.io.OutputStream out = socket.getOutputStream();
            String res = "Server Echo:" + msg;
            try {
                out.write(res.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
