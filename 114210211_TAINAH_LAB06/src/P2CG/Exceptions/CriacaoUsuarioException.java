/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG.Exceptions;

public class CriacaoUsuarioException extends UsuarioException {

	public CriacaoUsuarioException(String string) {
		super(string);
	}

	public CriacaoUsuarioException() {
		super("Informacoes invalidas para criar o usuario.Tente Novamente");
	}
}
