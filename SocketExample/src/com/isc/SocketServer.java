package com.isc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

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
            System.out.println("Client says:" + num);

            java.io.OutputStream out = null;
			try {
				out = socket.getOutputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String res = "Server Echo:" + msg;
            try {
				out.write(res.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } finally {
            try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }


}
