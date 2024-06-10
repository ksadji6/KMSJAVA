package repositories;
import java.sql.ResultSet;
// import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// import java.util.ArrayList;
// import java.util.List;
import java.util.List;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;
// import entities.Classe;
// import entities.Niveau;
import entities.ProfClasse;

public class ProfClasseRepository extends Database {
    private final  String SQL_INSERT="INSERT INTO profclasse (id_classe,id_prof)  VALUES (?,?)";
    private final String SQL_FIND_CLASSES_BY_PROFESSEUR_ID = "SELECT c.* FROM classe c INNER JOIN profclasse p ON c.id_classe = p.id_classe WHERE p.id_prof=?";
  


   public void insert(ProfClasse profClasse){
    openConnexion();
    try {
        initPreparedStatement(SQL_INSERT);
        statement.setInt(1, profClasse.getClasse().getId());
        statement.setInt(2, profClasse.getProfesseur().getId());        
        executeUpdate();
       closeConnexion();
     } catch (SQLException e) {
      e.printStackTrace();
     }
     }


     public List<Classe> findClassesByProfesseurId(int id_prof) {
        List<Classe> classes = new ArrayList<>();
        try {
            openConnexion();
            initPreparedStatement(SQL_FIND_CLASSES_BY_PROFESSEUR_ID);
            statement.setInt(1, id_prof);
            ResultSet rs = executeSelect();
            if (rs != null) {
                while (rs.next()) {
                    Classe classe = new Classe();
                    classe.setId(rs.getInt("id_classe"));
                    int niveau=rs.getInt("niveau");
                    int filiere=rs.getInt("filiere");
                    classe.setNiveau(Niveau.values()[niveau]);
                    classe.setFiliere(Filiere.values()[filiere]);
                    classes.add(classe);
                }
            }        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
      }
}
