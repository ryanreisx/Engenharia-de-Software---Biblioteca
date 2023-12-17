import java.util.ArrayList;
import java.util.List;


public class Biblioteca {

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    private static Biblioteca instancia;

    public static Biblioteca obterInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public Usuario encontrarUsuarioByID (int idUsuario) {
    	for (Usuario usuario : usuarios) {    		
            if (usuario.getIdUsuario() == idUsuario){
            	return usuario;
            }
		}
    	return null;
    }
  
    public Livro encontrarLivroByID (int idLivro) {
    	for (Livro livro : livros) {    		
            if (livro.getIdLivro() == idLivro) {
            	return livro;
            }
		}
    	return null;
    }
    

    public void cmdReservar(int idCliente, int idLivro) {
        Biblioteca b = Biblioteca.obterInstancia();
		Usuario usu = b.getUsuario(idCliente);
		Livro livro = b.getLivro(idLivro);
		
		if(usu.getQtdReserva()< 3)
		{
			boolean achouReserva = false;
			for(Reserva r : usu.reservas)
			{
				if(r.getIdLivro() == idLivro)
				{
					achouReserva = true;
					break;
				}
			}
			if(!achouReserva)
			{	
				Reserva r = new Reserva(usu, livro);
				livro.addReserva(r);
				usu.addReserva(r);
                GerenciadorMensagens.resRealizada(usu, livro);
			}
			else
			{
				GerenciadorMensagens.resDuplicada(livro, usu);
			}
		}
		else
			GerenciadorMensagens.resNumMaximo();
    }

    private Usuario getUsuario(int idUsuario)
    {
        for (Usuario u : usuarios) {
			if (u.getIdUsuario() == idUsuario) {
				return u;
			}
		}    
        return null;
    }


    public void cmdDevolver(int idCliente, int idLivro) {
        Biblioteca biblioteca = obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        Livro livro = biblioteca.encontrarLivroByID(idLivro);
        boolean temLivro = usuario.livroEstaComUsuario(idLivro);
        if (temLivro)
        {
            Exemplar e = usuario.getExemplarParaDevolver(idLivro);
            GerenciadorMensagens.devRealizada(livro, usuario);
			e.disponibilizarExemplar();
            usuario.devolveReservaExemplar(idLivro);
            usuario.addNumEmprestimos();
            livro.removerEmprestimoPorExemplar(e.getIdExemplar());
            e.setStatusEmprestimo(false);

			
		} else
        GerenciadorMensagens.devNaoRealizada(livro, usuario);
        }


        

    public void cmdEmprestar(int idCliente, int idLivro) {
        Biblioteca biblioteca = obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        Livro livro = biblioteca.encontrarLivroByID(idLivro);
        if (livro == null)
        {
            GerenciadorMensagens.empSemExemplar();
        }
        usuario.fazerEmprestimo(usuario, livro);
    }



    public void cmdConsultarLivro(int idLivro) {
        Biblioteca biblioteca = obterInstancia();
        Livro livro = biblioteca.encontrarLivroByID(idLivro);
        GerenciadorMensagens.livConsulta(livro);
    }

    
    public void cmdConsultarUsuario(int idCliente) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);
        GerenciadorMensagens.usuConsulta(usuario);
    }

    public void cmdConsultarNotificacao(int idCliente) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.encontrarUsuarioByID(idCliente);

        GerenciadorMensagens.ntfConsulta(usuario);
    }

    public void cmdObservar(int idCliente, int idLivro) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        Usuario usuario = biblioteca.getUsuario(idCliente);
        Livro livro = biblioteca.getLivro(idLivro);

        livro.registrarObservador((Observer) usuario);
        GerenciadorMensagens.obsAdicionado(livro, usuario);
    }

    public void cmdSair() {
        GerenciadorMensagens.sair();
        System.exit(0);
    }

    public Livro getLivro(int idLivro)
    {
        for (Livro l : livros) {
			if (l.getIdLivro() == idLivro) {
				if (l.verificarDisponibilidade())
					return l;
			}
		}
		return null;
    }

    public void addLivro(Livro livro)
    {
        livros.add(livro);
    }

    public void addUsuario(Usuario usuario)
    {
        usuarios.add(usuario);
    }
}
