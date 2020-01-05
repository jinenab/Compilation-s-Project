import java.io.Serializable;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
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
	return (String) s.subSequence(0, s.length()-2);
	
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


public TreeSet premierElement(char element) {
	TreeSet premiers=new TreeSet();
	int fromIndex=0;
	if(nonTerminal(element)==false)
	   premiers.add(element);
	else {
	for(int i=0;i<grammaire.size();i++) {
		if(grammaire.elementAt(i).charAt(0)==element) {
			

			 
			while(grammaire.elementAt(i).indexOf("|", fromIndex)>=0) {
				
				int index=grammaire.elementAt(i).indexOf("|", fromIndex)+1;
				 premiers.addAll(premierElement(grammaire.elementAt(i).charAt(index))) ;	

				if(nonTerminal(grammaire.elementAt(i).charAt(index))==true)
			
				{					premiers.remove('e');
				}
					fromIndex=index;


				 }
			premiers.addAll(premierElement(grammaire.elementAt(i).charAt(1)));
			if(nonTerminal(grammaire.elementAt(i).charAt(1))==true)
			{
			premiers.remove('e');
		}
			}

		
				
					
				}}
				
	return premiers;

		}

public Vector<String> getPremier() {
	return premier;
}

public void setPremier(Vector<String> premier) {
	this.premier = premier;
}
	
}

