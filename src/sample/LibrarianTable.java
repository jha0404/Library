package sample;

import sample.Librarian;

import java.nio.file.FileSystems;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibrarianTable {
    public static final String DB_NAME="Library.db";
    public static final String CONNECTION_STRING="jdbc:sqlite:"+ FileSystems.getDefault().getPath(DB_NAME);
    public static final String TABLE="Librarian";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_NAME="NAME";
    public static final String COLUMN_PASSWORD="PASSWORD";

    Connection con;
    Statement statement;

    public boolean open() throws SQLException {
        try {
           con=DriverManager.getConnection(CONNECTION_STRING);
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
                    " (" + COLUMN_ID + " integer, " +
                    COLUMN_NAME + " text, " +
                    COLUMN_PASSWORD + " text" +
                    ")");
            statement.close();
            close();
            return true;
        }
        return false;
    }

    public void Insert(String Name,Integer ID,String Password) throws SQLException{
       if(open()){
           String sql = "INSERT INTO "+TABLE+ "("+COLUMN_ID+","+COLUMN_NAME+","+COLUMN_PASSWORD+") VALUES (?, ?, ?)";

           PreparedStatement statement = con.prepareStatement(sql);
           statement.setInt(1,ID);
           statement.setString(2, Name);
           statement.setString(3, Password);


           int rowsInserted = statement.executeUpdate();
           if (rowsInserted > 0) {
               System.out.println("A new user was inserted successfully!");
           }
           statement.close();
           close();
       }


    }

    public List<Librarian> getLibrarian() throws SQLException {
        List<Librarian> list=new ArrayList<Librarian>();
        if(open()){
            statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM "+TABLE);
            while(resultSet.next()){
                Librarian librarian=new Librarian();
                librarian.setId(resultSet.getInt(COLUMN_ID));
                librarian.setName(resultSet.getString(COLUMN_NAME));
                librarian.setPassword(resultSet.getString(COLUMN_PASSWORD));
                list.add(librarian);

            }
            statement.close();
        }
        return list;
    }


    public void delete(Integer Id) throws SQLException {
        if(open()){
           statement=con.createStatement();
           String Sql="DELETE FROM "+TABLE+" WHERE "+COLUMN_ID+" = "+Id;
           statement.execute(Sql);
           statement.close();
           close();
        }
    }


}
