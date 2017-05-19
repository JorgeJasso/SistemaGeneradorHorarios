package horarios;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import horariosBeans.HorariosBeans;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import tablas.Alumno;

public final class ModificarHorario extends JPanel {

    private final MiFrame interfaz;
    private final ModificarHorario modificarHorario;
    private final JScrollPane scrollPane;
    private final JPanel inferior;
    private final JButton guardar;
    private final JButton salir;
    private boolean guardado;
    private ArrayList<String> datos;
    private Iterator<String> nombreIterator;
    private JTable tabla;
    String carrera;

    public ModificarHorario(MiFrame interfaz, String carrera) {
        this.carrera = carrera;
        setLayout(null);
        Eventos eventos = new Eventos();
        EventosClick eventosClick = new EventosClick();
        this.interfaz = interfaz;
        modificarHorario = this;
        inferior = new JPanel();
        datos = new ArrayList<String>();
        guardado = false;

        guardar = new JButton("Guadar Horario");
        guardar.setBounds(43, 330, 120, 33);
        guardar.setBackground(Color.DARK_GRAY);
        guardar.setForeground(Color.WHITE);
        guardar.addActionListener(eventos);
        inferior.add(guardar);

        salir = new JButton("Salir");
        salir.setBounds(361, 330, 80, 33);
        salir.setBackground(Color.DARK_GRAY);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(eventos);

        inferior.add(salir);
        interfaz.add(inferior, BorderLayout.SOUTH);

        tabla = new JTable();
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setBackground(Color.DARK_GRAY);
        tabla.setForeground(Color.WHITE);
        tabla.addMouseListener(eventosClick);
        scrollPane = new JScrollPane(tabla);
        mostrar(carrera, tabla);
        interfaz.getContentPane().add(scrollPane, BorderLayout.CENTER);

        interfaz.setVisible(true);
    }

    public void mostrar(String carrera, JTable tabla) {
        HorariosBeans beans = new HorariosBeans(tabla);
        tabla.setPreferredScrollableViewportSize(new Dimension(250, 100));
        try {
            DefaultTableModel modelo;
            modelo = beans.horarios_carreraEspecifica(carrera);
            tabla.setModel(modelo);
            tabla.setRowHeight(25);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Mostrar tabla");
        }
    }

    public boolean isCellEditable(int fila, int columna) {
        return false;
    }

    public class Eventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == guardar) {
                JFileChooser dig = new JFileChooser();
                String direccion = "";
                int opcion = dig.showSaveDialog(guardar);
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    File file = dig.getSelectedFile();
                    direccion = file.toString();
                    try {
                        FileOutputStream archivo = new FileOutputStream(direccion + ".pdf");
                        Document doc = new Document();
                        PdfWriter.getInstance(doc, archivo);
                        doc.open();
                        try {
                            Image imagen = Image.getInstance("src\\imagenes\\cabecera.jpg");
                            imagen.setAlignment(Element.ALIGN_CENTER);
                            doc.add(imagen);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "No se encontro la imagen");
                        }
                        doc.add(new Paragraph("\n\n"));
                        doc.add(new Paragraph("Nombre: " + Alumno.nombre_Alumno + " " + Alumno.apellido_Paterno + " " + Alumno.apellido_Materno));
                        doc.add(new Paragraph("No. Control: " + Alumno.num_Control));
                        doc.add(new Paragraph("Carrera: " + Alumno.carrera));
                        Calendar fecha = Calendar.getInstance();
                        int dia = fecha.get(Calendar.DAY_OF_MONTH);
                        int mes = fecha.get(Calendar.MONTH);
                        int ano = fecha.get(Calendar.YEAR);
                        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
                        doc.add(new Paragraph("Fecha: " + dia + " de " + meses[mes] + " de " + ano));
                        doc.add(new Paragraph("Semestre: " + Alumno.semestre));
                        if (mes <= 7) {
                            doc.add(new Paragraph("Periodo: Ene-Jul/" + ano));
                        } else {
                            doc.add(new Paragraph("Periodo: Ago-Dic/" + ano));
                        }
                        doc.add(new Paragraph("\n\n"));

                        PdfPTable tabla = new PdfPTable(8);
                        tabla.setWidthPercentage(100);
                        float[] medidaCeldas = {4.20f, 1.20f, 4.0f, 2.10f, 2.10f, 2.30f, 2.10f, 2.10f};
                        tabla.setWidths(medidaCeldas);
                        PdfPCell celda1 = new PdfPCell(new Phrase("Materia", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda1.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda1);
                        PdfPCell celda2 = new PdfPCell(new Phrase("Sem", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda2.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda2.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda2);
                        PdfPCell celda3 = new PdfPCell(new Phrase("Maestro", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda3.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda3.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda3);
                        PdfPCell celda4 = new PdfPCell(new Phrase("Lunes", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda4.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda4.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda4);
                        PdfPCell celda5 = new PdfPCell(new Phrase("Martes", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda5.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda5.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda5);
                        PdfPCell celda6 = new PdfPCell(new Phrase("Miercoles", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda6.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda6.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda6);
                        PdfPCell celda7 = new PdfPCell(new Phrase("Jueves", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda7.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda7.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda7);
                        PdfPCell celda8 = new PdfPCell(new Phrase("Viernes", FontFactory.getFont("arial", 12, Font.BOLD, BaseColor.WHITE)));
                        celda8.setHorizontalAlignment(Element.ALIGN_CENTER);
                        celda8.setBackgroundColor(BaseColor.DARK_GRAY);
                        tabla.addCell(celda8);
                        nombreIterator = datos.iterator();
                        while (nombreIterator.hasNext()) {
                            tabla.addCell(nombreIterator.next());
                        }
                        doc.add(tabla);
                        doc.close();
                        JOptionPane.showMessageDialog(null, "Documento creado con exito");
                        guardado = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error al crear el archivo PDF");
                    }
                }
            } else {
                if (event.getSource() == salir) {
                    if (guardado) {
                        interfaz.remove(inferior);
                        interfaz.remove(scrollPane);
                        Principal principal = new Principal(interfaz, carrera);
                        interfaz.remover(modificarHorario, principal);
                    } else {
                        int confirmar = JOptionPane.showConfirmDialog(null, "Tus cambios no se han guardado desear salir");
                        if (confirmar == JOptionPane.YES_OPTION) {
                            interfaz.remove(inferior);
                            interfaz.remove(scrollPane);
                            Principal principal = new Principal(interfaz, carrera);
                            interfaz.remover(modificarHorario, principal);
                        }
                    }
                }
            }
        }
    }

    public class EventosClick extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent event) {
            int columna = tabla.getColumnModel().getColumnIndexAtX(event.getX());
            int fila = event.getY() / tabla.getRowHeight();
            if (fila < tabla.getRowCount() && fila >= 0 && columna < tabla.getColumnCount() && columna >= 0) {
                Object value = tabla.getValueAt(fila, columna);
                if (value instanceof JButton) {
                    ((JButton) value).doClick();
                    JButton boton = (JButton) value;
                    int clic_tabla = tabla.rowAtPoint(event.getPoint());
                    JButton estado = (JButton) tabla.getValueAt(clic_tabla, 0);
                    boolean empalme = false;
                    JButton comprobar;
                    if (estado.getText().equals("Alta")) {
                        switch (clic_tabla) {
                            case 0:
                                comprobar = (JButton) tabla.getValueAt(6, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 1:
                                comprobar = (JButton) tabla.getValueAt(7, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 2:
                                comprobar = (JButton) tabla.getValueAt(8, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 3:
                                comprobar = (JButton) tabla.getValueAt(9, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 6:
                                comprobar = (JButton) tabla.getValueAt(0, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 7:
                                comprobar = (JButton) tabla.getValueAt(1, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 8:
                                comprobar = (JButton) tabla.getValueAt(2, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                            case 9:
                                comprobar = (JButton) tabla.getValueAt(3, 0);
                                empalme = (comprobar.getText().equals("Baja"));
                                break;
                        }
                        if (!empalme) {
                            datos.add("" + tabla.getValueAt(clic_tabla, 1));
                            datos.add("" + tabla.getValueAt(clic_tabla, 2));
                            datos.add("" + tabla.getValueAt(clic_tabla, 3));
                            datos.add("" + tabla.getValueAt(clic_tabla, 4));
                            datos.add("" + tabla.getValueAt(clic_tabla, 5));
                            datos.add("" + tabla.getValueAt(clic_tabla, 6));
                            datos.add("" + tabla.getValueAt(clic_tabla, 7));
                            datos.add("" + tabla.getValueAt(clic_tabla, 8));
                            estado = new JButton("Baja");
                            estado.setBackground(Color.RED);
                        } else {
                            JOptionPane.showMessageDialog(null, "Materias empalmadas");
                        }
                    } else {
                        nombreIterator = datos.iterator();
                        int cont = -1;
                        while (nombreIterator.hasNext()) {
                            cont++;
                            if (nombreIterator.next().equals("" + tabla.getValueAt(clic_tabla, 1))) {
                                for (int i = 0; i < 8; i++) {
                                    datos.remove(cont);
                                }
                                break;
                            }
                        }
                        estado = new JButton("Alta");
                        estado.setBackground(Color.GREEN);
                    }
                    tabla.setValueAt(estado, clic_tabla, 0);
                }
            }
        }
    }
}
