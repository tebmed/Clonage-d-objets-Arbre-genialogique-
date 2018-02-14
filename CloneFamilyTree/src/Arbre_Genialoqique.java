import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Arbre_Genialoqique implements Cloneable{
	
	public Arbre_Genialoqique(String nom)
	{
		this.nom = nom;
		this.enfants = new ArrayList();
	}
		
	//clone methode
		public Object clone() throws CloneNotSupportedException
		{
			Arbre_Genialoqique tmp = (Arbre_Genialoqique) super.clone();
			ArrayList<Arbre_Genialoqique> s = new ArrayList<>();
			//deep copy
	        try
	        {
				//tmp.enfants = (ArrayList<Arbre_Genialoqiquee>) this.enfants.clone();
				
				for (int i = 0; i < this.enfants.size(); i++) 
	        	{
					Arbre_Genialoqique t = this.enfants.get(i);
					s.add((Arbre_Genialoqique) t.clone());
				}
	        	tmp.enfants = s;
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			return tmp;
		}
			
		//add node
		public void ajouter_enfant(Arbre_Genialoqique enfant)
		{  
		   this.enfants.add(enfant); 
		}
		
		//display methode
		public void  affichage()
		{
			 
			  Arbre_Genialoqique tmp=this;
			  LinkedList<Arbre_Genialoqique> q = new LinkedList<Arbre_Genialoqique>();
			  q.addFirst(tmp);
			  while(!(q.isEmpty())) 
			  {
	             			  
				  tmp = q.getLast();
				  System.out.println(tmp.nom);  
				//  System.out.println("le nombre de ses fils est :"+tmp.enfants.size());
				  System.out.println(tmp);
				  System.out.println("ses enfants");
				  for (int i = 0; i < tmp.enfants.size(); i++) 
				  {
					System.out.println(tmp.enfants.get(i).nom);
					System.out.println(tmp.enfants.get(i));
					q.addFirst(tmp.enfants.get(i));
					
				  }
				  
				  System.out.println("----------");
				  q.removeLast();
				 
			  }
			}
	
	//attributs
	String nom;
    ArrayList<Arbre_Genialoqique> enfants;
    
}