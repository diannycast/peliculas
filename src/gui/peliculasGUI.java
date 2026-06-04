package gui;

import com.peliculas.dao.PeliculaDAO;
import com.peliculas.dao.PeliculaDAOimpl;

import javax.swing.*;

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
    // Capa de datos del proyecto
    private PeliculaDAO dao;

    public PeliculasGUI() {
        // Inicializamos la conexión con Neon
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
                    p.setIdClasificacion(1); // Valor base por defecto

                    dao.agregar(p);
                    textArea1.setText("ÉXITO: ¡La película se guardó correctamente en Neon!");
                    limpiarCampos();
                } catch (Exception ex) {
                    textArea1.setText("ERROR: Revisa que los campos numéricos sean correctos.\n" + ex.getMessage());
                }
            }
        });
