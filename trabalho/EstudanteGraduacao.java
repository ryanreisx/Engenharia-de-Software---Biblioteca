public class EstudanteGraduacao extends Usuario
{
	public EstudanteGraduacao(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
		setMaximoDiasEmprestimo(3);
    }
	
}
