import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.mxgraph.view.mxGraph;

public class Famille  implements Cloneable{
	
   public Famille(String nom){
    this.nom_de_famille=nom;
	this.a = null;
   }
		
	//clone method
   public Object clone() throws CloneNotSupportedException{
      Famille tmp = (Famille)super.clone();
	  try{
	     tmp.a = (Arbre_Genialogique) this.a.clone();
	  } 
	  catch (Exception e){	
	     e.printStackTrace();
	  }
	  return tmp;
	}
	
	public void affichage(){
	   System.out.println("        Nom de Famille : "+this.nom_de_famille);
	 //  this.a.affichage();
	}
	
	public void ajouter_personne(String pr,String pére){
		
       Arbre_Genialogique personne = new Arbre_Genialogique(pr);
	   Arbre_Genialogique  tmp = this.a;
	   
	   if(tmp != null){   
	      Arbre_Genialogique p = tmp.trouver_pere(pére);
	      int x = p.enfants.size();
	      if(x==0){
	         personne.posx=p.posx-70;
	     	 personne.posy =p.posy+55;
	      }
	      if(x==1){
	         personne.posx=p.posx;
	    	 personne.posy =p.posy+55;	
	      }
	      if(x==2){
	    	 personne.posx=p.posx+70;
	    	 personne.posy =p.posy+55;	
	      }
	         p.ajouter_enfant(personne);
	   }
	   else{
	      personne.posx=180;
		  personne.posy=10;
	      this.a=personne;
	   }
		
	}
	
	public mxGraph dessiner_arbre(mxGraph gr,Object par){
	    return this.a.dessiner_arbre(gr,par);
	}
	
	class Arbre_Genialogique implements Cloneable{		
	
	    public Arbre_Genialogique(String prenom){		
		    this.prenom = prenom;
			this.enfants = new ArrayList();
		}
		
		public Arbre_Genialogique trouver_pere(String prenom){   
		    Arbre_Genialogique tmp=this;
			LinkedList<Arbre_Genialogique> q = new LinkedList<Arbre_Genialogique>();
			q.addFirst(tmp);
			while(!(q.isEmpty())){
	            tmp = q.getLast();
				if(tmp.prenom.equals(prenom)){
				   break; 
				}
				else{
				    for (int i = 0; i < tmp.enfants.size(); i++){	
					    q.addFirst(tmp.enfants.get(i));
				    }
				    q.removeLast();
				}
				 
			}
			return tmp;
	    }
		
		//clone methode
		public Object clone() throws CloneNotSupportedException{
            Arbre_Genialogique tmp = (Arbre_Genialogique) super.clone();
			ArrayList<Arbre_Genialogique> s = new ArrayList<>();
			//deep copy
	        try{ 
	            //tmp.enfants = (ArrayList<Arbre_Genialogique>) this.enfants.clone();
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
		public void ajouter_enfant(Arbre_Genialogique enfant){  
	      this.enfants.add(enfant); 	
		}

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
				  Object v1 = graph.insertVertex(parent, null,tmp3.prenom,tmp3.posx,tmp3.posy, 50, 25);
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
				
				  for (int i4 = 0; i4 < list_nom.size(); i4++) 
				  {
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
	    String prenom;
	    int posx,posy;
	    public ArrayList<Arbre_Genialogique> enfants;
	 }

	//attributs
	String nom_de_famille;
    Arbre_Genialogique a;
}
