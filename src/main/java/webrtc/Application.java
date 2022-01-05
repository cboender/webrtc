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
		server = HttpServer.create(new InetSocketAddress(8080), 0);
		server.createContext("/app", new RequestHandler());
		server.start();
	}
}
