
public class Test {

	public static void main(String[] args) {
		Grammaire grammaire= new Grammaire();
		System.out.println(grammaire);
		System.out.println("******Premiers******");
		for(int i=0;i<grammaire.getNonTerminal().size();i++) {
			System.out.println(grammaire.getNonTerminal().elementAt(i));
			System.out.println(grammaire.premierElement( grammaire.getNonTerminal().elementAt(i).charAt(0) ));

		}
	
	}

}
