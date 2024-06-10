package services;
import entities.Professeur;
import repositories.ResponsablePedaRepository;

public class ResponsablePedaService {
     ResponsablePedaRepository responsablePedaRepository=new ResponsablePedaRepository();
    
    public void ajouterProfesseur(Professeur professeur){
        responsablePedaRepository.insert(professeur);
    }
    
    /*public  List<Professeur>listerProfesseurs(){
    
        return responsablePedaRepository.selectAllProfesseur();
    }
    
    public List<Classe> filtrerClassesProfesseur (Professeur professeur){
        return responsablePedaRepository.selectClasseParProfesseur(professeur);
    }*/
}
