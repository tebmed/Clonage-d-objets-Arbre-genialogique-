import java.util.ArrayList;
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
        	/*
			tmp.enfants = (ArrayList<Arbre_Genialoqique>) this.enfants.clone();
			*/
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
	public  void  affichage()
	{
		 

		System.out.println(this.nom+" addresse physique: "+this);	  
		while(this != null)
		{
	       //display the children's list
		    for (int i = 0; i < this.enfants.size(); i++) 
			{
			  Arbre_Genialoqique tmp = this.enfants.get(i);
		      System.out.println(tmp.nom+" addresse physique: "+tmp);
			}
		  break;
		  }
		}
	
	//attributs
	String nom;
    ArrayList<Arbre_Genialoqique> enfants;
    
}
