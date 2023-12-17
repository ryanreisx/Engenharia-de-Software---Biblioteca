import java.time.LocalDate;

public class Reserva  {

    public Livro livro;
    public Usuario usuario;
	public LocalDate dataSolicitacao;

    //Constructor
    public Reserva (Usuario usuario, Livro livro) {
    	this.livro = livro;
    	this.usuario = usuario;
		this.dataSolicitacao = LocalDate.now();
    }



    //Getters and Setters...

	public int getIdLivro(){
		return livro.getIdLivro();
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}		
	
	public LocalDate getDataSolicitacao()
	{
		 return dataSolicitacao;
	}
	

}
