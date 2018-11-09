package com;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        JFrame frame = getFrame();
        JPanel panel = new JPanel();
        frame.add(panel);
        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setTitle(frame.getTitle() + "1");
            }
        });
        JButton button2 = new JButton("Click submit");
        panel.add(button);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice device = environment.getDefaultScreenDevice();
                try {
                    Robot robot = new Robot(device);
//                    robot.mouseMove(750 + 195, 250 + 48);
//                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                    robot.keyPress(KeyEvent.VK_TAB);
//                    robot.keyRelease(KeyEvent.VK_TAB);
                    Rectangle rect=new Rectangle(0,0,1000,1000);
                    BufferedImage image=robot.createScreenCapture(rect);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
            }
        });
        panel.revalidate();
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(750, 250, 500, 500);
        return jFrame;
    }
}
