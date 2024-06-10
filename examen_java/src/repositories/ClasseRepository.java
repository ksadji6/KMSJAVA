package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;

public class ClasseRepository extends Database {
    private final  String SQL_SELECT_ALL_CLASSE="SELECT * FROM classe" ;
    private final  String SQL_INSERT="INSERT INTO `classe` (`filiere`, `niveau`) VALUES (?,?)";
    private final String SQL_SELECT_BY_ID="SELECT * FROM classe WHERE id_classe like ?";

    public void insert(Classe classe){
        try {
          openConnexion();
          initPreparedStatement(SQL_INSERT);
          statement.setDouble(1, classe.getFiliere().ordinal());
          statement.setDouble(2, classe.getNiveau().ordinal());
          executeUpdate();
        } 
         catch (SQLException e) {
            
          System.out.println("Erreur de Connexion a la BD");
        }
        }
        public List<Classe> selectAllClasses(){
            List<Classe> classes=new ArrayList<>();
             try {
               openConnexion();
               initPreparedStatement(SQL_SELECT_ALL_CLASSE);
               ResultSet rs= executeSelect();
               while (rs.next()) {
        
                   Classe classe=new Classe();
                   classe.setId(rs.getInt("id_classe"));
                   int niveau=rs.getInt("niveau");
                   int filiere=rs.getInt("filiere");
                   classe.setNiveau(Niveau.values()[niveau]);
                   classe.setFiliere(Filiere.values()[filiere]);
                   classes.add(classe);        
               }
               statement.close();
               rs.close();
               conn.close();
          } 
          catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
          }
          return  classes;
         }
         public Classe selectClasseById(int id){
            Classe classe=null;
            try {
                openConnexion();
                initPreparedStatement(SQL_SELECT_BY_ID);
                statement.setInt(1, id);
                ResultSet rs= executeSelect();
                if (rs.next()) {
                   //Une ligne ==> rs de la requete
                    classe= new Classe();
                    classe.setId(rs.getInt("id_classe"));
                    int niveau=rs.getInt("niveau");
                    int filiere=rs.getInt("filiere");
                    classe.setNiveau(Niveau.values()[niveau]);
                    classe.setFiliere(Filiere.values()[filiere]);
                 
                }
                statement.close();
                rs.close();
                conn.close();
           } 
           catch (SQLException e) {
             System.out.println("Erreur de Connexion a la BD");
           }
               return classe;
          }
        
        
        }