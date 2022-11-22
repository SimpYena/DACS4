/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBLayers;

import DatabaseConnector.Mysqlconnector;
//import server.db.layers.DTO.GameMatch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class GameMatchBUS {

    ArrayList<GameMatchDTO> listGameMatch = new ArrayList<>();
    GameMatchDAL gameMatchDAL = new GameMatchDAL();

    public GameMatchBUS() {
        readDB();
    }

    public void readDB() {
        listGameMatch = gameMatchDAL.readDB();
    }

    public boolean add(GameMatchDTO g) {
        boolean status = gameMatchDAL.add(g);

        if (status == true) {
            listGameMatch.add(g);
        }

        return status;
    }

    public boolean delete(int id) {
        boolean status = gameMatchDAL.delete(id);

        if (status == true) {
            for (int i = (listGameMatch.size() - 1); i >= 0; i--) {
                if (listGameMatch.get(i).getId() == id) {
                    listGameMatch.remove(i);
                }
            }
        }

        return status;
    }

    public boolean update(GameMatchDTO g) {
        boolean status = gameMatchDAL.update(g);

        if (status == true) {
            listGameMatch.forEach((gm) -> {
                gm = new GameMatchDTO(g);
            });
        }

        return status;
    }

    public GameMatchDTO getById(int id) {
        for (GameMatchDTO g : listGameMatch) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    // ================ utils ===================
    public int calculateTotalMatch(int playerId) {
        int result = 0;

        for (GameMatchDTO m : listGameMatch) {
            if (m.getPlayerID1() == playerId || m.getPlayerID2() == playerId) {
                result++;
            }
        }
        return result;
    }

    public int calculateWinCount(int playerId) {
        int result = 0;

        for (GameMatchDTO m : listGameMatch) {
            if (m.getWinnerID() == playerId) {
                result++;
            }
        }
        return result;
    }

    public int calculateLongestWinStreak(int playerId) {
        int longest = 0;
        int current = 0;

        for (GameMatchDTO m : listGameMatch) {
            if (m.getPlayerID1() == playerId || m.getPlayerID2() == playerId) {
                if (m.getWinnerID() == playerId) {
                    current++;
                } else {
                    if (current > longest) {
                        longest = current;
                    }
                    current = 0;
                }
            }
        }

        return longest;
    }

    public float calculateWinRate(int playerId) {
        return (float) (100.00 * (calculateWinCount(playerId) / calculateTotalMatch(playerId)));
    }

    public ArrayList<GameMatchDTO> getList() {
        return listGameMatch;
    }
}
