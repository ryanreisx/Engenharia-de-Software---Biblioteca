
import java.time.LocalDate;

public class Emprestimo{

    public Exemplar exemplar;
    public Usuario usuario;
    public LocalDate dataDevolucao = LocalDate.now();
    
    public Emprestimo (Usuario usuario, Exemplar exemplar) {
    	this.exemplar = exemplar;
    	this.usuario = usuario;
    	//dataDevolucao = usuario.tempoEmprestimo();
    	//falta ver como pegar o dado de tempo do usuario
    }
    public int getIdExemplar() {
		return exemplar.getIdExemplar();
	}
    
    
    //Getters and Setters...
	public Exemplar getExemplar() {
		return exemplar;
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
    
	
}
