/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.*;
import Modelo.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.*;

/**
 *
 * @author Jahaziel
 */
public class GUIAdmin extends javax.swing.JFrame {
	
	//Arreglos de profesores
	ConsultasProfesor con = new ConsultasProfesor();
    ArrayList<Profesor> profes = con.obtenerListaProfesores();
	Profesor seleccionadoP;
	int filasP;
	
	//Arreglos para Materiales
	ConsultasMaterial conM = new ConsultasMaterial();
	ArrayList<Material> materiales = conM.obtenerListaMateriales();
	Material SelecionadoM;
	int filasM;
	
	//Arreglos para Alumnos
	ConsultasAlumno conA = new ConsultasAlumno();
	ArrayList<Alumno> alumnos = conA.obtenerListaAlumnos();
	Alumno seleccionadoA;
	int filasA;
	
	//Atributos para las Tablas
	DefaultTableModel modeloProfesor = new DefaultTableModel();
	DefaultTableModel modeloTelefonoP = new DefaultTableModel();
	DefaultTableModel modeloAlumno = new DefaultTableModel();
	DefaultTableModel modeloTelefonoA = new DefaultTableModel();
	DefaultTableModel modeloMaterial = new DefaultTableModel();
	DefaultTableModel modeloMateria = new DefaultTableModel();
	TableRowSorter trs;
	
	/**
	 * Creates new form GUIAdmin
	 */
	public GUIAdmin() {	
		//LLenar JFrame
		initComponents();
		ponertitulos();
		listarAlumno();
		listarProfesor();
		listarMaterial();
		
		//Localizar JFrame
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(getBackground());
	}
	
	/*
	************************Metodos para Llenar tablas*************************
	*/
	//Inicializar Tablas
	//Poner Titulos
	public void ponertitulos(){
		//Profesores
		String [] cabecera = {"Numero de Empleado","Nombre","Apellido Paterno","Apellido Materno"};
		modeloProfesor.setColumnIdentifiers(cabecera);
		tablaProfe.setModel(modeloProfesor);
		
		//Profesores
		String [] cabeceraA = {"Boleta","Nombre","Apellido Paterno","Apellido Materno","Nivel"};
		modeloAlumno.setColumnIdentifiers(cabeceraA);
		tablaAlumno.setModel(modeloAlumno);
		
		//Materiales
		String [] cabeceraM ={"ID","Titulo","Autor","Año","Area del Conocimiento"};
		modeloMaterial.setColumnIdentifiers(cabeceraM);
		tablaMaterial.setModel(modeloMaterial);
		
		//Telefonos Alumno
		String [] cabeceraTA ={"Telefonos"};
		modeloTelefonoA.setColumnIdentifiers(cabeceraTA);
		tablaTelA.setModel(modeloTelefonoA);
		
		//Materias
		String [] cabeceraMa ={"Materias"};
		modeloMateria.setColumnIdentifiers(cabeceraMa);
		tablaMat.setModel(modeloMateria);
		
		//Telefonos Profesor
		//Telefonos Alumno
		modeloTelefonoP.setColumnIdentifiers(cabeceraTA);
		tablaTelP.setModel(modeloTelefonoP);
		
	}
	/*
	***********************************Llenar tablas****************************
	*/
	//Llenar Profesor
	public void listarProfesor(){
		
		profes.stream().map((p) -> {
			Object []datos = new Object[modeloProfesor.getColumnCount()];
			datos[0]= p.getNumEmpleado();
			datos[1]=p.getNombre();
			datos[2]= p.getApellidoPaterno();
			datos[3]=p.getApellidoMaterno();
			return datos;
		}).forEachOrdered((datos) -> {
			modeloProfesor.addRow(datos);
		});
		tablaProfe.setModel(modeloProfesor);
	}
	//Lenar Alumnos
	public void listarAlumno(){
		for(Alumno a: alumnos){
			Object []datos = new Object[modeloAlumno.getColumnCount()];
			datos[0]= a.getBoleta();
			datos[1]=a.getNombre();
			datos[2]= a.getApellidoPaterno();
			datos[3]=a.getApellidoMaterno();
			datos[4]=a.getNivel();
			modeloAlumno.addRow(datos);
		}
		tablaMaterial.setModel(modeloMaterial);
	}
	//Llenar Material
	public void listarMaterial(){
		for(Material m: materiales){
			Object []datos = new Object[modeloMaterial.getColumnCount()];
			datos[0]= m.getId();
			datos[1]=m.getTitulo();
			datos[2]= m.getAutor();
			datos[3]=m.getAnio();
			datos[4]=m.getAreaConocimiento();
			modeloMaterial.addRow(datos);
		}
		tablaMaterial.setModel(modeloMaterial);
	}
	//Llenar Materias
	public void listarMaterias(ArrayList<String> materias){
		eliminarMaterias();
		for(String m: materias){
			Object []datos = new Object[modeloMateria.getColumnCount()];
			datos[0]= m;
			modeloMateria.addRow(datos);
		}
		tablaMat.setModel(modeloMateria);
		
	}
	
	public void listarTelefonoA(Alumno a){
		ArrayList<String> tel=a.getTelefono();
		eliminarTelefono();
		for(String t: tel){
			Object []datos = new Object[modeloTelefonoA.getColumnCount()];
			datos[0]= t;
			modeloTelefonoA.addRow(datos);
		}
		tablaTelA.setModel(modeloTelefonoA);
	}
	public void listarTelefonoP(Profesor p){
		ArrayList<String> tel=p.getTelefono();
		eliminarTelefonoP();
		for(String t: tel){
			Object []datos = new Object[modeloTelefonoP.getColumnCount()];
			datos[0]= t;
			modeloTelefonoP.addRow(datos);
		}
		tablaTelP.setModel(modeloTelefonoP);
	}
	
	public void eliminarTelefono(){
        DefaultTableModel tb = (DefaultTableModel) tablaTelA.getModel();
        int a = tablaTelA.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
			tb.removeRow(tb.getRowCount()-1);
		}
	}
	public void eliminarTelefonoP(){
        DefaultTableModel tb = (DefaultTableModel) tablaTelP.getModel();
        int a = tablaTelP.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
			tb.removeRow(tb.getRowCount()-1);
		}
	}
	public void eliminarMaterias(){
        DefaultTableModel tb = (DefaultTableModel) tablaMat.getModel();
        int a = tablaMat.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
			tb.removeRow(tb.getRowCount()-1);
		}
	}
	

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPGeneral = new javax.swing.JTabbedPane();
        jPAlumno = new javax.swing.JPanel();
        jPDatosGenerrales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtMaternoA = new javax.swing.JTextField();
        txtPaternoA = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        jDNat = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTelA = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        jCPaterno = new javax.swing.JCheckBox();
        txtBuscadorA = new javax.swing.JTextField();
        jCBoleta = new javax.swing.JCheckBox();
        jCNombre = new javax.swing.JCheckBox();
        jPEscolar = new javax.swing.JPanel();
        jLBoleta = new javax.swing.JLabel();
        jLNivel = new javax.swing.JLabel();
        txtBoleta = new javax.swing.JTextField();
        txtNivel = new javax.swing.JTextField();
        jLFoto = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtUsuarioA = new javax.swing.JTextField();
        txtContraA = new javax.swing.JTextField();
        jBAlta = new javax.swing.JButton();
        jBCambio = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();
        cerrarSesionP1 = new javax.swing.JButton();
        jBIngresateleA = new javax.swing.JButton();
        jPProfesor = new javax.swing.JPanel();
        jPDatosGenerrales1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        txtMaternoP = new javax.swing.JTextField();
        txtPaternoP = new javax.swing.JTextField();
        txtDomicilioP = new javax.swing.JTextField();
        FechaP = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaMat = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaTelP = new javax.swing.JTable();
        Empleado = new javax.swing.JPanel();
        jLNumEmpleado = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jLFoto1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtContraP = new javax.swing.JTextField();
        txtUsuarioP = new javax.swing.JTextField();
        jBAltaP = new javax.swing.JButton();
        jBDajaP = new javax.swing.JButton();
        jBCambiarP = new javax.swing.JButton();
        cerrarSesionP = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaProfe = new javax.swing.JTable();
        jCEmpleadoP = new javax.swing.JCheckBox();
        txtBuscadorP = new javax.swing.JTextField();
        jCPaternoP = new javax.swing.JCheckBox();
        jCNombreP = new javax.swing.JCheckBox();
        jBIngreasarTele = new javax.swing.JButton();
        jBIngresaMate = new javax.swing.JButton();
        jPMaterial = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLID3 = new javax.swing.JLabel();
        jLTitulo3 = new javax.swing.JLabel();
        jLAutor3 = new javax.swing.JLabel();
        jLAnio3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtIDM = new javax.swing.JTextField();
        txtTituloM = new javax.swing.JTextField();
        txtAutorM = new javax.swing.JTextField();
        txtAnioM = new javax.swing.JTextField();
        txtAreaM = new javax.swing.JTextField();
        txtEjemplaresM = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLISBN = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        jRLibro = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLVolumen = new javax.swing.JLabel();
        jLNumero = new javax.swing.JLabel();
        txtVolumen = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        jRRevista = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLClave = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        txtClave = new javax.swing.JTextField();
        jREnlace = new javax.swing.JRadioButton();
        jBCerrar = new javax.swing.JButton();
        jBCambiar = new javax.swing.JButton();
        jBAltaM = new javax.swing.JButton();
        jBaja = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaMaterial = new javax.swing.JTable();
        txtBuscadorM = new javax.swing.JTextField();
        jCArea = new javax.swing.JCheckBox();
        jCAnio = new javax.swing.JCheckBox();
        jCAutor = new javax.swing.JCheckBox();
        jCTitulo = new javax.swing.JCheckBox();
        jCID = new javax.swing.JCheckBox();
        jPPrestamo = new javax.swing.JPanel();
        jBSesionPre = new javax.swing.JButton();
        jBCambiarPr = new javax.swing.JButton();
        jBBajaPre = new javax.swing.JButton();
        jBAltaPre = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administracion de la Bibloteca");

        jPDatosGenerrales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Nombre(s):");

        jLabel2.setText("Apellido Paterno:");

        jLabel3.setText("Apellido Materno:");

        jLabel4.setText("Fecha de Nacimiento:");

        jLabel5.setText("Domicilio:");

        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDatosGenerralesLayout = new javax.swing.GroupLayout(jPDatosGenerrales);
        jPDatosGenerrales.setLayout(jPDatosGenerralesLayout);
        jPDatosGenerralesLayout.setHorizontalGroup(
            jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                        .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(49, 49, 49)
                        .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtPaternoA)
                            .addComponent(txtMaternoA)))
                    .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                        .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(29, 29, 29)
                        .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDomicilio)
                            .addComponent(jDNat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPDatosGenerralesLayout.setVerticalGroup(
            jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPDatosGenerralesLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)))
                .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDNat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPDatosGenerralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablaTelA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefonos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTelA);

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Boleta", "Nombre", "Apellido Paterno", "Apellido Materno", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAlumno);

        jCPaterno.setText("Apellido Paterno");
        jCPaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPaternoActionPerformed(evt);
            }
        });

        txtBuscadorA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorAKeyTyped(evt);
            }
        });

        jCBoleta.setText("Boleta");
        jCBoleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBoletaActionPerformed(evt);
            }
        });

        jCNombre.setText("Nombre");
        jCNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCNombreActionPerformed(evt);
            }
        });

        jPEscolar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Escolares", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLBoleta.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLBoleta.setText("Boleta:");

        jLNivel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLNivel.setText("Nivel:");

        jLFoto.setText("Foto");

        jLabel13.setText("Usuario:");

        jLabel16.setText("Contraseña:");

        txtContraA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEscolarLayout = new javax.swing.GroupLayout(jPEscolar);
        jPEscolar.setLayout(jPEscolarLayout);
        jPEscolarLayout.setHorizontalGroup(
            jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEscolarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNivel)
                    .addComponent(jLBoleta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEscolarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(jPEscolarLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContraA, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(txtUsuarioA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPEscolarLayout.setVerticalGroup(
            jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEscolarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBoleta)
                    .addComponent(txtBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtUsuarioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPEscolarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNivel)
                    .addComponent(txtNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtContraA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPEscolarLayout.createSequentialGroup()
                .addComponent(jLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jBAlta.setText("Dar Alta");
        jBAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaActionPerformed(evt);
            }
        });

        jBCambio.setText("Cambiar");
        jBCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambioActionPerformed(evt);
            }
        });

        jBBaja.setText("Dar Baja");
        jBBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBajaActionPerformed(evt);
            }
        });

        cerrarSesionP1.setText("Cerrar Sesión");
        cerrarSesionP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionP1ActionPerformed(evt);
            }
        });

        jBIngresateleA.setText("Ingresar Telefono");
        jBIngresateleA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresateleAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAlumnoLayout = new javax.swing.GroupLayout(jPAlumno);
        jPAlumno.setLayout(jPAlumnoLayout);
        jPAlumnoLayout.setHorizontalGroup(
            jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAlumnoLayout.createSequentialGroup()
                        .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPAlumnoLayout.createSequentialGroup()
                                .addComponent(jPDatosGenerrales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPAlumnoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPEscolar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAlumnoLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jBIngresateleA)
                                        .addGap(149, 149, 149)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAlumnoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAlumnoLayout.createSequentialGroup()
                                .addComponent(jBAlta)
                                .addGap(18, 18, 18)
                                .addComponent(jBCambio)
                                .addGap(18, 18, 18)
                                .addComponent(jBBaja)
                                .addGap(144, 144, 144)
                                .addComponent(cerrarSesionP1)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPAlumnoLayout.createSequentialGroup()
                                .addComponent(jCBoleta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCNombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCPaterno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscadorA, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(294, 294, 294))))))
        );
        jPAlumnoLayout.setVerticalGroup(
            jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAlumnoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPDatosGenerrales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPAlumnoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBIngresateleA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPEscolar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCNombre)
                    .addComponent(jCPaterno)
                    .addComponent(jCBoleta)
                    .addComponent(txtBuscadorA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPAlumnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBBaja)
                    .addComponent(jBAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cerrarSesionP1))
                .addContainerGap())
        );

        jTPGeneral.addTab("Alumno", jPAlumno);

        jPDatosGenerrales1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel6.setText("Nombre(s):");

        jLabel7.setText("Apellido Paterno:");

        jLabel8.setText("Apellido Materno:");

        jLabel9.setText("Fecha de Nacimiento:");

        jLabel10.setText("Domicilio:");

        javax.swing.GroupLayout jPDatosGenerrales1Layout = new javax.swing.GroupLayout(jPDatosGenerrales1);
        jPDatosGenerrales1.setLayout(jPDatosGenerrales1Layout);
        jPDatosGenerrales1Layout.setHorizontalGroup(
            jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosGenerrales1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosGenerrales1Layout.createSequentialGroup()
                        .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(49, 49, 49)
                        .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreP, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(txtPaternoP)
                            .addComponent(txtMaternoP, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPDatosGenerrales1Layout.createSequentialGroup()
                        .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDomicilioP)
                            .addComponent(FechaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPDatosGenerrales1Layout.setVerticalGroup(
            jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosGenerrales1Layout.createSequentialGroup()
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosGenerrales1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPDatosGenerrales1Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPaternoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaternoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(FechaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPDatosGenerrales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDomicilioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tablaMat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaMat);

        tablaTelP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaTelP);

        Empleado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Escolares", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLNumEmpleado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLNumEmpleado.setText("Num.Empleado");

        txtEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpleadoActionPerformed(evt);
            }
        });

        jLFoto1.setText("Foto");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Usuario");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Contraseña:");

        javax.swing.GroupLayout EmpleadoLayout = new javax.swing.GroupLayout(Empleado);
        Empleado.setLayout(EmpleadoLayout);
        EmpleadoLayout.setHorizontalGroup(
            EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNumEmpleado)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(txtContraP)
                    .addComponent(txtUsuarioP))
                .addGap(26, 26, 26))
        );
        EmpleadoLayout.setVerticalGroup(
            EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumEmpleado)
                    .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtUsuarioP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtContraP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLFoto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jBAltaP.setText("Dar Alta");
        jBAltaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaPActionPerformed(evt);
            }
        });

        jBDajaP.setText("Dar Baja");

        jBCambiarP.setText("Cambiar");
        jBCambiarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarPActionPerformed(evt);
            }
        });

        cerrarSesionP.setText("Cerrar Sesión");
        cerrarSesionP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionPActionPerformed(evt);
            }
        });

        tablaProfe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero de Empleado", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProfe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaProfe);

        jCEmpleadoP.setText("Numero de Empleado");
        jCEmpleadoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCEmpleadoPActionPerformed(evt);
            }
        });

        txtBuscadorP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorPKeyTyped(evt);
            }
        });

        jCPaternoP.setText("Apellido Paterno");
        jCPaternoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPaternoPActionPerformed(evt);
            }
        });

        jCNombreP.setText("Nombre");
        jCNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCNombrePActionPerformed(evt);
            }
        });

        jBIngreasarTele.setText("Ingresar");
        jBIngreasarTele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngreasarTeleActionPerformed(evt);
            }
        });

        jBIngresaMate.setText("Ingresar");
        jBIngresaMate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresaMateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPProfesorLayout = new javax.swing.GroupLayout(jPProfesor);
        jPProfesor.setLayout(jPProfesorLayout);
        jPProfesorLayout.setHorizontalGroup(
            jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProfesorLayout.createSequentialGroup()
                .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPProfesorLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jBAltaP)
                        .addGap(18, 18, 18)
                        .addComponent(jBCambiarP)
                        .addGap(18, 18, 18)
                        .addComponent(jBDajaP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(cerrarSesionP))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPProfesorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPDatosGenerrales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPProfesorLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jBIngreasarTele)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBIngresaMate)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPProfesorLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(Empleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPProfesorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(jPProfesorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCEmpleadoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCNombreP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCPaternoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscadorP, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPProfesorLayout.setVerticalGroup(
            jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProfesorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDatosGenerrales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPProfesorLayout.createSequentialGroup()
                        .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBIngreasarTele)
                            .addComponent(jBIngresaMate))
                        .addGap(1, 1, 1)
                        .addComponent(Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCEmpleadoP)
                    .addComponent(txtBuscadorP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCPaternoP)
                    .addComponent(jCNombreP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAltaP)
                    .addComponent(jBDajaP)
                    .addComponent(jBCambiarP)
                    .addComponent(cerrarSesionP))
                .addContainerGap())
        );

        jTPGeneral.addTab("Profesor", jPProfesor);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLID3.setText("ID:");

        jLTitulo3.setText("Título:");

        jLAutor3.setText("Autor:");

        jLAnio3.setText("Año:");

        jLabel23.setText("Área:");

        jLabel24.setText("Ejemplares:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLID3)
                    .addComponent(jLTitulo3)
                    .addComponent(jLAutor3)
                    .addComponent(jLAnio3)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDM)
                    .addComponent(txtTituloM)
                    .addComponent(txtAutorM)
                    .addComponent(txtAnioM)
                    .addComponent(txtAreaM)
                    .addComponent(txtEjemplaresM, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLID3)
                    .addComponent(txtIDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitulo3)
                    .addComponent(txtTituloM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAutor3)
                    .addComponent(txtAutorM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAnio3)
                    .addComponent(txtAnioM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtAreaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtEjemplaresM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Libro:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLISBN.setText("ISBN:");

        jRLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLISBN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtISBN)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jRLibro)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLISBN)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRLibro))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Revista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLVolumen.setText("Volumen:");

        jLNumero.setText("Numero:");

        jRRevista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRRevistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLVolumen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVolumen))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jRRevista)
                                .addGap(0, 59, Short.MAX_VALUE))
                            .addComponent(txtNumero))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLVolumen)
                    .addComponent(txtVolumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRRevista))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enlace", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel21.setText("URL:");

        jLClave.setText("Clave:");

        jREnlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jREnlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtURL))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLClave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClave)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(0, 17, Short.MAX_VALUE)
                                .addComponent(jREnlace)
                                .addGap(52, 52, 52)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jREnlace))
        );

        jBCerrar.setText("Cerrar Sesión");
        jBCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarActionPerformed(evt);
            }
        });

        jBCambiar.setText("Cambiar");
        jBCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCambiarActionPerformed(evt);
            }
        });

        jBAltaM.setText("Dar Alta");
        jBAltaM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltaMActionPerformed(evt);
            }
        });

        jBaja.setText("Dar Baja");
        jBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBajaActionPerformed(evt);
            }
        });

        tablaMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Titulo", "Autor", "Año", "Area del Conocimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMaterialMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaMaterial);

        txtBuscadorM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscadorMKeyTyped(evt);
            }
        });

        jCArea.setText("Área");
        jCArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAreaActionPerformed(evt);
            }
        });

        jCAnio.setText("Año");

        jCAutor.setText("Autor");
        jCAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCAutorActionPerformed(evt);
            }
        });

        jCTitulo.setText("Título");
        jCTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCTituloActionPerformed(evt);
            }
        });

        jCID.setText("ID");
        jCID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMaterialLayout = new javax.swing.GroupLayout(jPMaterial);
        jPMaterial.setLayout(jPMaterialLayout);
        jPMaterialLayout.setHorizontalGroup(
            jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMaterialLayout.createSequentialGroup()
                .addGroup(jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMaterialLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscadorM, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMaterialLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBAltaM)
                        .addGap(18, 18, 18)
                        .addComponent(jBCambiar)
                        .addGap(18, 18, 18)
                        .addComponent(jBaja)
                        .addGap(167, 167, 167)
                        .addComponent(jBCerrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMaterialLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPMaterialLayout.setVerticalGroup(
            jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMaterialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCArea)
                    .addComponent(jCAnio)
                    .addComponent(jCAutor)
                    .addComponent(jCTitulo)
                    .addComponent(jCID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPMaterialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCerrar)
                    .addComponent(jBCambiar)
                    .addComponent(jBAltaM)
                    .addComponent(jBaja))
                .addContainerGap())
        );

        jTPGeneral.addTab("Material", jPMaterial);

        jBSesionPre.setText("Cerrar Sesión");
        jBSesionPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSesionPreActionPerformed(evt);
            }
        });

        jBCambiarPr.setText("Cambiar");

        jBBajaPre.setText("Dar Baja");

        jBAltaPre.setText("Dar Alta");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable5);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información General", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel14.setText("Fecha de Entrega");

        jLabel15.setText("Fecha del Prestamo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPPrestamoLayout = new javax.swing.GroupLayout(jPPrestamo);
        jPPrestamo.setLayout(jPPrestamoLayout);
        jPPrestamoLayout.setHorizontalGroup(
            jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrestamoLayout.createSequentialGroup()
                .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPPrestamoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrestamoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBAltaPre)
                                .addGap(18, 18, 18)
                                .addComponent(jBCambiarPr)
                                .addGap(18, 18, 18)
                                .addComponent(jBBajaPre)
                                .addGap(136, 136, 136)
                                .addComponent(jBSesionPre))
                            .addComponent(jScrollPane7)))
                    .addGroup(jPPrestamoLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPPrestamoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGap(13, 13, 13)))
        );
        jPPrestamoLayout.setVerticalGroup(
            jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSesionPre)
                    .addComponent(jBCambiarPr)
                    .addComponent(jBBajaPre)
                    .addComponent(jBAltaPre))
                .addContainerGap())
            .addGroup(jPPrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrestamoLayout.createSequentialGroup()
                    .addContainerGap(267, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(152, 152, 152)))
        );

        jTPGeneral.addTab("Prestamo", jPPrestamo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void txtContraAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraAActionPerformed

    private void txtEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpleadoActionPerformed

    private void cerrarSesionP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionP1ActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this, "¡Hasta luego!.");
		this.dispose();
		new GUILogin().setVisible(true);
    }//GEN-LAST:event_cerrarSesionP1ActionPerformed

    private void cerrarSesionPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionPActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this, "¡Hasta luego!.");
		this.dispose();
		new GUILogin().setVisible(true);
    }//GEN-LAST:event_cerrarSesionPActionPerformed

    private void jBCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this, "¡Hasta luego!.");
		this.dispose();
		new GUILogin().setVisible(true);
    }//GEN-LAST:event_jBCerrarActionPerformed

    private void jBSesionPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSesionPreActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this, "¡Hasta luego!.");
		this.dispose();
		new GUILogin().setVisible(true);
    }//GEN-LAST:event_jBSesionPreActionPerformed

    private void jBAltaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaPActionPerformed
        // TODO add your handling code here:
		//Validacion de datos
		if(txtNombreP.getText().isEmpty()||txtPaternoP.getText().isEmpty()||txtMaternoP.getText().isEmpty()||txtDomicilioP.getText().isEmpty()
				||txtContraP.getText().isEmpty()||txtUsuarioP.getText().isEmpty()||FechaP.getDate()==null||txtEmpleado.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Verifica tu llenado, por favor.");
		}
		else{
			String nombre = txtNombreP.getText();
			String apellidoPaterno = txtPaternoP.getText();
			String apellidoMaterno = txtMaternoP.getText();
			Date fechaNacimiento= (Date)FechaP.getDate();
			String domicilio = txtDomicilioP.getText();
			String claveAcceso = txtContraP.getText();
			String nombreUsuario = txtUsuarioP.getText();
			int numEmpleado = Integer.parseInt(txtEmpleado.getText());
			//checamos si existe el empleado
			boolean verdad = false;
			for(Profesor p : profes){
				if(p.getNumEmpleado()==numEmpleado && p.getNombre().equals(nombre)){
					verdad =true;
				}
			}
			if(verdad){
				JOptionPane.showMessageDialog(this,"Profesor ya existe.");
				txtNombreP.setText(null);
				txtPaternoP.setText(null);
				txtMaternoP.setText(null);
				FechaP.setDate(null);
				txtDomicilioP.setText(null);
				txtContraP.setText(null);
				txtUsuarioP.setText(null);
				txtEmpleado.setText(null);
			}
			else{
				ConsultasProfesor conp = new ConsultasProfesor();
				Profesor p= new Profesor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,claveAcceso,nombreUsuario);
				if(conp.registrarProfesor(p)){
					Object []datos = new Object[modeloProfesor.getColumnCount()];
					profes.add(p);
					datos[0]=p.getNumEmpleado();
					datos[1]=p.getNombre();
					datos[2]=p.getApellidoPaterno();
					datos[3]=p.getApellidoMaterno();
					modeloProfesor.addRow(datos);
					JOptionPane.showMessageDialog(this,"Registrado con exito.");
				}
				else{
					JOptionPane.showMessageDialog(this,"Hubo un problema de conexion.");
				}
				txtNombreP.setText(null);
				txtPaternoP.setText(null);
				txtMaternoP.setText(null);
				FechaP.setDate(null);
				txtDomicilioP.setText(null);
				txtContraP.setText(null);
				txtUsuarioP.setText(null);
				txtEmpleado.setText(null);
			}
		}
		
			
    }//GEN-LAST:event_jBAltaPActionPerformed

    private void tablaProfeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfeMouseClicked
        // TODO add your handling code here:
		int seleccion = tablaProfe.rowAtPoint(evt.getPoint());
		filasP=seleccion;
		for(Profesor p : profes){
			if(tablaProfe.getValueAt(seleccion,0).equals(p.getNumEmpleado())){
				seleccionadoP = p;
				txtNombreP.setText(p.getNombre());
				txtPaternoP.setText(p.getApellidoPaterno());
				txtMaternoP.setText(p.getApellidoMaterno());
				FechaP.setDate(p.getFechaNacimiento());
				txtDomicilioP.setText(p.getDomicilio());
				txtContraP.setText(p.getClaveAcceso());
				txtUsuarioP.setText(p.getNombreUsuario());
				txtEmpleado.setText(String.valueOf(p.getNumEmpleado()));
				listarTelefonoP(p);
				listarMaterias(p.getMateriasImparte());
			}
		}
    }//GEN-LAST:event_tablaProfeMouseClicked

    private void txtBuscadorPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorPKeyTyped
        // TODO add your handling code here:
		txtBuscadorP.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(jCEmpleadoP.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),0));
				}
				else if(jCNombreP.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),1));
				}
				else if(jCPaternoP.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),2));
				}
				
			}
		});
		
		trs = new TableRowSorter(modeloProfesor);
		tablaProfe.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscadorPKeyTyped

    private void jCNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCNombrePActionPerformed
        // TODO add your handling code here:
		if(jCNombreP.isSelected()){
			jCPaternoP.setSelected(false);
			jCEmpleadoP.setSelected(false);
		}
    }//GEN-LAST:event_jCNombrePActionPerformed

    private void jCPaternoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPaternoPActionPerformed
        // TODO add your handling code here:
		if(jCPaternoP.isSelected()){
			jCNombreP.setSelected(false);
			jCEmpleadoP.setSelected(false);
		}
    }//GEN-LAST:event_jCPaternoPActionPerformed

    private void jCEmpleadoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCEmpleadoPActionPerformed
        // TODO add your handling code here:
		if(jCEmpleadoP.isSelected()){
			jCPaternoP.setSelected(false);
			jCNombreP.setSelected(false);
		}
    }//GEN-LAST:event_jCEmpleadoPActionPerformed

    private void jBCambiarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarPActionPerformed
        // TODO add your handling code here:
		String nombre = txtNombreP.getText();
		String apellidoPaterno = txtPaternoP.getText();
		String apellidoMaterno = txtMaternoP.getText();
		Date fechaNacimiento= (Date)FechaP.getDate();
		String domicilio = txtDomicilioP.getText();
		String claveAcceso = txtContraP.getText();
		String nombreUsuario = txtUsuarioP.getText();
		int numEmpleado = Integer.parseInt(txtEmpleado.getText());
		Profesor pN= new Profesor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,claveAcceso,nombreUsuario);;
		ConsultasProfesor conp= new ConsultasProfesor();
		if(conp.modificarProfesor(seleccionadoP, pN)){
			int indice =0;
			int aux=0;
			for(Profesor p : profes){
				if(p.getNumEmpleado()==numEmpleado){
					aux=indice;
				}
				indice++;
			}
			profes.set(aux,pN);
			Object []datos = new Object[modeloProfesor.getColumnCount()];
			datos[0]=pN.getNumEmpleado();
			datos[1]=pN.getNombre();
			datos[2]=pN.getApellidoPaterno();
			datos[3]=pN.getApellidoMaterno();
			for(int i = 0; i<tablaProfe.getColumnCount();i++){
				modeloProfesor.setValueAt(datos[i], filasP, i);
			}
			JOptionPane.showMessageDialog(this,"Se hicieron Cambios");
		}
		txtNombreP.setText(null);
		txtPaternoP.setText(null);
		txtMaternoP.setText(null);
		FechaP.setDate(null);
		txtDomicilioP.setText(null);
		txtContraP.setText(null);
		txtUsuarioP.setText(null);
		txtEmpleado.setText(null);
    }//GEN-LAST:event_jBCambiarPActionPerformed

    private void tablaMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMaterialMouseClicked
        // TODO add your handling code here:
		int seleccion = tablaMaterial.rowAtPoint(evt.getPoint());
		filasM=seleccion;
		for(Material m : materiales){
			if(tablaMaterial.getValueAt(seleccion,0).equals(m.getId())){
				SelecionadoM = m;
				txtIDM.setText(String.valueOf(m.getId()));
				txtTituloM.setText(m.getTitulo());
				txtAutorM.setText(m.getAutor());
				txtAnioM.setText(String.valueOf(m.getAnio()));
				txtAreaM.setText(m.getAreaConocimiento());
				txtEjemplaresM.setText(String.valueOf(m.getNumEjemplares()));
				if(m instanceof Libro){
					Libro l = (Libro)m;
					txtISBN.setText(l.getIsbn());
					txtVolumen.setText(null);
					txtNumero.setText(null);
					txtURL.setText(null);
					txtClave.setText(null);
					jRLibro.setSelected(true);
					jRRevista.setSelected(false);
					jREnlace.setSelected(false);
					txtISBN.setEnabled(true);
					txtVolumen.setEnabled(false);
					txtNumero.setEnabled(false);
					txtURL.setEnabled(false);
					txtClave.setEnabled(false);
				}
				else if(m instanceof Revista){
					Revista r = (Revista)m;
					txtISBN.setText(null);
					txtVolumen.setText(String.valueOf(r.getVolumen()));
					txtNumero.setText(String.valueOf(r.getNumero()));
					txtURL.setText(null);
					txtClave.setText(null);
					jRLibro.setSelected(false);
					jRRevista.setSelected(true);
					jREnlace.setSelected(false);
					txtISBN.setEnabled(false);
					txtVolumen.setEnabled(true);
					txtNumero.setEnabled(true);
					txtURL.setEnabled(false);
					txtClave.setEnabled(false);
				}
				else if(m instanceof MaterialElectronico){
					MaterialElectronico e = (MaterialElectronico)m;
					txtISBN.setText(null);
					txtVolumen.setText(null);
					txtNumero.setText(null);
					txtURL.setText(e.getPaginaDescarga());
					txtClave.setText(String.valueOf(e.getClaveTemporal()));
					jRLibro.setSelected(false);
					jRRevista.setSelected(false);
					jREnlace.setSelected(true);
					txtISBN.setEnabled(false);
					txtVolumen.setEnabled(false);
					txtNumero.setEnabled(false);
					txtURL.setEnabled(true);
					txtClave.setEnabled(true);
				}
			}
		}
    }//GEN-LAST:event_tablaMaterialMouseClicked

    private void jRLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRLibroActionPerformed
        // TODO add your handling code here:
		if(jRLibro.isSelected()){
			jRLibro.setSelected(true);
			jRRevista.setSelected(false);
			jREnlace.setSelected(false);
			txtISBN.setEnabled(true);
			txtVolumen.setEnabled(false);
			txtNumero.setEnabled(false);
			txtURL.setEnabled(false);
			txtClave.setEnabled(false);
			txtIDM.setText(null);
			txtTituloM.setText(null);
			txtAutorM.setText(null);
			txtAnioM.setText(null);
			txtAreaM.setText(null);
			txtEjemplaresM.setText(null);
			txtURL.setText(null);
			txtClave.setText(null);
			txtVolumen.setText(null);
			txtNumero.setText(null);
		}
		
    }//GEN-LAST:event_jRLibroActionPerformed

    private void jRRevistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRRevistaActionPerformed
        // TODO add your handling code here:
		if(jRRevista.isSelected()){
			jRLibro.setSelected(false);
			jRRevista.setSelected(true);
			jREnlace.setSelected(false);
			txtISBN.setEnabled(false);
			txtVolumen.setEnabled(true);
			txtNumero.setEnabled(true);
			txtURL.setEnabled(false);
			txtClave.setEnabled(false);
			txtIDM.setText(null);
			txtTituloM.setText(null);
			txtAutorM.setText(null);
			txtAnioM.setText(null);
			txtAreaM.setText(null);
			txtEjemplaresM.setText(null);
			txtURL.setText(null);
			txtClave.setText(null);
			txtISBN.setText(null);
		}
    }//GEN-LAST:event_jRRevistaActionPerformed

    private void jREnlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jREnlaceActionPerformed
        // TODO add your handling code here:
		if(jREnlace.isSelected()){
			jRLibro.setSelected(false);
			jRRevista.setSelected(false);
			jREnlace.setSelected(true);
			txtISBN.setEnabled(false);
			txtVolumen.setEnabled(false);
			txtNumero.setEnabled(false);
			txtURL.setEnabled(true);
			txtClave.setEnabled(true);
			txtIDM.setText(null);
			txtTituloM.setText(null);
			txtAutorM.setText(null);
			txtAnioM.setText(null);
			txtAreaM.setText(null);
			txtEjemplaresM.setText(null);
			txtVolumen.setText(null);
			txtNumero.setText(null);
			txtISBN.setText(null);
		}
    }//GEN-LAST:event_jREnlaceActionPerformed

    private void txtBuscadorMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorMKeyTyped
        // TODO add your handling code here:
		txtBuscadorM.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(jCID.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorM.getText(),0));
				}
				else if(jCTitulo.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorM.getText(),1));
				}
				else if(jCAutor.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorM.getText(),2));
				}
				else if(jCAnio.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorM.getText(),3));
				}
				else if(jCArea.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorM.getText(),4));
				}
			}
			
		});
		trs = new TableRowSorter(modeloMaterial);
		tablaMaterial.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscadorMKeyTyped

    private void jCIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCIDActionPerformed
        // TODO add your handling code here:
		if(jCID.isSelected()){
			jCTitulo.setSelected(false);
			jCAutor.setSelected(false);
			jCAnio.setSelected(false);
			jCArea.setSelected(false);
		}
    }//GEN-LAST:event_jCIDActionPerformed

    private void jCTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCTituloActionPerformed
        // TODO add your handling code here:
		if(jCTitulo.isSelected()){
			jCID.setSelected(false);
			jCAutor.setSelected(false);
			jCAnio.setSelected(false);
			jCArea.setSelected(false);
		}
    }//GEN-LAST:event_jCTituloActionPerformed

    private void jCAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAutorActionPerformed
        // TODO add your handling code here:
		if(jCAutor.isSelected()){
			jCID.setSelected(false);
			jCTitulo.setSelected(false);
			jCAnio.setSelected(false);
			jCArea.setSelected(false);
		}
    }//GEN-LAST:event_jCAutorActionPerformed

    private void jCAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCAreaActionPerformed
        // TODO add your handling code here:
		if(jCArea.isSelected()){
			jCID.setSelected(false);
			jCAutor.setSelected(false);
			jCAnio.setSelected(false);
			jCTitulo.setSelected(false);
		}
    }//GEN-LAST:event_jCAreaActionPerformed

    private void jBAltaMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaMActionPerformed
        // TODO add your handling code here:
		if(txtIDM.getText().isEmpty()||txtTituloM.getText().isEmpty()||txtAutorM.getText().isEmpty()||txtAnioM.getText().isEmpty()
				||txtAreaM.getText().isEmpty()||txtEjemplaresM.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Verifica tu llenado, por favor.");
		}
		else{
			int id= Integer.parseInt(txtIDM.getText());
			String titulo=txtTituloM.getText();
			String autor = txtAutorM.getText();
			int anio= Integer.parseInt(txtAnioM.getText());
			String areaConocimiento = txtAreaM.getText();
			int numEjemplares = Integer.parseInt(txtEjemplaresM.getText());
			
			boolean verdad = false;
			for(Material m : materiales){
				if(m.getId()==id){
					verdad =true;
				}
			}
			
			if(verdad){
				JOptionPane.showMessageDialog(this,"Profesor ya existe.");
			}
			else{
				Object []datos = new Object[modeloMaterial.getColumnCount()];
				if(jRLibro.isSelected()){
					String isbn = txtISBN.getText();
					ConsultasLibro conl = new ConsultasLibro();
					Material m= new Libro(id,titulo,autor,anio,areaConocimiento,numEjemplares,isbn);
					conl.registrarLibro((Libro)m);
					materiales.add(m);
					datos[0]=m.getId();
					datos[1]=m.getTitulo();
					datos[2]=m.getAutor();
					datos[3]=m.getAnio();
					datos[4]=m.getAreaConocimiento();
					modeloMaterial.addRow(datos);
					JOptionPane.showMessageDialog(this,"Se registro Libro.");
					
				}
				else if(jRRevista.isSelected()){
					int volumen = Integer.parseInt(txtVolumen.getText());
					int numero = Integer.parseInt(txtNumero.getText());
					ConsultasRevista conr = new ConsultasRevista();
					Material m= new Revista(volumen,numero,id,titulo,autor,anio,areaConocimiento,numEjemplares);
					conr.registrarRevista((Revista)m);
					materiales.add(m);
					datos[0]=m.getId();
					datos[1]=m.getTitulo();
					datos[2]=m.getAutor();
					datos[3]=m.getAnio();
					datos[4]=m.getAreaConocimiento();
					modeloMaterial.addRow(datos);
					JOptionPane.showMessageDialog(this,"Se registro Revista.");
					
				}
				else if(jREnlace.isSelected()){
					String URL = txtURL.getText();
					int clave = Integer.parseInt(txtClave.getText());
					ConsultasMElectronico cone = new ConsultasMElectronico();
					Material m= new MaterialElectronico(URL,clave,id,titulo,autor,anio,areaConocimiento,numEjemplares);
					cone.registrarMaterialElectronico((MaterialElectronico)m);
					materiales.add(m);
					datos[0]=m.getId();
					datos[1]=m.getTitulo();
					datos[2]=m.getAutor();
					datos[3]=m.getAnio();
					datos[4]=m.getAreaConocimiento();
					modeloMaterial.addRow(datos);
					JOptionPane.showMessageDialog(this,"Se registro Enlace.");
					
				}
			}
			txtIDM.setText(null);
			txtTituloM.setText(null);
			txtAutorM.setText(null);
			txtAnioM.setText(null);
			txtAreaM.setText(null);
			txtEjemplaresM.setText(null);
			txtVolumen.setText(null);
			txtNumero.setText(null);
			txtISBN.setText(null);
			txtURL.setText(null);
			txtClave.setText(null);
		}
    }//GEN-LAST:event_jBAltaMActionPerformed

    private void jBCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambiarActionPerformed
        // TODO add your handling code here:
		Material m = null;
		boolean verdad=false;
		
		int id= Integer.parseInt(txtIDM.getText());
		String titulo=txtTituloM.getText();
		String autor = txtAutorM.getText();
		int anio= Integer.parseInt(txtAnioM.getText());
		String areaConocimiento = txtAreaM.getText();
		int numEjemplares = Integer.parseInt(txtEjemplaresM.getText());
		
		if(SelecionadoM instanceof Libro){
			String isbn = txtISBN.getText();
			ConsultasLibro conl = new ConsultasLibro();
			m= new Libro(id,titulo,autor,anio,areaConocimiento,numEjemplares,isbn);
			if(conl.modificarLibro((Libro)SelecionadoM,(Libro)m)){
				verdad=true;	
				
			}
			else{
				JOptionPane.showMessageDialog(this,"Verificar datos, no se realizo cambio.");
			}
			
		}

		else if(SelecionadoM instanceof Revista){
			int volumen = Integer.parseInt(txtVolumen.getText());
			int numero = Integer.parseInt(txtNumero.getText());
			ConsultasRevista conr = new ConsultasRevista();
			m= new Revista(volumen,numero,id,titulo,autor,anio,areaConocimiento,numEjemplares);
			if(conr.modificarRevista((Revista)SelecionadoM,(Revista)m)){
				verdad=true;		
			}
			else{
				JOptionPane.showMessageDialog(this,"Verificar datos, no se realizo cambio.");
			}
			
		}
		
		else if(SelecionadoM instanceof MaterialElectronico){
			String URL = txtURL.getText();
			int clave = Integer.parseInt(txtClave.getText());
			ConsultasMElectronico cone = new ConsultasMElectronico();
			m= new MaterialElectronico(URL,clave,id,titulo,autor,anio,areaConocimiento,numEjemplares);
			if(cone.modificarMaterialElectronico((MaterialElectronico)SelecionadoM,(MaterialElectronico)m)){
				verdad=true;	
			}
			else{
				JOptionPane.showMessageDialog(this,"Verificar datos, no se realizo cambio.");
			}
			
		}
		
		if(verdad){
			int indice =0;
			int aux=0;
			for(Material me: materiales){
				if(me.getId()==m.getId()){
					aux = indice;
				}
				indice++;
			}
			materiales.set(aux,m);
			
			Object []datos = new Object[modeloMaterial.getColumnCount()];
			datos[0]=m.getId();
			datos[1]=m.getTitulo();
			datos[2]=m.getAutor();
			datos[3]=m.getAnio();
			datos[4]=m.getAreaConocimiento();
			for(int i = 0; i<tablaMaterial.getColumnCount();i++){
				modeloMaterial.setValueAt(datos[i], filasM, i);
			}
			JOptionPane.showMessageDialog(this,"Cambios Realizados.");
		}
		txtIDM.setText(null);
		txtTituloM.setText(null);
		txtAutorM.setText(null);
		txtAnioM.setText(null);
		txtAreaM.setText(null);
		txtEjemplaresM.setText(null);
		txtVolumen.setText(null);
		txtNumero.setText(null);
		txtISBN.setText(null);
		txtURL.setText(null);
		txtClave.setText(null);
    }//GEN-LAST:event_jBCambiarActionPerformed

    private void jBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBajaActionPerformed
        // TODO add your handling code here:
		int aux=0;
		Material m;
		for(int i = 0; i< materiales.size();i++){
			m=materiales.get(i);
			if(m.getId()==SelecionadoM.getId()){
				aux=i;
			}
		}
		if(SelecionadoM instanceof Libro){
			ConsultasLibro conl = new ConsultasLibro();
			if(conl.borrarLibro((Libro)SelecionadoM)){
				modeloMaterial.removeRow(filasM);
				materiales.remove(aux);
			}
			else{
				JOptionPane.showMessageDialog(this,"No se a eliminado Libro.");
			}
		}
		else if(SelecionadoM instanceof Revista){
			ConsultasRevista conr = new ConsultasRevista();
			if(conr.borrarRevista((Revista)SelecionadoM)){
				modeloMaterial.removeRow(filasM);
				materiales.remove(aux);
			}
			else{
				JOptionPane.showMessageDialog(this,"No se a eliminado Revista.");
			}
		}
		else if(SelecionadoM instanceof MaterialElectronico){
			ConsultasMElectronico cone = new ConsultasMElectronico();
			if(cone.borrarMaterialElectronico((MaterialElectronico)SelecionadoM)){
				modeloMaterial.removeRow(filasM);
				materiales.remove(aux);
			}
			else{
				JOptionPane.showMessageDialog(this,"No se a eliminado Enlace.");
			}
		}
		
    }//GEN-LAST:event_jBajaActionPerformed

    private void txtBuscadorAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorAKeyTyped
        // TODO add your handling code here:
		txtBuscadorA.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				if(jCBoleta.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),0));
				}
				else if(jCNombre.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),1));
				}
				else if(jCPaterno.isSelected()){
					trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBuscadorP.getText(),2));
				}
				
			}
		});
		
		trs = new TableRowSorter(modeloAlumno);
		tablaAlumno.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscadorAKeyTyped

    private void jCBoletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBoletaActionPerformed
        // TODO add your handling code here:
		if(jCBoleta.isSelected()){
			jCPaterno.setSelected(false);
			jCNombre.setSelected(false);
		}
    }//GEN-LAST:event_jCBoletaActionPerformed

    private void jCNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCNombreActionPerformed
        // TODO add your handling code here:
		if(jCNombre.isSelected()){
			jCPaterno.setSelected(false);
			jCBoleta.setSelected(false);
		}
    }//GEN-LAST:event_jCNombreActionPerformed

    private void jCPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPaternoActionPerformed
        // TODO add your handling code here:
		if(jCPaterno.isSelected()){
			jCBoleta.setSelected(false);
			jCNombre.setSelected(false);
		}
    }//GEN-LAST:event_jCPaternoActionPerformed

    private void tablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnoMouseClicked
        // TODO add your handling code here:
		int seleccion = tablaAlumno.rowAtPoint(evt.getPoint());
		filasA=seleccion;
		for(Alumno a : alumnos){
			if(tablaAlumno.getValueAt(seleccion,0).equals(a.getBoleta())){
				seleccionadoA = a;
				txtNombre.setText(a.getNombre());
				txtPaternoA.setText(a.getApellidoPaterno());
				txtMaternoA.setText(a.getApellidoMaterno());
				jDNat.setDate(a.getFechaNacimiento());
				txtDomicilio.setText(a.getDomicilio());
				txtUsuarioA.setText(a.getNombreUsuario());
				txtContraA.setText(a.getClaveAcceso());
				txtBoleta.setText(String.valueOf(a.getBoleta()));
				txtNivel.setText(a.getNivel());
				listarTelefonoA(a);
				
			}
		}
    }//GEN-LAST:event_tablaAlumnoMouseClicked

    private void jBAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltaActionPerformed
        // TODO add your handling code here:
		if(txtNombre.getText().isEmpty()||txtPaternoA.getText().isEmpty()||txtMaternoA.getText().isEmpty()||txtDomicilio.getText().isEmpty()
				||txtContraA.getText().isEmpty()||txtUsuarioA.getText().isEmpty()||jDNat.getDate()==null||txtBoleta.getText().isEmpty()||txtNivel.getText().isEmpty()){
			JOptionPane.showMessageDialog(this,"Verifica tu llenado, por favor.");
		}
		else{
			String nombre = txtNombre.getText();
			String apellidoPaterno = txtPaternoA.getText();
			String apellidoMaterno = txtMaternoA.getText();
			Date fechaNacimiento= (Date)jDNat.getDate();
			String domicilio = txtDomicilio.getText();
			String claveAcceso = txtContraA.getText();
			String nombreUsuario = txtUsuarioA.getText();
			int boleta = Integer.parseInt(txtBoleta.getText());
			String nivel = txtNivel.getText();
			
			//checamos si existe el alumno
			boolean verdad = false;
			for(Alumno a: alumnos){
				if(a.getBoleta()==boleta && a.getNombre().equals(nombre)){
					verdad =true;
				}
			}
			if(verdad){
				JOptionPane.showMessageDialog(this,"Alumno ya existe.");
				txtNombre.setText(null);
				txtPaternoA.setText(null);
				txtMaternoA.setText(null);
				jDNat.setDate(null);
				txtDomicilio.setText(null);
				txtContraA.setText(null);
				txtUsuarioA.setText(null);
				txtBoleta.setText(null);
				txtNivel.setText(null);
			}
			else{
				Alumno a = new Alumno(boleta,nivel,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,claveAcceso,nombreUsuario);
				ConsultasAlumno cona = new ConsultasAlumno();
				if(cona.registrarAlumno(a)){
					Object []datos = new Object[modeloMaterial.getColumnCount()];
					alumnos.add(a);
					datos[0]=a.getBoleta();
					datos[1]=a.getNombre();
					datos[2]=a.getApellidoPaterno();
					datos[3]=a.getApellidoMaterno();
					datos[4]=a.getNivel();
					modeloAlumno.addRow(datos);
					JOptionPane.showMessageDialog(this,"Registrado con exito.");
					
				}
			}
			
		}
    }//GEN-LAST:event_jBAltaActionPerformed

    private void jBCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCambioActionPerformed
        // TODO add your handling code here:
		String nombre = txtNombre.getText();
		String apellidoPaterno = txtPaternoA.getText();
		String apellidoMaterno = txtMaternoA.getText();
		Date fechaNacimiento= (Date)jDNat.getDate();
		String domicilio = txtDomicilio.getText();
		String claveAcceso = txtContraA.getText();
		String nombreUsuario = txtUsuarioA.getText();
		int boleta = Integer.parseInt(txtBoleta.getText());
		String nivel = txtNivel.getText();
		
		Alumno a = new Alumno(boleta,nivel,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,claveAcceso,nombreUsuario);
		ConsultasAlumno cona = new ConsultasAlumno();
		int indice =0;
		int aux=0;
		if(cona.modificarAlumno(seleccionadoA, a)){
			for(Alumno al: alumnos){
				if(al.getBoleta()==a.getBoleta()){
					aux=indice;
				}
				indice++;
			}
		}
		alumnos.set(aux,a);
		Object []datos = new Object[modeloAlumno.getColumnCount()];
		alumnos.add(a);
		datos[0]=a.getBoleta();
		datos[1]=a.getNombre();
		datos[2]=a.getApellidoPaterno();
		datos[3]=a.getApellidoMaterno();
		datos[4]=a.getNivel();
		for(int i = 0; i<tablaAlumno.getColumnCount();i++){
			modeloAlumno.setValueAt(datos[i], filasA, i);
		}
		JOptionPane.showMessageDialog(this,"Cambios Realizados.");
		
		txtNombre.setText(null);
		txtPaternoA.setText(null);
		txtMaternoA.setText(null);
		jDNat.setDate(null);
		txtDomicilio.setText(null);
		txtContraA.setText(null);
		txtUsuarioA.setText(null);
		txtBoleta.setText(null);
		txtNivel.setText(null);
		
    }//GEN-LAST:event_jBCambioActionPerformed

    private void jBBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBajaActionPerformed
        // TODO add your handling code here:
		int aux=0;
		Alumno a;
		for(int i = 0; i< alumnos.size();i++){
			a=alumnos.get(i);
			if(a.getBoleta()==seleccionadoA.getBoleta()){
				aux=i;
			}
		}
		ConsultasAlumno cona = new ConsultasAlumno();
			if(cona.borrarAlumnoPorBoleta(seleccionadoA.getBoleta())){
				modeloAlumno.removeRow(filasA);
				alumnos.remove(aux);
			}
    }//GEN-LAST:event_jBBajaActionPerformed

    private void jBIngresateleAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresateleAActionPerformed
        // TODO add your handling code here:
		ConsultasAlumno cona = new ConsultasAlumno();
		int id= cona.obtenerIdPorBoleta(seleccionadoA.getBoleta());
		ConsultasTelefono tel = new ConsultasTelefono();
		
		JOptionPane.showMessageDialog(this,"Para cargar numeros tiene que estar creado el alumno y seleccionado en la tabla");
		String numero = JOptionPane.showInputDialog("Ingresar telefono");
		
		Telefono telefono = new Telefono(id,numero);
		
		if(tel.registrarTelefono(telefono)){
			Object []datos = new Object[modeloTelefonoA.getColumnCount()];
			datos[0]=numero;
			modeloTelefonoA.addRow(datos);
			seleccionadoA.getTelefono().add(numero);
			JOptionPane.showMessageDialog(this,"Telefono Registrado");
			int aux=0;
			int in=0;
			for(Alumno a: alumnos){
				if(a.getBoleta()==seleccionadoA.getBoleta()){
					aux=in;
				}
				in++;
			}
			alumnos.set(aux, seleccionadoA);
		}
		else{
			JOptionPane.showMessageDialog(this,"No se registro Telefono");
		}
		
		
    }//GEN-LAST:event_jBIngresateleAActionPerformed

    private void jBIngreasarTeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngreasarTeleActionPerformed
        // TODO add your handling code here:
		ConsultasProfesor conp = new ConsultasProfesor();
		int id= conp.obtenerIdPorNumeroEmpleado(seleccionadoP.getNumEmpleado());
		ConsultasTelefono tel = new ConsultasTelefono();
		
		JOptionPane.showMessageDialog(this,"Para cargar numeros tiene que estar creado el profesor y seleccionado en la tabla");
		String numero = JOptionPane.showInputDialog("Ingresar telefono");
		
		Telefono telefono = new Telefono(id,numero);
		
		if(tel.registrarTelefono(telefono)){
			Object []datos = new Object[modeloTelefonoP.getColumnCount()];
			datos[0]=numero;
			modeloTelefonoP.addRow(datos);
			seleccionadoP.getTelefono().add(numero);
			JOptionPane.showMessageDialog(this,"Telefono Registrado");
			int aux=0;
			int in=0;
			for(Profesor p: profes){
				if(p.getNumEmpleado()==seleccionadoP.getNumEmpleado()){
					aux=in;
				}
				in++;
			}
			profes.set(aux, seleccionadoP);
		}
		else{
			JOptionPane.showMessageDialog(this,"No se registro Telefono");
		}
    }//GEN-LAST:event_jBIngreasarTeleActionPerformed

    private void jBIngresaMateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresaMateActionPerformed
        // TODO add your handling code here:
		JOptionPane.showMessageDialog(this,"Para cargar materia tiene que estar creado el profesor y seleccionado en la tabla");
		String materia = JOptionPane.showInputDialog("Ingresar materias");
		seleccionadoP.getMateriasImparte().add(materia);
		int aux=0;
		int in=0;
		for(Profesor p: profes){
			if(p.getNumEmpleado()==seleccionadoP.getNumEmpleado()){
				aux=in;
			}
			in++;
		}
		profes.set(aux, seleccionadoP);
		Object []datos = new Object[modeloMateria.getColumnCount()];
		datos[0]=materia;
		modeloMateria.addRow(datos);
		JOptionPane.showMessageDialog(this,"Materia Registradoa");
		
    }//GEN-LAST:event_jBIngresaMateActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUIAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUIAdmin().setVisible(true);
			}
		});
	}
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Empleado;
    private com.toedter.calendar.JDateChooser FechaP;
    private javax.swing.JButton cerrarSesionP;
    private javax.swing.JButton cerrarSesionP1;
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBAltaM;
    private javax.swing.JButton jBAltaP;
    private javax.swing.JButton jBAltaPre;
    private javax.swing.JButton jBBaja;
    private javax.swing.JButton jBBajaPre;
    private javax.swing.JButton jBCambiar;
    private javax.swing.JButton jBCambiarP;
    private javax.swing.JButton jBCambiarPr;
    private javax.swing.JButton jBCambio;
    private javax.swing.JButton jBCerrar;
    private javax.swing.JButton jBDajaP;
    private javax.swing.JButton jBIngreasarTele;
    private javax.swing.JButton jBIngresaMate;
    private javax.swing.JButton jBIngresateleA;
    private javax.swing.JButton jBSesionPre;
    private javax.swing.JButton jBaja;
    private javax.swing.JCheckBox jCAnio;
    private javax.swing.JCheckBox jCArea;
    private javax.swing.JCheckBox jCAutor;
    private javax.swing.JCheckBox jCBoleta;
    private javax.swing.JCheckBox jCEmpleadoP;
    private javax.swing.JCheckBox jCID;
    private javax.swing.JCheckBox jCNombre;
    private javax.swing.JCheckBox jCNombreP;
    private javax.swing.JCheckBox jCPaterno;
    private javax.swing.JCheckBox jCPaternoP;
    private javax.swing.JCheckBox jCTitulo;
    private com.toedter.calendar.JDateChooser jDNat;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLAnio3;
    private javax.swing.JLabel jLAutor3;
    private javax.swing.JLabel jLBoleta;
    private javax.swing.JLabel jLClave;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLFoto1;
    private javax.swing.JLabel jLID3;
    private javax.swing.JLabel jLISBN;
    private javax.swing.JLabel jLNivel;
    private javax.swing.JLabel jLNumEmpleado;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLTitulo3;
    private javax.swing.JLabel jLVolumen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPAlumno;
    private javax.swing.JPanel jPDatosGenerrales;
    private javax.swing.JPanel jPDatosGenerrales1;
    private javax.swing.JPanel jPEscolar;
    private javax.swing.JPanel jPMaterial;
    private javax.swing.JPanel jPPrestamo;
    private javax.swing.JPanel jPProfesor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jREnlace;
    private javax.swing.JRadioButton jRLibro;
    private javax.swing.JRadioButton jRRevista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTPGeneral;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTable tablaMat;
    private javax.swing.JTable tablaMaterial;
    private javax.swing.JTable tablaProfe;
    private javax.swing.JTable tablaTelA;
    private javax.swing.JTable tablaTelP;
    private javax.swing.JTextField txtAnioM;
    private javax.swing.JTextField txtAreaM;
    private javax.swing.JTextField txtAutorM;
    private javax.swing.JTextField txtBoleta;
    private javax.swing.JTextField txtBuscadorA;
    private javax.swing.JTextField txtBuscadorM;
    private javax.swing.JTextField txtBuscadorP;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtContraA;
    private javax.swing.JTextField txtContraP;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtDomicilioP;
    private javax.swing.JTextField txtEjemplaresM;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtIDM;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtMaternoA;
    private javax.swing.JTextField txtMaternoP;
    private javax.swing.JTextField txtNivel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPaternoA;
    private javax.swing.JTextField txtPaternoP;
    private javax.swing.JTextField txtTituloM;
    private javax.swing.JTextField txtURL;
    private javax.swing.JTextField txtUsuarioA;
    private javax.swing.JTextField txtUsuarioP;
    private javax.swing.JTextField txtVolumen;
    // End of variables declaration//GEN-END:variables
}
