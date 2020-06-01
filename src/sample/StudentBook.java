package sample;

import java.nio.file.FileSystems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentBook {
    public static final String DB_NAME="Library.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:"+ FileSystems.getDefault().getPath(DB_NAME);
    public static final String TABLE="StudentBook";
    public static final String COLUMN_ID="RegNo";
    public static final String COLUMN_AUTHOR="StudentName";
    public static final String COLUMN_AMOUNT="Book";

    Connection con;
    Statement statement;

    public boolean open() throws SQLException {
        try {
            con= DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;   /*  couldnt connect to database*/
        }
    }
    public boolean close() throws SQLException {
        try {
            con.close();
            return true;
        } catch (SQLException e) {
            // e.printStackTrace();
            return false;
        }
    }


    public boolean CreateTable() throws SQLException {

        if(open()){
            statement=con.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE +
                    " (" + COLUMN_ID + " text, " +
                    COLUMN_AUTHOR + " text, " +
                    COLUMN_AMOUNT + " text" +
                    ")");
            statement.close();
            close();
            return true;
        }
        return false;
    }

    public void Insert(String Student,String RegNo,String Book) throws SQLException{
        if(open()){
            String sql = "INSERT INTO "+TABLE+ "("+COLUMN_ID+","+COLUMN_AUTHOR+","+COLUMN_AMOUNT+") VALUES (?, ?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,RegNo);
            statement.setString(2, Student);
            statement.setString(3, Book);


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }
            statement.close();
            close();
        }


    }

    public List<Student> getLibrarian() throws SQLException {
        List<Student> list=new ArrayList<Student>();
        if(open()){
            statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+TABLE);
            while(resultSet.next()){
                Student student=new Student();
                student.setBook(resultSet.getString(3));
                student.setName(resultSet.getString(2));
                student.setRegNo(resultSet.getString(1));

                list.add(student);

            }
            statement.close();
        }
        return list;
    }


    public void delete(String Id) throws SQLException {
        if(open()){
            statement=con.createStatement();
            String Sql="DELETE FROM "+TABLE+" WHERE "+COLUMN_ID+" = "+Id;
            statement.execute(Sql);
            statement.close();
            close();
        }
    }
}
