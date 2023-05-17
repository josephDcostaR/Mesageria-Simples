import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInterface extends Remote {
    void enviarMensagem(String mensagem) throws RemoteException;
    String receberMensagem() throws RemoteException;
}
