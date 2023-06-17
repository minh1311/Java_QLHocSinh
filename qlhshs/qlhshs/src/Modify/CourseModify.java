
package Modify;
import connect.DBConnect;
import model.Course;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class CourseModify {
    public static List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Statement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();
            String sql = "select *from course";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
               
                Course course = new Course(resultSet.getInt("course_id"), resultSet.getString("course_name"),resultSet.getInt("ky_id"));

                courseList.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return courseList;
    }

    public static void insert(Course course) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
           
            connection = DBConnect.getConnection();

            String sql = "insert into course(course_name, ky_id)"
                    + "values(?,?)";

            statement = connection.prepareCall(sql);
            statement.setString(1, course.getCourse_name());
            statement.setInt(2, course.getKy_id());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void update(Course course) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "update course set course_name=?, ky_id=? where course_id = ?";

            statement = connection.prepareCall(sql);
            statement.setString(1, course.getCourse_name());
            statement.setInt(2, course.getKy_id());
            statement.setInt(3,course.getCourse_id());
            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void delete(int id) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "delete from course where course_id = ?";

            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    
    
    public static List<Course> findByName(String name) {
        List<Course> courseList = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "select *from course where course_name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            

            while (resultSet.next()) {
                Course course = new Course(resultSet.getInt("course_id"), resultSet.getString("course_name"), resultSet.getInt("ky_id"));

                courseList.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CourseModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return courseList;    
    }
}
