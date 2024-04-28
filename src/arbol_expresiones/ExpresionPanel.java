/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_expresiones;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
class ExpresionPanel extends JPanel {
    private Expresion arbol;

    ExpresionPanel(Expresion arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        arbol.dibujar(g, getWidth() / 2, 50, 5); // El número 5 representa el nivel del árbol
    }
}
