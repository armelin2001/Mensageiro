package mensageiro;

public class Contato {
	private String nome;
	private Conversa conversa;
	public Contato(String nome) {
		this.nome = nome;
		conversa = new Conversa();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Conversa getConversa() {
		return conversa;
	}
	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}



}

