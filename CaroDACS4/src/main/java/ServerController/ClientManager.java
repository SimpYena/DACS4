/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerController;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ClientManager {

    ArrayList<Client> clients;

    public ClientManager() {
        clients = new ArrayList<>();
    }

    public boolean add(Client c) {
        if (!clients.contains(c)) {
            clients.add(c);
            return true;
        }
        return true;
    }

    public boolean remove(Client c) {
        if (clients.contains(c)) {
            clients.remove(c);
            return true;
        }
        return false;
    }

    public Client find(String email) {
        for (Client c : clients) {
            if (c.getLoginPlayer() != null && c.getLoginPlayer().getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public void broadcast(String msg) {
        clients.forEach((c) -> {
            c.sendData(msg);
        });
    }

    public Client findClientFindingMatch() {
        for (Client c : clients) {
            if (c.isFindingMatch()) {
                return c;
            }
        }

        return null;
    }

    public int getSize() {
        return clients.size();
    }
}
