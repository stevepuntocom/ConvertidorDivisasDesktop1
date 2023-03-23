package convertidorDivisas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class winConvertidorDivisas extends JFrame implements ActionListener{

	private JFrame frmConvertirDeDivisas;
	private JTextField textFieldCantidadOrigen;
	private JTextField textFieldCantidadDestino;
	
	private JComboBox comboBoxDivisaOrigen, comboBoxDivisaDestino;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winConvertidorDivisas window = new winConvertidorDivisas();
					window.frmConvertirDeDivisas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public winConvertidorDivisas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConvertirDeDivisas = new JFrame();
		frmConvertirDeDivisas.setBackground(new Color(102, 204, 255));
		frmConvertirDeDivisas.setResizable(false);
		frmConvertirDeDivisas.setTitle("Convertidor de divisas");
		frmConvertirDeDivisas.setBounds(100, 100, 732, 471);
		frmConvertirDeDivisas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConvertirDeDivisas.getContentPane().setLayout(null);
		
		//ImageIcon icon = new ImageIcon(C:\Users\steve\eclipse-workspace2\convertidorDivisas\media\FlagofDominicanRepublic_6545.ico);
		
		frmConvertirDeDivisas.setLocationRelativeTo(null);
		
		textFieldCantidadOrigen = new JTextField();
		textFieldCantidadOrigen.setBounds(325, 103, 256, 19);
		frmConvertirDeDivisas.getContentPane().add(textFieldCantidadOrigen);
		textFieldCantidadOrigen.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(325, 76, 96, 13);
		//Image img = icon.getImage();
		//lblCantidad.setIcon(icon);
//		lblCantidad.setIcon("C:\Users\steve\eclipse-workspace2\convertidorDivisas\media\FlagofDominicanRepublic_6545.ico");
		frmConvertirDeDivisas.getContentPane().add(lblCantidad);
		
		comboBoxDivisaOrigen = new JComboBox();
		comboBoxDivisaOrigen.setModel(new DefaultComboBoxModel(new String[] {"Peso dominicano - DOP", "Gourde haitiano - HTG", "Dolar canadiense - CAD", "Dolar americano - USD"}));
		comboBoxDivisaOrigen.setBounds(99, 102, 185, 21);
		frmConvertirDeDivisas.getContentPane().add(comboBoxDivisaOrigen);
		
		comboBoxDivisaDestino = new JComboBox();
		comboBoxDivisaDestino.setModel(new DefaultComboBoxModel(new String[] {"Peso dominicano - DOP", "Gourde haitiano - HTG", "Dolar canadiense - CAD", "Dolar americano - USD"}));
		comboBoxDivisaDestino.setBounds(99, 170, 179, 21);
		frmConvertirDeDivisas.getContentPane().add(comboBoxDivisaDestino);
		
		//ConvertidorDivisas convertidorDivisas = new ConvertidorDivisas();
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(199, 245, 85, 21);
		btnCalcular.addActionListener(this);
		frmConvertirDeDivisas.getContentPane().add(btnCalcular);
		
		textFieldCantidadDestino = new JTextField();
		textFieldCantidadDestino.setEditable(false);
		textFieldCantidadDestino.setBounds(325, 171, 256, 19);
		frmConvertirDeDivisas.getContentPane().add(textFieldCantidadDestino);
		textFieldCantidadDestino.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (btnCalcular == e.getSource()) {
			double cantidadOrigen = Double.valueOf(textFieldCantidadOrigen.getText());
			double cantidadDestino = 0.0;//Double.valueOf(textFieldCantidadDestino.getText());
			String divisaOrigen = (String) comboBoxDivisaOrigen.getSelectedItem();
			String divisaDestino = (String) comboBoxDivisaDestino.getSelectedItem();
			//textFieldCantidadDestino.setText(textFieldCantidadOrigen.getText());
			//textFieldCantidadDestino.setText(Integer.toString(cantidadOrigen), comboBoxDivisaOrigen.getSelectedItem(), Integer.toString(cantidadDestino), comboBoxDivisaDestino.getSelectedItem());
			//System.out.println(comboBoxDivisaDestino.getSelectedItem());
			//calcular(cantidadOrigen, cantidadDestino, divisaOrigen, divisaDestino);
			textFieldCantidadDestino.setText(calcular(cantidadOrigen, cantidadDestino, divisaOrigen, divisaDestino));
			//convertidorDivisas.procesar();
		}
	}

	private String calcular(double cantidad1, double cantidad2, String divisa1, String divisa2) {

		double tasaDopCad = 0.025218d;
		double tasaDopUsd = 0.01851851852d;
		double tasaDopHtg = 2.819773d;
		double tasaCadDop = 40;
		double tasaCadUsd = 0.726137d;
		double tasaCadHtg = 111.816056d;
		double tasaUsdCad = 1.377150593d;
		double tasaUsdDop = 54d;
		double tasaUsdHtg = 153.987479d;
		double tasaHtgCad = 0.008943259d;
		double tasaHtgUsd = 0.006494034d;
		double tasaHtgDop = 0.354638476d;
		double tasa = 0;
		
//		Peso dominicano - DOP
//		Gourde haitiano - HTG
//		Dolar canadiense - CAD
//		Dolar americano - USD
		
		if (divisa1 == divisa2) {
			//System.out.println(cantidadOrigen);
			//return Double.toString(cantidad1);
			tasa = 1;

			//System.out.println(Double.toString(cantidadOrigen));
			//textFieldCantidadDestino.setText(Double.toString(cantidadOrigen));
			//this.textFieldCantidadDestino.setText((String) cantidadOrigen);
		}
		else if (divisa1 == "Peso dominicano - DOP" && divisa2 == "Gourde haitiano - HTG") {
			tasa = tasaDopHtg;
		}
		else if (divisa1 == "Peso dominicano - DOP" && divisa2 == "Dolar canadiense - CAD") {
			tasa = tasaDopCad;
			
		}
		else if (divisa1 == "Peso dominicano - DOP" && divisa2 == "Dolar americano - USD") {
			tasa = tasaDopUsd;
		}
		else if (divisa1 == "Gourde haitiano - HTG" && divisa2 == "Peso dominicano - DOP") {
			tasa = tasaHtgDop;
		}
		else if (divisa1 == "Gourde haitiano - HTG" && divisa2 == "Dolar canadiense - CAD") {
			tasa = tasaHtgCad;
		}
		else if (divisa1 == "Gourde haitiano - HTG" && divisa2 == "Dolar americano - USD") {
			tasa = tasaHtgUsd;
		}
		else if (divisa1 == "Dolar canadiense - CAD" && divisa2 == "Gourde haitiano - HTG") {
			tasa = tasaCadHtg;
		}
		else if (divisa1 == "Dolar canadiense - CAD" && divisa2 == "Peso dominicano - DOP") {
			tasa = tasaCadDop;
		}
		else if (divisa1 == "Dolar canadiense - CAD" && divisa2 == "Dolar americano - USD") {
			tasa = tasaCadUsd;
		}
		else if (divisa1 == "Dolar americano - USD" && divisa2 == "Dolar canadiense - CAD") {
			tasa = tasaUsdCad;
		}
		else if (divisa1 == "Dolar americano - USD" && divisa2 == "Peso dominicano - DOP") {
			tasa = tasaUsdDop;
		}
		else if (divisa1 == "Dolar americano - USD" && divisa2 == "Gourde haitiano - HTG") {
			tasa = tasaUsdHtg;
		}
		//cantidad2 = cantidad1 * tasa;
		return String.valueOf(cantidad1 * tasa);

		
		
		
/*		
 * 1 USD 54			DOP
 * CAD DOP HTG USD
		
		1 CAD	39,8276 	DOP
		1 CAD 	0.7231 		USD
		1 CAD 	111.8323	HTG

		1 DOP 2.8198		HTG
		1 DOP 0.0183		USD
		1 DOP 0.0252		CAD
		
		1 USD 1,361			CAD
		
		1 USD 153.9875		HTG

		1 HTG 0.0065		USD
		1 HTG 0.0089		HTG
		1 HTG 0.3546		DOP

//Source: https://htg.es.currencyrate.today/cad
	private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCad = private double tasaDopCAD = private double tasaDopCAD = private double tasaDopCAD = private double tasaDopCAD = private double tasaDopCAD = private double tasaDopCAD = private double tasaDopCAD = private double tasaDOPCAD = private double tasaDOPCAD = 0;;;;;;;;;;;;;;;;;;;;;;;;;
*/
	}
	
	
}
