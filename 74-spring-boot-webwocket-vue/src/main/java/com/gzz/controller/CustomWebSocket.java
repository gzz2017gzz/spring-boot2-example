package com.gzz.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 14:50:00
 */
@ServerEndpoint(value = "/gzz/websocket")
@Component
public class CustomWebSocket {
	/**
	 * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	 */
	private static int onlineCount = 0;
	/**
	 * concurrent包的线程安全Set，用来存放每个客户端对应的CumWebSocket对象。
	 */
	private static CopyOnWriteArraySet<CustomWebSocket> webSocketSet = new CopyOnWriteArraySet<CustomWebSocket>();
	/**
	 * 与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	private Session session;

	/**
	 * 连接建立成功调用的方法
	 *
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;
		// 加入set中
		webSocketSet.add(this);
		// 添加在线人数
		addOnlineCount();
		System.out.println("新连接接入。当前在线人数为：" + getOnlineCount());
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		// 从set中删除
		webSocketSet.remove(this);
		// 在线数减1
		subOnlineCount();
		System.out.println("有连接关闭。当前在线人数为：" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用
	 *
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println("客户端发送的消息：" + message);
	}

	/**
	 * 暴露给外部的群发
	 *
	 * @param message
	 * @throws IOException
	 */

	public static void sendInfo(String message) {
		sendAll(message);
	}

	/**
	 * 群发
	 *
	 * @param message
	 */
	private static void sendAll(String message) {
		Arrays.asList(webSocketSet.toArray()).forEach(item -> {
			CustomWebSocket customWebSocket = (CustomWebSocket) item;
			// 群发
			try {
				customWebSocket.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * 发生错误时调用
	 *
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("----websocket-------有异常啦");
		error.printStackTrace();
	}

	/**
	 * 减少在线人数
	 */
	private void subOnlineCount() {
		CustomWebSocket.onlineCount--;
	}

	/**
	 * 添加在线人数
	 */
	private void addOnlineCount() {
		CustomWebSocket.onlineCount++;
	}

	/**
	 * 当前在线人数
	 *
	 * @return
	 */
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	/**
	 * 发送信息
	 *
	 * @param message
	 * @throws IOException
	 */
	public void sendMessage(String message) throws IOException {
		// 获取session远程基本连接发送文本消息
		this.session.getBasicRemote().sendText(message);
		// this.session.getAsyncRemote().sendText(message);
	}
}
