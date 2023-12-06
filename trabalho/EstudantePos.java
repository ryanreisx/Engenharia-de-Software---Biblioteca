
public class EstudantePos extends Usuario
{
    public EstudantePos(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
		setMaximoDiasEmprestimo(4);
    }
	
}
