import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


public class Test extends JFrame {
	
	public Test(){ 
		liste_des_familles = new ArrayList<Famille>();
		this.setLayout(null);
		p1= new JPanel();
		p1.setLayout(null);
		p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p1.setBounds(20, 1, 400, 300);
		p1.setBackground(Color.pink);
		this.add(p1);
		
		bclone_1 = new JButton();
		bclone_1.setText("cloner");
		bclone_1.setBounds(150, 310, 100, 30);
		this.add(bclone_1);
		
		p1c= new JPanel();
		p1c.setLayout(null);
		p1c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p1c.setBounds(20, 345, 400, 300);
		p1c.setBackground(Color.pink);
		this.add(p1c);
		
		p2= new JPanel();
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p2.setBounds(450, 1, 400, 300);
		p2.setBackground(Color.pink);
		this.add(p2);
		
		bclone_2 = new JButton();
		bclone_2.setText("cloner");
		bclone_2.setBounds(600, 310, 100, 30);
		this.add(bclone_2);
		
		p2c= new JPanel();
		p2c.setLayout(null);
		p2c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p2c.setBounds(450, 345, 400, 300);
		p2c.setBackground(Color.pink);
		this.add(p2c);
		
		p3= new JPanel();
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p3.setBounds(880, 1, 400, 300);
		p3.setBackground(Color.pink);
	    this.add(p3);
		
		bclone_3 = new JButton();
		bclone_3.setText("cloner");
		bclone_3.setBounds(1030, 310, 100, 30);
		this.add(bclone_3);
		
		p3c= new JPanel();
		p3c.setLayout(null);
		p3c.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p3c.setBounds(880, 345, 400, 300);
		p3c.setBackground(Color.pink);
	    this.add(p3c);
	    
	    l_nom = new JLabel("Nom :");
	    l_nom.setBounds(100,670,80,50);
		this.add(l_nom);
	    
	    tf_nom = new JTextField();
	    tf_nom.setBounds(160,680,150,30);
	    this.add(tf_nom);
	    
	    l_prenom= new JLabel("Prenom :");
	    l_prenom.setBounds(400,670,80,50);
		this.add(l_prenom);
	    
	    tf_prenom = new JTextField();
	    tf_prenom.setBounds(480,680,150,30);
	    this.add(tf_prenom);
	    
	    l_père= new JLabel("Pére :");
	    l_père.setBounds(750,670,80,50);
		this.add(l_père);
	    
	    tf_père = new JTextField();
	    tf_père.setBounds(810,680,150,30);
	    this.add(tf_père);
	    
	    b_ajouter_person = new JButton("Ajouter");
	    b_ajouter_person.setBounds(1100,680,100,30);
	    this.add(b_ajouter_person);
	    
	    b_ajouter_person.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom = tf_nom.getText().trim();
	            String prenom = tf_prenom.getText().trim();
	            String père = tf_père.getText().trim();
	      
	            boolean exist = false;
	            int i=0;
	            for (i=0; i < liste_des_familles.size(); i++) {
					if(liste_des_familles.get(i).nom_de_famille.equals(nom))
					{
					  System.out.println(liste_des_familles.get(i));
					  exist = true;
					  break;
					}
				}
	            if(!exist)
	            {
	            	Famille f = new Famille(nom);
	 	            liste_des_familles.add(f);
	            }
	           
	          if(i==0) 
	          {
	        	p1.removeAll();
				p1.validate();
	            liste_des_familles.get(i).ajouter_personne(prenom,père);
	            liste_des_familles.get(i).affichage();
	            System.out.println(liste_des_familles.get(i));
	            lfamille1 = new JLabel(liste_des_familles.get(i).nom_de_famille);
	            lfamille1.setBounds(5, 5, 120, 20);
	            lfamille1.setForeground(Color.red);
	            lfamille1.setFont(lfamille1.getFont().deriveFont(22.0f));
	            p1.add(lfamille1);
	            
	            graph1 = new mxGraph();
	            parent1 = graph1.getDefaultParent();
	            
	            graph1 = liste_des_familles.get(i).dessiner_arbre(graph1,parent1);
	            graphComponent1 = new mxGraphComponent(graph1);
			    graphComponent1.setBounds(1, 1, 550, 550);
			    p1.revalidate();
			    repaint();
				p1.add(graphComponent1);
	          }
	          else if(i==1) 
	               {
	        	     p2.removeAll();
				     p2.validate();
	                 liste_des_familles.get(i).ajouter_personne(prenom,père);
	                 liste_des_familles.get(i).affichage();
	                 System.out.println(liste_des_familles.get(i));
	                 lfamille2 = new JLabel(liste_des_familles.get(i).nom_de_famille);
	 	             lfamille2.setBounds(5, 5, 100, 20);
	 	             lfamille2.setForeground(Color.red);
		             lfamille2.setFont(lfamille2.getFont().deriveFont(22.0f));
	 	             p2.add(lfamille2);
	 	             
	 	             graph2 = new mxGraph();
	 	             parent2 = graph2.getDefaultParent();
	                 graph2 = liste_des_familles.get(i).dessiner_arbre(graph2,parent2);
	                 
	                 graphComponent2 = new mxGraphComponent(graph2);
			         graphComponent2.setBounds(1, 1, 550, 550);
			         p2.revalidate();
			         repaint();
				     p2.add(graphComponent2);
	               }
	               else if(i==2) 
                        {
       	                  p3.removeAll();
			              p3.validate();
                          liste_des_familles.get(i).ajouter_personne(prenom,père);
                          liste_des_familles.get(i).affichage();
                          System.out.println(liste_des_familles.get(i));
                          lfamille3 = new JLabel(liste_des_familles.get(i).nom_de_famille);
          	              lfamille3.setBounds(5, 5, 100, 20);
          	              lfamille3.setForeground(Color.red);
        	              lfamille3.setFont(lfamille3.getFont().deriveFont(22.0f));
          	              p3.add(lfamille3);
                          graph3 = liste_des_familles.get(i).dessiner_arbre(graph3,parent3);
                          graphComponent3 = new mxGraphComponent(graph3);
		                  graphComponent3.setBounds(1, 1, 550, 550);
		                  p3.revalidate();
		                  repaint();
			              p3.add(graphComponent3);
                        }
	          tf_prenom.setText("  ");
              tf_nom.setText("  ");
              tf_père.setText("  ");
			}	
		});
	
	    bclone_1.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent arg0) {
				Famille f1c = null;
				p1c.removeAll();
				p1c.validate();
			    try 
			    {
				  f1c = (Famille) liste_des_familles.get(0).clone();
			    } catch (CloneNotSupportedException e)
			    {
				 e.printStackTrace();
			    }
			 
		     graph1c= f1c.dessiner_arbre(graph1c,parent1c);
			 graphComponent1c = new mxGraphComponent(graph1c);
		     graphComponent1c.setBounds(1, 1, 550, 550);
		     p1c.revalidate();
		     repaint();
			 p1c.add(graphComponent1c);
			}
		});
	    
	    bclone_2.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent arg0) {
				Famille f2c = null;
				p2c.removeAll();
				p2c.validate();
			    try 
			    {
				  f2c = (Famille) liste_des_familles.get(1).clone();
			    } catch (CloneNotSupportedException e)
			    {
				 e.printStackTrace();
			    }
			 
		     graph2c= f2c.dessiner_arbre(graph2c,parent2c);
			 graphComponent2c = new mxGraphComponent(graph2c);
		     graphComponent2c.setBounds(1, 1, 550, 550);
		     p2c.revalidate();
		     repaint();
			 p2c.add(graphComponent2c);
			}
		});
	    
	    bclone_3.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent arg0) {
				Famille f3c = null;
				p3c.removeAll();
				p3c.validate();
			    try 
			    {
				  f3c = (Famille) liste_des_familles.get(2).clone();
			    } catch (CloneNotSupportedException e)
			    {
				 e.printStackTrace();
			    }
			 
		     graph3c= f3c.dessiner_arbre(graph3c,parent3c);
			 graphComponent3c = new mxGraphComponent(graph3c);
		     graphComponent3c.setBounds(1, 1, 550, 550);
		     p3c.revalidate();
		     repaint();
			 p3c.add(graphComponent3c);
			}
		});
	    
	    
	    this.setResizable(true);
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	public static void main(String args[]){
		new Test();
	}
	
	 //les attributs
	 JPanel p1,p2,p3,p1c,p2c,p3c;
	 JButton bclone_1,bclone_2,bclone_3,b_ajouter_person;
	 JLabel l_nom, l_prenom , l_père , lfamille1, lfamille2 , lfamille3;
	 JTextField tf_nom,tf_prenom,tf_père;
	
	 mxGraph graph1,graph2;
	 Object parent1,parent2;
	 mxGraphComponent graphComponent1,graphComponent2,graphComponent3,graphComponent1c,graphComponent2c,graphComponent3c;
	 
	 
	
	 
	 mxGraph graph3 = new mxGraph();
	 Object parent3 = graph3.getDefaultParent();
	 
	 
	 mxGraph graph1c = new mxGraph();
	 Object parent1c = graph1c.getDefaultParent();
	
	 mxGraph graph2c = new mxGraph();
	 Object parent2c = graph2c.getDefaultParent();
	 mxGraph graph3c = new mxGraph();
	 Object parent3c = graph3c.getDefaultParent();
	 ArrayList<Famille> liste_des_familles;	 	
}
