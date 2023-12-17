import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Subject{

    public int idLivro;
    public String titulo;
    public String editora;
    public String autores;
    public int ano;
	public String edicao;
	//public GerenciaEmprestimo emprestimos;

    //Constructor
    public Livro(String titulo, int idLivro, int ano, String edicao, String autores, String editora) {
        this.titulo = titulo;
		this.idLivro = idLivro;
        this.ano = ano;
		this.edicao = edicao;
		this.editora = editora;
        this.autores = autores;
    }
    public List<Reserva> reservas = new ArrayList<Reserva>();
    public List<Exemplar> listaExemplares = new ArrayList<Exemplar>();
    public List<Observer> listaObservadores = new ArrayList<Observer>();
	public ArrayList<Emprestimo> listaEmprestimos = new ArrayList<Emprestimo>();

    
    public void addExemplar(Exemplar exemplar) {
		
        listaExemplares.add(exemplar);      
    }
    
	public boolean verificarDisponibilidade() {
		for (Exemplar exemplar : listaExemplares) {    		
            if (exemplar.isStatusEmprestimo() == false) { //está emprestado?
            	return true;
            }
		}
		return false;
	}

	public boolean temExemplar()
	{
		if (listaExemplares.size()>0)
		{
			return true;
		}
		return false;
	}

	public int numeroReservas () {
		return reservas.size();
	}
	
	public int numeroEmprestimos () {
		return listaEmprestimos.size();
	}
	
	public String usuariosComReserva() {
		String nomes = " ";
		for (Reserva reserva : reservas) {
			nomes += reserva.getUsuario().getNome() + ", ";
			
		};
		return nomes;
	}
	
	public String usuariosComEmprestimo() {
		String nomes = " ";
		for (Emprestimo emprestimo : listaEmprestimos) {
			nomes += emprestimo.getUsuario().getNome() + ", ";
			
		};
		return nomes;
	}

	public String usuarioComEmprestimoExemplar(Exemplar exemplar) {
		String nome = " ";
		for (Emprestimo emprestimo : listaEmprestimos) {
			if(exemplar == emprestimo.getExemplar()){
				nome = emprestimo.nomeUsuario();
				return nome;
			}
			
		};
		return nome;
	}


	public void livConsulta () throws IOException {
		GerenciadorMensagens.livConsulta(this);
	}
	
	//Getters and Setters
	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<Exemplar> getExemplares() {
		return listaExemplares;
	}

	public void setExemplares(List<Exemplar> listaExemplares) {
		this.listaExemplares = listaExemplares;
	}

	public List<Observer> getObservadores() {
		return listaObservadores;
	}

	public void setObservadores(List<Observer> listaObservadores) {
		this.listaObservadores = listaObservadores;
	}

	public boolean maisExemplaresDisponiveisQueReservados() {
		if (this.getNumExemplaresDisponiveis() > reservas.size()) {
			return true;
		}
		return false;
	}

	public void addEmprestimo(Emprestimo e) {
		listaEmprestimos.add(e);
	}

	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
		if (reservas.size() > 2)
		{
			notificarOBS();
		}
	}

	public void notificarOBS()
	{
		for(Observer obs : listaObservadores)
		{
			obs.update(this);
		}
	}

	public Exemplar getExemplarReservado() {
		for(Exemplar e : listaExemplares) {
			if(e.isStatusEmprestimo()== false) {
				return e;
			}
		}
		return null;
	}

	public void removerReserva(Reserva r) {
		int index = reservas.indexOf(r);
		if (index >= 0) {
			reservas.remove(index);
			reservas.size();
		}
	}

	public Exemplar getExemplarDisponivel() {
		for(Exemplar e : listaExemplares) {
			if(!e.isStatusEmprestimo()) {
				return e;
			}
		}
		return null;
	}
	
	public boolean estaReservado() {
		for (Exemplar e : listaExemplares) {
			if (e.isStatusEmprestimo()) {
				return true;
			}
		}
		return false;
	}	

	public int getNumExemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for (Exemplar e : listaExemplares) {
			if (e.isStatusEmprestimo()==false) {			
				exemplaresDisponiveis++;
			}
		}
		return exemplaresDisponiveis;
	}

	public void removerEmprestimoPorExemplar(int idExemplar) {
		int index = indiceEmprestimoPorExemplar(idExemplar);
		listaEmprestimos.remove(index);
	}

	public int indiceEmprestimoPorExemplar(int idExemplar) {
		for(Emprestimo e : listaEmprestimos)
		{
			if(e.getIdExemplar() == idExemplar) {
				int index = listaEmprestimos.indexOf(e);
				return index;
			}
		}
		return 0;
	}

	@Override
	public void registrarObservador(Observer observador) {
		listaObservadores.add(observador);
	}



	
	
	
}
