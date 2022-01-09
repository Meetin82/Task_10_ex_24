package ru.vsu.cs.semenov_d_s;

import ru.vsu.cs.semenov_d_s.GUIInterface.FrameMain;

import java.util.Locale;

public class GUIMain {

    public static void main(String[] args) throws Exception {
        winMain();
    }

    public static void winMain() {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

}
