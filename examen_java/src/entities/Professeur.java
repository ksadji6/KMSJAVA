package entities;

import java.util.List;

public class Professeur {
    private int id; 
    private int nci;
    public int getNci() {
        return nci;
    }
    public void setNci(int nci) {
        this.nci = nci;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String nomComplet; 
    private String grade;
    List<ProfClasse> profClasses;
    public List<ProfClasse> getProfClasses() {
        return profClasses;
    }
    public void setProfClasses(List<ProfClasse> profClasses) {
        this.profClasses = profClasses;
    }
    public Professeur() {
    }
    
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    } 
}
