/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoriadeinventarios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class TeoriaDeInventarios implements ActionListener{
    
    public static JComboBox cmDem = new JComboBox();
    public static JComboBox cmMan = new JComboBox();
    public static JFormattedTextField diasMes = new JFormattedTextField(3);
    //Creamos los botones que efectuaran los procesos
    public static JButton BEoq  = new JButton("EOQ");
    public static JButton BCsd  = new JButton("Compra Sin Deficit");
    public static JButton BCcd  = new JButton("Compra Con Deficit");
    public static JButton BMsd  = new JButton("Manof. sin deficit");
    public static JButton BMcd  = new JButton("Manof. con deficit");
    
    public static JPanel pan = new JPanel();
    
    public static JLabel tex = new JLabel();
    public static JLabel tex2 = new JLabel();
    
    //Creamos variables booleanas para saber si usaremos o no el campo
    boolean D = false, Co = false, Cm = false, Cp = false, Td= false, Mc = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        pan.setBackground(Color.LIGHT_GRAY);
        pan.setVisible(true);
        pan.setBounds(360, 270, 400, 180);
        pan.setLayout(null);

        tex.setFont(new Font("Cambria",Font.ITALIC,20));
        tex.setForeground(Color.black);
        tex.setText("Soluciones");
        tex.setBounds(0, 0, 400, 50);
        pan.add(tex);
        tex2.setFont(new Font("Cambria",Font.ITALIC,20));
        tex2.setForeground(Color.black);
        tex2.setText("Numero pedidos");
        tex2.setBounds(0, 70, 400, 50);

        pan.add(tex2);
        
        JFrame Ventana = new JFrame();
        
        Ordenar(Ventana);
        Ventana.setSize(800, 500);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.getContentPane().setBackground(Color.LIGHT_GRAY);
        Ventana.add(pan);
        Ventana.setLayout(null);
        

        
        
        
        
        
        
        
        
        
        
        Ventana.setLocationRelativeTo(null);
        Ventana.setVisible(true);
        
        
    }
    
    
    public static void Ordenar (JFrame Ventana){
        JLabel labe = new JLabel();
        labe.setBackground(Color.white);
        labe.setBounds(120,10,500,80);
        labe.setFont(new Font("Cambria",Font.ITALIC,40));
        labe.setText("TEORIA DE INVENTARIOS");
        labe.setVisible(true);
        Ventana.add(labe);
        
        
        
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
        
        
        //Creamos labels para saber que variable va en cada campo
        JLabel Ldem  = new JLabel("Demanda");
        JLabel LCorden  = new JLabel("Costo orden");
        JLabel LCman  = new JLabel("C.mantenimiento");
        JLabel LCpen  = new JLabel("C.penalizacion");
        JLabel LTd  = new JLabel("Tasa demanda");
        JLabel LTp = new JLabel("Tasa produccion");
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
        
                

        cmDem.addItem("Dias");
        cmDem.addItem("Anios");
        cmMan.addItem("Dias");
        cmMan.addItem("Anios");
        diasMes.setValue(20);
        
        

        //Le damos las posiciones a todos los campos de datos
        cmDem.setBounds(50, 200, 100, 30);
        cmMan.setBounds(290, 200, 100, 30);
        diasMes.setBounds(490, 200, 100, 30);

        
        Ventana.add(cmDem);
        Ventana.add(cmMan);
        Ventana.add(diasMes);
        
        
        //Creamos labels para saber que variable va en cada campo
        JLabel cmdem  = new JLabel("Unidad de tiempo");
        JLabel cmman  = new JLabel("Unidad de tiempo");
        JLabel cmdm  = new JLabel("Dias trabajados al mes");

        //Posicionamos los nombres de los campos encima de estos
        
        cmdem.setBounds(50, 240, 160, 30);
        cmman.setBounds(290, 240, 160, 30);
        cmdm.setBounds(490, 240, 150, 30);
        
        Ventana.add(cmdem);
        Ventana.add(cmman);
        Ventana.add(cmdm);
                
        
        
        TCorden.setBounds(170, 140, 100, 30);
        TCman.setBounds(290, 140, 100, 30);
        TCpen.setBounds(410, 140, 100, 30);
        TTd.setBounds(530, 140, 100, 30);
        TTp.setBounds(650, 140, 100, 30);
        
        //Posicionamos los botones
        
        JButton opc  = new JButton("Opciones");
        opc.setBounds(50, 300, 100, 25);
        opc.setBackground(Color.green);
        opc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mostrar(Tdem.getValue(), TCorden.getValue(),TCman.getValue(),
                        TCpen.getValue(), TTd.getValue(), TTp.getValue());
            }
        });
        opc.setVisible(true);
        Ventana.add(opc);
        BEoq.setBounds(220, 300, 100, 25);
        BEoq.setVisible(false);
        BEoq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mEOQ(Tdem.getValue(), TCorden.getValue(),TCman.getValue());
            }
        });
        Ventana.add(BEoq);
        BCsd.setBounds(50, 340, 150, 25);
        BCsd.setVisible(false);
        BCsd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mEOQ(Tdem.getValue(), TCorden.getValue(),TCman.getValue());
            }
        });
        Ventana.add(BCsd);
        BCcd.setBounds(220, 340, 150, 25);
        BCcd.setVisible(false);
        BCcd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mCcd(Tdem.getValue(), TCorden.getValue(),TCman.getValue(),TCpen.getValue());
            }
        });
        
        Ventana.add(BCcd);
        BMsd.setBounds(50, 380, 150, 25);
        BMsd.setVisible(false);
        BMsd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mMsd(Tdem.getValue(), TCorden.getValue(),TCman.getValue(), TTd.getValue(), TTp.getValue());
            }
        });
        Ventana.add(BMsd);
        BMcd.setBounds(220, 380, 150, 25);
        BMcd.setVisible(false);
        BMcd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mMcd(Tdem.getValue(), TCorden.getValue(),TCman.getValue(),TCpen.getValue(), TTd.getValue(), TTp.getValue());
            }
        });
        Ventana.add(BMcd);
             
        
    }

    
    public static void mostrar(Object a,Object b,Object c,Object d,Object e,Object f ){
        if (!a.equals(0) && !b.equals(0) && !c.equals(0)){
                BEoq.setVisible(true);
                BCsd.setVisible(true);
                BCcd.setVisible(false);
                BMsd.setVisible(false);
                BMcd.setVisible(false);
                if (!d.equals(0)){
                    BCcd.setVisible(true);
                }
                if (!e.equals(0) && !f.equals(0)){
                    BMsd.setVisible(true);
                    if (!d.equals(0)){
                        BMcd.setVisible(true);
                    }
                }
        }
         
        
    }
    //Metodo EOQ o compra sin deficit
    public static void mEOQ(Object a,Object b,Object c){
        int de = (int) a;
        int cosO = (int) b;
        int cosM = (int) c;
        //Pasamos un dato a decimal para que la respuesta no nos arroje siempre un entero
        float dem = (float) de;
        float cosOr = (float) cosO;
        float cosMan = (float) cosM; 
        //Obtenemos el dato de dias trabajados al mes por si se necesita mas adelante
        int x = (int)diasMes.getValue();
        float Q = 10;
        float demandaDiaria = 0;
        float mantenimientoDiario = 0;
        
        String CD = cmDem.getSelectedItem().toString();
        String CM = cmMan.getSelectedItem().toString();
        
        if (CD.equals("Anios")){
            demandaDiaria = dem/(12*x);
            if (CM.equals("Anios")){
                Q = (float) Math.sqrt(2*dem*cosOr/cosMan);
            }
            //Caso en que este la demanda en anio y el mantenimiento en dias
            else {
                Q = (float) Math.sqrt(2*demandaDiaria*cosOr/cosMan);
            }
        }
        if (CD.equals("Dias")){
            demandaDiaria = dem;
            //Caso en que este la demanda en dias y el mantenimiento en anios
            if (CM.equals("Anios")){
                mantenimientoDiario = cosMan/ (12*x);
                Q = (float) Math.sqrt(2*dem*cosOr/mantenimientoDiario);
            }
            
            else {
                Q = (float) Math.sqrt(2*demandaDiaria*cosOr/cosMan);
            }
        }
        
        Q = (int)Q;
        
        String x1 = "Se necesitan:" + (Q+1) + " unidades por pedido";
        tex.setText(x1);
        tex2.setText("Se hace en " + (int)(dem/Q +1) + " pedidos");
        
    }
    //Metodo compra con deficit
    public static void mCcd(Object a,Object b,Object c, Object d){
        //Le sacamos la parte entera a cada objeto
        int de = (int) a;
        int cosO = (int) b;
        int cosMa = (int) c;
        int cosPe = (int) d;
        //Pasamos esa parte entera a flotante para poder ver los decimales
        float dem = (float) de;
        float cosOr = (float) cosO;
        float cosMan = (float) cosMa;
        float cosPen = (float) cosPe;
        //Miramos cuantos dias se trabajan al mes
        int x = (int)diasMes.getValue();
        //Iniciamos la variable Q (cantidad optima a pedir)
        float  Q = 11;
        //Miramos que campos tienen las opciones de unidad de tiempo
        String CD = cmDem.getSelectedItem().toString();
        String CM = cmMan.getSelectedItem().toString();
        //Creamos variables de demanda y manteimiento diarios en casos de que toque convertir
        float demandaDiaria = 0;
        float mantenimientoDiario = 0;
        /*
        Miramos si estan en la misma unidad de tiempo, sino convertimos los datos
        para trabajarlos en la misma unidad de tiempo
        */
        if (CD.equals("Anios")){
            demandaDiaria = dem/(12*x);
            if (CM.equals("Anios")){
                Q = (int)Math.sqrt(((2*dem*cosOr*(cosPen+cosMan))/(cosMan*cosPen)));
            }
            //Caso en que este la demanda en anio y el mantenimiento en dias
            else {
                Q = (int) Math.sqrt(2*demandaDiaria*cosOr*(cosPen+cosMan)/(cosMan*cosPen));
            }
        }
        if (CD.equals("Dias")){
            
            demandaDiaria = dem;
            //Caso en que este la demanda en dias y el mantenimiento en anios
            if (CM.equals("Anios")){
                mantenimientoDiario = cosMan/ (12*x);
                Q = (int) Math.sqrt(2*demandaDiaria*cosOr*(cosPen+mantenimientoDiario)/(mantenimientoDiario*cosPen));
            }
            
            else {
                Q = (float)Math.sqrt((2*dem*cosOr*(cosPen+cosMan))/(cosMan*cosPen));
            }
        }
        Q = (int)Q;
        String x1 = "Se necesitan:" + (Q+1) + " unidades por pedido";
        tex.setText(x1);
        tex2.setText("Se hace en " + (int)(dem/Q +1) + " pedidos");
    }
    //Metodo manofactura sin deficit
    public static void mMsd(Object a,Object b,Object c, Object e,Object f){
        
        //Le sacamos la parte entera a cada objeto
        int de = (int) a;
        int cosO = (int) b;
        int cosMa = (int) c;
        int tde = (int)e;
        int tpro = (int)f;
        //Pasamos esa parte entera a flotante para poder ver los decimales
        float dem = (float) de;
        float cosOr = (float) cosO;
        float cosMan = (float) cosMa;
        float tdem = (float) tde;
        float tprod = (float) tpro;
        //Tomamos el numero de dias trabajados al mes
        int x = (int)diasMes.getValue();
        //Iniciamos la variable Q (cantidad optima a pedir)
        float Q = 11;
        //Creamos variables de demanda y manteimiento diarios en casos de que toque convertir
        float demandaDiaria = 0;
        float mantenimientoDiario = 0;
        //Tomamos los valores de seleccion de anios o dias
        String CD = cmDem.getSelectedItem().toString();
        String CM = cmMan.getSelectedItem().toString();
        if (CD.equals("Anios")){
            demandaDiaria = dem/(12*x);
            if (CM.equals("Anios")){
                 Q = (float) Math.sqrt(2*dem*cosOr/(cosMan*(1-(tdem/tprod))));
            }
            //Caso en que este la demanda en anio y el mantenimiento en dias
            else {
                 Q = (float) Math.sqrt(2*demandaDiaria*cosOr/(cosMan*(1-(tdem/tprod))));
            }
        }
        if (CD.equals("Dias")){
            
            demandaDiaria = dem;
            //Caso en que este la demanda en dias y el mantenimiento en anios
            if (CM.equals("Anios")){
                mantenimientoDiario = cosMan/ (12*x);
                Q = (float) Math.sqrt(2*dem*cosOr/(mantenimientoDiario*(1-(tdem/tprod))));
            }
            
            else {
                Q = (float) Math.sqrt(2*dem*cosOr/(cosMan*(1-(tdem/tprod))));
            }
        }
        
       Q = (int)Q;
    String x1 = "Se necesitan:" + (Q+1) + " unidades por pedido";
    tex.setText(x1);
    tex2.setText("Se hace en " + (int)(dem/Q +1) + " pedidos");
    }
    //Metodo manofactura con deficit
    public static void mMcd(Object a,Object b,Object c, Object d, Object e,Object f){

    int dem = (int) a;
    int cosOr = (int) b;
    int cosMan = (int) c;
    int pena = (int) d;
    int tdem = (int)e;
    int tprod = (int)f;
    float xtdem = (float) tdem;
    int x = (int)diasMes.getValue();
    float Q = (float) Math.sqrt(2*dem*cosOr*(pena+cosMan)/(cosMan*pena*(1-(xtdem/tprod))));
    float demandaDiaria = 0;
    float mantenimientoDiario = 0;
    System.out.println();
    String CD = cmDem.getSelectedItem().toString();
    String CM = cmMan.getSelectedItem().toString();
    if (CD.equals("Anios")){
        demandaDiaria = dem/(12*x);
        if (CM.equals("Anios")){
             Q = (float) Math.sqrt(2*dem*cosOr*(pena+cosMan)/(cosMan*pena*(1-(xtdem/tprod))));
        }
        //Caso en que este la demanda en anio y el mantenimiento en dias
        else {
             Q = (float) Math.sqrt(2*demandaDiaria*cosOr*(pena+cosMan)/(cosMan*pena*(1-(xtdem/tprod))));
        }
    }
    if (CD.equals("Dias")){

        demandaDiaria = dem;
        //Caso en que este la demanda en dias y el mantenimiento en anios
        if (CM.equals("Anios")){
            mantenimientoDiario = cosMan/ (12*x);
            Q = (float) Math.sqrt(2*dem*cosOr*(pena+mantenimientoDiario)/(mantenimientoDiario*pena*(1-(xtdem/tprod))));
        }

        else {
            Q = (float) Math.sqrt(2*dem*cosOr*(pena+cosMan)/(cosMan*pena*(1-(xtdem/tprod))));
        }
    }

    Q = (int)Q;
    String x1 = "Se necesitan:" + (Q+1) + " unidades por pedido";
    tex.setText(x1);
    tex2.setText("Se hace en " + (int)(dem/Q +1) + " pedidos");
}

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
