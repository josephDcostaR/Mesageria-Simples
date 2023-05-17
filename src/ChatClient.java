import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ChatClient {

    private static ChatInterface chat;

    public static void main(String[] args) {
        
        try {
            
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        chat = (ChatInterface) registry.lookup("ChatServer");

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Insira seu nome: ");
            String nome = scan.nextLine();
            
            new Thread(new ReceiverThread()).start();
            while (true) {
                String message = scan.nextLine();
                chat.enviarMensagem( nome + " > " + message);
            }
        }
            
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static class ReceiverThread implements Runnable
    {

        @Override
        public void run() {
            
            while(true) {
                try {
                    String message = chat.receberMensagem();
                    if(!message.isEmpty()){
                        System.out.println(message);
                    }
                } catch (Exception e) {
                    System.err.println("Erro: " + e.getMessage());
                  e.printStackTrace();
        }
                }
            }
        }
        
    }
    

