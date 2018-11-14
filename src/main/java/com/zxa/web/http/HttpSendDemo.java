package com.zxa.web.http;

import org.apache.catalina.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: HttpSendDemo
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/9/19 10:02
 */
public class HttpSendDemo {
	public static void main(String[] args) {
		try {
			new HttpSendDemo().selector();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("========");
		}
	}

	public void selector()throws IOException{
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(18080));
		serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
		while(true){
			Set selectedKeys = selector.selectedKeys();
			Iterator iterator = selectedKeys.iterator();
			while(iterator.hasNext()){
				SelectionKey key = (SelectionKey) iterator.next();
				if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT){
					ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
					SocketChannel sc = socketChannel.accept();
					sc.configureBlocking(false);
					sc.register(selector,SelectionKey.OP_ACCEPT);
					iterator.remove();
				}else if ((key.readyOps() & SelectionKey.OP_READ ) == SelectionKey.OP_READ ){
					SocketChannel sc = (SocketChannel)key.channel();
					while(true){
						buffer.clear();
						int n = sc.read(buffer);
						if(n<=0){
							break;
						}
						buffer.flip();
					}
					iterator.remove();
				}
			}
		}
	}

}
