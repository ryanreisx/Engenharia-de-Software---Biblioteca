
public interface ILivro{
	
	public void adicionarExemplar(int idExemplar, Livro livro);
	public void emprestarLivro(Usuario usuario);
	public boolean verificarDisponibilidade();
	
	

	
	
}
