import java.io.*;
import java.net.*;
import java.util.*;

public class TCPProg2 {
    private PrintWriter output;
    private BufferedReader input;
    
    public TCPProg2(Socket socket) throws Exception {
        output = new PrintWriter(socket.getOutputStream(), true);
        input =new BufferedReader
            (new InputStreamReader(socket.getInputStream()));
    }
    
    public void startReceiving() throws Exception {
        String line;
        Scanner sc = new Scanner (System.in);
        while ((line = input.readLine()) != null) {
            System.out.println(line);
            if (sc.hasNextLine()){
                output.println(sc.nextLine());
            }
        }
    }

    public void startSending() {
        Scanner stdin = new Scanner(System.in);
        String message;
        System.err.println("Please enter data here");
        while (stdin.hasNextLine()) {
            output.println(stdin.nextLine());
            try{
                message = input.readLine();
                System.out.println(message);
            } catch (IOException e){
            }
        }
    }
    
    public static void main(String[] args) {
        Socket socket = null;
        try {
            int port = Integer.parseInt(args[0]);
            if (args.length > 1) {
                socket = new Socket(args[1], port);
                System.err.println("Connected to " + args[1] +
                                   " on port " + port);
                TCPProg2 example = new TCPProg2(socket);
                example.startSending();
            } else {
                ServerSocket serverSocket = new ServerSocket(port);
                System.err.println("Waiting for someone to connect");
                socket = serverSocket.accept();
                System.err.println("Accepted connection on port " + port);
                TCPProg2 example = new TCPProg2(socket);
                example.startReceiving();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("\nUsage: java TCPProgram <port> [host]");
        }
    }
}
