package entities;
import java.util.List;

public class Classe {
    private int id;
    private Filiere filiere;
    private Niveau niveau;
    List<Inscription> inscriptions;
    List<ProfClasse> profClasses;
    
    public List<ProfClasse> getProfClasses() {
        return profClasses;
    }
    public void setProfClasses(List<ProfClasse> profClasses) {
        this.profClasses = profClasses;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
    public Niveau getNiveau() {
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
