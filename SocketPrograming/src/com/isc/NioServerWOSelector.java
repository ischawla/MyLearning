package com.isc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioServerWOSelector {


    public static void main(String ar[]) throws IOException, InterruptedException {

        //Open a SocketServerChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // bind the port
        int port = 9999;
        ssc.bind(new InetSocketAddress(port));
        //set the channel to nonblocking
        ssc.configureBlocking(false);

        while(true){
            //if there is a connection , new SocketChannel will be created
            SocketChannel socketChannel = ssc.accept();
            if(socketChannel == null){
                System.out.println("No Connection .. Use resource for other task");
                Thread.sleep(2_000);
                continue;
            }
            //Read request
            ByteBuffer byteBuffer =  ByteBuffer.allocate(1024);

            //positive number: the bytes read
            // 0 : No data read
            // -1: reach the end
            int readResult =  socketChannel.read(byteBuffer);
            String reqMsg =  new String(byteBuffer.array(), 0 , readResult, StandardCharsets.UTF_8);
            System.out.println("Client says: " + reqMsg);


            //Write Response
            String resp = "Server Echo " + reqMsg;
            socketChannel.write(ByteBuffer.wrap(resp.getBytes(StandardCharsets.UTF_8)));

            //close channel
            socketChannel.close();
        }

    }
}
