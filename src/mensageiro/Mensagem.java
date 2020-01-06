package mensageiro;

public class Mensagem {
	private String texto;
	
	public Mensagem(String texto) {
		
		this.texto = texto;
	
	}
	
	public void imprimir() {
	
		System.out.println(texto);
	
	}
	public String getTexto() {
	
		return texto;
	
	}
}
