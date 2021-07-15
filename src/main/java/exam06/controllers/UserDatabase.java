package exam06.controllers;

import exam06.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "update student set email= ?,password = ? where ID = ?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getEmail());
            pt.setString(2, user.getPassword());
            pt.setInt(3, user.getId());

            pt.executeUpdate();
            set = true;
            this.con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    //user login
    public User logUser(String email, String pass){
        User usr=null;
        try{
            String query ="select * from student where email=? and password=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setName(rs.getString("fullname"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return usr;
    }

}