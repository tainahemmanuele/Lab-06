package P2CG;

import java.util.ArrayList;

public class CatalogoJogos {
	private ArrayList <Jogo> jogos;
	
	public CatalogoJogos(){
		this.jogos = new ArrayList<Jogo> ();
	}
	
	public void adicionaJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public void remove(Jogo jogo){
	    jogos.remove(jogo);
	}
	
}
