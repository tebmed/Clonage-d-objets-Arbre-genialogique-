import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Famille  implements Cloneable{
	
	public Famille(String nom)
	{
		this.nom_de_famille=nom;
		this.a = null;
	}
	
	public Famille(String nom,Arbre_Genialogique a)
	{
		this.nom_de_famille = nom;
		this.a=a;
	}
	
	//clone methods
	public Object clone() throws CloneNotSupportedException
	{
		Famille tmp = (Famille)super.clone();
		try
		{
			tmp.a = (Arbre_Genialogique) this.a.clone();
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		return tmp;
	}
	
	public void affichage()
	{
		  Arbre_Genialogique tmp=this.a;
		  System.out.println("        Nom de Famille : "+this.nom_de_famille);
		  tmp.affichage();
	}
	public void ajouter_personne(String pr)
	{
		
		Arbre_Genialogique personne = new Arbre_Genialogique(pr);
		Arbre_Genialogique  tmp = this.a;
		
		
		if(tmp != null)
	       {
	       System.out.println("entrer le prenom de son pére");
	       String pre = s.next();
	       Arbre_Genialogique p = tmp.trouver_pere(pre);
	       p.ajouter_enfant(personne);
	       }
	       else
	       {
	    	   this.a=personne;
	       }
		
	}
	
	class Arbre_Genialogique implements Cloneable
	{		
		public Arbre_Genialogique(String prenom)
		{
			
			this.prenom = prenom;
			this.enfants = new ArrayList();
		}
		
		public Arbre_Genialogique trouver_pere(String prenom)
		{   
			
			Arbre_Genialogique tmp=this;
			LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
			q.addFirst(tmp);
			while(!(q.isEmpty())) 
			{
	           			  
				  tmp = q.getLast();
				  if(tmp.prenom.equals(prenom))
				  {
					  break; 
				  }
				  else
				  {
				     for (int i = 0; i < tmp.enfants.size(); i++) 
				     {	
					  q.addFirst(tmp.enfants.get(i));
				     }
				  
				     q.removeLast();
				  }
				 
			  }
			 return tmp;
			
		 }
		
		
		//clone methode
		public Object clone() throws CloneNotSupportedException
		{
			Arbre_Genialogique tmp = (Arbre_Genialogique) super.clone();
			ArrayList<Arbre_Genialogique> ss = new ArrayList<>();
			//deep copy
	        try
	        {
				//tmp.enfants = (ArrayList<Arbre_Genialogique>) this.enfants.clone();
				for (int i = 0; i < this.enfants.size(); i++) 
	        	{
					Arbre_Genialogique t = this.enfants.get(i);
					ss.add((Arbre_Genialogique) t.clone());
				}
	        	tmp.enfants = ss;
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			return tmp;
		}
		
		
		//add node
		public void ajouter_enfant(Arbre_Genialogique enfant)
		{  
	      this.enfants.add(enfant); 	
		}
		
		
		//display methode
		public void  affichage()
		{
			  Arbre_Genialogique tmp=this;
			  LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
			  q.addFirst(tmp);
			  while(!(q.isEmpty())) 
			  {
	             			  
				  tmp = q.getLast();
				  System.out.println("   *******   ");  
				  System.out.println("Prenom : "+tmp.prenom);  
				  
			   if(tmp.enfants.size() != 0)
			   {
				 System.out.println("Ses enfants :"); 
	             for (int i = 0; i < tmp.enfants.size(); i++) 
				 {
					 System.out.print(tmp.enfants.get(i).prenom+"   --  ");
				 }
			  
				 System.out.println("   ");
				 for (int i = 0; i < tmp.enfants.size(); i++) 
				 {
				   q.addFirst(tmp.enfants.get(i));
				 }
			   }
				 q.removeLast();
				 
			  }
		}
		
		
		//attributs
	    String prenom;
	    public ArrayList<Arbre_Genialogique> enfants;
	}

	//attributs
	String nom_de_famille;
    Arbre_Genialogique a;
    Scanner s = new Scanner(System.in);
}
