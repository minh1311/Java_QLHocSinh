
package Modify;
import connect.DBConnect;
import model.Student;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class StudentModify {
    
    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Statement statement = null;
        Connection connection = null;
        try {     
            connection = DBConnect.getConnection();
            String sql = "select *from student";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),
                        resultSet.getInt("year_birth"), resultSet.getInt("age"), resultSet.getString("hometown"), 
                resultSet.getInt("class_id"));

                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return studentList;
    }

    public static void insert(Student std) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "insert into student(student_name, year_birth, age, hometown, class_id)"
                    + "values(?,?,?,?,?)";

            statement = connection.prepareCall(sql);
            statement.setString(1, std.getStudent_name());
            statement.setInt(2, std.getYear_birth());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getHometown());
            statement.setInt(5, std.getClass_id());

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void update(Student std) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
           
            connection = DBConnect.getConnection();
            String sql = "update student set student_name=?, year_birth=?, age=?, hometown=?, class_id = ? where student_id = ?";

            statement = connection.prepareCall(sql);
            statement.setString(1, std.getStudent_name());
            statement.setInt(2, std.getYear_birth());
            statement.setInt(3, std.getAge());
            statement.setString(4, std.getHometown());
            statement.setInt(5, std.getClass_id());
            statement.setInt(6, std.getStudent_id());


            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public static void delete(int id) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "delete from student where student_id = ?";

            statement = connection.prepareCall(sql);
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    
    
    
    public static List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "select *from student where student_name like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+name+"%");
            
            ResultSet resultSet = statement.executeQuery();
            

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),
                        resultSet.getInt("year_birth"), resultSet.getInt("age"), resultSet.getString("hometown"), resultSet.getInt("class_id"));

                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return studentList;
        
       
    }
    
    public static List<Student> getStudnetById(int id) {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            
            connection = DBConnect.getConnection();

            String sql = "select *from student where student_id = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet = statement.executeQuery();
            

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("student_id"), resultSet.getString("student_name"),
                        resultSet.getInt("year_birth"), resultSet.getInt("age"), resultSet.getString("hometown"), resultSet.getInt("class_id"));

                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (connection != null) {

                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return studentList;

    } 
}
