package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoServer {
    private static final int SERVER_PORT = 8186;
    private static DataInputStream in;
    private static DataOutputStream out;

    public static void main(String[] args) throws InterruptedException {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)
        ) {
            while (true) {
                System.out.println("Ожидание подключения...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Соединение установлено");

                in = new DataInputStream(clientSocket.getInputStream());
                out = new DataOutputStream(clientSocket.getOutputStream());

                Thread t1 = new Thread(() -> {                                  // эта часть кода дописана как ДЗ
                    Scanner scanner = new Scanner(System.in);
                    try {
                        String message;
                        while (true) {
                            message = "Cервер: ".concat(scanner.nextLine());
                            System.out.println(message);
                            out.writeUTF(message.toUpperCase());
                            Thread.sleep(100);                              // добавил задержку, т.к. иначе не получалось выполнить приложение без ошибок, видимо, были какие-то конфликты доступа к потоку данных
                        }
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                t1.start();                                                     // окончание добавленного кода

                try {
                    String message;
                    while (true) {
                        message = in.readUTF();

                        if (message.equals("/server stop")) {
                            System.out.println("Сервер остановлен");
                            System.exit(0);
                        }

                        System.out.println("Клиент: " + message.substring(3));      // здесь беру строку без первых 3х символов, т.к. в окошке клиента я пишу сообщение в виде " Я: ...", собственно, здесь я убираю это "Я" и дописываю "Клиент"
                        out.writeUTF(message.toUpperCase());
                        Thread.sleep(100);              // добавил задержку, т.к. иначе не получалось выполнить приложение без ошибок, видимо, были какие-то конфликты доступа к потоку данных
                    }

                } catch (SocketException e) {
                    clientSocket.close();
                    System.out.println("Клиент отключился");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
