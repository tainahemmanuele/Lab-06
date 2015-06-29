/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;

/**
 * Classe criada para auxuliar no funcionamento da loja de jogos. Possui metodo
 * que auxiliam na criaco de jogos e usuarios alem de fazer o upgrade e o
 * downgrade dos usuarios. A partir dos metodos da loja, que metodos das classes
 * Jogo, JogoFactory e Usuario sao chamados.
 * 
 * @author tainahemmanuele
 *
 */

public class Loja  {
	private ArrayList<Usuario> usuarios;
	private String nomeJogo;
	private double preco;
	private String tipo;
	private String tipoUsuario;
	private double dinheiro;
	private double valorTotal;
	private Jogo jogo;
	private double desconto;

	/**
	 * Construtor criado para inicializar um objeto do tipo loja.
	 */
	public Loja() {
		this.usuarios = new ArrayList<Usuario>();
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
	 */
	public void adicionaJogo(String nome, Usuario usuario) {
		if (preco < usuario.getDinheiro()) {
			valorTotal += preco;
			try {
				usuario.compraJogo(jogo);
			} catch (UsuarioException e) {
				System.out.println(e.getMessage());
			}
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
		usuarios.add(usuario);
	}
	
	public void ordenaPontos(){
		Collections.sort(usuarios);
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
