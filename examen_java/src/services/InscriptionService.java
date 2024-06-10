package services;

import java.util.List;
import entities.Inscription;
import repositories.InscriptionRepository;

public class InscriptionService {
    InscriptionRepository inscriptionRepository=new InscriptionRepository();
    public void faireInscription(Inscription inscription){
        inscriptionRepository.insert(inscription);
    }
    public List<Inscription> rechercherInscriptionParAnnee(String anneeScolaire){
        return inscriptionRepository.selectAllInscriptions(anneeScolaire);
    }
    public List<Inscription> rechercherInscriptionParAnnee(String anneeScolaire,int idClasse){
        return inscriptionRepository.selectAllInscriptionsByAnneeScolaire(anneeScolaire,idClasse);
    }
    public  Inscription rechercherInscriptionParMatriculeEtudiant(String matricule){
        return inscriptionRepository.selectInscriptionByMatricule(matricule);
    }
    // public  Inscription rechercherInscriptionParMatriculeEtudiant1(String matricule){
    //     return inscriptionRepository.selectInscriptionByMatricule(matricule);
    // }
}
