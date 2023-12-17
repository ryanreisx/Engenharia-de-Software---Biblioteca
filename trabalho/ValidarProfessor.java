
public class ValidarProfessor implements IValidadorEmprestimo {

    public boolean validar(Usuario usuario, Livro livro) {
        String nomeUsuario = usuario.getNome();
        String nomeLivro = livro.getTitulo();

        if (!livro.verificarDisponibilidade()) {
            GerenciadorMensagens.verificarDisponibilidade(nomeLivro);
            return false;
        }

		// Verifica se Usu�rio est� em d�bito
		if (usuario.temDebito()) {
			GerenciadorMensagens.verificarDebito();
			return false;
		}
		
		Exemplar exemplar = null;
		
		if(livro.verificarDisponibilidade())
			exemplar = livro.getExemplarDisponivel();
		else if(livro.estaReservado())
			exemplar = livro.getExemplarReservado();
	
		
		// Adiciona o empr�stimo
		exemplar.setStatusEmprestimo(true);
		Emprestimo e = new Emprestimo(usuario, livro, exemplar);
		usuario.addEmprestimo(e);
		livro.addEmprestimo(e);
		usuario.addNumEmprestimos();
		GerenciadorMensagens.empComSucesso(nomeLivro, nomeUsuario);
        return true;

	}
}



