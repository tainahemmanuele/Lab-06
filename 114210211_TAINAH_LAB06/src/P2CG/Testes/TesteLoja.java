/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Testes;

import java.util.HashSet;

import P2CG.EstiloJogos;
import P2CG.Facade;
import P2CG.Jogo;
import P2CG.Loja;
import P2CG.Plataforma;
import P2CG.Usuario;
import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.JogoException;
import P2CG.Exceptions.UsuarioException;
import P2CG.Exceptions.UsuarioInvalidoException;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteLoja {

	/**
	 * Teste criado para testar se a classe loja esta funcionando corretamente.
	 * Neste teste e testado os metodos de criar o jogo, criar o usuario e se a
	 * partir disso o usuario consegue jogar o jogo, alem de imprimir as
	 * informacoes referentes a loja.
	 */
	@Test
	public void testLojaCriacaoUsuarioeJogo() {
		try {
			Facade facade = new Facade();
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele","tainahemmanuele", 250.00, "Noob");
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();


			estilo.add(EstiloJogos.ONLINE);
			estilo.add(EstiloJogos.MULTIPLAYER);
			estilo2.add(EstiloJogos.OFFLINE);

			Jogo injustice = facade.criaJogo("Injustice", 159.99, "Luta", estilo);
			facade.adicionaJogo("Injustice", tainah);

			facade.imprime();
			Jogo supermario = facade.criaJogo("Super Mario World", 30.00,
					"Plataforma", estilo2);
			
			facade.adicionaJogo("Super Mario World", tainah);

			facade.adicionaDinheiro(58.96, tainah);
			
			facade.imprime();
			tainah.ganhouPartida("Injustice", 0, false);
			tainah.ganhouPartida("Super Mario World", 50, true);
			tainah.ganhouPartida("Super Mario World", 150, true);

			Jogo papermario = facade.criaJogo("Paper Mario", 75.00, "RPG",
					estilo1);
			facade.adicionaJogo("Paper Mario", tainah);

			facade.imprime();
		} catch (Exception e) {

		}
	}

	/**
	 * Teste criado para testar o comportamento da classe loja e seus metodos na
	 * criacao de varios usuarios.
	 *
	 */
	@Test
	public void testLojaCriaVariosUsuarioseJogos() {
		try {
			Facade facade = new Facade();
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();

			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 1050.00, "Veterano");
			Usuario gabriela = facade.criaUsuario("Maria Gabriela", "mgabriela",
					750.00, "Noob");
			Usuario homer = facade.criaUsuario("Homer Simpson", "homer.simpson",
					258.00, "Noob");
			Usuario lisa = facade.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");
			Usuario burns = facade.criaUsuario("Mr.Burns", "burns", 85000.00,
					"Noob");
			Usuario bart = facade.criaUsuario("Bart Simpson", "bart.simpson",
					150.00, "Veterano");

			estilo.add(EstiloJogos.COMPETITIVO);
			estilo.add(EstiloJogos.MULTIPLAYER);
			estilo.add(EstiloJogos.ONLINE);

			estilo1.add(EstiloJogos.OFFLINE);
			estilo1.add(EstiloJogos.MULTIPLAYER);

			estilo2.add(EstiloJogos.ONLINE);
			estilo2.add(EstiloJogos.COMPETITIVO);

			facade.criaJogo("Injustice", 159.99, "Luta", estilo);
			facade.adicionaJogo("Injustice", tainah);

			facade.criaJogo("Guilty", 80.00, "Luta", estilo);
			facade.adicionaJogo("Guilty", tainah);

			facade.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario Bros", tainah);

			facade.criaJogo("Injustice", 159.99, "Luta", estilo);
			facade.adicionaJogo("Injustice", gabriela);

			facade.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario World", gabriela);

			facade.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			facade.adicionaJogo("Paper Mario", gabriela);

			facade.criaJogo("Guilty", 80.00, "Luta", estilo);
			facade.adicionaJogo("Guilty", gabriela);

			facade.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			facade.adicionaJogo("Mario e Luigi: Superstar Saga", gabriela);

			facade.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario Bros", gabriela);

			facade.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			facade.adicionaJogo("Paper Mario", lisa);

			facade.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			facade.adicionaJogo("Mario e Luigi: Superstar Saga", burns);

			facade.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario Bros", burns);

			facade.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			facade.adicionaJogo("Paper Mario", burns);

			facade.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario World", burns);

			facade.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			facade.adicionaJogo("Paper Mario", bart);

			tainah.perdeuPartida("Injustice", 120, true);
			tainah.ganhouPartida("Injustice", 150, true);
			tainah.perdeuPartida("Injustice", 130, false);
			tainah.ganhouPartida("Super Mario Bros", 1500, true);

			gabriela.ganhouPartida("Paper Mario", 1500, true);
			gabriela.ganhouPartida("Mario e Luigi: Superstar Saga", 5, false);
			gabriela.perdeuPartida("Mario e Luigi: Superstar Saga", 350, true);
			gabriela.ganhouPartida("Mario e Luigi: Superstar Saga", 5, false);
			gabriela.perdeuPartida("Injustice", 350, false);
			gabriela.perdeuPartida("Super Mario World", 15089, true);
			gabriela.ganhouPartida("Guilty", 3560, true);
			gabriela.ganhouPartida("Super Mario Bros", 1520, true);

			lisa.ganhouPartida("Paper Mario", 3500, true);
			lisa.ganhouPartida("Paper Mario", 3550, true);
			lisa.perdeuPartida("Paper Mario", 3500, false);
			lisa.ganhouPartida("Paper Mario", 4589, true);

			bart.ganhouPartida("Paper Mario", 2985, true);

			facade.imprime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Assert.fail();
		}

	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes a criacao do usuario.
	 */
	@Test
	public void testLojaCriacaoUsuarioInvalido() {
		Facade facade = new Facade();
		try {

			facade.criaUsuario("", "tainahemmanuele", 250.00, "Noob");
		} catch (Exception e) {

		}
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele", "", 250.00,
					"Noob");
		} catch (Exception e) {

		}
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", -250.00, "Noob");
		} catch (Exception e) {

		}
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "");
		} catch (Exception e) {

		}
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Usuario");
		} catch (Exception e) {

		}
	}

	/**
	 * Teste criado para saber se a classe loja captura e lanca as excecoes
	 * referentes a criacao do jogo.
	 */
	@Test
	public void testLojaCriacaoJogoInvalido() {
		Facade facade = new Facade();
		HashSet<EstiloJogos> estilo = new HashSet();
		estilo.add(EstiloJogos.COMPETITIVO);
		estilo.add(EstiloJogos.MULTIPLAYER);
		estilo.add(EstiloJogos.ONLINE);

		try {
			facade.criaJogo("", 159.99, "Luta", estilo);
		} catch (Exception e) {

		}
		try {
			facade.criaJogo("Injustice", -159.99, "Luta", estilo);
		} catch (Exception e) {

		}

	}

}
