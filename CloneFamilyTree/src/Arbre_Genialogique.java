import java.util.ArrayList;
import java.util.LinkedList;

public class Arbre_Genialogique implements Cloneable{
	
	public Arbre_Genialogique(String nf,String prenom)
	{
		this.nom_de_famille = nf;
		this.prenom = prenom;
		this.enfants = new ArrayList();
	}
		
	//clone methode
	public Object clone() throws CloneNotSupportedException
	{
		Arbre_Genialogique tmp = (Arbre_Genialogique) super.clone();	
		//deep copy
        try
        {
			//tmp.enfants = (ArrayList<Arbre_Genialogique>) this.enfants.clone();
        	ArrayList<Arbre_Genialogique> s = new ArrayList<>();
			for (int i = 0; i < this.enfants.size(); i++) 
        	{
				Arbre_Genialogique t = this.enfants.get(i);
				s.add((Arbre_Genialogique) t.clone());
			}
        	tmp.enfants = s;
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
	//search from dad
	public Arbre_Genialogique trouver_pere(String prenom)
	{   
		Arbre_Genialogique tmp= this;
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
	
	//display methode
	public void  affichage()
	{
		 
		  Arbre_Genialogique tmp=this;
		  LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
		  q.addFirst(tmp);
		  while(!(q.isEmpty())) 
		  {
             			  
			  tmp = q.getLast();
			  System.out.println("Nom : "+tmp.nom_de_famille+" , Prenom : "+tmp.prenom);  
			  System.out.println(tmp);
			  
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
	private String nom_de_famille;
	private String prenom;
    private ArrayList<Arbre_Genialogique> enfants;

}
