/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbol_expresiones;

import java.awt.Graphics;

public abstract class Expresion {
    abstract double evaluar();
    abstract void dibujar(Graphics g, int x, int y, int nivel);
}