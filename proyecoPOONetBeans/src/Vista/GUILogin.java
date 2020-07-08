/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jahaziel
 */
public class GUILogin extends javax.swing.JFrame {
	//Atributo 
	Fondo fondo1 = new Fondo();
	ArrayList<Persona> personas;

	/**
	 * Creates new form GUILoggin
	 */
	public GUILogin(ArrayList<Persona> personas) {
		//Pesonalizar JFrame
		this.setContentPane(fondo1);
		
		//LLenar JFrame
		initComponents();
		ponerIconos();
		
		//Pasa Datos
		this.personas = personas;
		
		//Localizar JFrame
		this.setLocationRelativeTo(null);
		
	}

	private GUILogin() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ingredarJFrame = new javax.swing.JPanel();
        lbUsuario = new javax.swing.JLabel();
        lbUsuarioIcono = new javax.swing.JLabel();
        lbContrasena = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        lbContrasenaIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Administacion Biblotecaria SIB");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Iniciar Sesión");

        ingredarJFrame.setBackground(new java.awt.Color(102, 255, 204));
        ingredarJFrame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("Usuario:");

        lbContrasena.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbContrasena.setForeground(new java.awt.Color(255, 255, 255));
        lbContrasena.setText("Contraseña:");

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));

        password.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(0, 0, 0));

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(102, 255, 204));
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ingredarJFrameLayout = new javax.swing.GroupLayout(ingredarJFrame);
        ingredarJFrame.setLayout(ingredarJFrameLayout);
        ingredarJFrameLayout.setHorizontalGroup(
            ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingredarJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ingredarJFrameLayout.createSequentialGroup()
                        .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingredarJFrameLayout.createSequentialGroup()
                                .addComponent(lbContrasenaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbContrasena)
                                .addGap(18, 18, 18))
                            .addGroup(ingredarJFrameLayout.createSequentialGroup()
                                .addComponent(lbUsuarioIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ingredarJFrameLayout.createSequentialGroup()
                        .addComponent(btnIngresar)
                        .addContainerGap())))
        );
        ingredarJFrameLayout.setVerticalGroup(
            ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ingredarJFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUsuarioIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbContrasenaIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ingredarJFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbContrasena)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(ingredarJFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(ingredarJFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
		// TODO add your handling code here:
		for (Persona p : personas) {
			//if(p.equals(persona))
		}
    }//GEN-LAST:event_btnIngresarActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {			
			public void run() {
				new GUILogin().setVisible(true);
			}
		});
	}
	
	/*
	***************Pone iconos a la interface*****************
	*/
	public void ponerIconos(){
		//Conexion de Imagen al Icono
		ImageIcon iconoUsuario= new ImageIcon(getClass().getResource("Imagenes/usuario.png"));
		ImageIcon iconoContrasena= new ImageIcon(getClass().getResource("Imagenes/contraseña.png"));
		//Asignacion del tamaño
		Icon fondo1 = new ImageIcon(iconoUsuario.getImage().getScaledInstance(lbUsuarioIcono.getWidth(),lbUsuarioIcono.getHeight(),Image.SCALE_DEFAULT));
		Icon fondo2 = new ImageIcon(iconoContrasena.getImage().getScaledInstance(lbContrasenaIcono.getWidth(),lbContrasenaIcono.getHeight(),Image.SCALE_DEFAULT));
		
		//Asignacion al Label
		lbUsuarioIcono.setIcon(fondo1);
		lbContrasenaIcono.setIcon(fondo2);
		
		//Mostrar
		this.repaint();
	} 
	
	/*
	*************************Clase que permite poner imagen de Fondo**************************
	*/
	class Fondo extends JPanel{
		//Atributos
		private Image imagen;
		
		//Metodos
		@Override
		public void paint(Graphics g){
			imagen = new ImageIcon(getClass().getResource("Imagenes/fondo.png")).getImage();
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paint(g);
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JPanel ingredarJFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbContrasena;
    private javax.swing.JLabel lbContrasenaIcono;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbUsuarioIcono;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
	
}
