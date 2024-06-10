package services;
import entities.Etudiant;
import repositories.EtudiantRepository;

public class EtudiantService {
    EtudiantRepository etudiantRepository=new EtudiantRepository();
    public void ajouterEtudiant(Etudiant etudiant){
        etudiantRepository.insert(etudiant);
    }
    
    /*public  List<Etudiant>listerEtudiants(){
    
        return etudiantRepository.selectAllEtudiants();
    }*/
}
