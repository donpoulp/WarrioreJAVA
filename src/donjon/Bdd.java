package donjon;
import java.sql.*;

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
//                System.out.println(res.getInt(1)+"  "+res.getString(2)
//                        +"  "+res.getString(3));
                System.out.println("Type : "+res.getString("Type") +
                        ", "+"Nom : "+res.getString("Nom") +
                        ", "+"Vie : "+res.getString("NiveauVie") +
                        ", "+"Force : "+res.getString("NiveauForce") +
                        ", "+"Arme ou Sort : "+res.getString("Arme/Sort") +
                        ", "+"Bouclier : "+res.getString("Bouclier"));
            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
