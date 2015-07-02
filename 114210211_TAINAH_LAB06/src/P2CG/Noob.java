/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe herdada de jogador. Cria um jogador do tipo noob.
 * 
 * @author tainahemmanuele
 *
 */
public class Noob extends Jogador{

	/**
	 * Construtor da classe Noob.
	 * @param jogos - lista de jogos do usuario;
	 * @param dinheiro - dinheiro do usuario.
	 */
	public Noob(ArrayList<Jogo> jogos,double dinheiro) {
		super(jogos,dinheiro);
	}


	/**
	 * Metodo criado para a compra do jogo. Herda da classe Jogador. Nesse
	 * metodo, e gerado os pontos do jogador/usuario pela compra do jogo; O desconto do
	 * preco do jogo e calculado; O preco do jogo com desconto e subtraido do
	 * dinheiro total do usuario; O jogo e adicionado na lista de jogos do
	 * usuario.
	 */
	@Override
	public void compraJogo(Jogo jogo) throws UsuarioException {
		double desconto = calculaDesconto(jogo.getPreco());
        adicionaPontos(jogo.getPreco());
		subtraiDinheiro(jogo.getPreco() - desconto);

	}

	/**
	 * Metodo criado para recompensar o jogador/usuario com pontos, de acordo com as
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
	 * Metodo criado para punir jogador/usuario com pontos, de acordo com as
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

	/**
	 * Metodo criado para calcular o desconto do jogo, de acordo com o tipo de
	 * jogador.
	 */
	@Override
	public double calculaDesconto(double precoJogo) {
		double desconto = precoJogo*0.1;
		return desconto;
	}

	
}
