/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.HashSet;

import junit.framework.Assert;

import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Facade;
import P2CG.Loja;
import P2CG.Usuario;
import P2CG.Exceptions.UsuarioInvalidoException;

public class TesteLojaPontosExperiencia {

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo RPG.
	 */
	@Test
	public void testPontosExperienciaRPG() {
		Facade facade = new Facade();
		HashSet<EstiloJogos> estilo = new HashSet();

		estilo.add(EstiloJogos.ONLINE);
		estilo.add(EstiloJogos.MULTIPLAYER);
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = facade.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			facade.criaJogo("Mario e Luigi: Superstar Saga", 85.99, "RPG", estilo);
			facade.adicionaJogo("Mario e Luigi: Superstar Saga", tainah);

			facade.criaJogo("Paper Mario", 75.00, "RPG", estilo);
			facade.adicionaJogo("Paper Mario", lisa);

			Assert.assertTrue(859 == tainah.getPontos());
			Assert.assertTrue(750 == lisa.getPontos());

			tainah.ganhouPartida("Mario e Luigi: Superstar Saga", 0, false);

			
			Assert.assertTrue(869 == tainah.getPontos());

			
			lisa.ganhouPartida("Paper Mario", 1500, true);

			Assert.assertTrue(760 == lisa.getPontos());
		} catch (Exception e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo Plataforma.
	 */
	@Test
	public void testPontosExperienciaPlataforma() {
		Facade facade = new Facade();
		HashSet<EstiloJogos> estilo1 = new HashSet();
		estilo1.add(EstiloJogos.OFFLINE);
		estilo1.add(EstiloJogos.MULTIPLAYER);

		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = facade.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			facade.criaJogo("Super Mario World", 30.00, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario World", lisa);

			facade.criaJogo("Super Mario Bros", 35.60, "Plataforma", estilo1);
			facade.adicionaJogo("Super Mario Bros", tainah);

			

			Assert.assertTrue(356 == tainah.getPontos());
			Assert.assertTrue(300 == lisa.getPontos());

			tainah.ganhouPartida("Super Mario Bros", 150, true);
			tainah.ganhouPartida("Super Mario Bros", 160, true);
			tainah.ganhouPartida("Super Mario Bros", 130, false);
			tainah.ganhouPartida("Super Mario Bros", 200, true);

			lisa.ganhouPartida("Super Mario World", 300, true);


			Assert.assertTrue(396 == tainah.getPontos());
			Assert.assertTrue(310 == lisa.getPontos());

		} catch (Exception e) {
			Assert.fail();
		}

	}

	/**
	 * Teste criado para testar se os pontos referentes a experiencia dos
	 * jogadores estao sendo computados corretamente (pontos referentes a compra
	 * do jogo).Nesse caso, referente a jogos do tipo Luta.
	 */
	@Test
	public void testPontosExperienciaLuta() {
		Facade facade = new Facade();
		HashSet<EstiloJogos> estilo = new HashSet();

		estilo.add(EstiloJogos.ONLINE);
		estilo.add(EstiloJogos.MULTIPLAYER);
		try {
			Usuario tainah = facade.criaUsuario("Tainah Emmanuele",
					"tainahemmanuele", 250.00, "Noob");
			Usuario lisa = facade.criaUsuario("Lisa Simpson", "lisa.simpson",
					2500.00, "Veterano");

			facade.criaJogo("Injustice", 159.99, "Luta", estilo);
			facade.adicionaJogo("Injustice", tainah);

			facade.criaJogo("Guilty", 80.00, "Luta", estilo);
			facade.adicionaJogo("Guilty", lisa);

			Assert.assertTrue(1599 == tainah.getPontos());
			Assert.assertTrue(800 == lisa.getPontos());

			tainah.ganhouPartida("Injustice", 15000, true);
			tainah.ganhouPartida("Injustice", 18000, true);
			tainah.ganhouPartida("Injustice", 20000, true);

			lisa.ganhouPartida("Guilty", 20000, true);
			lisa.ganhouPartida("Guilty", 30000, true);
			lisa.ganhouPartida("Guilty", 50000, true);

			
			Assert.assertTrue(1629 == tainah.getPontos());
			Assert.assertTrue(830 == lisa.getPontos());

		} catch (Exception e) {
			Assert.fail();
		}
	}

}
