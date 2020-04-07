
import org.testng.internal.Utils;

import java.sql.*;
import java.util.ArrayList;

public class NewsDAO {
    private String title;
    private String content;
    private String date;
    private int idJournalist;


    private static ConnexionMySQL unConnexionMySQL = new ConnexionMySQL();
    private static Connection con;

    public static NewsDAO create(String Title, String Content, String Date, int IdJournalist)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();

        NewsDAO test = new NewsDAO(Title, Content, Date, IdJournalist);

        Statement statement = con.createStatement();
        int resultSet = statement.executeUpdate("INSERT INTO news(title, content, date, idJournalist) VALUES("
                +"'"+Title+"', "
                +"'"+Content+"', "
                +Date+", "
                +IdJournalist+
                ")", Statement.NO_GENERATED_KEYS);
        return test;
    }

    public void save(int id) throws Exception {
        con = unConnexionMySQL.ConnexionMySQL();
        Statement lStat = con.createStatement();
        lStat.executeUpdate( "update news set "
                + " Title = " + Utils.toString(title) + ","
                + " Content = " + Utils.toString(content) + ","
                + " Date = " + Utils.toString(date) + ","
                + " IdJournalist = " + Utils.toString(idJournalist) +
                " where title ='" + id + "'", Statement.NO_GENERATED_KEYS);
    }

    public static boolean delete(int id) throws Exception {
        String queryString = "delete from news where id='" + id + "'";
        Statement lStat = con.createStatement();
        lStat.executeUpdate(queryString);
        return true;
    }

    public static NewsDAO readNewsById(int id_news)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from news where news.id = "+id_news);
        if (resultSet.next()){
            return creerParRequete(resultSet);
        }
        else{
            return null;
        }
    }

    public static NewsDAO readNewsByTitle(String title_news)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from news where news.title = "+title_news);
        if (resultSet.next()){
            return creerParRequete(resultSet);
        }
        else{
            return null;
        }
    }

    public static NewsDAO readNewsAndJournalistByIdNews(int id)  throws Exception{
        con = unConnexionMySQL.ConnexionMySQL();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT news.title, journalist.name from news, journalist where news.id = "+id+" AND  news.IdJournalist = journalist.id " );
        if (resultSet.next()){
            return creerParRequete(resultSet);
        }
        else{
            return null;
        }
    }


    public static ArrayList<NewsDAO> getByIdJournalist(int IdJournalist) throws Exception {
        ArrayList<NewsDAO> lesNewsDAO = new ArrayList<>();
        Statement lStat = con.createStatement();
        ResultSet lResult = lStat.executeQuery("select * from news where IdJournalist='" + IdJournalist + "'");
        // y en a t'il au moins un ?
        while (lResult.next()) {
            lesNewsDAO.add(creerParRequete(lResult));
        }
        return lesNewsDAO;
    }



        private static NewsDAO creerParRequete(ResultSet result) throws Exception {
        String    lTitle  = result.getString("Title");
        String    lContent  = result.getString("Content");
        String    lDate = result.getString("Date");
        int    lidJournalist  = result.getInt("IdJournalist");
        return    new NewsDAO(lTitle, lContent, lDate, lidJournalist);
    }

    public NewsDAO(String Title, String Content, String Date, int IdJournalist) {
        this.title = Title;
        this.content = Content;
        this.date = Date;
        this.idJournalist = IdJournalist;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public int getIdJournalist(){
        return idJournalist;
    }

}



