/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author jovan
 */
public class ViewWindow extends JFrame {
    
    private PanelControls controls;
    
    public ViewWindow (){
        initFrame();
    }
    
    private void initFrame(){
        setTitle("E. de expresiones");
        setLayout(new BorderLayout());
        controls = new PanelControls();
        add(controls,BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public PanelControls getControls() {
        return controls;
    }
}
