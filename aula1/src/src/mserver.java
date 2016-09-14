package src;

import java.net.*;
import java.io.*;
import java.util.Vector;

class mserver {

    public static void main(String[] args) {
        ServerSocket sSocket = null;
        Socket cSocket = null;
        BufferedReader is = null;
        PrintWriter os = null;

        int porta = 4444;

        if (args.length > 0) {
            porta = Integer.parseInt(args[0]);
        }

        try {
            //PASSO 1: O servidor cria um ServerSocket  
            sSocket = new ServerSocket(porta);
            System.out.println("Aguardando conexao");
            //PASSO 2: O servidor aguarda a conexão de um cliente 
            cSocket = sSocket.accept();
            System.out.println("Recebi uma conexao: " + cSocket.getInetAddress() + ":" + cSocket.getPort());
            //PASSO 3: O servidor cria os streams de leitura/escrita com o cliente conectado. 
            is = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
            os = new PrintWriter(cSocket.getOutputStream());

        } catch (IOException e) {
            System.out.println("Nao consegui ouvir a porta: " + porta + ", " + e);
            System.exit(1);
        }
        os.println("Voce se conectou em: " + cSocket.getLocalAddress() + ":" + cSocket.getLocalPort());
        os.flush();

        String msg;

        try {
            //PASSO 4: O servidor entra num loop para receber mensagens.
            while ((msg = is.readLine()) != null) {
                System.out.println("Cliente disse: " + msg);

                if (msg.equals("Bye")) {
                    os.println("Adeus, Cliente");
                    os.flush();
                    break;
                }
            }
            os.close();
        } catch (IOException e) {
            System.out.println("ERRO: " + e);
            System.exit(1);
        }
    }
}
