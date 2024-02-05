package com.isc;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String ar[]) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket= new ServerSocket(9999);
        System.out.println("BIO Sderver started");
        while(true){
            //wait and accept for the connection
            Socket socket = serverSocket.accept();
            System.out.println("Received a connection..");

            //4. create a thread to handle the request
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handle(socket);
                }
            });

        }

    }



    public static void handle(Socket socket){
        try{
            System.out.println("Thread id " + Thread.currentThread().getId() + " Name " + Thread.currentThread().getName());
            //read the request msg
            InputStream input = socket.getInputStream();
            byte b[] = new byte[1024];
            int num =  input.read(b); // convert the msg into bytes
            String msg = new String(b,0,num);
            System.out.println("Client msg: " +  msg);

            //send response
            OutputStream outputStream = socket.getOutputStream();
            String responseMsg = "Msg send by Server: " + msg;
            outputStream.write(responseMsg.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try{
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
