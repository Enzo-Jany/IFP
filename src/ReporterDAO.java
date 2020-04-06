import java.sql.*;


public class ReporterDAO {
    ConnexionMySQL unConnexionMySQL = new ConnexionMySQL();
    Connection con;

    public String getReporterById(int id_reporter)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT name from journalist where id = " + id_reporter);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        else{
            return "Nan";
        }
    }
}