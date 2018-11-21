/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author brookes
 */


public class HTTPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(9000);
        System.out.println("Listening for connection on port 9000....");
        while(true) {
            // Spin forever
            // final Socket clientSocket = server.accept();
            // 1. Read HTTP request from the client socket 
            // 2. Prepare an HTTP response 
            // 3. Send HTTP response to the client 
            // 4. Close the socket

            
            try (Socket socket = server.accept()) {
                Date today = new Date();
                CurrentDate date = new CurrentDate();
                String httpResponse = "<a>\n\nHTTP/1.1 200 OK\n\nkeep-Alive: timeout=10, max=100\n\n"
                        + "Content-Type: text/html\n\n" + date;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
              
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line = reader.readLine();
            while (!line.isEmpty()) { System.out.println(line);
            line = reader.readLine();
            } 
            }
            }
    }

}


    
    

