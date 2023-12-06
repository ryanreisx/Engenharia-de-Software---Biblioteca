
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciaEmprestimo {

    public List<Emprestimo> listaEmprestimos;
	
    public void adicionarEmprestimo(Usuario usuario, Exemplar exemplar) {
    	Emprestimo emprestimo = new Emprestimo (usuario, exemplar); 
        listaEmprestimos.add(emprestimo);
    }

   /* public void removerReservasPorLivro(Livro livro) {
        Iterator<Emprestimo> iterator = listaEmprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.getExemplar().equals(livro)) {
                iterator.remove(); 
                System.out.println("Reserva removida para o livro: " + livro.getTitulo());
            }
        }
    }*/
    
    public void devolucaoPorUsuario(Usuario usuario, Livro livro) {
    	List<Emprestimo> emprestimosPorUsuario = new ArrayList<>();
    	emprestimosPorUsuario = this.consultaPorUsuario(usuario);
    	
    	Iterator<Emprestimo> iterator = emprestimosPorUsuario.iterator();
        while (iterator.hasNext()) {
        	Emprestimo emprestimo = iterator.next();
            if (emprestimo.getExemplar().getLivro().equals(livro)) {
            	iterator.remove(); 
            	emprestimo.getExemplar().setStatusEmprestimo(false);
                System.out.println("Reserva removida para o livro: " + livro.getTitulo() + "usuario: " + usuario.nome);
            }
        }
    }
    
    public List<Emprestimo> consultaPorLivro(Livro livro) {
        List<Emprestimo> emprestimosPorLivro = new ArrayList<>();
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getExemplar().equals(livro)) {
                emprestimosPorLivro.add(emprestimo);
            }
        }
        return emprestimosPorLivro;
    }

    public int consultaNumeroEmprestimosLivro (Livro livro) {
    	List<Emprestimo> emprestimosPorLivro = new ArrayList<>();
    	emprestimosPorLivro = consultaPorLivro(livro);
    	return emprestimosPorLivro.size();
    }
    
    public List<Emprestimo> consultaPorUsuario(Usuario usuario) {
        List<Emprestimo> emprestimosPorUsuario = new ArrayList<>();
        for (Emprestimo emprestimo : listaEmprestimos) {
            if (emprestimo.getUsuario().equals(usuario)) {
                emprestimosPorUsuario.add(emprestimo);
            }
        }
        return emprestimosPorUsuario;
    }
    
    public int consultaNumeroEmprestimosUsuario (Usuario usuario) {
    	List<Emprestimo> emprestimosPorUsuario = new ArrayList<>();
    	emprestimosPorUsuario = consultaPorUsuario(usuario);
    	return emprestimosPorUsuario.size();
    }
    // posso pegar o atributo de quantidade maxima de emprestimo em usuario e já retornar se ele pode pegar ou não
    
    
    
}
	
