/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_expresiones;

import java.awt.Color;
import java.awt.Graphics;

class OperadorBinario extends Expresion {
    char operador;
    Expresion izquierda;
    Expresion derecha;

    OperadorBinario(char operador, Expresion izquierda, Expresion derecha) {
        this.operador = operador;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }

    @Override
    double evaluar() {
        double izq = izquierda.evaluar();
        double der = derecha.evaluar();
        switch (operador) {
            case '+':
                return izq + der;
            case '-':
                return izq - der;
            case '*':
                return izq * der;
            case '/':
                return izq / der;
            default:
                throw new IllegalArgumentException("Operador desconocido: " + operador);
        }
    }

    @Override
    void dibujar(Graphics g, int x, int y, int nivel) {
        g.setColor(Color.BLACK);
        g.drawString(Character.toString(operador), x, y);
        int espaciado = 30; // Espaciado horizontal entre nodos
        izquierda.dibujar(g, x - (int) (nivel * espaciado), y + 50, nivel - 1);
        derecha.dibujar(g, x + (int) (nivel * espaciado), y + 50, nivel - 1);
        g.drawLine(x, y, x - (int) (nivel * espaciado), y + 20);
        g.drawLine(x, y, x + (int) (nivel * espaciado), y + 20);
    }
}
