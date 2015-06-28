/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe herdada de usuario. Cria usuario do tipo noob.
 * 
 * @author tainahemmanuele
 *
 */
public class Noob extends Jogador{

	public Noob(ArrayList<Jogo> jogos,double dinheiro) {
		super(jogos,dinheiro);
	}

	/**
	 * Construtor usado para criar um usuario do tipo Noob
	 * 
	 * @param nome
	 *            , nome do usuario
	 * @param login
	 *            , login do usuario
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @throws CriacaoUsuarioException
	 *             , excecao lan�ada caso o nome do usuario seja vazio, o
	 *             login do usuario seja vazio ou o dinheiro do usuario seja
	 *             negativo.
	 */


	/**
	 * Metodo criado para a compra do jogo. Herda da classe Usuario. Nesse
	 * metodo, e gerado os pontos do usuario pela compra do jogo; O desconto do
	 * preco do jogo e calculado; O preco do jogo com desconto e subtraido do
	 * dinheiro total do usuario; O jogo e adicionado na lista de jogos do
	 * usuario.
	 */
	@Override
	public void compraJogo(Jogo jogo) throws UsuarioException {
		setDesconto(0.1);
        adicionaPontos(jogo.getPreco());
		subtraiDinheiro(jogo.getPreco() - (getDesconto() * jogo.getPreco()));

	}

	/**
	 * Metodo criado para recompensar usuario com pontos, de acordo com as
	 * jogabilidades dos jogos que o mesmo jogou. Os pontos sao adicionados ao
	 * total de pontos do usuario.
	 */
	@Override
	public void ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou) {
		for (Jogo jogo : getJogos()) {
			if (jogo.getNome().equals(nomeJogo)) {
				jogo.joga(scoreObtido, zerou);
				setPontos(jogo.getPontos());
			}
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(EstiloJogos.OFFLINE)) {
					setPontos(30);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.MULTIPLAYER)) {
					setPontos(10);

				}
			}
		}

	}

	/**
	 * Metodo criado para punir usuario com pontos, de acordo com as
	 * jogabilidades do jogos que o mesmo jogou. Os pontos sao subtraidos do
	 * total de pontos do usuario.
	 */
	@Override
	public int perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou) {
		for (Jogo jogo : getJogos()) {
			if (jogo.getNome().equals(nomeJogo)) {
				jogo.joga(scoreObtido, zerou);
				setPontos(jogo.getPontos());
			}
			if (jogo.getNome().equals(nomeJogo)) {
				if (jogo.getJogabilidade().contains(EstiloJogos.ONLINE)) {
					setPontos(-10);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.COMPETITIVO)) {
					setPontos(-20);
				}
				if (jogo.getJogabilidade().contains(EstiloJogos.COOPERATIVO)) {
					setPontos(-50);
				}
				return getPontos();
			}
		}
		return (Integer) null;

	}

	
}
