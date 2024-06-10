package repositories;

import java.sql.SQLException;
import entities.Professeur;


public class ResponsablePedaRepository extends Database  {
    
   private final  String SQL_INSERT="INSERT INTO classe ( filiere, niveau)  VALUES (?,?)";

  


   public void insert(Professeur professeur){
    openConnexion();
    try {
        initPreparedStatement(SQL_INSERT);
        statement.setInt(1, professeur.getId());
        statement.setString(2, professeur.getNomComplet());
        statement.setString(3, professeur.getGrade()); 
        statement.setInt(4, professeur.getNci());
        executeUpdate();
       closeConnexion();
     } catch (SQLException e) {
      e.printStackTrace();
     }
     }

 

}
