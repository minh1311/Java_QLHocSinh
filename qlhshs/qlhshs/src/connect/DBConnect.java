
package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
    public static Connection getConnection(){
        try {
            Connection conn = null;
//            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
            return  conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String [] args) throws SQLException{
        Connection conn = getConnection();
        System.out.print(conn.toString());
        conn.close();
    }
}
