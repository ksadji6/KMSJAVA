package services;

import java.util.List;

import entities.Classe;
import repositories.ClasseRepository;

public class ClasseService {
    ClasseRepository classeRepository=new ClasseRepository();
    public void ajouterClasse(Classe classe){
        classeRepository.insert(classe);
    }
    public  Classe findClasseById(int id){
        return classeRepository.selectClasseById(id);
    }
    public  List<Classe>listerClasses(){
    
        return classeRepository.selectAllClasses();
    }

}
