import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;



public class ChatServerImpl extends UnicastRemoteObject implements ChatInterface {

    private List<String> mensagens;

    public ChatServerImpl() throws RemoteException{
        super();
        mensagens = new ArrayList<>();
    }

    @Override
    public void enviarMensagem(String mensagem) throws RemoteException {
        mensagens.add(mensagem);
    }

    @Override
    public String receberMensagem() throws RemoteException {
       if(mensagens.isEmpty()){
        return "";
       } else {
            String mensagem = mensagens.get(0);
            mensagens.remove(0);
            return mensagem;
       }
    }

    
    
}
