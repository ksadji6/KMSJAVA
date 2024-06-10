package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository extends Database {
   private final  String SQL_INSERT="INSERT INTO `inscription` (`id`, `anneeScolaire`, `matricule`,`id_classe`) VALUES (?,?,?,?)";
   private final  String SQL_SELECT_BY_MATRICULE="Select * from inscription where matricule like ? " ;
   private final  String SQL_SELECT_ALL="SELECT * FROM inscription i, etudiant e where i.matricule=e.matricule and i.anneeScolaire like ?" ;
   private final  String SQL_SELECT_ALL_BY_ANNEE_CLASSE="SELECT * FROM inscription i, etudiant e where i.matricule=e.matricule and i.anneeScolaire like ? and i.id_classe like ?" ;
   
    public void insert(Inscription inscription){
        try {
          openConnexion();
          initPreparedStatement(SQL_INSERT);
        statement.setInt(1, inscription.getId());
          statement.setString(2, inscription.getAnneeScolaire());
          statement.setString(3, inscription.getEtudiant().getMatricule());
          statement.setInt(4, inscription.getClasse().getId());
          executeUpdate();
        } 
         catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
        }
        }

        public Etudiant selectEtudiantByMatricule(String matricule){
            Etudiant etudiant=null;
            try {
                openConnexion();
                initPreparedStatement(SQL_SELECT_BY_MATRICULE);
                statement.setString(1, matricule);
                ResultSet rs= executeSelect();
                if (rs.next()) {
                   //Une ligne ==> rs de la requete
                    etudiant= new Etudiant();
                    etudiant.setMatricule(rs.getString("id_etudiant"));
                    etudiant.setNomComplet(rs.getString("nomcomplet"));
                    etudiant.setTuteur(rs.getString("tuteur"));
                }
                statement.close();
                rs.close();
                conn.close();
           } 
           catch (SQLException e) {
             System.out.println("Erreur de Connexion a la BD");
           }
               return etudiant;
          }
          
         public List<Inscription> selectAllInscriptions(String anneeScolaire){
          List<Inscription> inscriptions=new ArrayList<>() ;
           try {
             openConnexion();
             initPreparedStatement(SQL_SELECT_ALL);
             statement.setString(1, anneeScolaire);
             ResultSet rs= executeSelect();
             while (rs.next()) {
      
                 Inscription inscription=new Inscription();
                 inscription.setId(rs.getInt("id"));
                 inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
                 Etudiant etudiant=new Etudiant();
                 etudiant.setMatricule(rs.getString("matricule"));
                 etudiant.setNomComplet(rs.getString("nomComplet"));
                 etudiant.setTuteur(rs.getString("tuteur"));
                 inscription.setEtudiant(etudiant);
                 inscriptions.add(inscription);
             }
             statement.close();
             rs.close();
             conn.close();
        } 
        catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
        }
        return  inscriptions;
       }

         public List<Inscription> selectAllInscriptionsByAnneeScolaire(String anneeScolaire, int idClasse){
          List<Inscription> inscriptions=new ArrayList<>() ;
           try {
             openConnexion();
             initPreparedStatement(SQL_SELECT_ALL_BY_ANNEE_CLASSE);
             statement.setString(1, anneeScolaire);
             statement.setInt(2, idClasse);
             ResultSet rs= executeSelect();
             while (rs.next()) {
      
                 Inscription inscription=new Inscription();
                 inscription.setId(rs.getInt("id"));
                 inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
                 Etudiant etudiant=new Etudiant();
                 etudiant.setMatricule(rs.getString("matricule"));
                 etudiant.setNomComplet(rs.getString("nomComplet"));
                 etudiant.setTuteur(rs.getString("tuteur"));
                 inscription.setEtudiant(etudiant);
                 inscriptions.add(inscription);
             }
             statement.close();
             rs.close();
             conn.close();
        } 
        catch (SQLException e) {
          System.out.println("Erreur de Connexion a la BD");
        }
        return  inscriptions;
       }



       public Inscription selectInscriptionByMatricule(String matricule){
        Inscription inscription=null;
        try {
            openConnexion();
            initPreparedStatement(SQL_SELECT_BY_MATRICULE);
            statement.setString(1, matricule);
            ResultSet rs= executeSelect();
            if (rs.next()) {
              inscription=new Inscription();
              inscription.setId(rs.getInt("id"));
              inscription.setAnneeScolaire(rs.getString("anneeScolaire"));
              Etudiant etudiant= new Etudiant();
              etudiant.setMatricule(rs.getString("matricule"));
              etudiant.setNomComplet(rs.getString("nomComplet"));
              etudiant.setTuteur(rs.getString("tuteur"));
              inscription.setEtudiant(etudiant);
            }
            statement.close();
            rs.close();
            conn.close();
       } 
       catch (SQLException e) {
         System.out.println("");
       }
           return inscription;
      }
}
