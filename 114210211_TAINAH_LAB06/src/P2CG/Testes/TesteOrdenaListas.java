/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Facade;
import P2CG.TiposOrdenacao;
import P2CG.Usuario;

public class TesteOrdenaListas {

	@Test
	public void testOrdenaListaJogo() {
		try {
			Facade facade = new Facade();
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();

			TiposOrdenacao tipo1 =  TiposOrdenacao.DESEMPENHO;

			TiposOrdenacao tipo2 =  TiposOrdenacao.EXPERIENCIA;

			TiposOrdenacao tipo3 =  TiposOrdenacao.VICIO;
			
			TiposOrdenacao tipo4 =  TiposOrdenacao.DEFAULT;
			
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

			
			gabriela.ordenaJogo(tipo1);
			Assert.assertEquals("Injustice", gabriela.getJogos().get(0).getNome());

			
			gabriela.ordenaJogo(tipo2);
			Assert.assertEquals("Mario e Luigi: Superstar Saga", gabriela.getJogos().get(1).getNome());

			
			gabriela.ordenaJogo(tipo3);
			Assert.assertEquals("Paper Mario", gabriela.getJogos().get(1).getNome());

			
			gabriela.ordenaJogo(tipo4);
			Assert.assertEquals("Guilty", gabriela.getJogos().get(0).getNome());

			
			tainah.ordenaJogo(tipo1);
			Assert.assertEquals("Injustice", tainah.getJogos().get(1).getNome());
			
			tainah.ordenaJogo(tipo2);
			Assert.assertEquals("Super Mario Bros", tainah.getJogos().get(1).getNome());

			tainah.ordenaJogo(tipo3);
			Assert.assertEquals("Guilty", tainah.getJogos().get(0).getNome());

			
			tainah.ordenaJogo(tipo4);
			Assert.assertEquals("Super Mario Bros", tainah.getJogos().get(3).getNome());
	

		} catch (Exception e) {

		}
	}
	
	@Test
	public void testeOrdenaUsuario(){
		try{
			Facade facade = new Facade();
			HashSet<EstiloJogos> estilo = new HashSet();
			HashSet<EstiloJogos> estilo1 = new HashSet();
			HashSet<EstiloJogos> estilo2 = new HashSet();

			TiposOrdenacao tipo1 =  TiposOrdenacao.DESEMPENHO;

			TiposOrdenacao tipo2 =  TiposOrdenacao.EXPERIENCIA;

			TiposOrdenacao tipo3 =  TiposOrdenacao.VICIO;
			
			TiposOrdenacao tipo4 =  TiposOrdenacao.DEFAULT;
			
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

			facade.ordenaPontos();
			Assert.assertEquals("Maria Gabriela", facade.listaUsuario().get(0).getNome());
			Assert.assertEquals("Tainah Emmanuele", facade.listaUsuario().get(1).getNome());
			Assert.assertEquals("Mr.Burns", facade.listaUsuario().get(2).getNome());
			Assert.assertEquals("Lisa Simpson", facade.listaUsuario().get(3).getNome());

			facade.imprimeTop();
		}
		catch(Exception e){
			
		}
	}
	

}
