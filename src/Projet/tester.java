package Projet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		Manipulation m = new Manipulation();
		String tab[] = new String [10];
			try {
				BufferedReader lecture;
				lecture = new BufferedReader(new FileReader("pays.txt"));
				String l = lecture.readLine() ;
				String temp[] = l.split("\t") ;
				for (int i=0 ; i<temp.length;i++)
				{
					tab[i]=temp[i];
				}
				lecture.close();
			} catch (FileNotFoundException e1) {
				System.out.println("Fichier non trouv�");
			} catch (IOException e) {
				System.out.println("Lecture impossible");
			}


		String fonctionalite ="********************\tSyst�me de gestion des centres d'isolements\t********************\n\n"+"Note : Il suffit de tapez le num�ro correspondant au votre choix  (Tapez -1 pour echapper une op�ration )\n\n  "+
		"\t1/ Affecter des personnes\n\n"+"\t2/ Liste des personnes ayant termin�e leur p�riode d'isolement\n\n"+
		"\t3/ Liste de toutes les personnes qui habitent un centre d'isolement\n\n"+
		"\t4/ Ajouter un centre d'isolement\n\n"+
		"\t5/ Afficher tous les centres d'isolement d'un gouvernorat\n\n"+
		"\t6/ Afficher le pourcentage de contamination d'un centre\n\n"+
		"\t7/ Afficher le pourcentage de contamination d'un gouvernorat\n\n"+
		"\t8/ Enregistrer le d�part d'une personne\n\n"+
		"\t9/ Changer l'�tat de sant� d'une personne\n\n"+
		"\t10/ Afficher les personnes hospitalis�es\n\n"+
		"\t11/ Evaluer les services de votre centre d'isolement\n\n"+
		"\t12/ Demande d'un medecin disponible\n\n";
		System.out.println(fonctionalite);
		{
		boolean test = false;
		while (test==false)
		{       Scanner cl = new Scanner(System.in);
			int ad=0 ;
			boolean t =true ;
			while(t)
			{
				try {
					System.out.print("Choix :");
					 String adr = cl.nextLine();
					 ad=Integer.parseInt(adr);
					 t=false;

				}
				catch(Exception e)
				{
					t=true;
				}
			}


		while(ad==1) {
				boolean b =true ;
				System.out.println("combien de personne? et leur gouvernorat? :");
				System.out.println("\t -"+(tab[0])+"\t\t\t -"+(tab[1])+"\n\t -"+(tab[2])+"\t\t\t -"+(tab[3])+"\n\t -"+(tab[4])+"\t\t -"+(tab[5])+"\n\t -"+(tab[6])+"\t\t -"+(tab[7])+"\n\t -"+(tab[8])+"\t\t -"+(tab[9])+"\n");
				String nb ="" ;
				try {
				nb=cl.nextLine();
				int e=Integer.parseInt(nb);
				}
				catch(Exception e) {
					System.out.println("\nerreur de saisie veuillez r�essayer ");
					break ;
				}
				if(nb.equalsIgnoreCase("-1")|| nb.equalsIgnoreCase("0"))
				{
					b=false;
				}
				if(b==false) break ;
				String gouv ="" ;
				gouv =cl.nextLine();
				if(gouv.equalsIgnoreCase("-1"))
				{
					b=false;
				}
				if(b==false) break ;
				if(m.existe(gouv)) {
				m.Demande(Integer.parseInt(nb),gouv);
				b=false;
				}
				if(b==false) break ;
				}

		while(ad==2) {
			try {
				boolean b=true ;
			System.out.print("Donner la r�ference du centre � visualiser : ");
			String nb =cl.nextLine();
		    int ref =  Integer.parseInt(nb);
		    if(nb.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
		    if(m.existe(ref)) {
		    m.afficher(ref); b=false ;}
		    if(b==false) break ;
			}catch(Exception e) {
			System.out.println("\nerreur de saisie, veuillez r�essayer  ");
		}
		}
		while(ad==3) {
			try {
				boolean b=true ;
			System.out.print("Donner la r�ference du centre � visualiser : ");
			String nb =cl.nextLine();
		    int ref =  Integer.parseInt(nb);
		    if(nb.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
		    if(m.existe(ref)) {
		    m.afficher_personnes(ref);
		    b=false ;} if (b==false) break;
		    }catch(Exception e) {
			System.out.println("\nerreur de saisie veuillez r�essayer \n ");
		}


		}
		while(ad==4) {
		boolean b = true ;
		System.out.println("\t -"+(tab[0])+"\t\t\t -"+(tab[1])+"\n\t -"+(tab[2])+"\t\t\t -"+(tab[3])+"\n\t -"+(tab[4])+"\t\t -"+(tab[5])+"\n\t -"+(tab[6])+"\t\t -"+(tab[7])+"\n\t -"+(tab[8])+"\t\t -"+(tab[9])+"\n");
		System.out.print("Dans quel gouvernorat? : ");
		String gouv =cl.nextLine();
		if(gouv.equalsIgnoreCase("-1"))
		{
			b=false;
		}
		if(b==false) break ;
		if(m.existe(gouv)) {
		m.ajouter_centre(gouv);
		ad=0 ;
		}


		}while(ad==5) {
			boolean b=true ;
			System.out.println("\t -"+(tab[0])+"\t\t\t -"+(tab[1])+"\n\t -"+(tab[2])+"\t\t\t -"+(tab[3])+"\n\t -"+(tab[4])+"\t\t -"+(tab[5])+"\n\t -"+(tab[6])+"\t\t -"+(tab[7])+"\n\t -"+(tab[8])+"\t\t -"+(tab[9])+"\n");
			System.out.print("De quel gouvernorat? : ");
			String g =cl.nextLine();
			if(g.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
			if(m.existe(g)) {
			m.afficher_centres(g); ad=0 ;}

		}while(ad==6) {try {
			boolean b=true ;
			System.out.print("Donner la r�ference du centre : ");
			String nb =cl.nextLine();
		    int ref =  Integer.parseInt(nb);
		    if(nb.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
		    if(m.existe(ref)) {
		    m.statistiques_centre(ref); b=false ;}
		    if(b==false) break ;

		}catch(Exception e) {
			System.out.println("\nerreur de saisie veuillez r�essayer  ");
			ad=6 ;
		}
		}


		while(ad==7) {
			boolean b =true ;
			System.out.println("\t -"+(tab[0])+"\t\t\t -"+(tab[1])+"\n\t -"+(tab[2])+"\t\t\t -"+(tab[3])+"\n\t -"+(tab[4])+"\t\t -"+(tab[5])+"\n\t -"+(tab[6])+"\t\t -"+(tab[7])+"\n\t -"+(tab[8])+"\t\t -"+(tab[9])+"\n");
			System.out.print("Donner le gouvernorat : ");
			String gouv =cl.nextLine();
			if(gouv.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
			if(m.existe(gouv)) {
			m.statistiques_gouv( gouv);
			ad=0 ;}





		}while(ad==8) {
			boolean b=true; int ref=0 ; long cin=0 ;
			try {
			System.out.print("Donner son num�ro de cin :");
			String c =cl.nextLine();
		    cin =  Long.parseLong(c);
		    if(c.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
		    System.out.print("Donner la r�ference du centre auquel elle appartient :");
		    String nbre =cl.nextLine();
		    ref =  Integer.parseInt(nbre);
		    if(nbre.equalsIgnoreCase("-1"))
			{
				b=false;
			}}
			catch(Exception e) {
				System.out.println("\nerreur de saisie veuillez r�essayer \n ");
			break;
		}

			if(b==false) break ;
	        if(m.existe_centre_cin(ref,cin)) {
		    m.supprimer_personne(cin, ref);
		    b=false ;

	}
	if(b==false) break ;
	}

			while(ad==9) {
			try {
				boolean b=true ;
				System.out.print("Donner son num�ro de cin :"); 
				String ci =cl.nextLine();
			    long cin =  Long.parseLong(ci);
			    if(ci.equalsIgnoreCase("-1"))
				{
					b=false;
				}
				if(b==false) break ;
			    System.out.println("Taper: 0 si en bonne sant� ou la contamination n'est pas confirm�e\n 1  si situation normale (corona) \n 2 si malade (situation grave (corona))");
			    String et =cl.nextLine();
			    int etat =  Integer.parseInt(et);
			    if(etat!=0 && etat!=1 && etat!=2) throw new Err();
			    if(et.equalsIgnoreCase("-1"))
				{
					b=false;
				}
				if(b==false) break ;
			    System.out.print("Donner la r�ference du centre : ");
		        String nbre =cl.nextLine();	
			    int ref =  Integer.parseInt(nbre);
			    if(nbre.equalsIgnoreCase("-1"))
				{
					b=false;
				}
				if(b==false) break ;
			    if(m.existe_centre_cin(ref,cin))
		        {m.changer_sante(cin,etat,ref);
			    System.out.println("La mise � jour est bien enregistr�e");
			    b=false;}
			    if(b==false) break ;
		}
		catch (Err e)
			{
			System.out.println("La r�ponse doit etre 0 , 1 ou 2"); 
			}
		
		catch(Exception e) {
			System.out.println("\nerreur de saisie veuillez r�essayer \n ");
			ad=9;

	}
			
		}while(ad==10) {
			try {
				boolean b= true ;
				System.out.print("Donner la r�ference du centre � visualiser : ");
				 String nbre =cl.nextLine();
				    int ref =  Integer.parseInt(nbre);
				    if(nbre.equalsIgnoreCase("-1"))
					{
						b=false;
					}
					if(b==false) break ;
				    if(m.existe(ref)) {
			    m.hospitalisees(ref);
			    b=false ;}
				    if(b==false) break ;
			}catch(Exception e) {
				System.out.println("\nerreur de saisie veuillez r�essayer \n ");
				ad=10;
			}

		}while(ad==11) {
			try {
				boolean b= true ;
				System.out.print("Donner la r�ference du centre auquel elle appartient : ");
				 String nbre =cl.nextLine();
				  int ref =  Integer.parseInt(nbre);
				  if(nbre.equalsIgnoreCase("-1"))
					{
						b=false;
					}
					if(b==false) break ;
				  if(m.existe(ref)) {
			    m.evaluation(ref);
			    b=false ;}
				  if(b==false) break ;
			}catch(Exception e) {
				System.out.println("\nerreur de saisie veuillez r�essayer \n ");
			}
		}while(ad==12) {
			boolean b = true ;
			System.out.println("\t -"+(tab[0])+"\t\t\t -"+(tab[1])+"\n\t -"+(tab[2])+"\t\t\t -"+(tab[3])+"\n\t -"+(tab[4])+"\t\t -"+(tab[5])+"\n\t -"+(tab[6])+"\t\t -"+(tab[7])+"\n\t -"+(tab[8])+"\t\t -"+(tab[9])+"\n");
			System.out.print("Dans quel gouvernorat? : ");
			String gouv =cl.nextLine();
			if(gouv.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
			if(m.existe(gouv)) {
				System.out.println("Choisissez La Sp�cialit� voulue\n\t1)Geriatrie\n\t2)Urgence\n\t3)pneumologie\n\t4)R�animation\n\t5)P�diatrie");
				ad=0;
			String z = cl.nextLine();
			int sp=Integer.parseInt(z);
			if(z.equalsIgnoreCase("-1"))
			{
				b=false;
			}
			if(b==false) break ;
			if(sp==1)
				m.Demande_docteur("g�riatrie",gouv);
			if(sp==2)
				m.Demande_docteur("urgence",gouv);
			if(sp==3)
					m.Demande_docteur("pneumologie",gouv);
			if(sp==5)
				m.Demande_docteur("P�diatrie",gouv);
				if(sp==4)
					m.Demande_docteur("R�animation",gouv);

			}



		}



	//retour au menu principal
		boolean b=true ;
		while(b)
		{
			try {
			System.out.print("\nTaper 0 pour retourner au menu principal et 1 pour quitter : ");
			String r = cl.nextLine();
			int retour = Integer.parseInt(r);
			if(retour==0) {System.out.println(fonctionalite); b=false;}
			  else if(retour==1) {b=false;System.exit(-1); cl.close();}}
			catch (Exception e)
			{
				b=true;
			}
		}

		}

	}
	}

	}
