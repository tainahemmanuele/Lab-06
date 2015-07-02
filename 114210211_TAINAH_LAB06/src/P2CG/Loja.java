/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;
import P2CG.Exceptions.UsuarioNaoExisteException;


/**
 * Classe criada para auxiliar no funcionamento da loja de jogos.Sua funcao e armazenar e 
 * pesquisar os usuarios.
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
	 * Metodo criado para pesquisar um usuario na lista de usuarios.
	 * @param nome - nome do usuario;
	 * @return - retorna um objeto do tipo usuario.
	 * @throws UsuarioException - Excecao lancada caso o usuario pesquisado nao exista.
	 */
	public Usuario pesquisaUsuario(String nome) throws UsuarioException{
		for(Usuario usuario: usuarios){
			if(usuario.getNome().equals(nome)){
			   return usuario;
			}
			}

	    throw new UsuarioNaoExisteException ("Usuario nao existe");

		}
		
	/**
	 * Metodo que adiciona um usuario a lista de usuarios.
	 * @param usuario - objeto do tipo usuario.
	 */
	public void adicionaUsuario(Usuario usuario){
		usuarios.add(usuario);
	}
	
	/**
	 * Metodo que ordena(de forma decrescente) a lista de usuarios por quantidade de Xp do usuario.
	 */
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
