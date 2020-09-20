package ru.fyodorov.lesson6;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Fyodorov Alexandr
 *
 * Простой HTTP сервер, обрабатывающий запросы
 * Сервер запускается на порту 8080,
 * по адресу: http://localhost:8080/test
 * Команды GET:
 * curl localhost:8080/test
 * curl -X GET http://localhost:8080/test
 * На запрос GET, выдает список файлов и директорий в текущей директории
 * На остальные запросы выдает 404.
 */
public class MyServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/test", new MyHandler());
        server.start();
    }
}