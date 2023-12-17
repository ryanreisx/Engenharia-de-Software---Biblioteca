
public class cmdConsultaNotificacao implements IComando{

    public void executar (CarregadorArgs args)
    {
        Biblioteca biblioteca = Biblioteca.obterInstancia();
        int idUsuario = args.getArg1();

        biblioteca.cmdConsultarNotificacao(idUsuario);
    }
	
	
}
