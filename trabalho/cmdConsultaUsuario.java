
public class cmdConsultaUsuario implements IComando{

    public void executar (CarregadorArgs args)
    {
        int idUsuario = args.getArg1();
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        biblioteca.cmdConsultarUsuario(idUsuario);
    }
	
	
}
