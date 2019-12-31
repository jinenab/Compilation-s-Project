import java.util.Scanner;
import java.util.Vector;
public class Grammaire {
Vector<String> nonTerminal=new Vector<String>();
Vector<String> grammaire=new Vector<String>();
Vector<String> premier=new Vector<String>();
public Grammaire() {
	super();
	Scanner scanner = new Scanner(System.in);
	System.out.println("Bonjour, veuillez saisir le nombre de symbole non Terminal");
	int n = scanner.nextInt();
	for(int i = 0;i<n;i++)
	{
		System.out.println("Saisir un symbole non Terminal");
		String s =scanner.next();
        nonTerminal.add(s);
	}
	System.out.println("Veuillez saisir le nombre de régles");
	n = scanner.nextInt();
	for(int i = 0;i<n;i++)
	{
		System.out.println("Saisir une régle");
        grammaire.add(scanner.next());
	}
	
	
}

public String affichage() {
	String s= new String();
	
	for(int i=0;i<grammaire.size();i++) {
		s=s+grammaire.elementAt(i).charAt(0)+"-->"+grammaire.elementAt(i).substring(1, grammaire.elementAt(i).length())+" , ";
	}
	
	return s;
}

@Override
public String toString() {
	return "Grammaire [nonTerminal=" + nonTerminal + ", grammaire = " + affichage() + "]";
}
public Vector<String> getNonTerminal() {
	return nonTerminal;
}
public void setNonTerminal(Vector<String> nonTerminal) {
	this.nonTerminal = nonTerminal;
}
public Vector<String> getGrammaire() {
	return grammaire;
}
public void setGrammaire(Vector<String> grammaire) {
	this.grammaire = grammaire;
}

public boolean nonTerminal(char element) {
	for(int i=0;i<nonTerminal.size();i++) {
		if(element==nonTerminal.elementAt(i).charAt(0))
			return true;
	}
	return false;
}


public String premierElement(char element) {
	String premiers=new String();
	int fromIndex=0;
	if(   nonTerminal(element)==false  ){
	   premiers=premiers+element;
		
	}
	for(int i=0;i<grammaire.size();i++) {
		if(grammaire.elementAt(i).charAt(0)==element) {
		
				
				premiers=premiers+premierElement(grammaire.elementAt(i).charAt(1));
				while(grammaire.elementAt(i).indexOf("|", fromIndex)>=0) {
					int index=grammaire.elementAt(i).indexOf("|", fromIndex)+1;
					premiers=premiers+premierElement(grammaire.elementAt(i).charAt(index));
					fromIndex=index;
					
				}
				

		}
	}
	return premiers;
}
}
