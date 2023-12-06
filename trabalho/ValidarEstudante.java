public class ValidarEstudante implements IValidadorEmprestimo {

    public boolean validar(Usuario usuario, Livro livro) {
        String nomeUsuario = usuario.getNome();
        String nomeLivro = livro.getTitulo();

        if (!livro.verificarDisponibilidade()) {
            System.out.println("Exemplares estão indisponíveis!");
            return false;
        }

        if (usuario.temDebito()) {
            System.out.println("O Usuário tem débito em atraso! Não é possível efetuar o empréstimo.");
            return false;
        }

        // if (usuario.getQtdReserva() > usuario.getQtdDeEmprestimo()) {
        //     System.out.println("O Usuário excedeu o limite de empréstimo!");
        //     return false;
        // }

        // if ((livro.ReservasMenorQueExemplares()) && !(usuario.usuarioFezReserva(livro))) {
        //     System.out.println("A quantidade de reserva existente é menor do que a quantidade de exemplares disponíveis!");
        //     return false;
        // }

        // if ((livro.ReservasMaiorOuIgualQueExemplares()) && !(usuario.usuarioFezReserva(livro))) {
        //     System.out.println("O livro tem mais reservas que exemplares e o usuário não tem reserva!");
        //     return false;
        // }

        // if (!usuario.temEmprestimo(livro)) {
        //     System.out.println("O usuário não tem empréstimo em curso do exemplar: " + livro);
        //     return false;
        // }

        // if (usuario.FezReserva(livro)) {  
        //     Exemplar exemplar = livro.getExemplarReservado();
        //     Reserva reserva = usuario.getReserva(livro.getCodigo());
        //     System.out.println(nomeLivro + " emprestado com sucesso para " + nomeUsuario + "!");
        //     return true;
        // }

        System.out.println("Não foi possível fazer o empréstimo!");
        return false;
    }
}
