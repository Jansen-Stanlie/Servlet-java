package exam06.controllers;


import exam06.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao {
    Connection con;

    public StudentsDao(Connection con){
        this.con = con;
    }

    public boolean addStudent(User user){
        boolean test = false;
        String query= "insert into student(fullname,address,status,physics,calculus,biologi) values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, user.getName());
            pst.setString(2,user.getAddress());
            pst.setString(3,user.getStatus());
            pst.setInt(4,user.getPhysics());
            pst.setInt(5,user.getCalculus());
            pst.setInt(6,user.getBiologi());

            pst.executeUpdate();
            test = true;
        }catch (Exception e){
           e.printStackTrace();
        }
            return test;
    }
    public List<User> getAllStud(){
        List<User> users = new ArrayList<>();

        try{

            String query = "select * from student";
            PreparedStatement pt = this.con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();

            while(rs.next()){
                int ID = rs.getInt("id");
                String address = rs.getString("address");
                String name = rs.getString("fullname");
                String status = rs.getString("status");
                String physics =  rs.getString("physics");
                String calculus = rs.getString("calculus");
                String biology =rs.getString("biologi");
                int physic = Integer.parseInt(physics);
                int bio = Integer.parseInt(biology);
                int calc = Integer.parseInt(calculus);
                User row = new User(ID,name,address,status,physic,calc,bio);
                users.add(row);
            }

        }catch(Exception e){
            e.printStackTrace();;
        }
        return users;
    }
    public Boolean editUser(User user){
        boolean test = false;
        try{
            String query = "update student set fullname=?, address = ?,status=?, physics=?, calculus=?,biologi = ? where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1,user.getName());
            pt.setString(2, user.getAddress());
            pt.setString(3, user.getStatus());
            pt.setInt(4, user.getPhysics());
            pt.setInt(5, user.getCalculus());
            pt.setInt(6, user.getBiologi());
            pt.setInt(7, user.getId());
            test = true;
            pt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return test;
    }
    public User getSingleData(int id){
        User us = null;

        try{
            String query = "select * from student where id=? ";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs= pt.executeQuery();
            while(rs.next()){
                int ID= rs.getInt("iD");
                String name = rs.getString("name");
                String status = rs.getString("status");
                int physics = rs.getInt("physics");
                int calculus  = rs.getInt("calculus");
                int biologi = rs.getInt("biologi");

                us = new User(ID,name,status,physics,calculus,biologi);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return us;
    }
    public Boolean deleteData(int id){
        boolean test = false;
        try{
            String query= "delete from student where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            pt.execute();
            test = true;
        }catch(Exception ex){
            ex.printStackTrace();;
        }
        return test;
    }
}
