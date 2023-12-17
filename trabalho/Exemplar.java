public class Exemplar{

    public int idExemplar;
    public Livro livro;
    public boolean statusEmprestimo;
   
    //Constructor
    public Exemplar(int idExemplar, Livro livro) {
    	this.idExemplar = idExemplar;
    	this.livro = livro;
    	statusEmprestimo = false;
    }
    
    //Getters and Setters...
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getIdExemplar() {
		return idExemplar;
	}
	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}
	public boolean isStatusEmprestimo() {
		return statusEmprestimo;
	}
	public void setStatusEmprestimo(boolean statusEmprestimo) {
		this.statusEmprestimo = statusEmprestimo;
	}
	
	public void disponibilizarExemplar() {
		this.statusEmprestimo = true;
	}
		

}
