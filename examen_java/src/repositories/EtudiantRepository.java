package repositories;
import java.sql.SQLException;
import entities.Etudiant;

public class EtudiantRepository extends Database {
    private final  String SQL_INSERT="INSERT INTO `etudiant` (`matricule`, `nomcomplet`, `tuteur`) VALUES (?,?,?)";
   
    public void insert(Etudiant etudiant){
        try {
          openConnexion();
          initPreparedStatement(SQL_INSERT);
        statement.setString(1, etudiant.getMatricule());
          statement.setString(2, etudiant.getNomComplet());
          statement.setString(3, etudiant.getTuteur());
          executeUpdate();
        } 
         catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
        }
        }

        

}
