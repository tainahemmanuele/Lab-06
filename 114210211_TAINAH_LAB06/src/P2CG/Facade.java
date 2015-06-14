package P2CG;

import java.util.HashSet;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;

public class Facade {

	Controller controller = new Controller();
	public Facade(){
		
	}
	
	public Jogo criaJogo(String nome, double preco, String tipo,
			HashSet<EstiloJogos> jogabilidade) {
		try {
			return controller.criaJogo(nome, preco, tipo, jogabilidade);
		} catch (JogoException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Usuario criaUsuario(String nome, String login, double dinheiro,
			String tipoUsuario)  {
		try {
			return controller.criaUsuario(nome, login, dinheiro, tipoUsuario);
		} catch (CriacaoUsuarioException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void adicionaJogo(String nome, Usuario usuario) {
		try {
			controller.adicionaJogo(nome, usuario);
		} catch (UsuarioException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
