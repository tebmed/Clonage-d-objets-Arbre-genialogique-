import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;


public class Test extends JFrame{
	
	 public Test()
	 {  
		 this.setLayout(null);
		
		 p1 = new JPanel();
		 p1.setLayout(null); 
		
		 p2 = new JPanel();
		 p2.setLayout(null);
		
		 b_clone = new JButton("Cloner ");
         b_clone.setBounds(575,220,150,200);
        
		p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		p1.setBounds(1, 1, 550, 550);
		p2.setBounds(748,1 ,550, 550);
		
		p1.setBackground(Color.pink);
		p2.setBackground(Color.pink);
		
		lnom = new JLabel("Nom : ");
		lnom.setBounds(60, 560,80,50);
		this.add(lnom);
		
		lnom1 = new JLabel("Nom : ");
		lnom1.setBounds(808, 560,80,50);
		this.add(lnom1);
		
		
		tnom = new JTextField();
		tnom.setBounds(130,572,120,30);
		this.add(tnom);
		
		tnom1 = new JTextField();
		tnom1.setBounds(878,572,120,30);
		this.add(tnom1);
		
		
		lprenom = new JLabel("Prenom : ");
		lprenom.setBounds(60,600,80,50);
		this.add(lprenom);
		
		lprenom1 = new JLabel("Prenom : ");
		lprenom1.setBounds(808,600,80,50);
		this.add(lprenom1);
		
		tprenom = new JTextField();
		tprenom.setBounds(130,612,120,30);
		this.add(tprenom);
		
		tprenom1 = new JTextField();
		tprenom1.setBounds(878,612,120,30);
		this.add(tprenom1);
		
		lpere = new JLabel("père :");
		lpere.setBounds(60,640,80,50);
		this.add(lpere);
     
		lpere1 = new JLabel("père :");
		lpere1.setBounds(808,640,80,50);
		this.add(lpere1);

		tpere = new JTextField();
		tpere.setBounds(130,652,120,30);
		this.add(tpere);
		
		tpere1 = new JTextField();
		tpere1.setBounds(878,652,120 ,30);
		this.add(tpere1);
		
		b_ajoutet1 = new JButton("Ajouter");
		b_ajoutet1.setBounds(290,612,120,30);
		this.add(b_ajoutet1);
		
		
		b_ajoutet1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			    
				p1.removeAll();
				p1.validate();
			    String nom = tnom.getText().trim();
				String prenom = tprenom.getText().trim();
				String pére = tpere.getText().trim();
			
				Arbre_Genialogique  a = new Arbre_Genialogique(nom, prenom);
				if(a1 != null )
				{
			     if(pére.equals(""))
			     {
			    	 try {
						JOptionPane p6 = new JOptionPane();   
					    p6.showMessageDialog(p1,"vous devez saisir le prenom du père ! ","attention",JOptionPane.ERROR_MESSAGE);
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     }
			     else
			     {
			      
			     	Arbre_Genialogique p = a1.trouver_pere(pére);
			     	//System.out.println(p.prenom);
			     	int x = p.enfants.size();
			     	if(x==0)
			     	{
			     	a.posx=p.posx-100;
			     	a.posy =p.posy+80;
			     	}
			     	if(x==1)
			     	{
			     	 a.posx=p.posx;
				     a.posy =p.posy+80;	
			     	}
			     	if(x==2)
			     	{
			     	 a.posx=p.posx+100;
				     a.posy =p.posy+80;	
			     	}

			     	p.ajouter_enfant(a);
			     	
			     }
				}
				else
				{
					a.posx=200;
					a.posy=10;
					a1=a;
				}
				tnom.setText(" ");
				tprenom.setText(" ");
			    tpere.setText(" ");
			    
			    graph = a1.dessiner_arbre(graph,parent);
			    graphComponent = new mxGraphComponent(graph);
			    graphComponent.setBounds(1, 1, 550, 550);
			    p1.revalidate();
			    repaint();
				p1.add(graphComponent);
				
				
			}
		});
		
		b_ajoutet2 = new JButton("Ajouter");
		b_ajoutet2.setBounds(1030,612,120,30);
		this.add(b_ajoutet2);
		
		b_ajoutet2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				
				p2.removeAll();
				p2.validate();
			    String nom1 = tnom1.getText().trim();
				String prenom1 = tprenom1.getText().trim();
				String pére1 = tpere1.getText().trim();
				
				Arbre_Genialogique a4 = new Arbre_Genialogique(nom1, prenom1);
				if(a2 != null)
				{
					if(pére1.equals(""))
				     {
				    	 try {
							JOptionPane p7 = new JOptionPane();   
						    p7.showMessageDialog(p2,"vous devez saisir le prenom du père ! ","attention",JOptionPane.ERROR_MESSAGE);
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     }
					else
					{
			
					 Arbre_Genialogique p4 = a2.trouver_pere(pére1);
					 int x1 = p4.enfants.size();	 
			     	 if(x1==0)
			     	 {
			     	  a4.posx=p4.posx-100;
			     	  a4.posy =p4.posy+80;
			     	
			     	 }
			     	 if(x1==1)
			     	 {
			     	  a4.posx=p4.posx;
				      a4.posy =p4.posy+80;	
			     	 }
			     	 if(x1==2)
			     	 {
			     	  a4.posx=p4.posx+100;
				      a4.posy=p4.posy+80;	
			     	 }
			     	 p4.ajouter_enfant(a4);
					}
				 }
				
				
				tnom1.setText(" ");
				tprenom1.setText(" ");
			    tpere1.setText(" ");
			    
			    graph1 = a2.dessiner_arbre(graph1,parent1);
			    graphComponent1 = new mxGraphComponent(graph1);
			    graphComponent1.setBounds(1, 1, 550, 550);
		        p2.revalidate();
			    repaint();
				p2.add(graphComponent1);
			
			}
		});
		
        b_clone.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
			  p2.removeAll();
			  p2.validate();	
			 try {
				 a2 = (Arbre_Genialogique) a1.clone();
			    } catch (CloneNotSupportedException e)
			    {
				 e.printStackTrace();
			    }
		      graphk= a2.dessiner_arbre(graphk,parentk);
			  graphComponentk = new mxGraphComponent(graphk);
		      graphComponentk.setBounds(1, 1, 550, 550);
		      p2.revalidate();
		      repaint();
			  p2.add(graphComponentk);
			}
		});
	    
		this.add(b_clone);
	    this.add(p1);
	    this.add(p2);
	    this.setSize(1300, 800);
		this.setVisible(true); 
	 }
	
	 public static void main(String [] args)
	 {
		 new Test();
	 }
	 
	 //attributs
	 Arbre_Genialogique  a1 = null;
	 Arbre_Genialogique  a2 = null;
	 mxGraph graph = new mxGraph();
	 Object parent = graph.getDefaultParent();
	 mxGraph graph1 = new mxGraph();
	 Object parent1 = graph1.getDefaultParent();
	 mxGraph graphk = new mxGraph();
	 Object parentk = graphk.getDefaultParent();
	
	 mxGraphComponent graphComponent,graphComponent1,graphComponentk;
	 JPanel p1,p2;
	 JButton b_clone,b_ajoutet1,b_ajoutet2;
	 JLabel lnom,lprenom,lpere,lnom1,lprenom1,lpere1;
	 JTextField tnom,tprenom,tpere,tnom1,tprenom1,tpere1;
}
