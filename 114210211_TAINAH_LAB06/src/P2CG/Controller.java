package P2CG;

import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;

public class Controller {
	private JogoFactory fabricaJogos;
	private Jogo jogo;
	private Loja loja;
	private Usuario usuario;
	private double preco;
	private double valorTotal;
	private double desconto;
	private String status;

	public Controller(){
		this.fabricaJogos = new JogoFactory();
		this.loja = new Loja();
		this.preco = 0;
		this.desconto = 0;
	}
	
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {
			this.jogo = fabricaJogos.criaJogo(nome, preco, tipo, jogabilidade);
			this.preco = preco;
			return jogo;

	}
	
	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario) throws CriacaoUsuarioException {
		    this.usuario =new Usuario(nome, login, dinheiro);
			if (tipoUsuario.equals("Noob")) {
				return usuario;
			} else if (tipoUsuario.equals("Veterano")) {
				usuario.upgrade();
				return usuario;
			} else if (!tipoUsuario.equals("Noob")
					|| tipoUsuario.equals("Veterano")) {

			}
	

		return null;
	}
	
	public void adicionaJogo(String nome, Usuario usuario) throws UsuarioException {
		if (preco < usuario.getDinheiro()) {
			valorTotal += preco;
			usuario.compraJogo(jogo);

		}
	}
	
	public void adicionaUsuario(Usuario usuario){
		loja.adicionaUsuario(usuario);
	}
	
	public void imprimeTop(){
		loja.ordenaPontos();
		for(int i =0; i<5; i++){
			System.out.println(loja.getUsuarios());
			
		}
	}
	
	public void ordenaPontos(){
		loja.ordenaPontos();
	}
	
	public String imprime() {
		status+=" === Central P2-CG === ";
		for (Usuario usuario : loja.getUsuarios()) {
			status+= "  "+usuario.getLogin();
			status+= "  "+usuario.getNome();
			status+= "  "+"Jogador " + usuario.getClass().getSimpleName()
					+ ": " + usuario.getPontos() + " x2p";
			status+= "  "+"Lista de Jogos:";
			for (Jogo jogo : usuario.getJogos()) {
				status+= "  "+"+" + jogo.getNome() + " - "
						+ jogo.getClass().getSimpleName() + ":";
				status+= "  "+"===> Jogou " + jogo.getVezesjogadas()
						+ " vez(es)";
				status+= "  "+"===> Zerou " + jogo.getZerajogo()
						+ " vez(es)";
				status+= "  "+"===> Maior Score " + jogo.getScore();
				status+= "  ";

			}
			desconto += usuario.getDinheiroDesconto();
			status+= "  "+desconto;
		}
		status+= "  "+"Total de preco dos jogos: R$ " + valorTotal;
		status+= "  ";
		status+= "  "+"---------------------------------------------";
		status+= "  "+"Total arrecadado com vendas de jogos:" + desconto;
		return status;
	}
}
