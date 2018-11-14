package com.zxa.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: Server
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/19 19:38
 */
public class Server {
	private Selector selector;
	private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	String str;

	public void start() throws IOException{

		ServerSocketChannel ssc = ServerSocketChannel.open();//打开服务器端套接字通道

		ssc.configureBlocking(false);

		ssc.bind(new InetSocketAddress("localhost",18001));
		selector = Selector.open();
		Set<SelectionKey> keys = selector.selectedKeys();


		Iterator<SelectionKey> keyIterator = keys.iterator();
		while(keyIterator.hasNext()){
			SelectionKey key = keyIterator.next();
			if( !key.isValid() ){
				continue;
			}
			if(key.isAcceptable()){
				accept(key);
			} else if (key.isReadable()){
				read(key);
			}else if (key.isWritable()){
				write(key);
			}
			keyIterator.remove();
		}

	}
	private void write(SelectionKey key) throws IOException, ClosedChannelException {
		SocketChannel channel = (SocketChannel) key.channel();
		System.out.println("write:"+str);

		sendBuffer.clear();
		sendBuffer.put(str.getBytes());
		sendBuffer.flip();
		channel.write(sendBuffer);
		channel.register(selector, SelectionKey.OP_READ);
	}

	private void read(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();

		// Clear out our read buffer so it's ready for new data
		this.readBuffer.clear();
//        readBuffer.flip();
		// Attempt to read off the channel
		int numRead;
		try {
			numRead = socketChannel.read(this.readBuffer);
		} catch (IOException e) {
			// The remote forcibly closed the connection, cancel
			// the selection key and close the channel.
			key.cancel();
			socketChannel.close();

			return;
		}

		str = new String(readBuffer.array(), 0, numRead);
		System.out.println(str);
		socketChannel.register(selector, SelectionKey.OP_WRITE);
	}

	private void accept(SelectionKey key) throws IOException {
		ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
		SocketChannel clientChannel = ssc.accept();
		clientChannel.configureBlocking(false);
		clientChannel.register(selector, SelectionKey.OP_READ);
		System.out.println("a new client connected "+clientChannel.getRemoteAddress());
	}

	public static void main(String[] args) throws IOException {
		System.out.println("server started...");
		new Server().start();
	}
}

