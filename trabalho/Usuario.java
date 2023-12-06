
public abstract class Usuario{

    IValidadorEmprestimo validador;
	public int idUsuario;
	public String nome;
	private int qtdEmprestimo;
	private int qtdReservas;
	private int maxDiasEmprestimo;


	public int getIdUsuario() {
		return this.idUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public int getQtdEmprestimo() {
		return this.qtdEmprestimo;
	}

	public int getQtdReserva() {
		return this.qtdReservas;
	}

	public int getMaximoDiasEmprestimo() {
		return this.maxDiasEmprestimo;
	}

	public void setMaximoDiasEmprestimo(int dias) {
		this.maxDiasEmprestimo = dias;
	}

	public boolean temDebito() {
		return true;
	}

	
	
	
}
