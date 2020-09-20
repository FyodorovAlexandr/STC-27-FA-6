package ru.fyodorov.lesson6;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Класс обрабатывает запросы
 */
public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if ("GET".equals(httpExchange.getRequestMethod())) {
            String response = FileUtilities.getDirsFiles(new File(".").getCanonicalPath());

            httpExchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = httpExchange.getResponseBody()) {
                os.write(response.getBytes());
                os.flush();
            }
        } else {
            httpExchange.sendResponseHeaders(404, -1);
        }
        httpExchange.close();
    }
}