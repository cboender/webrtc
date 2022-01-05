package webrtc;

import java.io.*;
import java.net.*;

import com.sun.net.httpserver.*;

import webrtc.http.*;

public class Application {

	private HttpServer server = null;

	public static void main(String[] args) throws IOException {
		new Application().start();
	}

	public void start() throws IOException {
		String sPort = System.getenv("PORT");
		int port = 8080;
		if (sPort != null) {
			port = Integer.parseInt(sPort);
		}
		server = HttpServer.create(new InetSocketAddress(port), 0);
		server.createContext("/app", new RequestHandler());
		server.start();
	}
}
