
public class cmdSair implements IComando{

    public void executar (CarregadorArgs args)
    {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        biblioteca.cmdSair();
    }
	
	
}
