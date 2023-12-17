import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario{

    IValidadorEmprestimo validador;
	public int idUsuario;
	public String nome;
	private int maxDiasEmprestimo;
	private int qtdMaximoLivroEmprestimo;
	private int numEmprestimos = 0;

	public List<Reserva> reservas = new ArrayList<Reserva>();
	public List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();



	public int getQtMaximoDiasEmprestimo() {
        return qtdMaximoLivroEmprestimo;
    }

	public int getQtdMaximaEmprestimo()
	{
		return maxDiasEmprestimo;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public int getQtdEmprestimo() {
		return this.emprestimos.size();
	}

	public int getQtdReserva() {
		return this.reservas.size();
	}

	public int getMaximoDiasEmprestimo() {
		return this.maxDiasEmprestimo;
	}



	public void setMaximoDiasEmprestimo(int dias) {
		this.maxDiasEmprestimo = dias;
	}
	public void setqtdMaximoEmprestimo(int dias) {
		this.maxDiasEmprestimo = dias;
	}


	public boolean temDebito() {
        LocalDate dataHoraAtual = LocalDate.now();
		for (Emprestimo emprestimo : emprestimos) {
			
			if (dataHoraAtual.isAfter(emprestimo.getDataDevolucao()))
			{
				return true;
			}
		}
		return false;


	}

	public boolean temReserva(int codigo)
	{
		for (Reserva reserva : reservas) {
			if (reserva.getLivro().getIdLivro() == codigo) {
				return true;
			}
		}
		return false;
	}



	public Exemplar getExemplarParaDevolver(int idLivro) {
		for (Emprestimo e : emprestimos)
			if (e.obterlivroId() == idLivro && e.exemplarEstaEmprestado()){
				return e.getExemplar();
			}
		return null;
	}

	
	public boolean temLivro (int idLivro) {
	
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.obterlivroId() == idLivro && emprestimo.exemplarEstaEmprestado())
			{
				return true;
			}
		}
		return false;
	}

		
	public boolean livroEstaComUsuario(int idLivro) {
		for (Emprestimo e : emprestimos) {
			int livroid = e.obterlivroId();
			if (livroid == idLivro && e.exemplarEstaEmprestado()) {
				return true;
			}
		}
		return false;
	}


	public Reserva getReserva(int codigoLivro) {
		for (Reserva r : reservas) {
			if (r.getLivro().getIdLivro() == codigoLivro) {
				return r;
			}
		}
		return null;
	}

	public void addNumEmprestimos() {
		this.numEmprestimos++;
	}

	public void addEmprestimo(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}

	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
		
	}

	public void removerReserva(Reserva r) {
		int index = reservas.indexOf(r);
		if (index >= 0) {
			reservas.remove(index);
			reservas.size();

		}
	}


	public void devolveReservaExemplar(int codigoLivro) {
		for (Emprestimo e : emprestimos) {
			if (e.obterlivroId() == codigoLivro && e.getDataDevolucao() == null)
			{
				e.setDataDevolucao(LocalDate.now());
				return;
			}
		}
	}
	

	public void fazerEmprestimo(Usuario usuario, Livro livro) {
		validador.validar(usuario, livro);
	}



	

	
}
