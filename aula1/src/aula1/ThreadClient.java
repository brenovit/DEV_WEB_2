package aula1;

import java.net.Socket;
import java.util.Vector;

public class ThreadClient {
    Vector clientes = new Vector();
    Socket cSocket = null;
    
    ThreadClient(Socket cSocket, Vector vetor) { 
        this.cSocket = cSocket; 
        this.vetor = vetor; 
    }    
}
