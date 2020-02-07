
import java.sql.*;

public class NewsDAO {
    ConnexionMySQL unConnexionMySQL = new ConnexionMySQL();
    Connection con;

    public String getJournalisteById(int id)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT reporter.name from reporter,news where news.id_reporter=reporter.id_reporter AND id_news = "+id);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        else{
            return "Nan";
        }
    }

    public String getNewsById(int id)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from news where id_news = "+id);
        if (resultSet.next()){
            return resultSet.getString(1);

        }
        else{
            return "Nan";
        }
    }
}



