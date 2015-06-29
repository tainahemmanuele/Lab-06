/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG.Exceptions;

public class UsuarioInvalidoException extends UsuarioException {

	public UsuarioInvalidoException(String string) {
		super(string);
	}

	public UsuarioInvalidoException() {
		super("Nao foi possivel criar usuario");
	}
}
