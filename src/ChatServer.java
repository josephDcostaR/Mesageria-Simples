
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ChatServer {

    public static void main(String[] args) throws Exception {

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ChatServerImpl chatServer = new ChatServerImpl();
            registry.rebind("ChatServer", chatServer);
            System.out.println("Ready Go...");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
}
