package webrtc.http;

import java.io.*;
import java.nio.file.*;

import com.sun.net.httpserver.*;

public class RequestHandler implements HttpHandler {

	public static final String CONTEXT_ROOT = "/app";

	private File rootFile = new File("webroot");

	@Override
	public void handle(HttpExchange t) throws IOException {
		String uri = t.getRequestURI().getPath();
		String url = uri;
		if (CONTEXT_ROOT.equals(uri)) {
			url = "WebRTC.html";
		}
		File file = new File(rootFile, url);
		String response = new String(Files.readAllBytes(file.toPath()));
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();

		os.write(response.getBytes());
		os.close();
	}

}
