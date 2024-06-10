package repositories;




import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Professeur;


public class ProfesseurRepository extends Database  {
   private final  String SQL_INSERT="INSERT INTO professeur (nci,nomcomplet,grade)  VALUES (?,?,?)";
   private final  String SQL_LAST_VALUE_INSERT="select Max(id_prof) as max from professeur";
    private final String SQL_SELECT_ALL_PROFESSEUR="select * from professeur";
  


    public void insert(Professeur professeur){
        openConnexion();
        try {
            initPreparedStatement(SQL_INSERT);
            statement.setInt(1, professeur.getNci());
            statement.setString(2, professeur.getNomComplet());
            statement.setString(3, professeur.getGrade()); 
            
            executeUpdate();
            closeConnexion();
        } 
        catch (SQLException e)
        {
          e.printStackTrace();
        }  
    }

    public Professeur selectLastProfesseur(){
        Professeur professeur=null;
        try{
            openConnexion();
            initPreparedStatement(SQL_LAST_VALUE_INSERT);
            ResultSet rs=executeSelect();
            while (rs.next()) {
                professeur=new Professeur();
                professeur.setId(rs.getInt("max"));
                }
        }
            
            catch(SQLException e){
                e.printStackTrace();
            }
            return professeur;
        
    }
    public List<Professeur> selectAllProfesseurs(){
        List<Professeur> professeurs=new ArrayList<>();
         try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL_PROFESSEUR);
           ResultSet rs= executeSelect();
           while (rs.next()) {
    
               Professeur professeur=new Professeur();
               professeur.setId(rs.getInt("id_prof"));
               professeur.setNci(rs.getInt("nci"));
               professeur.setNomComplet(rs.getString("nomcomplet"));
               professeur.setGrade(rs.getString("grade"));
               professeurs.add(professeur);        
           }
           rs.close();
           conn.close();
      } 
      catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
      return  professeurs;
     }
}        

