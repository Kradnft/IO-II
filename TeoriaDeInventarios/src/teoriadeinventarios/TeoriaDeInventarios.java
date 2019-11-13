/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriadeinventarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author kevinbordapenagos
 */
public class TeoriaDeInventarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame Ventana = new JFrame();
        Ventana.setSize(800, 500);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Ventana.setLayout(null);
        
        JLabel labe = new JLabel();
        labe.setBackground(Color.white);
        labe.setBounds(120,10,500,80);
        labe.setFont(new Font("Cambria",Font.ITALIC,40));
        labe.setText("TEORIA DE INVENTARIOS");
        labe.setVisible(true);
        Ventana.add(labe);
        
        //Creamos los botones que efectuaran los procesos
        JButton BEoq  = new JButton("EOQ");
        JButton BCsd  = new JButton("Compra Sin Deficit");
        JButton BCcd  = new JButton("Compra Con Deficit");
        JButton BMsd  = new JButton("Manofactura sin deficit");
        JButton BMcd  = new JButton("Manofactuta con deficit");
        JButton opc  = new JButton("¿Cuales operaciones puedo realizar?");
        
        
        //Creamos un formato que solo reciba entradas numericas
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0); //valor mínimo
        formatter.setMaximum(Integer.MAX_VALUE); //valor máximo
        formatter.setAllowsInvalid(false);
        
        // Creamos los campos de texto donde irán las variables solicitadas
        JFormattedTextField Tdem  = new JFormattedTextField(formatter);
        Tdem.setValue(0);
        JFormattedTextField TCorden  = new JFormattedTextField(formatter);
        TCorden.setValue(0);
        JFormattedTextField TCman  = new JFormattedTextField(formatter);
        TCman.setValue(0);
        JFormattedTextField TCpen  = new JFormattedTextField(formatter);
        TCpen.setValue(0);
        JFormattedTextField TTd  = new JFormattedTextField(formatter);
        TTd.setValue(0);
        JFormattedTextField TTp = new JFormattedTextField(formatter);
        TTp.setValue(0);
        
        //Creamos labels para saber que variable va en cada campo
        JLabel Ldem  = new JLabel("Demanda");
        JLabel LCorden  = new JLabel("Costo orden");
        JLabel LCman  = new JLabel("C.mantenimiento");
        JLabel LCpen  = new JLabel("C.penalizacion");
        JLabel LTd  = new JLabel("Tasa demanda");
        JLabel LTp = new JLabel("Tasa produccion");
        
        //Creamos variables booleanas para saber si usaremos o no el campo
        boolean D = false, Co = false, Cm = false, Cp = false, Td= false, Mc = false;
        
        //Campos a 120
        //Le damos las posiciones a todos los campos de datos
        Tdem.setBounds(50, 140, 100, 30);
        TCorden.setBounds(170, 140, 100, 30);
        TCman.setBounds(290, 140, 100, 30);
        TCpen.setBounds(410, 140, 100, 30);
        TTd.setBounds(530, 140, 100, 30);
        TTp.setBounds(650, 140, 100, 30);
        
        Ventana.add(Tdem);
        Ventana.add(TCorden);
        Ventana.add(TCman);
        Ventana.add(TCpen);
        Ventana.add(TTd);
        Ventana.add(TTp);
        
        //Posicionamos los nombres de los campos encima de estos
        
        Ldem.setBounds(50, 110, 100, 25);
        LCorden.setBounds(170, 110, 100, 25);
        LCman.setBounds(290, 110, 100, 25);
        LCpen.setBounds(410, 110, 100, 25);
        LTd.setBounds(530, 110, 100, 25);
        LTp.setBounds(650, 110, 120, 25);
        
        Ventana.add(Ldem);
        Ventana.add(LCorden);
        Ventana.add(LCman);
        Ventana.add(LCpen);
        Ventana.add(LTd);
        Ventana.add(LTp);
        
        
        
        
        Ventana.setLocationRelativeTo(null);
        Ventana.setVisible(true);
        
        
    }
    
    
}
