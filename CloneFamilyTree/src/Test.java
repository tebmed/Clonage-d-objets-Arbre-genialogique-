
public class Test
{
	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Arbre_Genialoqique a = new Arbre_Genialoqique("MOHAMMED");
		Arbre_Genialoqique b = new Arbre_Genialoqique("ABDOU"); 
		Arbre_Genialoqique c = new Arbre_Genialoqique("AMIN"); 
		a.ajouter_enfant(b);
		a.ajouter_enfant(c);
		 
        a.affichage();
         
		System.out.println("---------------after cloning----------------");
		Arbre_Genialoqique a1 = (Arbre_Genialoqique) a.clone();
		Arbre_Genialoqique ck = new Arbre_Genialoqique("Soufien"); 
		Arbre_Genialoqique h1 = new Arbre_Genialoqique("Khalil"); 
		Arbre_Genialoqique h2 = new Arbre_Genialoqique("Mounir"); 
		a1.ajouter_enfant(ck);
		a1.ajouter_enfant(h1);
		a1.ajouter_enfant(h2);
		a1.affichage();
		 
		System.out.println("---------------after modifying----------------");
		a.affichage();
		 
    }
}
