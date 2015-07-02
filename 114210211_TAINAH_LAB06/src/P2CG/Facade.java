/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe criada com o objeto de delegar as chamadas para a classe controller. Captura as Exceptions
 * e imprime os metodos que retornam String no Controller.
 * @author tainahemmanuele
 *
 */
public class Facade {

	Controller controller;
	
	/**
	 * Construtor da classe Facade.
	 */
	public Facade(){
		this.controller = new Controller();
		
	}
	
	/**
	 * Metodo utilizado na criacao de um jogo. 
	 * Retorna o retorno do metodo criaJogo() da classe Controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @param nome - nome do jogo;
	 * @param preco - preco do jogo;
	 * @param tipo - tipo do jogo; 
	 * @param jogabilidade - lista com as jogabilidades do jogo;
	 * @return - retorna um objeto do tipo jogo.
	 */
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) {
		try {
			return controller.criaJogo(nome, preco, tipo, jogabilidade);
		} catch (JogoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Metodo utilizado na criacao de um usuario.
	 * Retorna o retorno do metodo criaUsuario() da classe controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @param nome - nome do usuario;
	 * @param login - login do usuario;
	 * @param dinheiro - dinheiro do usuario;
	 * @param tipoJogador - tipo do jogador a ser criado (Noob ou Veterano);
	 * @return - retorna um objeto do tipo usuario.
	 */
	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoJogador)  {
		try {
			return controller.criaUsuario(nome, login, dinheiro, tipoJogador);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Metodo criado para adicionar um jogo a lista de jogos do usuario.
	 * Retorna o retorno do metodo adicionaJogo() da classe controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @param nome - nome do jogo;
	 * @param usuario - objeto do tipo usuario, que deve ter o jogo adicionado a sua
	 * lista de jogos.
	 */
	public void adicionaJogo(String nome, Usuario usuario) {
		try {
			controller.adicionaJogo(nome, usuario);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Metodo que adiciona dinheiro ao usuario.
	 * Chama o metodo adicionaDinheiro() da classe Controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @param dinheiro - dinheiro a ser adicionado.
	 * @param usuario - objeto do tipo usuario , que deve ter o dinheiro adicionado
	 * a sua conta.
	 */
	public void adicionaDinheiro(double dinheiro, Usuario usuario){
		controller.adicionaDinheiro(dinheiro, usuario);
	}
	

	/**
	 * Metodo utilizado para imprimir o retorno do metodo imprimeTop() da classe controller.
	 */
	public void imprimeTop(){
		System.out.println(controller.imprimeTop());
	}
	
	/**
	 * Metodo utilizado para pesquisar um usuario.
	 * Retorna o retorno do metodo pesquisaUsuario() da classe Controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @param nome - nome do usuario;
	 * @return - retorna um objeto do tipo usuario.
	 */
	public Usuario pesquisaUsuario(String nome){
		try {
			return controller.pesquisaUsuario(nome);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	/**
	 * Metodo que possui a lista de usuarios.
	 * Retorna o retorno do metodo listaUsuario() da classe Controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 * @return - retorna um ArrayList do tipo Usuario.
	 */
	public  ArrayList <Usuario>listaUsuario(){
		return controller.listaUsuario();
	}
	
	/**
	 * Metodo utilizado para ordenar a lista de usuarios por mair quantidade de XP.
	 * Chama o metodo ordenaPontos() da classe Controller.
	 * A facade apenas delega (forwarding) a operacao para a classe Controller.
	 */
	public void ordenaPontos(){
		controller.ordenaPontos();
	}
	
	/**
	 * Metodo utilizado para imprimir o retorno do metodo imprime() da classe Controller
	 */
	public void imprime(){
		System.out.println(controller.imprime());
	}
}
