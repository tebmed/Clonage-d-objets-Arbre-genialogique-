import java.util.Scanner;


public class Test {
	
	public static  void menu()
	{
		System.out.println("1--ajouter un(e) person(n)e");
		System.out.println("2--afficher l'arbre génialogique");
		System.out.println("3--Cloner l'arbre Géniologique");
	}

	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Arbre_Genialogique  a1 = null;
		int ch =0;
	 do{
		menu(); 
		System.out.println("entrer votre choix");
	    ch = s.nextInt();
	   
		switch (ch)
		{
		case 1:System.out.println("entrer son nom");
		       String nom = s.next();
		       System.out.println("prenom :");
		       String prenom = s.next();
		       Arbre_Genialogique  a = new Arbre_Genialogique(nom, prenom);
		       if(a1 != null)
		       {
		       System.out.println("entrer le prenom de son pére");
		       String pr = s.next();
		       Arbre_Genialogique p = a1.trouver_pere(pr);
		       p.ajouter_enfant(a);
		       }
		       else
		       {
		    	   a1=a;
		       }
			   break;
			   
		case 2:a1.affichage();
		       break;
		      
		case 3:Arbre_Genialogique b = (Arbre_Genialogique)a1.clone();
		       System.out.println("------------cloner----------------");
			   b.affichage();
		       System.out.println("------------origin----------------");
               a1.affichage();
			   
			   break;
			   
		}
	 }while(ch==1 || ch==2 || ch==3);
		 
	}
}
