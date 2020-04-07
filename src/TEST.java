
import org.testng.internal.Utils;

import java.sql.*;

public class TEST {
    private String numero;
    private  String test1;


    private static ConnexionMySQL unConnexionMySQL = new ConnexionMySQL();
    private static Connection con;

    public static TEST create(String Numero, String Test1)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();

        TEST test = new TEST(Numero, Test1);

        Statement statement = con.createStatement();

        int resultSet = statement.executeUpdate("INSERT INTO test(numero, test1) VALUES("
                +"'"+Numero+"', "
                +Test1+
                ")", Statement.NO_GENERATED_KEYS);
        return test;
    }




    private static TEST creerParRequete(ResultSet result) throws Exception {
        String    lNumero  = result.getString("Numero");
        String    lTest1  = result.getString("Test1");

        return    new TEST(lNumero, lTest1);
    }

    public TEST(String Numero, String Test1) {
        this.numero = Numero;
        this.test1 = Test1;
    }

    public String getNumero(){
        return numero;
    }

}



