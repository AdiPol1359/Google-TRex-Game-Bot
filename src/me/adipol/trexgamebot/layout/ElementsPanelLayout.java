package me.adipol.trexgamebot.layout;

import me.adipol.trexgamebot.listener.ChangeKeyButtonListener;

import javax.net.ssl.SNIHostName;
import javax.swing.*;
import java.awt.*;

public class ElementsPanelLayout extends GroupLayout {
    public static JButton changeKeyButton;
    public static JLabel actualKey;

    public ElementsPanelLayout(Container host) {
        super(host);

        changeKeyButton = new JButton("Start / Stop");
        changeKeyButton.addActionListener(new ChangeKeyButtonListener());

        actualKey = new JLabel("F2", SwingConstants.CENTER);
        actualKey.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        actualKey.setFont(actualKey.getFont().deriveFont(actualKey.getFont().getStyle() | Font.BOLD));

        this.setAutoCreateGaps(true);

        this.setHorizontalGroup(
                this.createSequentialGroup()
                .addComponent(changeKeyButton, 141, 141, 141)
                .addComponent(actualKey, 141, 141, 141)
        );

        this.setVerticalGroup(
                this.createSequentialGroup()
                .addGroup(
                        this.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(changeKeyButton, 32, 32, 32)
                        .addComponent(actualKey, 32, 32, 32)
                )
        );
    }
}
