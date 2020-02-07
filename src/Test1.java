import java.sql.*;

public class Test1 {

    public static void main(String[] args) {
            int GetById = 2;

            Statement statement ;

            try

            {

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/Base_IFP" ,"root","root");
                System.out.println("Connection réussi");
                statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT pseudo from reporter where id = " + GetById);
                if (resultSet.next()){
                    System.out.print(resultSet.getString(1));
                }



            }catch(ClassNotFoundException | SQLException e){
                System.err.println(e);
                System.exit(-1);
            }
    }
}



