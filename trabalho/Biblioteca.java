import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Usuario> usuarios;
    private List<Livro> livros; 
    private static Biblioteca instancia;

    private Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public static Biblioteca obterInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public boolean cmdReservar(int idCliente, int idLivro) {
        // Lógica para reservar o livro
        // Retorna true se a reserva for bem-sucedida, false caso contrário
        return false; // Exemplo de retorno, substitua com a lógica real
    }

    public boolean cmdEmprestar(int idCliente, int idLivro) {
        // Lógica para emprestar o livro
        // Retorna true se o empréstimo for bem-sucedido, false caso contrário
        return false; // Exemplo de retorno, substitua com a lógica real
    }

    public boolean cmdDevolver(int idCliente, int idLivro) {
        // Lógica para devolver o livro
        // Retorna true se a devolução for bem-sucedida, false caso contrário
        return false; // Exemplo de retorno, substitua com a lógica real
    }

    public Livro cmdConsultarLivro(int idCliente, int idLivro) {
        // Lógica para consultar informações do livro
        // Retorna o livro consultado ou null se não encontrado
        return null; // Exemplo de retorno, substitua com a lógica real
    }
    
    public Usuario cmdConsultarUsuario(int idCliente) {
        // Lógica para consultar informações do usuário
        // Retorna o usuário consultado ou null se não encontrado
        return null; // Exemplo de retorno, substitua com a lógica real
    }

    public void cmdConsultarNotificacao(int idCliente, int idLivro) {
        // Lógica para observar ou realizar alguma ação
        // Este método pode não retornar nada, pois é um void
    }

    public void cmdObservar(int idCliente, int idLivro) {
        // Lógica para observar ou realizar alguma ação
        // Este método pode não retornar nada, pois é um void
    }

    public void cmdSair() {
        System.out.println("Programa finalizado!");
        System.exit(0);
    }
}
