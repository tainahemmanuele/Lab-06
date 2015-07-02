/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG.Testes;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import P2CG.EstiloJogos;
import P2CG.Facade;
import P2CG.Usuario;

public class TestePesquisaUsuario {

	@Test
	public void testPesquisaUsuario() {
		try{
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
		
		Usuario usuario = facade.pesquisaUsuario("Bart Simpson");
		Assert.assertEquals(bart, usuario);
		Assert.assertNotSame(burns, usuario);
		
		
		Usuario usuario2 = facade.pesquisaUsuario("Ze");
		
		}catch (Exception e){
			
		}
	}

}
