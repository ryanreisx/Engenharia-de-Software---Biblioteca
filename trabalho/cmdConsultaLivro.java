public class cmdConsultaLivro implements IComando{

    public void executar (CarregadorArgs args)
    {
        int idLivro = args.getArg1();
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        biblioteca.cmdConsultarLivro(idLivro);
    }
	
	
}
