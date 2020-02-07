import java.sql.*;

public class ConnexionMySQL {
    /** driverDst : MySQl driver  */
    private static String driver    = "com.mysql.jdbc.Driver";

    /** url : ConnexionMySQL URL */
    private static String url       = "jdbc:mysql://localhost:8889/IFP";

    /** userName :  */
    private static String userName  = "root";

    /** password :  */
    private static String password  = "root";

    /** destination connection on the database */
    private static Connection conn  = null;

    public Connection ConnexionMySQL() throws Exception  {
        if (conn == null) {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection réussi");
        }
        return conn;
    }
}


