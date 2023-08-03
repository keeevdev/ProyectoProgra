/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Kevin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ProduccionesPalaceApp extends JFrame {
    private LinkedList<Usuario> usuarios = new LinkedList<>();

    private class GradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();

            Color startColor = new Color(0, 92, 191); // Azul oscuro
            Color endColor = new Color(0, 173, 239); // Azul claro

            GradientPaint gradient = new GradientPaint(0, 0, startColor, 0, height, endColor);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, width, height);
        }
    }

    public ProduccionesPalaceApp() {
        super("Producciones Palace - Sistema de Usuarios");

        JLabel lblTitulo = new JLabel("Bienvenido");
        lblTitulo.setFont(new Font("SFPRODISPLAYBOLD", Font.BOLD, 18));
        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblPassword = new JLabel("Contraseña:");
        JTextField txtUsuario = new JTextField(20);
        JPasswordField txtPassword = new JPasswordField(20);
        JButton btnIngresar = new JButton("Ingresar");
        JButton btnCrearUsuario = new JButton("Nuevo usuario");

        JPanel panel = new GradientPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        panel.add(lblTitulo, c);
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(lblUsuario, c);
        c.gridx = 2;
        panel.add(txtUsuario, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(lblPassword, c);
        c.gridx = 2;
        panel.add(txtPassword, c);
        c.gridy = 6;
        c.gridwidth = 4;
        panel.add(btnIngresar, c);
        c.gridy = 8;
        panel.add(btnCrearUsuario, c);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String password = new String(txtPassword.getPassword());

                if (autenticarUsuario(usuario, password)) {
                    JOptionPane.showMessageDialog(ProduccionesPalaceApp.this, "Bienvenido, " + usuario + "!");
                    SwingUtilities.invokeLater(()-> new EventosApp());
                
                } else {
                    JOptionPane.showMessageDialog(ProduccionesPalaceApp.this, "Credenciales incorrectas. Intente de nuevo.");
                }
            }
        });

        btnCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crear un nuevo usuario
                JTextField txtNombre = new JTextField(20);
                JTextField txtApellidos = new JTextField(20);
                JTextField txtNuevoUsuario = new JTextField(20);
                JPasswordField txtNuevaPassword = new JPasswordField(20);
                JCheckBox chkActivo = new JCheckBox("Activo");
                JTextField txtCorreo = new JTextField(20);

                JPanel panelCrearUsuario = new JPanel(new GridLayout(0, 1));
                panelCrearUsuario.add(new JLabel("Nombre:"));
                panelCrearUsuario.add(txtNombre);
                panelCrearUsuario.add(new JLabel("Primer apellido:"));
                panelCrearUsuario.add(txtApellidos);
                panelCrearUsuario.add(new JLabel("Usuario:"));
                panelCrearUsuario.add(txtNuevoUsuario);
                panelCrearUsuario.add(new JLabel("Contraseña:"));
                panelCrearUsuario.add(txtNuevaPassword);
                panelCrearUsuario.add(chkActivo);
                panelCrearUsuario.add(new JLabel("Correo:"));
                panelCrearUsuario.add(txtCorreo);

                int result = JOptionPane.showConfirmDialog(ProduccionesPalaceApp.this, panelCrearUsuario, "Crear Nuevo Usuario",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    String nombre = txtNombre.getText();
                    String apellidos = txtApellidos.getText();
                    String nuevoUsuario = txtNuevoUsuario.getText();
                    String nuevaPassword = new String(txtNuevaPassword.getPassword());
                    boolean estadoActivo = chkActivo.isSelected();
                    String correo = txtCorreo.getText();

                    Usuario nuevoUsuarioObj = new Usuario(nombre, apellidos, nuevoUsuario, nuevaPassword, estadoActivo, correo);
                    agregarUsuario(nuevoUsuarioObj);
                    JOptionPane.showMessageDialog(ProduccionesPalaceApp.this, "Usuario creado exitosamente!");
                    
                    
                  btnIngresar.addActionListener(new ActionListener() {
                      public void actionPerformed(ActionEvent e) {
                          String usuario = txtUsuario.getText();
                          String password = new String(txtPassword.getPassword());
                          if (autenticarUsuario(usuario, password)) {
                              JOptionPane.showMessageDialog(ProduccionesPalaceApp.this, "Bienvenido, " + usuario + "!");
                              SwingUtilities.invokeLater(() -> new EventosApp());
                          } else {
                              JOptionPane.showMessageDialog(ProduccionesPalaceApp.this, "Credenciales incorrectas. Intente de nuevo.");
                          }}});

                    
                
                    
                    
                } else {
                    JOptionPane.showInputDialog(ProduccionesPalaceApp.this, "Datos erróneos");
                    
                }
            }
        });

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setVisible(true);
    }

    private boolean autenticarUsuario(String usuario, String password) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getPassword().equals(password) && u.isEstadoActivo()) {
                return true;
            }
        }
        return false;
    }

    // Método para agregar un nuevo usuario a la LinkedList
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public LinkedList<Usuario> consultarUsuarios() {
        return usuarios;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProduccionesPalaceApp());
    }
}
