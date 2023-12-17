public class EstudanteGraduacao extends Usuario
{
	private int qtdMaximoLivroEmprestimo;
	public EstudanteGraduacao(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
		this.qtdMaximoLivroEmprestimo = 3;
		setMaximoDiasEmprestimo(3);
		validador = new ValidarEstudante();
		
		
    }
	public int getQtMaximoDiasEmprestimo() {
        return qtdMaximoLivroEmprestimo;
    }


	
}
