package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import static jdk.internal.net.http.HttpResponseImpl.RawChannelProvider.connection;

public class UserDaoJdbcImpl implements UserDao {



    public UserDaoJdbcImpl() {

    }
//Tablisany tuzuu
    public void createUsersTable() {
try (Connection conn = Util.connection();
     Statement stmt = conn.createStatement();
        ){
        String sql = "Create table users(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(20)," +
                "last_name VARCHAR(20)," +
                "age int NOT NULL)";
   stmt.execute(sql);
    System.out.println("Ulandy:");
        }catch (SQLException e){
    e.printStackTrace();
        }
    }
//Tablisany ochuruu
    public void dropUsersTable() {
        try(Connection conn = Util.connection();
            Statement stmt = conn.createStatement();
        ) {
            String sql = "DROP TABLE users";
            stmt.executeUpdate(sql);
            System.out.println(" Tablisanyz ochtu:");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //koldonuuchunu saktoo
    public void saveUser(String name, String lastName, byte age) {
        String SQL = "insert into users (name,last_name,age) values(?,?,?)";
        try (Connection conn =Util. connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException ox) {
            System.out.println(ox.getMessage());
        }
    }
//id boiuncha ochuruu
    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement =Util.connection().
                prepareStatement("DELETE from users where id=(?)")){
            preparedStatement.setLong(1,id);
            ResultSet rs=preparedStatement.executeQuery();
//            if (rs.next()){
//        try(Connection conn = DriverManager.getConnection(url, user,password);
//            Statement stmt = conn.createStatement()) {
//            String SQL = "DELETE FROM users " +
//                    "WHERE id = (?)";
//            stmt.executeUpdate(SQL);
//            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                //Display values
                System.out.print("Id: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", LastName: " + rs.getString("lastName"));
                System.out.println(", age: " + rs.getByte("age"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
//baaryn aluu
    public List<User> getAllUsers() {
        ArrayList<User> list1 = new ArrayList<>();
        String SQL = "SELECT * FROM users";
        try (Connection conn = Util.connection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                list1.add( new User (
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("last_name"),
                        rs.getByte("age")));
            }
            return list1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

//tazaloo
    public void cleanUsersTable() {
        try(Connection conn = Util.connection();
            Statement stmt = conn.createStatement()) {
            String SQL = "DELETE FROM users ";
            stmt.executeUpdate(SQL);
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                //Display values
                System.out.print("Id: " + rs.getInt("id"));
                System.out.print(", Name: " + rs.getString("name"));
                System.out.print(", LastName: " + rs.getString("lastName"));
                System.out.println(", age: " + rs.getByte("age"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
//    public static void printId1(int id) throws SQLException{
//        try (PreparedStatement preparedStatement = connection().
//                prepareStatement("select * from cities where id=(?)")){
//            preparedStatement.setInt(1,id);
//            ResultSet rs=preparedStatement.executeQuery();
//            if (rs.next()){
//                int idID =rs.getInt("id");
//                String name = rs.getString("name");
//                int  formedYear = rs.getInt("formed_year");
//                String isLocated =  rs.getString("is_located");
//                Long livePeople = rs.getLong("live_people");
//                System.out.println(idID);
//                System.out.println(name);
//                System.out.println(formedYear);
//                System.out.println(isLocated);
//                System.out.println(livePeople);
//            }
//        }finally {
//            connection().close();
//        }
//    }