package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne{
	public int niveau;
        public ArrayList<Licence> lesLicences = new ArrayList<> ();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }
        
        public void ajouterLicence (String numero, LocalDate delivrance, Club club) {
            Personne p = new Personne(numeroINSEE, nom, prenom, adresse, telephone, naissance);
            Licence l = new Licence(p, numero, delivrance, club);
            lesLicences.add(l);
        }
        
        public Licence derniereLicence(){
            Licence l = lesLicences.get(lesLicences.size()-1);
            return l;
        }
}
