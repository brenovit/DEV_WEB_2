package src;

import thread.Leitor;
import java.io.*;
import java.net.*;

public class cliente {

    public static void main(String[] args) {

        int porta = 4444;
        String ipaddr = "127.0.0.1";

        Socket cSocket = null;
        PrintWriter os = null;
        BufferedReader is = null;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        if (args.length > 0) {
            ipaddr = args[0];
        }

        if (args.length > 1) {
            porta = Integer.parseInt(args[1]);
        }

        try {
            //PASSO 1: O cliente cria um socket com o servidor.
            cSocket = new Socket(ipaddr, porta);
            //PASSO 2: O cliente cria os streams de leitura/escrita com o servidor conectado. 
            is = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            os = new PrintWriter(cSocket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Nao consegui conexao de I/O com o host" + ipaddr);
            System.exit(1);
        }

        Leitor myleitor = new Leitor(is);
        myleitor.start();

        System.out.println("Servidor Conectado");

        if (cSocket != null && os != null && is != null) {
            try {
                String fromClient;

                //PASSO 3: O cliente entra num loop para receber mensagens.
                while ((fromClient = stdIn.readLine()) != null) {
                    if (fromClient.equals("bye")) {
                        break;
                    }
                    os.println(fromClient);
                    os.flush();
                }

                myleitor.stop();
                os.close();
                is.close();
                cSocket.close();
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
            }
        }
    }
}
