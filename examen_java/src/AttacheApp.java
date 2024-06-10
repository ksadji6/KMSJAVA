// import java.util.List;
// import java.util.Scanner;
// import entities.Classe;
// import entities.Etudiant;
// import entities.Inscription;
// import services.ClasseService;
// import services.EtudiantService;
// import services.InscriptionService;

// public class AttacheApp {
//     public static void main(String[] args) throws Exception {
//         int choix;
//         InscriptionService inscriptionService=new InscriptionService();
//         EtudiantService etudiantService = new EtudiantService();
//         ClasseService classeService=new ClasseService();
//                 Scanner sc=new Scanner(System.in);
                
//                 do {
//                     System.out.println("1-Faire une inscription ou une reinscription");
//                     System.out.println("2-Lister les étudiants inscrits au cours d'une année"); 
//                     System.out.println("3-Quitter"); 
//                     choix=sc.nextInt();
//                     sc.nextLine();
//                     switch (choix) {
//                         case 1:
//                             System.out.println("Veuillez renseigner le matricule de l'etudiant");
//                             String matricule=sc.nextLine();
//                             Inscription inscription=new Inscription();
//                             inscription=inscriptionService.rechercherInscriptionParMatriculeEtudiant(matricule);
//                             Etudiant etudiant=new Etudiant();
                            
//                             if (inscription==null) {
//                                 System.out.println("Cet etudiant n'est pas inscrit.Veuillez donc l'inscrire!");
//                                 System.out.println("Entrez le matricule de l'etudiant");
//                                 matricule=sc.nextLine();
//                                 System.out.println("Entrez le nom complet de l'etudiant");
//                                 String nomComplet=sc.nextLine();
//                                 System.out.println("Entrez le nom du tuteur de l'etudiant");
//                                 String tuteur=sc.nextLine();
//                                 etudiant=new Etudiant();
//                                 etudiant.setMatricule(matricule);
//                                 etudiant.setNomComplet(nomComplet);
//                                 etudiant.setTuteur(tuteur);
//                                 etudiantService.ajouterEtudiant(etudiant);
//                             }else{
//                                 System.out.println("Ce matricule existe déja.Reinscrivez cet etudiant.");
//                             }
//                             inscription=new Inscription();
//                             System.out.println("Choisissez l'année correspondante à l'inscription");
//                             String anneeScolaire=sc.nextLine();
//                             System.out.println("Les différentes classes sont: \n");
//                             List<Classe> classes=classeService.listerClasses();
//                             for (Classe cl: classes) {
//                                 System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
//                             }
//                             int idClasse=sc.nextInt();
//                             Classe classe=new Classe();
//                             classe=classeService.findClasseById(idClasse);
//                             inscription.setClasse(classe);
//                             inscription.setAnneeScolaire(anneeScolaire);
//                             inscription.setEtudiant(etudiant);
//                             inscriptionService.faireInscription(inscription);

//                             break;
//                         case 2:
//                         System.out.println("Veuillez choisir l'annéé correspondante à l'inscription.");
//                         anneeScolaire=sc.nextLine();
//                         List<Inscription> inscriptions=inscriptionService.rechercherInscriptionParAnnee(anneeScolaire);
//                     for (Inscription ins:inscriptions) {
//                         System.out.println(" Matricule=> "+ins.getEtudiant().getMatricule()+"\n Nom Complet=>  "+ins.getEtudiant().getNomComplet()+" \n Tuteur: "+ins.getEtudiant().getTuteur());
//                         System.out.println("*__*__*__*__*__*__*__*__*__*__*");
//                     }
//                     System.out.println("Vous pouvez filter la liste des étudiants en fonction des classes. Voulez-vous le faire?");
//                     String reponse=sc.nextLine();
//                     if (reponse.equalsIgnoreCase("oui")) {
//                         System.out.println("Les différentes classes sont: \n");
//                             classes=classeService.listerClasses();
//                             for (Classe cl: classes) {
//                                 System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
//                             }
//                             idClasse=sc.nextInt();
//                             inscriptions=inscriptionService.rechercherInscriptionParAnnee(anneeScolaire, idClasse);
//                             for (Inscription ins:inscriptions) {
//                                 System.out.println(" Matricule=> "+ins.getEtudiant().getMatricule()+"\n Nom Complet=>  "+ins.getEtudiant().getNomComplet()+" \n Tuteur: "+ins.getEtudiant().getTuteur());
//                         System.out.println("*__*__*__*__*__*__*__*__*__*__*");
//                             }
//                     }  
//                     else if (reponse.equalsIgnoreCase("non")) {
//                         break;
//                     }      
//                         break;

//                     default:
//                         break;  }
//                 } while (choix!=3);
//                 sc.close();
//     }
    
// }
