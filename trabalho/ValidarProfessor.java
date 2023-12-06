
// public class ValidarProfessor implements IValidadorEmprestimo {

//     public boolean validar(Usuario usuario, Livro livro, int totalDiasEmprestimo, int codigoDoExemplar) {
//         String nomeUsuario = usuario.getNome();
//         String nomeLivro = livro.getNome();

//         if (!livro.temExemplar()) {
//             System.out.println("Exemplares estão indisponíveis!");
//             return false;
//         }

//         if (usuario.temDebito()) {
//             System.out.println("O Usuário tem débito em atraso! Não é possível efetuar o empréstimo.");
//             return false;
//         }

//         Exemplar exemplar = null;
//         if (livro.estaDisponivel()) {
//             exemplar = livro.getExemplarDisponivel();
//         } else if (livro.estaReservado()) {
//             exemplar = livro.getExemplarReservado();
//         }

//         if (exemplar != null) {
//             exemplar.emprestarExemplar();
//             Emprestimo e = new Emprestimo(usuario, livro, exemplar, totalDiasEmprestimo, codigoDoExemplar);
//             usuario.addEmprestimo(e);
//             livro.addEmprestimo(e);
//             usuario.addNumEmprestimos();
//             System.out.println(nomeLivro + " emprestado com sucesso para " + nomeUsuario + "!");
//             return true;
//         }

//         System.out.println("Não foi possível realizar o empréstimo!");
//         return false;
//     }
// }
