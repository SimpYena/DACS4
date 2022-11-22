/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import ClientModel.PlayerInGame;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import Constrant.Avatar;


/**
 *
 * @author Admin
 */
public class PlayerInRoomCustomRenderer extends JLabel implements ListCellRenderer<PlayerInGame> {

    @Override
    public Component getListCellRendererComponent(JList<? extends PlayerInGame> jlist, PlayerInGame p, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon = new ImageIcon(Avatar.PATH + p.getAvatar());
        setIcon(imageIcon);
        setText(p.getNameId());

        if (isSelected) {
            setBackground(jlist.getSelectionBackground());
            setForeground(jlist.getSelectionForeground());
        } else {
            setBackground(jlist.getBackground());
            setForeground(jlist.getForeground());
        }

        return this;
    }

}

