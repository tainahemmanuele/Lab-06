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
				loja.adicionaUsuario(usuario);
				return usuario;
			} else if (tipoUsuario.equals("Veterano")) {
				usuario.upgrade();
				loja.adicionaUsuario(usuario);
				return usuario;
			} else if (!tipoUsuario.equals("Noob")
					|| tipoUsuario.equals("Veterano")) {

			}
	

		return null;
	}
	
	/**
	 * Metodo criado para adicionar um jogo a lista de jogos do usuario. O jogo
	 * so e adicionado se o preco dele for menor que a quantidade total de
	 * dinheiro do usuario
	 * 
	 * @param nome
	 *            , nome do jogo a ser adicionado ao usuario.
	 * @param usuario
	 *            , recebe um objeto do tipo usuario, o usuario que quer comprar
	 *            o jogo.
	 * @throws UsuarioException 
	 */
	public void adicionaJogo(String nome, Usuario usuario) throws UsuarioException {
		if (preco < usuario.getDinheiro()) {
			valorTotal += preco;
			usuario.compraJogo(jogo);
			
		}
	}

	/**
	 * Adiciona mais dinheiro a um usuario.
	 * 
	 * @param dinheiro
	 *            , quantidade de dinheiro a ser adicionada.
	 * @param usuario
	 *            , recebe um objeto do tipo usuario,o usuario que deve ser
	 *            adicionado o dinheiro.
	 */
	public void adicionaDinheiro(double dinheiro, Usuario usuario) {
		usuario.adicionaDinheiro(dinheiro);
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
	
	public void imprime() {
		System.out.println("=== Central P2-CG ===");
		System.out.println();
		for (Usuario usuario : loja.getUsuarios()) {
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNome());
			System.out.println("Jogador " + usuario.tipoJogador()
					+ ": " + usuario.getPontos() + " x2p");
			
			System.out.println("Lista de Jogos:");
			for (Jogo jogo : usuario.getJogos()) {
				System.out.println("+" + jogo.getNome() + " - "
						+ jogo.getClass().getSimpleName() + ":");
				System.out.println("===> Jogou " + jogo.getVezesjogadas()
						+ " vez(es)");
				System.out.println("===> Zerou " + jogo.getZerajogo()
						+ " vez(es)");
				System.out.println("===> Maior Score " + jogo.getScore());
				System.out.println();

			}
			System.out.println(usuario.getDesconto());
			desconto = usuario.getDesconto();
			
		}
		System.out.println("Total de preco dos jogos: R$ " + valorTotal);
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("Total arrecadado com vendas de jogos:" + desconto);
	}

}
