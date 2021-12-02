package donjon;
import donjon.cases.stuffs.armes.epees.EpeeOneHand;
import donjon.cases.stuffs.boucliers.Bouclier;
import donjon.cases.stuffs.potions.Little;
import donjon.cases.stuffs.sorts.Eclairs;
import donjon.personnages.Guerrier;
import donjon.personnages.Magicien;

import java.sql.*;
import java.util.ArrayList;

public class Bdd {

    public static void getHeroes(){
        try
        {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM hero");
            //étape 4: exécuter la requête
            while(res.next())
                System.out.println("Id : "+res.getInt("id")+
                        " | "+"Type : "+res.getString("Type") +
                        " | "+"Name : "+res.getString("Nom") +
                        " | "+"Life : "+res.getInt("NiveauVie") +
                        " | "+"Strength : "+res.getInt("NiveauForce") +
                        " | "+"First item : "+res.getString("Arme/Sort") +
                        " | "+"Secondary item : "+res.getString("Bouclier/Philtre"));
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void delHeroes(int id){
        try
        {
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            System.out.println("Delete...");
            String sql = ("DELETE FROM hero WHERE id ="+id);
            stmt.executeUpdate(sql);
            System.out.println("This character has been delete.");
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void addWarrior(Integer id, String Type, String Nom, int life, int force, EpeeOneHand Arme, Bouclier Bouclier){
        try
        {
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            System.out.println("Create...");
            String sql = "INSERT INTO hero VALUES ("+id+",'"+Type+"','"+Nom+"',"+life+","+force+",'"+Arme+"','"+Bouclier+"')";
            stmt.executeUpdate(sql);
            System.out.println("This warrior has been created.");
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void addWizard(Integer id, String Type, String Nom, int life, int force, Eclairs Sort, Little philtre){
        try
        {
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            System.out.println("Create...");
            String sql = "INSERT INTO hero VALUES ("+id+",'"+Type+"','"+Nom+"',"+life+","+force+",'"+Sort+"','"+philtre+"')";
            stmt.executeUpdate(sql);
            System.out.println("This wizard has been created.");
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static ArrayList<Guerrier> getWarrior(){
        ArrayList<Guerrier> warrior = new ArrayList<>();
        try
        {
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            String sql = ("SELECT * FROM hero WHERE Type ='Guerrier'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                String name = w.getString("Nom");
                int vie = w.getInt("NiveauVie");
                int force = w.getInt("NiveauForce");
                String weapon = w.getString("Arme/Sort");
                String secondaryWeapon = w.getString("Bouclier/Philtre");

                Guerrier warrior1 = new Guerrier(name,vie,force,weapon,secondaryWeapon);
                warrior.add(warrior1);
            }
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return warrior;
    }

    public static ArrayList<Magicien> getWizard(){
        ArrayList<Magicien> wizard = new ArrayList<>();
        try
        {
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            String sql = ("SELECT * FROM hero WHERE Type ='Magicien'");
            ResultSet w = stmt.executeQuery(sql);

            while(w.next()){
                String name = w.getString("Nom");
                int vie = w.getInt("NiveauVie");
                int force = w.getInt("NiveauForce");
                String weapon = w.getString("Arme/Sort");
                String secondaryWeapon = w.getString("Bouclier/Philtre");

                Magicien wizard1 = new Magicien(name,vie,force,weapon,secondaryWeapon);
                wizard.add(wizard1);
            }
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return wizard;
    }

    public static void verifyCharacterByName(String nom){
        try{
            //étape 1: charger la classe driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ex_java?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "53b4St!3n1873!!");
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            //étape 4: exécuter la requête
            String sql = ("SELECT * FROM hero WHERE Nom ='"+nom+"'");
            int nbrRow  = stmt.executeQuery(sql).getRow();
            if (nbrRow !=1){
                System.out.println("Your character exist ! You can play with him.");
            }else {
                System.out.println("Your character doesn't exist ! Go to create for play with him.");

            }
            //étape 5: fermez l'objet de connexion
            conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
