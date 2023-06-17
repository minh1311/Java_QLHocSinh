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
import model.Class;


public class ClassModify {
    public static List<Class> findAll() {
        List<Class> courseList = new ArrayList<>();
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "select class.*, course_name from class inner join course on class.course_id = course.course_id";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               
                Class cl = new Class(resultSet.getInt("class_id"), resultSet.getString("class_name"),
                        resultSet.getInt("course_id"), resultSet.getDate("register_day"));

                courseList.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return courseList;
    }
    
  public static void insert(Class cl) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "insert into class(class_name, course_id, register_day)"
                    + "values(?,?,?)";

            statement = connection.prepareCall(sql);
            statement.setString(1, cl.getClass_name());
            statement.setInt(2,  cl.getCourse_id());
            statement.setDate(3, (java.sql.Date) cl.getRegister_day());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        
    }
  
  public static void update(Class cl) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "update class set class_name=?, course_id = ?, register_day = ? where class_id = ?";

            statement = connection.prepareCall(sql);
            statement.setString(1, cl.getClass_name());
            statement.setInt(2, cl.getCourse_id());
            statement.setDate(3, (Date) cl.getRegister_day());
            statement.setInt(4, cl.getClass_id());


            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
  
  
    public static void delete(int id) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "delete from class where class_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public static List<Class> findByName(String name) {
        List<Class> classList = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "select *from class where class_name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            

            while (resultSet.next()) {
                Class cl = new Class(resultSet.getInt("class_id"), resultSet.getString("class_name"),
                        resultSet.getInt("course_id"),resultSet.getDate("register_day"));

                classList.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClassModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classList;          
    }  
}
