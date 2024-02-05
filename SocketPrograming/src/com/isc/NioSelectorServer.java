package com.isc;
//10.Java NIO Selector
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorServer {


    public static void main(String[] ar) throws IOException {
        //Open a ServerSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        // bind the port
        int port = 9999;
        ssc.bind(new InetSocketAddress(port));

        //set the channel to nonblocking
        ssc.configureBlocking(false);

        //create the selector
        Selector selector = Selector.open();

        //Register the ServerSocketChannel to the selector
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("NioSelectorServer is ready");

        while (true) {
            //check the OP_ACEPT event
            // if there is a collection, a new SocketChannel will be created
            int select = selector.select(2_000); //Every 2 sec, Selects a set of keys whose corresponding channels are ready for I/O operations.
            if (select == 0) {
                continue;
            }

            //get the event sets
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) { // It is for NEW connection
                    SocketChannel socketChannel = ssc.accept();
                    System.out.println("Client connected " + socketChannel);
                    socketChannel.configureBlocking(false);
                    //register the OP_READ event for the SocketChannel
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }


                //handle the read event
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();

                    //Read request
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    //positive number: the bytese read
                    //0 : No data is read
                    // -1: reach the end
                    int res = socketChannel.read(byteBuffer);


                    if (res > 0) {
                        //Convert bytebuffer data to String.
                        String reqMsg = new String(byteBuffer.array(), 0, res, StandardCharsets.UTF_8);
                        System.out.println("Request msgL" + reqMsg);

                        //write response
                        String serverRes = "Server Echo " + reqMsg;
                        socketChannel.write(byteBuffer.wrap(serverRes.getBytes(StandardCharsets.UTF_8))); //Convert the String Msg to Bytes and then sending to

                        //close channel
                        socketChannel.close();
                    }
                }
                //reserve the key from the sset
                iterator.remove();
            }//end of inner while
        } // end of while
    }
}