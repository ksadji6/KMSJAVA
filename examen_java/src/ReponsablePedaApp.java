import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Classe;
import entities.Filiere;
import entities.Niveau;
import entities.ProfClasse;
import entities.Professeur;
import services.ClasseService;
import services.ProfesseurService;


import entities.Etudiant;
import entities.Inscription;

import services.EtudiantService;
import services.InscriptionService;

public class ReponsablePedaApp {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
                int choix;
                Scanner sc=new Scanner(System.in);
                ProfesseurService professeurService= new ProfesseurService();
                ClasseService classeService=new ClasseService();
                InscriptionService inscriptionService=new InscriptionService();
                EtudiantService etudiantService = new EtudiantService();
                
                do {
                    System.out.println("1-Créer une classe");
                    System.out.println("2-Lister les classes"); 
                    System.out.println("3-Ajouter un professeur et lui affecter des classes"); 
                    System.out.println("4-Lister les professeurs");
                    System.out.println("5-Filtrer les classes d'un professeur");
                    System.out.println("6-Faire une inscription ou une reinscription");
                    System.out.println("7-Lister les étudiants inscrits au cours d'une année"); 
                    System.out.println("8-Quitter"); 
                    choix=sc.nextInt();
                    sc.nextLine();
                    switch (choix) {
                        case 1:
                            int choixNiveau;
                             
                            do {
                            System.out.println("Choisissez le niveau 1-L1; 2-L2; 3-L3");
                            choixNiveau = sc.nextInt();
                        } while (choixNiveau<1 || choixNiveau>3);
                            Niveau niveau = Niveau.values()[choixNiveau -1];
                            System.out.println("Choisissez la filière 1-IAGE; 2-MAE; 3-GLRS; 4-ETSE; 5-MOSIEF; 6-CDSD; 7-CPD ");
                            int choixFiliere=sc.nextInt();
                            Filiere filiere= Filiere.values()[choixFiliere -1];

                            Classe classe=new Classe();
                            classe.setNiveau(niveau);
                            classe.setFiliere(filiere);
                            classeService.ajouterClasse(classe);
                            
                            break;
                        case 2:
                            System.out.println("Voici les classes :");
                            List<Classe> classes=  classeService.listerClasses();
                            for (Classe cl: classes) {
                            System.out.println(cl.getNiveau() +" "+ cl.getFiliere());
                     }
                            
                        break;
                        case 3:
                        Professeur professeur=new Professeur();
                        System.out.println("Veuillez renseigner le Nci:");
                        professeur.setNci(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Veuillez renseigner le Nom Complet:");
                        professeur.setNomComplet(sc.nextLine());
                        System.out.println("Veuillez renseigner le Grade:");
                        professeur.setGrade(sc.nextLine());
                        classes=classeService.listerClasses();
                        int reponse=2;
                        List<ProfClasse>ListeClasseProf=new ArrayList<>();
                        do {
                            for (Classe cl: classes) {
                                System.out.println(cl.getId()+" "+cl.getNiveau()+ " "+ cl.getFiliere());
                            }
                            System.out.println("Veuillez selectionner la classe à laquelle vous souhaitez affecter un professeur!!");
                            int idClasse=sc.nextInt();
                            classe= classeService.findClasseById(idClasse);
                            if(classe!=null){
                                ProfClasse profClasse= new ProfClasse(classe);
                                profClasse.setProfesseur(professeur);
                                int dedans=0;
                                if(ListeClasseProf.size()>0){
                                    for(ProfClasse p: ListeClasseProf){
                                        if(p.getClasse().getId()==classe.getId()){
                                            dedans=1;
                                            System.out.println("La classe est deja attribuée au professeur");
                                    }
                                }
                                if(dedans==0){
                                    ListeClasseProf.add(profClasse);
                                }
                            }else{
                                    ListeClasseProf.add(profClasse);
                                }
                                
                            }
                            else{
                                System.out.println("Cet ID n'existe pas");
                            }
                            System.out.println("Voulez-vous poursuivre? 1-OUI 2-NON");
                            reponse=sc.nextInt();
                        } while (reponse==1);
                            professeur.setProfClasses(ListeClasseProf);
                            if (professeur.getProfClasses().size()<1){
                                System.out.println("Le professeur doit avoir au moins une classe!!");
                            }
                            else{
                                professeurService.ajouterProfesseur(professeur);
                            }
                            break;
                        
                        case 4:
                        System.out.println("Voici les professeurs :");
                            List<Professeur> professeurs=  professeurService.listerProfesseurs();
                            for (Professeur pr: professeurs) {
                            System.out.println(pr.getId()+" "+pr.getNci() +" "+ pr.getNomComplet()+" "+ pr.getGrade());
                            }
                        
                        break;
                        case 5:
                        System.out.println("Voici les professeurs :");
                            List<Professeur> listeprofesseurs=  professeurService.listerProfesseurs();
                            for (Professeur pr: listeprofesseurs) {
                            System.out.println(pr.getId()+" "+pr.getNci() +" "+ pr.getNomComplet()+" "+ pr.getGrade());
                            }
                            System.out.println("********************");
                    System.out.println("Renseignez l'Id du professeur  :");
                    int professeurId = sc.nextInt();
                    List<Classe> classesprof = professeurService.getClassesByProfesseurId(professeurId);
                    if (classesprof.isEmpty()) {
                        System.out.println("Aucune classe trouvée pour ce professeur.");
                    } else {
                        for (Classe c : classesprof) {
                            System.out.println("Classe Id: " + c.getId() + ", Niveau: " + c.getNiveau() + ", Filière: " + c.getFiliere());
                           
                        }
                    }
                    break;
                    case 6:
                            System.out.println("Veuillez renseigner le matricule de l'etudiant");
                            String matricule=sc.nextLine();
                            Inscription inscription=new Inscription();
                            inscription=inscriptionService.rechercherInscriptionParMatriculeEtudiant(matricule);
                            Etudiant etudiant=new Etudiant();
                            
                            if (inscription==null) {
                                System.out.println("Cet etudiant n'est pas inscrit.Veuillez donc l'inscrire!");
                                System.out.println("Entrez le matricule de l'etudiant");
                                matricule=sc.nextLine();
                                System.out.println("Entrez le nom complet de l'etudiant");
                                String nomComplet=sc.nextLine();
                                System.out.println("Entrez le nom du tuteur de l'etudiant");
                                String tuteur=sc.nextLine();
                                etudiant=new Etudiant();
                                etudiant.setMatricule(matricule);
                                etudiant.setNomComplet(nomComplet);
                                etudiant.setTuteur(tuteur);
                                etudiantService.ajouterEtudiant(etudiant);
                            }else{
                                System.out.println("Ce matricule existe déja.Reinscrivez cet etudiant.");
                            }
                            inscription=new Inscription();
                            System.out.println("Choisissez l'année correspondante à l'inscription");
                            String anneeScolaire=sc.nextLine();
                            System.out.println("Les différentes classes sont: \n");
                            List<Classe> classes1=classeService.listerClasses();
                            for (Classe cl: classes1) {
                                System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
                            }
                            int idClasse=sc.nextInt();
                            Classe classe1=new Classe();
                            classe1=classeService.findClasseById(idClasse);
                            inscription.setClasse(classe1);
                            inscription.setAnneeScolaire(anneeScolaire);
                            inscription.setEtudiant(etudiant);
                            inscriptionService.faireInscription(inscription);

                            break;
                            case 7:
                        System.out.println("Veuillez choisir l'annéé correspondante à l'inscription.");
                        anneeScolaire=sc.nextLine();
                        List<Inscription> inscriptions=inscriptionService.rechercherInscriptionParAnnee(anneeScolaire);
                    for (Inscription ins:inscriptions) {
                        System.out.println(" Matricule=> "+ins.getEtudiant().getMatricule()+"\n Nom Complet=>  "+ins.getEtudiant().getNomComplet()+" \n Tuteur: "+ins.getEtudiant().getTuteur());
                        System.out.println("*__*__*__*__*__*__*__*__*__*__*");
                    }
                    System.out.println("Vous pouvez filter la liste des étudiants en fonction des classes. Voulez-vous le faire?");
                    String reponse1=sc.nextLine();
                    if (reponse1.equalsIgnoreCase("oui")) {
                        System.out.println("Les différentes classes sont: \n");
                            classes1=classeService.listerClasses();
                            for (Classe cl: classes1) {
                                System.out.println(cl.getId()+" "+cl.getNiveau()+" "+cl.getFiliere());
                            }
                            idClasse=sc.nextInt();
                            inscriptions=inscriptionService.rechercherInscriptionParAnnee(anneeScolaire, idClasse);
                            for (Inscription ins:inscriptions) {
                                System.out.println(" Matricule=> "+ins.getEtudiant().getMatricule()+"\n Nom Complet=>  "+ins.getEtudiant().getNomComplet()+" \n Tuteur: "+ins.getEtudiant().getTuteur());
                        System.out.println("*__*__*__*__*__*__*__*__*__*__*");
                            }
                    }  
                    else if (reponse1.equalsIgnoreCase("non")) {
                        break;
                    }      
                        break;

                    default:
                        break;  }
                }while (choix!=8);
                sc.close();
                
    }
}
