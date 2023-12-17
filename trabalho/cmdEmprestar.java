
public class cmdEmprestar implements IComando{

    public void executar (CarregadorArgs args)
    {
        int idUsuario = args.getArg1();
        int idLivro = args.getArg2();
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        biblioteca.cmdEmprestar(idUsuario, idLivro);
    }
	
	
}
