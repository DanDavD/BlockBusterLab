/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author danie
 */
public class Main extends JFrame{
    private BlockBuster blockBuster;
    private JTextField codigoField, nombreField, tipoField, diasField;
    private JTextArea outputArea;

    public Main() {
        blockBuster = new BlockBuster();

        JLabel codigoLabel = new JLabel("Código:");
        codigoField = new JTextField(10);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(10);

        JLabel tipoLabel = new JLabel("Tipo (MOVIE/GAME):");
        tipoField = new JTextField(10);

        JLabel diasLabel = new JLabel("Días:");
        diasField = new JTextField(10);

        JButton buscarButton = new JButton("Buscar");
        JButton agregarButton = new JButton("Agregar");
        JButton rentarButton = new JButton("Rentar");
        JButton auditarButton = new JButton("Auditar Estados");

        outputArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel panel = new JPanel();
        panel.add(codigoLabel);
        panel.add(codigoField);
        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(tipoLabel);
        panel.add(tipoField);
        panel.add(diasLabel);
        panel.add(diasField);
        panel.add(buscarButton);
        panel.add(agregarButton);
        panel.add(rentarButton);
        panel.add(auditarButton);
        panel.add(scrollPane);

        add(panel);
        buscarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String tipo = tipoField.getText().toUpperCase();
                BlockBusterItem item = blockBuster.buscarItem(codigo, tipo);
                outputArea.setText((item != null) ? item.toString() : "Item no encontrado.");
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String nombre = nombreField.getText();
                String tipo = tipoField.getText().toUpperCase();
                blockBuster.agregarItem(codigo, nombre, tipo);
            }
        });

        rentarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoField.getText());
                String tipo = tipoField.getText().toUpperCase();
                int dias = Integer.parseInt(diasField.getText());
                BlockBusterItem item = blockBuster.buscarItem(codigo, tipo);
                outputArea.setText((item != null) ? item.toString() + "\nMonto a pagar: " + item.pagoRenta(dias) : "Item no encontrado.");
            }
        });

        auditarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                blockBuster.auditarMovieEstados();
                outputArea.setText("Estados auditados.");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BlockBuster App");
        setSize(500, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
    

