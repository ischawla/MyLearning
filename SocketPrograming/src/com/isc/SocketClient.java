package com.isc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String ar []) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 9999)) {
            OutputStream outputStream = socket.getOutputStream();
            // sending msg to the server
            Scanner scanner = new Scanner(System.in);
            System.out.println("Client says - ");
            String msg = scanner.next();
            outputStream.write(msg.getBytes());


            // receiving response from Server
            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            // int []i =  new int[10];
            int num = inputStream.read(b);
            String res = new String(b, 0, num);
            System.out.println("Server Responded - " + res);
        }





    }
}
