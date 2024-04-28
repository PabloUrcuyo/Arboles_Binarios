package arbol_expresiones;

import javax.swing.*;
import java.awt.*;
import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 *
 * @author Pablo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Solicitar al usuario que ingrese una expresión aritmética
        String expresion = JOptionPane.showInputDialog(null, "Ingrese una expresión aritmética:");

        // Construir el árbol de expresiones para la expresión ingresada
        Expresion arbol = construirArbol(expresion);

        if (arbol == null) {
            JOptionPane.showMessageDialog(null, "La expresión ingresada no es válida.");
            return;
        }

        // Crear el marco principal
        JFrame frame = new JFrame("Árbol de Expresiones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agregar el panel de expresión al marco
        ExpresionPanel panel = new ExpresionPanel(arbol);
        frame.add(panel);

        // Establecer el tamaño del marco y hacerlo visible
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
    
    private static Expresion construirArbol(String expresion) {
    Stack<Character> operadores = new Stack<>();
    Stack<Expression> operandos = new Stack<>();
    
    for (int i = 0; i < expresion.length(); i++) {
        char c = expresion.charAt(i);
        
        if (Character.isDigit(c)) {
            StringBuilder numero = new StringBuilder();
            while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                numero.append(expresion.charAt(i));
                i++;
            }
            operandos.push(new Numero(Double.parseDouble(numero.toString())));
            i--;
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            while (!operadores.isEmpty() && precedencia(operadores.peek()) >= precedencia(c)) {
                char operador = operadores.pop();
                Expression der = operandos.pop();
                Expression izq = operandos.pop();
                operandos.push(new OperadorBinario(operador, izq, der));
            }
            operadores.push(c);
        } else if (c == '(') {
            operadores.push(c);
        } else if (c == ')') {
            while (operadores.peek() != '(') {
                char operador = operadores.pop();
                Expression der = operandos.pop();
                Expression izq = operandos.pop();
                operandos.push(new OperadorBinario(operador, izq, der));
            }
            operadores.pop(); // Sacar el '('
        }
    }
    
    while (!operadores.isEmpty()) {
        char operador = operadores.pop();
        Expression der = operandos.pop();
        Expression izq = operandos.pop();
        operandos.push(new OperadorBinario(operador, izq, der));
    }
    
    return operandos.isEmpty() ? null : operandos.pop();
}

private static int precedencia(char operador) {
    switch (operador) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}
    
}
