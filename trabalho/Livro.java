
import java.util.List;

public class Livro implements ILivro{

    private String titulo;
    private int idLivro;
	private int ano;
    private String editora;
    private String autores;
	private boolean reserva;
	private String edicao;
    
    private List<Exemplar> listaExemplares;
    private List<Observer> listaObservadores;
    private GerenciaReserva reservas;
    private GerenciaEmprestimo emprestimos;

	public Livro(String titulo, int idLivro, int ano, String edicao, String editora, String autores)
	{
		this.titulo =titulo;
		this.idLivro = idLivro;
		this.ano = ano;
		this.edicao = edicao;
		this.autores = autores;
	}
    
    
    public void emprestarLivro(Usuario usuario) {
    	for (Exemplar exemplar : listaExemplares) {    		
            if (exemplar.isStatusEmprestimo() == false) {
            	emprestimos.adicionarEmprestimo(usuario, exemplar);
            	break;
            }
		}    	        
    }  
    
    
    public void adicionarExemplar(int idExemplar, Livro livro) {
    	Exemplar exemplar = new Exemplar(idExemplar, this);
        listaExemplares.add(exemplar);      
    }
    
	public boolean verificarDisponibilidade() {
		for (Exemplar exemplar : listaExemplares) {    		
            if (exemplar.isStatusEmprestimo() == false) {
            	return true;
            }
		}
		return false;
	}

			

	//Getters and Setters

	public String getEdicao( ) {
		return edicao;
	}
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

	
	
	
}
