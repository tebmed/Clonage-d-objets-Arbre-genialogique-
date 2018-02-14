
public class Test {

	
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		 Arbre_Genialoqique a = new Arbre_Genialoqique("mohammed");
		 Arbre_Genialoqique b = new Arbre_Genialoqique("ali"); 
		 Arbre_Genialoqique c = new Arbre_Genialoqique("amin"); 
	     Arbre_Genialoqique d = new Arbre_Genialoqique("nabil");
		 	 		 
	
		 a.ajouter_enfant(b);
		 a.ajouter_enfant(c);
	     a.ajouter_enfant(d);
		
		 Arbre_Genialoqique b1 = new Arbre_Genialoqique("abdou");
		 Arbre_Genialoqique b2 = new Arbre_Genialoqique("morched");
		 Arbre_Genialoqique b3 = new Arbre_Genialoqique("khalil");
	
		 b.ajouter_enfant(b1);
		 b1.ajouter_enfant(b2);
		 b.ajouter_enfant(b3);
		 
		 Arbre_Genialoqique b31 = new Arbre_Genialoqique("ayoub");
		 b3.ajouter_enfant(b31);
	   
	
         a.affichage();	 
         
         Arbre_Genialoqique clo = (Arbre_Genialoqique) a.clone();
         System.out.println("------------------------------- apres clonage--------------------------------");
       
         clo.affichage();
          
		 
	}
}
