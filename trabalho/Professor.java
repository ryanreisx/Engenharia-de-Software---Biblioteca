
public class Professor extends Usuario implements Observer{
    
    public Professor(int idUsuario, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
		setMaximoDiasEmprestimo(7);
        validador = new ValidarProfessor();
    }
    private int notificacao;

    public int getNotificacao()
    {
        return notificacao;
    }




    @Override
    public void update(Livro livro) {
        notificacao++;
    }
	
	
	
}

