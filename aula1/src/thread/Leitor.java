package thread;

import java.io.BufferedReader;
import java.io.IOException;

public class Leitor extends Thread {

    BufferedReader is = null;

    public Leitor(BufferedReader is) {
        super("cliente");
        this.is = is;
    }

    @Override
    public void run() {
        if (is != null) {
            try {
                String fromServer;

                while ((fromServer = is.readLine()) != null) {
                    System.out.println("O Servidor Disse: " + fromServer);
                    if (fromServer.equals("Bye")) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Programa Abortado: " + e);
            }
        }
    }
}
