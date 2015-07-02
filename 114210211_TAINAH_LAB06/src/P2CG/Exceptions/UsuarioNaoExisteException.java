/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG.Exceptions;

public class UsuarioNaoExisteException extends UsuarioException{

	public UsuarioNaoExisteException(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public UsuarioNaoExisteException() {
		super("Usuario nao existe.");
	}
}
