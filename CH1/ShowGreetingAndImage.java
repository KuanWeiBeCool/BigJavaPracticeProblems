package com.kuan;

import javax.swing.*;
import java.net.URL;

public class ShowGreetingAndImage {
    public static void main(String[] args) throws Exception {
        URL imageLocation = new URL(
                "http://horstmann.com/java4everyone/duke.gif");
        JOptionPane.showMessageDialog(null, "Hello", "Title",
                JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}
