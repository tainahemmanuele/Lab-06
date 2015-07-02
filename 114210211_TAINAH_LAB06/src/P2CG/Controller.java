/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;

/**
 * Classe criada como objetivo de gerenciar o funcionamento de Jogo, Loja e Usuario. 
 * @author tainahemmanuele
 *
 */
public class Controller {
	private JogoFactory fabricaJogos;
	private Jogo jogo;
	private Loja loja;
	private Usuario usuario;
	private double preco;
	private double valorTotal;
	private double desconto;
	private String status;
	String quebraLinha = System.getProperty("line.separator");

	/**
	 * Contrutor da classe Controller.
	 */
	public Controller(){
		this.fabricaJogos = new JogoFactory();
		this.loja = new Loja();
		this.preco = 0;
		this.desconto = 0;
	}
	
	/**
	 * Metodo usado para criar o jogo. Esse metodo chama a classe JogoFactory
	 * que contem todos os metodos para a criacao de jogos.
	 * 
	 * @param nome
	 *            , nome do jogo a ser criado
	 * @param preco
	 *            , preco do jogo a ser criado
	 * @param tipo
	 *            , tipo de jogo. A partir desse atributo que as classes
	 *            correspondentes aos tipos de jogos sao chamadas.
	 * @param jogabilidade
	 *            , lista que contem as jogabilidades do jogo
	 * @return, retorna um objeto do tipo jogo.
	 */
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) throws JogoException {
			this.jogo = fabricaJogos.criaJogo(nome, preco, tipo, jogabilidade);
			this.preco = preco;
			return jogo;

	}
	
	/**
	 * Metodo utilizado para criar um usuario. Por definicao, um usuario criado e um jogador do
	 * tipo Noob. Caso contrario, o metodo upgrade da classe usuario e chamado e e criado um jogador
	 * do tipo veterano. Retorna um objeto do tipo usuario.
	 * O metodo para adicionar o usuario se encontra na classe Loja.
	 * O controller apenas delega (forwarding) a operacao para a classe.
	 * @param nome - nome do usuario;
	 * @param login - login do usuario;
	 * @param dinheiro - dinheiro do usuario;
	 * @param tipoJogador - tipo de jogador que deve ser criado (Noob ou Veterano);
	 * @return - retorna um objeto do tipo usuario.
	 * @throws CriacaoUsuarioException - excecao lancada caso tente criar um usuario com
	 * nome vazio, login vazio ou dinheiro negativo.
	 */
	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoJogador) throws CriacaoUsuarioException {
		    this.usuario =new Usuario(nome, login, dinheiro);
			if (tipoJogador.equals("Noob")) {
				loja.adicionaUsuario(usuario);
				return usuario;
			} else if (tipoJogador.equals("Veterano")) {
				usuario.upgrade();
				loja.adicionaUsuario(usuario);
				return usuario;
			} else if (!tipoJogador.equals("Noob")
					|| tipoJogador.equals("Veterano")) {

			}
	

		return null;
	}
	
	/**
	 * Metodo criado para adicionar um jogo a lista de jogos do usuario. O jogo
	 * so e adicionado se o preco dele for menor que a quantidade total de
	 * dinheiro do usuario. O metodo utilizado para adicionar o jogo esta na classe Usuario.
	 * O controller apenas delega (forwarding) a operacao para a classe.
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
	 * Adiciona mais dinheiro a um usuario. Para isso, e chamado o metodo adicionaDinheiro que
	 * se encontra na classe Usuario. 
	 * O controller apenas delega (forwarding) a operacao para a classe.
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

	/**
	 * Metodo criado para retornar uma String com os 5 jogadores que mais possuem pontos.
	 * @return - retorna um objeto do tipo String.
	 */

	public String imprimeTop(){
		loja.ordenaPontos();
		status = "------------Top 5 de Usuarios Com Maiores Xp------------" + quebraLinha ;
		for(int i =0; i<5; i++){
			status += (i+1+"° " +loja.getUsuarios().get(i).getNome() + " possui "+ loja.getUsuarios().get(i).getPontos() +" de Xp"+ quebraLinha);
			
		}
		return status;
	}
	
	/**
	 * Metodo criado para ordenar a lista de usuarios a partir da quantidade de pontos.
	 * O metodo para a ordenacao se encontra na classe Loja.
	 * O controller apenas delega (forwarding) a operacao para a classe.
	 */
	public void ordenaPontos(){
		loja.ordenaPontos();
	}
	
	/**
	 * Metodo criado para manipular a lista de usuarios.
	 * A lista se encontra na classe loja.
	 * O controller apenas delega (forwarding) a operacao para a classe.
	 * @return - retorna um ArrayList do tipo Usuario.
	 */
	public ArrayList <Usuario>listaUsuario(){
		return loja.getUsuarios();
	}
	
	/**
	 * Meotod criado para pesquisar um usuario.
	 * O metodo que faz essa pesquisa se encontra na classe loja.
	 * O controller apenas delega (forwarding) a operacao para a classe.
	 * @param nome - nome do usuario;
	 * @return - retorna um objeto do tipo Usuario;
	 * @throws UsuarioException - Excecao lancada caso o usuario pesquisado nao exista.
	 */
	public Usuario pesquisaUsuario(String nome) throws UsuarioException{
		return loja.pesquisaUsuario(nome);
	}
	
	/**
	 * Metodo criado para retornar uma String com todas as informacoes referentes a loja e aos usuarios.
	 * @return - um objeto do tipo String.
	 */
	public String imprime() {
		status = "=== Central P2-CG ===" + quebraLinha;
		for (Usuario usuario : loja.getUsuarios()) {
			status+= usuario.getLogin()+ quebraLinha;
			status+= usuario.getNome() + quebraLinha;
			status+= "Jogador " + usuario.tipoJogador()
					+ ": " + usuario.getPontos() + " x2p" + quebraLinha;
			
			status+= "Lista de Jogos:"+ quebraLinha;
			for (Jogo jogo : usuario.getJogos()) {
				status+= "+" + jogo.getNome() + " - "
						+ jogo.getClass().getSimpleName() + ":" + quebraLinha;
				status+= "===> Jogou " + jogo.getVezesjogadas()
						+ " vez(es)"+ quebraLinha;
				status+= "===> Zerou " + jogo.getZerajogo()
						+ " vez(es)"+ quebraLinha;
				status+= "===> Maior Score " + jogo.getScore()+ quebraLinha;
				status+= quebraLinha;

			}
			desconto += usuario.getDesconto();

			
		}
		status+= "Total de preco dos jogos: R$ " + valorTotal + quebraLinha;
		status+= "---------------------------------------------"+quebraLinha;
		status+= "Total arrecadado com vendas de jogos:" + desconto + quebraLinha;
		status+= quebraLinha;
		desconto = 0;
		return status;
	}

}
