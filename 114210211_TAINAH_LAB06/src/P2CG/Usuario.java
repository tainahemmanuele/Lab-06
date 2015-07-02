/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.SaldoException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe criada para criar o usuario.Instancia um objeto do tipo Jogador. Possui
 * metodos que permite que o usuario jogue o jogo comprado na loja, que adiciona
 * pontos ao usuario conforme o tipo de jogo que o mesmo jogou, que subtrai
 * pontos do usuario conforme o tipo de jogo que o mesmo jogou. Mas, para que isso ocorra
 * deve havaer um objeto do tipo Jogador, pois e nessa classe que contem os metodos. 
 * A classe usuario apenas delega (forwarding) para classe Jogador.
 * 
 * @author tainahemmanuele
 *
 */
public class Usuario implements Comparable <Usuario> {
	private String nome;
	private String login;
	protected ArrayList<Jogo> jogos;
	private double dinheiro;
	private int pontos;
	public double desconto;
	private CatalogoJogos catalogo;
	private Jogador jogador;

	/**
	 * Construtor usado para criar um usuario
	 * 
	 * @param nome
	 *            , nome do usuario
	 * @param login
	 *            , login do usuario
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @throws CriacaoUsuarioException
	 *             , excecao lancada caso o nome do usuario seja vazio, o
	 *             login do usuario seja vazio ou o dinheiro do usuario seja
	 *             negativo.
	 */

	public Usuario(String nome, String login, double dinheiro)
			throws CriacaoUsuarioException {
		if (nome.equals("")) {
			throw new CriacaoUsuarioException(
					"Nome do usuario nao pode ser vazio");
		}
		if (login.equals("")) {
			throw new CriacaoUsuarioException(
					"Login do usuario nao pode ser vazio");
		}
		if (dinheiro < 0) {
			throw new CriacaoUsuarioException(
					"Dinheiro do usuario nao pode ser negativo");
		}

		this.nome = nome;
		this.login = login;
		this.jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;
		this.pontos = 0;
		this.catalogo = new CatalogoJogos(this.jogos);
		this.jogador = new Noob(this.jogos,this.dinheiro);

	}

	/**
	 * Metodo que permite que adicione mais dinheiro ao usuario
	 * 
	 * @param dinheiro
	 *            , dinheiro do usuario
	 */
	public void adicionaDinheiro(double dinheiro) {
		jogador.setDinheiro(dinheiro);
	}

	

	/**
	 * Metodo que instancia a classe Veterano. Permite que o objeto do tipo Jogador mude do tipo
	 * Noob para Veterano.
	 */
	public void upgrade(){
		jogador = new Veterano(jogos, dinheiro);
	}
	
	/**
	 * Metodo que instancia a classe Noob. Permite que o objeto do tipo Jogador mude do tipo
	 * Veterano para Noob.
	 */
	public void downgrade(){
		jogador = new Noob(jogos, dinheiro);
	}
	
	/**
	 * Metodo utilizado para jogar um jogo. Nesse caso, o jogador perde pontos de XP.
	 * Chama o metodo perdeuPartida() da classe Jogador de acordo com a instancia do
	 * objeto jogador (Se for Noob, será chamado o metodo da classe Noob, se for Veterano, sera chamado
	 * o metodo da classe Veterano).
	 * Permite a mudanca de jogador de forma dinamica (de Noob para Veterano ou vice-versa), a partir do
	 * momento que o jogador atinge o limiar de 1000 pontos. Upgrade se pontos >=1000, Downgrade
	 * se pontos < 1000.
	 * @param nomeJogo - nome do jogo;
	 * @param scoreObtido - score que o jogador obteve no jogo;
	 * @param zerou - se o o usuario conseguiu zerar ou nao.
	 */
	public void perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou){
		jogador.perdeuPartida(nomeJogo, scoreObtido, zerou);
		setPontos(jogador.getPontos());
		mudaJogador(this.pontos);
	}
	
	

	/**
	 * Metodo utilizado para jogar um jogo. Nesse caso, o jogador ganha pontos de XP.
	 * Chama o metodo ganhouPartida() da classe Jogador de acordo com a instancia do
	 * objeto jogador (Se for Noob, será chamado o metodo da classe Noob, se for Veterano, sera chamado
	 * o metodo da classe Veterano).
	 * Permite a mudanca de jogador de forma dinamica (de Noob para Veterano ou vice-versa), a partir do
	 * momento que o jogador atinge o limiar de 1000 pontos. Upgrade se pontos >=1000, Downgrade
	 * se pontos < 1000.
	 * @param nomeJogo - nome do jogo;
	 * @param scoreObtido - score que o jogador obteve no jogo;
	 * @param zerou - se o o usuario conseguiu zerar ou nao.
	 */
	public void ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou){
		jogador.ganhouPartida(nomeJogo, scoreObtido, zerou);
		setPontos(jogador.getPontos());
		mudaJogador(this.pontos);
	}
	
	public double getDesconto() {
		return desconto;
	}

	/**
	 * Metodo utilizado para comprar um jogo.Chama o metodo compraJogo() da classe Jogador de acordo com a instancia do
	 * objeto jogador (Se for Noob, será chamado o metodo da classe Noob, se for Veterano, sera chamado
	 * o metodo da classe Veterano);
	 * Porem possui implementacao propria. Permite que os pontos do usuario sejam alterado a partir
	 * da compra;
	 * Calcula o desconto total que o usuario teve ao comprar jogos;
	 * Adiciona o jogo a lista de jogos (Chama o metodo adicionaJogo() da classe Catalogo);
	 * Permite a mudanca de jogador de forma dinamica (de Noob para Veterano ou vice-versa), a partir do
	 * momento que o jogador atinge o limiar de 1000 pontos. Upgrade se pontos >=1000, Downgrade
	 * se pontos < 1000.
	 * @param jogo - jogo a ser comprado;
	 * @throws UsuarioException- Excecao lancada caso o usuario nao possua dinheiro suficiente 
	 * para comprar o jogo.
	 */
	public void compraJogo(Jogo jogo) throws UsuarioException{
		jogador.compraJogo(jogo);
		this.pontos += jogador.getPontos();
		descontoTotal(jogador.getDinheiroDesconto());
		catalogo.adicionaJogo(jogo);
		mudaJogador(this.pontos);
		
		}
		
	
	
	/**
	 * Metodo que muda dinamicamente o tipo de Jogador.
	 * @param pontos
	 */
    private void mudaJogador(int pontos){
    	if(pontos>=1000){
			upgrade();
		}else{
			downgrade();
		}
    }
	
	/**
	 * Metodo que adiciona o jogo criado e comprado pelo usuario na sua lista de
	 * jogos.
	 * Utiliza o metodo adicionaJogo da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 * @param jogo
	 *            , jogo que foi comprado pelo usuario.
	 */
	
	
	public void adicionaJogo(Jogo jogo){
		catalogo.adicionaJogo(jogo);
	}

	
	/**
	 * Metodo que remove o jogo criado e comprado pelo usuario na sua lista de
	 * jogos.
	 * Utiliza o metodo adicionaJogo da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 * @param jogo
	 *            , jogo que foi comprado pelo usuario.
	 */
	public void removeJogo(Jogo jogo){
		catalogo.remove(jogo);
	}
	

	/**
	 *Metodo utilizado para pesquisar um jogo.
	 *Retorna o retorno do metodo pesquisaJogo() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 * @param nome - nome do jogo;
	 * @return - retorna um objeto do tipo jogo.
	 */
	public Jogo pesquisaJogo(String nome){
		return catalogo.pesquisaJogo(nome);
	}
	
	/**
	 *Metodo utilizado para retornar o jogo que possui maior score, dentre todos
	 *da lista de jogos do usuario.
	 *Retorna o retorno do metodo maiorScore() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 */
	public Jogo maiorScore(){
		return catalogo.maiorScore();
	}
	
	/**
	 *Metodo utilizado para retornar o jogo mais jogado, dentre todos
	 *da lista de jogos do usuario.
	 *Retorna o retorno do metodo maiorJogado() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 */
	public Jogo maisJogado(){
		return catalogo.maisJogado();
	}
	
	/**
	 *Metodo utilizado para retornar o jogo mais zerado, dentre todos
	 *da lista de jogos do usuario.
	 *Retorna o retorno do metodo maiorZerado() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 */
	public Jogo maisZerado(){
		return catalogo.maisZerado();
	}
	
	/**
	 *  Metodo utilizado para retornar um ArrayList com os jogos que possuem a jogabilidade
	 *  passada por parametro.
	 *Retorna o retorno do metodo jogabilidadeEspecifica() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 * @param jogabilidade - Jogabilidade passada de acordo com os tipos definidos no enum
	 * EstiloJogos.
	 * @return - retorna uma lista do tipo Jogo com os jogos que contem a jogabilidade passada
	 * como parametro.
	 */
	public ArrayList <Jogo> jogabilidadeEspecifica(EstiloJogos jogabilidade){
		return catalogo.jogabilidadeEspecifica(jogabilidade);
	}
	
	/**
	 * Metodo criado para ordenar os jogos de acordo com o tipo de ordenacao passado como 
	 * parametro. Chama o metodo ordena da classe ComparacoesFactory, que contem os metodos
	 * necessarios para cada tipo de ordenacao. A lista de jogos e o tipo de ordenacao e passada
	 * como parametro para o metodo ordena da classe ComparacoesFactory.
	 * Utiliza o metodo ordenaJogo() da classe Catalogo.
	 * O Usuario apenas delega (forwarding) a operacao para a classe.
	 * @param tipos - Tipo passado de acordo com os tipos definidos no enum TiposOrdenacao.
	 */
	public void ordenaJogo(TiposOrdenacao tipos){
		catalogo.ordenaJogo(tipos);
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public int getPontos() {
		return pontos;
	}

	public int setPontos(int pontos) {
		return this.pontos += pontos;
	}

	

	public double getDinheiro() {
		return jogador.getDinheiro();
	}

	/**
	 * Metodo utilizado para calcular o valor total gasto com jogos, considerando
	 * o desconto que o usuario/jogador teve.
	 * @param descontoJogo - valor que o usuario pagou pelo jogo.
	 * @return - retorna o valor gasto pelo usuario.
	 */

	public double descontoTotal(double descontoJogo){
		desconto += descontoJogo;
		return desconto;
	}

	public String tipoJogador(){
		return jogador.getClass().getSimpleName();
	}

	
	@Override
	public String toString() {
		return "Usuario [getDesconto()="  + ", getDinheiro()="
				+ getDinheiro() + ", getAdiciona()=" + getPontos()
				+ ", getDinheiroDesconto()=" 
				+ ", getNome()=" + getNome() + ", getLogin()=" + getLogin()
				+ ", getJogos()=" + getJogos() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Equals criado para indicar que dois usuarios sao iguais quando tiverem
	 * o mesmo nome e login.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {

			Usuario usuario = (Usuario) obj;
			if (usuario.getNome().equals(this.getNome())
					&& usuario.getLogin() == this.getLogin()) {
				return true;

			} else {

				return false;
			}
		}
		return false;
	}
	/**
	 * Metodo que utiliza a interface Comparable. Ordena qualquer lista de usuarios por quantidade
	 * de XP.
	 */
	public int compareTo(Usuario usuario) {
	       if(this.pontos < usuario.getPontos()){
	    	   return 1;
	       }
	       if(this.pontos > usuario.getPontos()){
	    	   return -1;
	       }
	       return 0;
		}
}
