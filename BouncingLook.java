/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncingball;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
/**
 *
 * @author User
 */
public class BouncingLook extends JApplet{
    private Ball ball=new Ball();
private JButton btnStop=new JButton("Stop");
private JButton btnContinue=new JButton("Continue");
private JScrollBar sbSlow=new JScrollBar();

    public void init() {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,2));
        panel.add(btnStop);
        panel.add(btnContinue);
        ball.setBorder(new javax.swing.border.LineBorder(Color.blue));
        sbSlow.setOrientation(JScrollBar.HORIZONTAL);
        sbSlow.setValue(10);
        ball.setBavno(sbSlow.getValue());
        setLayout(new BorderLayout());
        add(sbSlow, BorderLayout.NORTH);
        add(ball, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        btnStop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ball.suspend();
            }
        });
        btnContinue.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ball.resume();
            }
        });

        sbSlow.addAdjustmentListener(new AdjustmentListener() {

            public void adjustmentValueChanged(AdjustmentEvent e) {
                ball.setBavno(e.getValue());
            }
        });
    }
}
