/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakedemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lenovo
 */
public class SettingsPanel extends JPanel{
    
     private Main window; 
   private static Icon cdicon = new ImageIcon(Main.class.getResource("snake.PNG")); 

  public SettingsPanel(snakedemo.Main window){
       setOpaque(true);
      this.window=window;  
    
    JLabel lab = new JLabel(cdicon);
     JButton a = new JButton("Two player");
         
        JButton b = new JButton("One player");
        b.addActionListener(new ActionListener()
             {
               public void actionPerformed(ActionEvent e)
               {
                    Main f=new Main();
                  // EventQueue.invokeLater(Main::new);
                
               }
             });
   
   
    setLayout(new BorderLayout(300,200));
	        setBorder(BorderFactory.createLineBorder(Color.black));
	        this.setBackground(Color.white);
	        setForeground(Color.black);
	        setFont(new Font("MsSanserif",Font.PLAIN,10));
		    Box box1 = Box.createHorizontalBox();
                        box1.add(Box.createHorizontalGlue());			   
			box1.add(lab);					
			box1.add(Box.createHorizontalGlue());
                        
                    Box box2 = Box.createHorizontalBox();
                        box2.add(Box.createHorizontalGlue());			  
			box2.add(a);					
			box2.add(Box.createHorizontalGlue());
			box2.add(b);
                        box2.add(Box.createHorizontalGlue());
                        
			Box boxx = Box.createVerticalBox();
			boxx.add(Box.createVerticalGlue());				
			boxx.add(box1);					
			boxx.add(Box.createVerticalGlue());
                        boxx.add(box2);
                        boxx.add(Box.createVerticalGlue());
                        
			this.add(boxx,BorderLayout.CENTER);
                        
        window.setSize(new Dimension(cdicon.getIconWidth(), cdicon.getIconHeight()));
    
        // setbackground of panel
        this.setBackground(Color.WHITE);
  
      
    }
    
}
