
import java.time.LocalDate;

public class Emprestimo{

    public Exemplar exemplar;
    public Usuario usuario;
    public LocalDate dataEmprestimo;
    public LocalDate dataDevolucao;
	public Livro livro;
	public EstadoEmprestimo estado = new Andamento();

    public Emprestimo (Usuario usuario, Livro livro, Exemplar exemplar) {
    	this.exemplar = exemplar;
    	this.usuario = usuario;
		this.livro = livro;
    	dataEmprestimo = LocalDate.now();
    	dataDevolucao = dataEmprestimo.plusDays(usuario.getMaximoDiasEmprestimo());
    }

    
	public String nomeUsuario (){
		return usuario.getNome();
	}
    
    //Getters and Setters...

	public int getIdExemplar() {
		return exemplar.getIdExemplar();
	}
	
	public Exemplar getExemplar() {
		return exemplar;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int obterlivroId()
	{
		return livro.getIdLivro();
	}
	public boolean exemplarEstaEmprestado() {
		if(exemplar.isStatusEmprestimo())
			return true;
		return false;
	}


    
	
}
