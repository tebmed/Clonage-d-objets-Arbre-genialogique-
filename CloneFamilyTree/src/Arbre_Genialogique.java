import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import com.mxgraph.view.mxGraph;

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
		Arbre_Genialogique tmp2 = (Arbre_Genialogique) super.clone();	
		ArrayList<Arbre_Genialogique> ss = new ArrayList<>();
		//deep copy
        try
        {
        	for (int i = 0; i < this.enfants.size(); i++) 
        	{
				Arbre_Genialogique t = this.enfants.get(i);
				ss.add((Arbre_Genialogique) t.clone());
			}
        	tmp2.enfants = ss;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tmp2;
	}
		
	//add node
	public void ajouter_enfant(Arbre_Genialogique enfant)
	{  
		  
		 this.enfants.add(enfant); 
		   
	}
	//search from dad
	public  Arbre_Genialogique trouver_pere(String prenom)
	{   
		
		Arbre_Genialogique tmp1=this;
		LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
		q.addFirst(tmp1);
		while(!(q.isEmpty())) 
		{
           			  
			  tmp1 = q.getLast();
			  if(tmp1.prenom.equals(prenom))
			  {
				  break; 
			  }
			  else
			  {
			  for (int i = 0; i < tmp1.enfants.size(); i++) 
			  {	
				q.addFirst(tmp1.enfants.get(i));
			  }
			  
			  q.removeLast();
			  }
			 
		  }
		 return tmp1;
		
			}
	
	//display methode
	public  mxGraph  dessiner_arbre(mxGraph graph,Object parent)
	{
		//dessier noeud 
		  Arbre_Genialogique tmp3=this;
		  ArrayList<String> list_nom= new ArrayList<>();
		  ArrayList<Object> list_noeud=new ArrayList<>();
		  LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
		  q.addFirst(tmp3);
		 
		  
		 
		  while(!(q.isEmpty())) 
		  {
              tmp3 = q.getLast();
			  if(!(list_nom.contains(tmp3.prenom)))
			  {
			  Object v1 = graph.insertVertex(parent, null,tmp3.nom_de_famille+" "+tmp3.prenom, tmp3.posx,tmp3.posy, 80, 30);
			  if(!(list_nom.contains(tmp3.prenom))) list_nom.add(tmp3.prenom);
			  if(!(list_noeud.contains(v1))) list_noeud.add(v1);
			  }
			 
			  

			  q.removeLast();
		   if(tmp3.enfants.size() != 0)
		   {
			 
			 for (int i = 0; i < tmp3.enfants.size(); i++) 
			 {
			   q.addFirst(tmp3.enfants.get(i));
			 }
		   }
			 
			 
		  }
	
		  if(list_nom.size()>1)
		  {
			  
		  //dessiner arc
		  Arbre_Genialogique tmp1=this;
	
		  LinkedList<Arbre_Genialogique> q1= new LinkedList<Arbre_Genialogique>();
		  q1.addFirst(tmp1);
		  
		  while(!(q1.isEmpty())) 
		  {
             			  
			  tmp1 = q1.getLast();
			  int index = 0;
			  int index2=0;
			
			  for (int i4 = 0; i4 < list_nom.size(); i4++) {
			   	 if(list_nom.get(i4).equals(tmp1.prenom))  index = i4;
			  }
			  if(tmp1.enfants.size() != 0)
			  {
				  for (int i6 = 0; i6 < tmp1.enfants.size(); i6++) 
				  {
					  String prn = tmp1.enfants.get(i6).prenom;
					  for (int i8 = 0; i8 < list_nom.size(); i8++) {
						   	 if(list_nom.get(i8).equals(prn))  index2 = i8;
						  }
					  q1.addFirst(tmp1.enfants.get(i6));
					  graph.insertEdge(parent, null, i6,list_noeud.get(index), list_noeud.get(index2));
				  }
			  }
			  
			   q1.removeLast();
			 
		  }
		  }
		  
		return graph;
	}
	
	
	
	//attributs
	 String nom_de_famille;
	 String prenom;
     ArrayList<Arbre_Genialogique> enfants; 
     int posx,posy;
   
}
