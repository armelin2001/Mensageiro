package mensageiro;
import java.util.ArrayList;

public class Conversa {
	private ArrayList<Mensagem> mensagens;
	
	
	public Conversa() {
		this.mensagens = new ArrayList<Mensagem>();
	}
	
	public void addMensagens(String textoMensagem) {
		Mensagem m= new Mensagem(textoMensagem);
		mensagens.add(m);
		
	}
	public void imprimir() {
		for(Mensagem m: mensagens) {
			m.imprimir();
			
		}
	}
public int numeroMensagens() {
	return mensagens.size();
}
}
