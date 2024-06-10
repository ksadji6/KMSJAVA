package services;
import java.util.List;

import entities.Classe;
import entities.ProfClasse;
import entities.Professeur;
import repositories.ProfClasseRepository;
import repositories.ProfesseurRepository;

public class ProfesseurService{
    ProfesseurRepository professeurRepository=new ProfesseurRepository();
    ProfClasseRepository profClasseRepository=new ProfClasseRepository();
    //ProfesseurService professeurService= new ProfesseurService();
    public void ajouterProfesseur(Professeur professeur){
        professeurRepository.insert(professeur);
        Professeur lastProfesseur= professeurRepository.selectLastProfesseur();
        List<ProfClasse> profClasse=professeur.getProfClasses();
        for(ProfClasse pc:profClasse){
            pc.setProfesseur(lastProfesseur);
            profClasseRepository.insert(pc);
            }

        }
         public  List<Professeur>listerProfesseurs(){
    
        return professeurRepository.selectAllProfesseurs();
    }
    
public List<Classe> getClassesByProfesseurId(int id_prof) {
      return profClasseRepository.findClassesByProfesseurId(id_prof);
}
}


