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

	public Controller(){
		this.fabricaJogos = new JogoFactory();
		this.loja = new Loja();
		//this.desconto = 0;
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
			if (tipoUsuario.equals("Noob")) {
				Usuario usuario = new Noob(nome, login, dinheiro);
				return usuario;
			} else if (tipoUsuario.equals("Veterano")) {
				Usuario usuario = new Veterano(nome, login, dinheiro);
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
}
