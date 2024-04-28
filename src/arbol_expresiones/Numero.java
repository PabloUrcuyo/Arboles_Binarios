/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_expresiones;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Pablo
 */
// Clase para representar un número en el árbol de expresiones
class Numero extends Expresion {
    double valor;

    Numero(double valor) {
        this.valor = valor;
    }

    @Override
    double evaluar() {
        return valor;
    }

    @Override
    void dibujar(Graphics g, int x, int y, int nivel) {
        g.setColor(Color.BLACK);
        g.drawString(Double.toString(valor), x, y);
    }
}

