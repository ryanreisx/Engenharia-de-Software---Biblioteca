
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciaReserva {

    public List<Reserva> listaReservas;
    
    public void adicionarReserva(Usuario usuario, Livro livro) {
    	
    	List<Reserva> reservasAtuais = new ArrayList<>();
    	
    	reservasAtuais = this.consultaPorUsuario(usuario);
    	
    	if (!reservasAtuais.isEmpty()) {
            Reserva reserva = new Reserva (usuario, livro);
            listaReservas.add(reserva);
    	}
    }

    public void removerReservasPorUsuario(Usuario usuario, Livro livro) {
        Iterator<Reserva> iterator = listaReservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getLivro().equals(livro)) {
            	if (reserva.getUsuario().equals(usuario)) {
            		iterator.remove(); 
                	System.out.println("Reserva removida para o livro: " + livro.getTitulo() + "Usuario: " + usuario.nome);
            	}
            }
        }
    }
    
    public void reservasUsuarioPorLivro (Usuario usuario, Livro livro) {
    	List<Reserva> reservas = new ArrayList<>();
    	reservas = consultaPorUsuario(usuario);
    	for (Reserva reserva : reservas) {
            if (reserva.getLivro().equals(livro)) {
                //reservasPorUsuario.add(reserva);
            	//definir um tipo de retorno
            }
        }
    }
    
    public List<Reserva> consultaPorLivro(Livro livro) {
        List<Reserva> reservasPorLivro = new ArrayList<>();

        for (Reserva reserva : listaReservas) {
            if (reserva.getLivro().equals(livro)) {
                reservasPorLivro.add(reserva);
            }
        }

        return reservasPorLivro;
    }
    
    public int consultaNumeroReservasLivro (Livro livro) {
    	List<Reserva> reservasPorLivro = new ArrayList<>();
    	reservasPorLivro = consultaPorLivro(livro);
    	return reservasPorLivro.size();
    }

    public List<Reserva> consultaPorUsuario(Usuario usuario) {
        List<Reserva> reservasPorUsuario = new ArrayList<>();

        for (Reserva reserva : listaReservas) {
            if (reserva.getUsuario().equals(usuario)) {
                reservasPorUsuario.add(reserva);
            }
        }

        return reservasPorUsuario;
    }
    
    public int consultaNumeroReservasUsuario (Livro livro) {
    	List<Reserva> reservasPorUsuario = new ArrayList<>();
    	reservasPorUsuario = consultaPorLivro(livro);
    	return reservasPorUsuario.size();
    }
    
}
