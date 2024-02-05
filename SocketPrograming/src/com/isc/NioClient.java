package com.isc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NioClient {
    public static void main(String ar[]) throws IOException {
        // create the channel
        SocketChannel socketChannel =  SocketChannel.open();

        //connect to the server
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

        //write the data
        System.out.println("Please input the msg..");
        Scanner scanner =  new Scanner(System.in);
        String msg =  scanner.nextLine();
        socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));

        // read response
        ByteBuffer readBuffer =  ByteBuffer.allocate(1024);
        int readResult =  socketChannel.read(readBuffer);
        System.out.println("Response "+ new String(readBuffer.array(),0,readResult,StandardCharsets.UTF_8));


        //close the socket
        socketChannel.close();
    }
}
