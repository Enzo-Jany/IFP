import java.sql.*;


public class ReporterDAO {
    ConnexionMySQL unConnexionMySQL = new ConnexionMySQL();
    Connection con;

    public String getReporterById(int id)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name from reporter where id_reporter = " + id);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        else{
            return "Nan";
        }
    }
}