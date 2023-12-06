
public class Reserva  {

    public Livro livro;
    public Usuario usuario;

    //Constructor
    public Reserva (Usuario usuario, Livro livro) {
    	this.livro = livro;
    	this.usuario = usuario;
    }
    
    //Getters and Setters...
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
}
