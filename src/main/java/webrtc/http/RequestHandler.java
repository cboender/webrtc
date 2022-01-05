package webrtc.http;

import java.io.*;

import com.sun.net.httpserver.*;

public class RequestHandler implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException {
		String response = "This is the response";
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
