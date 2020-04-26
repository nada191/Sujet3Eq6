package Projet;
	import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;

	public class Personne_concernee {
	    private Calendar date_arrivee;
	    private String nom, prenom;
	    private long num_cin;
	    private int etat_sante;
	    private Calendar date_depart;

	    Personne_concernee(String nom, String prenom, long num_cin, int etat_sante, Calendar date_arrivee) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.num_cin = num_cin;
	        this.etat_sante = etat_sante;
	        this.date_arrivee = date_arrivee;
	    }
	    public long getNum_cin() {
	    	return num_cin;
	    }
	    public String getNom() {
	    	return nom;
	    }
	    public String getPrenom() {
	    	return prenom;
	    }
	    public void setEtat_sante(int val){
	        etat_sante = val;
	    }
	    public int getEtat_sante() {
	    	return etat_sante; /* (en bonne santé(0) || malade (situation grave (corona)(1) || situation normale (corona)(2) || autre maladie(3)) */
	    }
	    public void setDate_depart(Calendar d){
	    	date_depart = d;
	    }
	    public Calendar getDate_depart() {
	    	return date_depart;
	    }
	    public Calendar getDate_arrivee() {
	    	return date_arrivee;
	    }
	    public  void set_d_depart()
	    {
	    	Calendar auj = Calendar.getInstance() ;
	    	date_depart=auj.getInstance();
	    }
	    public boolean fin_confinement(){
	    	Calendar auj = Calendar.getInstance();
	    	int mois = auj.get(auj.MONTH)+1 ;
	    	int jour = auj.get(auj.DATE) ;
	    	int annee = auj.get(auj.YEAR);
	    	Calendar d = date_arrivee ;
	    	d.add(Calendar.DATE,14);
	    	int moisd = d.get(Calendar.MONTH) ; 
	    	int jourd = d.get(Calendar.DATE) ;
	    	int anneed = d.get(Calendar.YEAR);	
	    	d.add(Calendar.DATE,-14);
	    	return (mois==moisd && jour==jourd && annee==anneed);
	    	
	    }
	    public void afficher_personne()
	    {
	    	int m = date_arrivee.get(Calendar.MONTH) ; 
	    	int j = date_arrivee.get(Calendar.DATE) ;
	    	int a = date_arrivee.get(Calendar.YEAR);
	    	System.out.println("Nom : "+nom+" Prenom : "+prenom+" N°cin : "+num_cin+" Etat de santé :"+etat_sante+" Date d'arrivé : "+ j+"/"+m+"/"+a) ;
	    }
	    

	}
