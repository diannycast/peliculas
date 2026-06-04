package gui;

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

public class PeliculasGUI {
    private JPanel panel1;
    private JTextField textField1; // ID
    private JTextField textField2; // Título
    private JTextField textField3; // Director
    private JTextField textField4; // Año
    private JTextField textField5; // Duración
    private JTextField textField6; // Vistas
    private JTextField textField7; // Categoría
    private JButton button1; // Agregar
    private JButton button2; // Buscar por ID
    private JButton button3; // Listar Todo
    private JButton button4; // Filtrar
    private JButton button5; // Exportar TXT
    private JTextArea textArea1; // Resultados