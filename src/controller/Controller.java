/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Logic;
import view.ViewWindow;

/**
 *
 * @author jovan
 */
public class Controller implements ActionListener {

    private ViewWindow view;
    private Logic model;

    public Controller(Logic model, ViewWindow view) {
        this.model = model;
        this.view = view;
        actionListener(this);
    }

    public void initWindow(){
        view.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "check":
                model.check();
                break;
            case "clear":
                model.clear();
                break;
        }
    }

    private void actionListener(ActionListener e) {
        view.getControls().getBtnCheck().addActionListener(e);
        view.getControls().getBtnClear().addActionListener(e);
    }

}
