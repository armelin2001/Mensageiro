package mensageiro;
import java.util.ArrayList;
import java.util.Scanner;


public class Usuario {
	private String nome; 
	private ArrayList<Contato> contatos;


	public Usuario(String nome) {
		this.nome = nome;
		contatos= new ArrayList<Contato>();

	}

	public void inserirContato(String nome) {
		Contato novoAmigo= new Contato(nome);
		contatos.add(novoAmigo);

	}
	public void enviarMensagem(String nome, String textoMensagem) {
		Contato contato= encontrarContato(nome);
		if(contato!=null) {

			contato.getConversa().addMensagens("Usuario:"+textoMensagem);


			System.out.println("Mensagem enviada com sucesso");
		}
		
		else {
			System.out.println("contato não existente.");
		}
			
	}

	public void receberMensagem(String nome, String textoMensagem) {
		Contato contato= encontrarContato(nome);
		if(contato!=null) {

			contato.getConversa().addMensagens(contato.getNome()+" enviou: "+textoMensagem);
			System.out.println("Mensagem recebida com sucesso");


		}

	}

	public Contato encontrarContato (String nome) {
		Contato contato=null;
		for (Contato c: contatos ) {
			if(c.getNome().equals(nome)) {
				contato=c;

			}
		}
		return contato;

	}

	public void conversar() {
		Scanner ler = new Scanner(System.in);
		boolean fim = false;
		int opcao;
		String nome;
		String msg;

		while (!fim) {

			System.out.println("--------------------------------------");
			System.out.println("Menu ");
			System.out.println("--------------------------------------");
			System.out.println("1) Adicionar contato");
			System.out.println("2) Enviar mensagem para contato");
			System.out.println("3) Receber mensagem de contato");
			System.out.println("4) Imprimir conversas");
			System.out.println("5)Fim ");
			System.out.println("\n Entre com a opção desejada: ");
			opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				ler = new Scanner(System.in);
				System.out.print("\n Entre com o nome do contato a ser adicionado:");
				nome = ler.nextLine();
				this.inserirContato(nome);
				System.out.println("\n Contato adiconado com sucesso!");
				System.out.println("\n Tecle no teclado para prosseguir");
				ler.nextLine();
				System.out.flush();

				break;

			case 2:
				ler = new Scanner(System.in);
				System.out.println("Entre com o nome do contato para enviar a mensagem:");
				nome=ler.nextLine();
				ler = new Scanner(System.in);
				System.out.println("Entre com o mensagem a ser enviada:");
				msg=ler.nextLine();
				this.enviarMensagem(nome, msg);
				System.out.println("\n Tecle no teclado para prosseguir");
				ler.nextLine();
				System.out.flush();


				break;



			case 3:

				ler = new Scanner(System.in);
				System.out.println("Entre com o nome do contato para receber a mensagem:");
				nome=ler.nextLine();
				ler = new Scanner(System.in);
				System.out.println("Entre com o mensagem a ser recebida:");
				msg=ler.nextLine();
				this.receberMensagem(nome, msg);
				System.out.println("\n Tecle no teclado para prosseguir");
				ler.nextLine();
				System.out.flush();

				break;

			case 4:
				System.out.println("***********************************");
				System.out.println("Conversas de " + this.nome);

				for (Contato c : contatos) {

					System.out.println("-----------------------------");
					System.out.println("Papo com: [" + c.getNome() + "] = "+c.getConversa().numeroMensagens()+"mensagens" );
					c.getConversa().imprimir();


				}
				
									
					
				
				System.out.println("Tecle no teclado para prosseguir");
				ler.nextLine();
				System.out.flush();
				break;
			case 5:
				fim = true;
				System.out.println("...finalizando");
				break;
			default:
				System.out.println("Opção incorreta tente novamente");
			}

		}
	}
	public static void main(String[] args) {
		Usuario user = new Usuario("Usuario");
		user.conversar();
	}

}
