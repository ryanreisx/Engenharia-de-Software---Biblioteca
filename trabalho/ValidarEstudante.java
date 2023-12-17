public class ValidarEstudante implements IValidadorEmprestimo {

    public boolean validar(Usuario usuario, Livro livro) {
        String nomeUsuario = usuario.getNome();
        String nomeLivro = livro.getTitulo();

        if (!livro.verificarDisponibilidade()) {
            GerenciadorMensagens.verificarDisponibilidade(nomeLivro);
            return false;
        }

        if (usuario.temDebito()) {
            GerenciadorMensagens.verificarDebito();
            return false;
        }

        if (usuario.getQtdEmprestimo() == usuario.getQtMaximoDiasEmprestimo()) {
             GerenciadorMensagens.verificarLimite();
             return false;
         }

        if ((!livro.maisExemplaresDisponiveisQueReservados()) && !(usuario.temReserva(livro.getIdLivro()))) {
            GerenciadorMensagens.verificarExemplaresDisponiveis();
            return false;
        }

        if (usuario.temLivro(livro.getIdLivro())) {
             GerenciadorMensagens.verificarUsuarioComLivro(livro);
             return false;
        }

        

        if (usuario.temReserva(livro.getIdLivro()) && livro.verificarDisponibilidade()) {  
            Exemplar exemplar = livro.getExemplarReservado();
            
            Reserva reserva = usuario.getReserva(livro.getIdLivro());
            usuario.removerReserva(reserva);
            livro.removerReserva(reserva);
            Emprestimo e = new Emprestimo(usuario, livro, exemplar);
            livro.addEmprestimo(e);
            exemplar.setStatusEmprestimo(true);
            GerenciadorMensagens.empComSucesso(nomeLivro, nomeUsuario);
            return true;
         }
         else if(livro.verificarDisponibilidade())
         {
            Exemplar exemplar = livro.getExemplarDisponivel();
            exemplar.setStatusEmprestimo(true);
            Emprestimo e = new Emprestimo(usuario, livro, exemplar);
            usuario.addEmprestimo(e);
            livro.addEmprestimo(e);
            usuario.addNumEmprestimos();
            GerenciadorMensagens.empComSucesso(nomeLivro, nomeUsuario);
            return true;

         }

        return false;
    }
}
