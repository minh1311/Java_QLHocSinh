package Modify;

import connect.DBConnect;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.kyhoc;


public class KyhocModify {
    public static List<kyhoc> findAll() {
        List<kyhoc> kyhocList = new ArrayList<>();
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "select * from kyhoc";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               
                kyhoc kh = new kyhoc(resultSet.getInt("ky_id"), 
                        resultSet.getString("tenkyhoc"), 
                        resultSet.getDate("start_day"), 
                        resultSet.getDate("end_day"));

                kyhocList.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return kyhocList;
    }
    
  public static void insert(kyhoc kh) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "insert into kyhoc(tenkyhoc, start_day, end_day)"
                    + "values(?,?,?)";

            statement = connection.prepareCall(sql);
            statement.setString(1, kh.getTenkyhoc());
            statement.setDate(2, (java.sql.Date) kh.getStart_day());
            statement.setDate(3, (java.sql.Date) kh.getEnd_day());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
    }
  
  public static void update(kyhoc kh) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "update kyhoc set tenkyhoc=?, start_day = ?, end_day = ? where ky_id = ?";

            statement = connection.prepareCall(sql);
            statement.setString(1, kh.getTenkyhoc());
            statement.setDate(2,(java.sql.Date) kh.getStart_day());
            statement.setDate(3,(java.sql.Date) kh.getEnd_day());
            statement.setInt(4, kh.getKy_id());


            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
  
  
    public static void delete(int id) {
//        PreparedStatement statement = null;
//        Connection connection = null;
//        try {
//            connection = DBConnect.getConnection();
//            String sql = "delete from kyhoc where id = ?";
//            statement = connection.prepareCall(sql);
//            statement.setInt(1, id);
//
//            statement.execute();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (connection != null) {
//
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//        }
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "delete from kyhoc where ky_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public static List<kyhoc> findByName(String name) {
        List<kyhoc> kyhoc1List = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "select *from kyhoc where tenkyhoc like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            

            while (resultSet.next()) {
                kyhoc kh = new kyhoc(resultSet.getInt("ky_id"), 
                        resultSet.getString("tenkyhoc"), 
                        resultSet.getDate("start_day"), 
                        resultSet.getDate("end_day"));

                kyhoc1List.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KyhocModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return kyhoc1List;          
    }  
}
