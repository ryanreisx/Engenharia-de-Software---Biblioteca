import java.util.Scanner;

public class main{
	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			Entrada entrada = new Entrada();

			

			Usuario usuario1 = new EstudanteGraduacao(123, "Joao da Silva");
			Usuario usuario2 = new EstudantePos(456, "Luiz Fernando Rodrigues");
			Usuario usuario3 = new EstudanteGraduacao(789, "Pedro Paulo");
			// Usuario usuario4 = new Professor(100, "Carlos Lucena");

			Livro livro1 = new Livro("Engenharia de Software", 100, 2000, "6", "AddisonWesley", "Ian Sommervile");
			Livro livro2 = new Livro("UML - Guia do Usuario", 101, 2000, "7", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson");
			Livro livro3 = new Livro("Code Complete", 200, 2014, "2", "Microsoft Press", "Steve McConnell");
			Livro livro4 = new Livro("Agile Software Development, Principles, Patterns, and Practices", 201, 2002, "1", "Prentice Hall", "Robert Martin");
			Livro livro5 = new Livro("Refactoring: Improving the Design of Existing Code", 300, 1999, "1", "Addison-Wesley Professional", "Martin Fowler");
			Livro livro6 = new Livro("Software Metrics: A Rigorous and Practical Apporach", 301, 2014, "3", "CRC Press", "Norman Fenton, James Bieman");
			Livro livro7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Sofware", 400, 1994, "1", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
			Livro livro8 = new Livro("UML Distilled: A Brief guide to the Standard Object Modeling Language", 401, 2003, "3", "Addison-Wesley Professional", "Martin Fowler");


			// Exemplar exemplar1 = new Exemplar("01");
			// Exemplar exemplar2 = new Exemplar("02");
			// Exemplar exemplar3 = new Exemplar("03");
			// Exemplar exemplar4 = new Exemplar("04");
			// Exemplar exemplar5 = new Exemplar("05");
			// Exemplar exemplar6 = new Exemplar("06");
			// Exemplar exemplar7 = new Exemplar("07");
			// Exemplar exemplar8 = new Exemplar("08");
			// Exemplar exemplar9 = new Exemplar("09");

			System.out.println("Sistema de Biblioteca");
			while(true) {
				String comando = scanner.nextLine();
				entrada.executarComandos(comando);
			}
		}

}