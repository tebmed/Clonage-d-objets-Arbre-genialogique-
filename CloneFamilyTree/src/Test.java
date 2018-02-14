import java.util.ArrayList;
import java.util.Scanner;


public class Test {
	
	static Scanner s = new Scanner(System.in);

    static void menu()
    {
    	System.out.println("------Arbre Génialogique------------"); 
    	System.out.println("1--creer une nouvelle famille");
    	System.out.println("2--Ajouter un enfant");
    	System.out.println("3--Afficher l'arbre génialogique");
    	System.out.println("4--Cloner une famille");
    	System.out.println("5--afficher la liste des famille");
    	System.out.println("6--Quitter");
    }
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		 int ch = 0;
		
		 ArrayList<Famille> liste_des_familles = new ArrayList<>();
		 do
		 {
			 menu();
			 System.out.println("Donner votre choix");
			 ch = s.nextInt();
			 
			 switch (ch)
			 { 
			  case 1:    System.out.println("Entrer le nom de famille:");
			             String nom = s.next();
			             Famille f = new Famille(nom);
			             liste_des_familles.add(f);
			             break;
			            
			         
			  case 2:   System.out.println("Entrer le nom :");
	                    String nomf = s.next();
	                    System.out.println("Entrer son/sa prenom");
	                    String prenomf = s.next();
	                    int i = 0;
	                    for (i=0; i < liste_des_familles.size(); i++) {
							if(liste_des_familles.get(i).nom_de_famille.equals(nomf))
							{
							  System.out.println(liste_des_familles.get(i));
							  liste_des_familles.get(i).ajouter_personne(prenomf);
							}
						}
			            break;
			            
			   case 3: System.out.println("Entrer le nom de la famille que vous voulez afficher son arbre");
			           String snom = s.next();
			           int k = 0;
			           Famille tmp = null;
	                    for (k=0; k < liste_des_familles.size(); k++)
	                    {
							if(liste_des_familles.get(k).nom_de_famille.equals(snom))
							{
								 tmp= liste_des_familles.get(k);
							}
						}
	                    tmp.affichage();
	                    break;
	                    
			   case 4: System.out.println("Entrer le nom de la famille que vous voulez cloner");
			           String snom1 = s.next();
	                   int k1 = 0;
	                   Famille tmp1 = null;
                       for (k=0; k < liste_des_familles.size(); k++) 
                       {
			             if(liste_des_familles.get(k).nom_de_famille.equals(snom1))
					     {
						    tmp1= liste_des_familles.get(k);
					     }
			           }
                        Famille ftmp = (Famille) tmp1.clone();
                        System.out.println("after cloning");
                        ftmp.affichage();
			             break;  
			             
			   case 5:for (int j12 = 0; j12 < liste_des_familles.size(); j12++)
		              {
		                  if(j12<liste_des_familles.size()-1)
		                  {
		                    System.out.print(liste_des_familles.get(j12).nom_de_famille+" -- ");
		                  }
		                  else
		                  {
		        	        System.out.print(liste_des_familles.get(j12).nom_de_famille); 
		                  }
		               }
			           break;
			   
			   }
		 }while(ch==1 || ch==2 || ch==3 || ch==4 || ch==5);
		 
		 
	}
}
