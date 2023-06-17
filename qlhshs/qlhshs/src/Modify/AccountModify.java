
package Modify;

import connect.DBConnect;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AccountModify {
    public Account login(String username, String password){
        Connection conn = DBConnect.getConnection();
        String sql = "select *from account where username like ? and password like ?";
        Account account =null;
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                account = new Account();
                account.setAccount_id(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
            }
            ps.close();
            conn.close();
            return account;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
        
    }
}
