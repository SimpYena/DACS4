/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBLayers;

import DatabaseConnector.Mysqlconnector;
//import server.db.layers.DTO.Player;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PlayerDAL {

    Mysqlconnector connector;

    public PlayerDAL() {

    }

    public ArrayList readDB() {
        ArrayList<PlayerDTO> result = new ArrayList<>();
        connector = new Mysqlconnector();

        try {
            String qry = "SELECT * FROM Player;";
            PreparedStatement stm = connector.getConnection().prepareStatement(qry);
            ResultSet rs = connector.sqlQry(stm);

            if (rs != null) {
                while (rs.next()) {
                    PlayerDTO p = new PlayerDTO(
                            rs.getInt("ID"),
                            rs.getString("Email"),
                            rs.getString("Password"),
                            rs.getString("Avatar"),
                            rs.getString("Name"),
                            rs.getString("Gender"),
                            rs.getInt("YearOfBirth"),
                            rs.getInt("Score"),
                            rs.getInt("MatchCount"),
                            rs.getInt("WinCount"),
                            rs.getInt("LoseCount"),
                            rs.getInt("CurrentStreak"),
                            rs.getBoolean("Blocked")
                    );
                    result.add(p);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error while trying to read Players info from database!");
        } finally {
            connector.closeConnection();
        }

        return result;
    }

    public boolean add(PlayerDTO p) {
        boolean result = false;
        connector = new Mysqlconnector();

        try {
            String qry = "INSERT INTO Player(Email,Password,Avatar,Name,Gender,YearOfBirth,Score,MatchCount,WinCount,LoseCount,CurrentStreak,Blocked) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stm = connector.getConnection().prepareStatement(qry);
            stm.setString(1, p.getEmail());
            stm.setString(2, p.getPassword());
            stm.setString(3, p.getAvatar());
            stm.setString(4, p.getName());
            stm.setString(5, p.getGender());
            stm.setInt(6, p.getYearOfBirth());
            stm.setInt(7, p.getScore());
            stm.setInt(8, p.getMatchCount());
            stm.setInt(9, p.getWinCount());
            stm.setInt(10, p.getLoseCount());
            stm.setInt(11, p.getCurrentStreak());
            stm.setBoolean(12, p.isBlocked());

            result = connector.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connector.closeConnection();
        }

        return result;
    }

    public boolean update(PlayerDTO p) {
        boolean result = false;
        connector = new Mysqlconnector();

        try {
            String qry = "UPDATE Player SET "
                    + "Email=?,"
                    + "Password=?,"
                    + "Avatar=?,"
                    + "Name=?,"
                    + "Gender=?,"
                    + "YearOfBirth=?,"
                    + "Score=?,"
                    + "MatchCount=?,"
                    + "WinCount=?,"
                    + "LoseCount=?,"
                    + "CurrentStreak=?,"
                    + "Blocked=?"
                    + " WHERE ID=?";

            PreparedStatement stm = connector.getConnection().prepareStatement(qry);

            stm.setString(1, p.getEmail());
            stm.setString(2, p.getPassword());
            stm.setString(3, p.getAvatar());
            stm.setString(4, p.getName());
            stm.setString(5, p.getGender());
            stm.setInt(6, p.getYearOfBirth());
            stm.setInt(7, p.getScore());
            stm.setInt(8, p.getMatchCount());
            stm.setInt(9, p.getWinCount());
            stm.setInt(10, p.getLoseCount());
            stm.setInt(11, p.getCurrentStreak());
            stm.setBoolean(12, p.isBlocked());
            stm.setInt(13, p.getId());

            result = connector.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connector.closeConnection();
        }

        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        connector = new Mysqlconnector();

        try {
            String qry = "DELETE FROM player WHERE ID=?";

            PreparedStatement stm = connector.getConnection().prepareStatement(qry);
            stm.setInt(1, id);

            result = connector.sqlUpdate(stm);
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

