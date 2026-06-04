package com.peliculas.gui;

import com.peliculas.dao.PeliculaDAO;
import com.peliculas.dao.PeliculaDAOimpl;
import com.peliculas.model.Pelicula;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class peliculasGUI {

    // Componentes con nombres automáticos por defecto
    private JPanel panel1;
    private JTextField textField1; // ID
    private JTextField textField2; // Título
    private JTextField textField3; // Director
    private JTextField textField4; // Año
    private JTextField textField5; // Duración
    private JTextField textField6; // Vistas
    private JTextField textField7; // Categoría
    private JButton button1; // Agregar
    private JButton button2; // Buscar ID
    private JButton button3; // Listar Todo
    private JButton button4; // Filtrar
    private JButton button5; // Exportar TXT
    private JTextArea textArea1; // Resultados

    private PeliculaDAO dao;

    public peliculasGUI() {
        // Conexión con tu capa de datos en Neon
        dao = new PeliculaDAOimpl();

        // 1. BOTÓN: Adicionar Registro
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pelicula p = new Pelicula();
                    p.setTitulo(textField2.getText());
                    p.setDirector(textField3.getText());
                    p.setAnio(Integer.parseInt(textField4.getText()));
                    p.setDuracionMin(Integer.parseInt(textField5.getText()));
                    p.setVistas(Integer.parseInt(textField6.getText()));
                    p.setIdCategoria(Integer.parseInt(textField7.getText()));
                    p.setIdClasificacion(1);

                    dao.agregar(p);
                    textArea1.setText("ÉXITO: ¡La película se guardó correctamente en Neon!");
                    limpiarCampos();
                } catch (Exception ex) {
                    textArea1.setText("ERROR: Revisa que los campos numéricos sean correctos.\n" + ex.getMessage());
                }
            }
        });

        // 2. BOTÓN: Consultar por ID
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textField1.getText());
                    Pelicula p = dao.buscarPorId(id);
                    if (p != null) {
                        textArea1.setText("=== CONSULTA INDIVIDUAL ===\n" + p.toString());
                    } else {
                        textArea1.setText("No se encontró ninguna película con el ID: " + id);
                    }
                } catch (Exception ex) {
                    textArea1.setText("ERROR: Ingresa un número de ID válido en el primer campo para buscar.");
                }
            }
        });

        // 3. BOTÓN: Consultar Todos
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Pelicula> lista = dao.obtenerTodos();
                StringBuilder sb = new StringBuilder("=== REPORTE GENERAL DE PELÍCULAS ===\n");
                for (Pelicula p : lista) {
                    sb.append(p.toString()).append("\n");
                }
                textArea1.setText(sb.toString());
            }
        });

        // 4. BOTÓN: Filtrar por Criterio
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int anio = Integer.parseInt(textField4.getText());
                    int categoria = Integer.parseInt(textField7.getText());

                    List<Pelicula> lista = dao.filtrarPorAnioYCategoria(anio - 5, anio + 5, categoria);

                    StringBuilder sb = new StringBuilder("=== REPORTE FILTRADO (Año Rango y Categoría) ===\n");
                    for (Pelicula p : lista) {
                        sb.append(p.toString()).append("\n");
                    }
                    textArea1.setText(sb.toString());
                } catch (Exception ex) {
                    textArea1.setText("ERROR: Coloca valores en 'Año' y 'Categoría' para poder filtrar.");
                }
            }
        });

        // 5. BOTÓN: Exportar a .txt
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido = textArea1.getText();
                if (contenido.trim().isEmpty() || contenido.startsWith("ERROR")) {
                    JOptionPane.showMessageDialog(null, "No hay datos válidos en pantalla para exportar.", "Atención", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try (FileWriter fw = new FileWriter("reporte_consulta.txt");
                     PrintWriter pw = new PrintWriter(fw)) {

                    pw.print(contenido);
                    JOptionPane.showMessageDialog(null, "¡Reporte exportado con éxito a 'reporte_consulta.txt'!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Gestión de Películas - Entrega Final");
        peliculasGUI ventana = new peliculasGUI();

        frame.setContentPane(ventana.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}