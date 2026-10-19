import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class GestionAlumnos extends DefaultHandler {

    private String id;
    private String nombre;
    private String apellidos;
    private String ciclo;
    private double notaActual;
    private StringBuilder texto = new StringBuilder();

    private int totalAlumnos;
    private int alumnosAprobados;
    private int alumnosSuspensos;
    private double sumaNotas;
    private Alumno mejorNota;
    private Alumno peorNota;

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {

        String fichero = "alumnos.xml";

        SAXParserFactory fabrica = SAXParserFactory.newInstance();
        XMLReader lector = fabrica.newSAXParser().getXMLReader();
        lector.setContentHandler(new GestionAlumnos());
        lector.parse(fichero);
    }
       @Override
    public void startDocument() {
        System.out.println("Inicio de la lectura del documento XML");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) {
        String etiqueta = (localName != null && !localName.isEmpty()) ? localName : qName;

        if ("alumno".equals(etiqueta)) {
            id = atributos.getValue("id");
            nombre = "";
            apellidos = "";
            ciclo = "";
            notaActual = 0.0;
        }

        texto.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        texto.append(ch, start, length);
    }

    
    @Override
    public void endElement(String uri, String localName, String qName) {
        String etiqueta = (localName != null && !localName.isEmpty()) ? localName : qName;
        String valor = texto.toString().trim();

        switch (etiqueta) {
            case "nombre":
                nombre = valor;
                break;
            case "apellidos":
                apellidos = valor;
                break;
            case "ciclo":
                ciclo = valor;
                break;
            case "nota":
                notaActual = Double.parseDouble(valor);
                break;
            case "alumno":
                guardarAlumno();
                System.out.println("[" + id + "] " + apellidos + ", " + nombre + " (" + ciclo + ") - Nota: " + notaActual);
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Fin de la lectura del documento XML");
        mostrarEstadisticas();
    }

    private void guardarAlumno() {
        totalAlumnos++;
        sumaNotas += notaActual;

        if (notaActual >= 5.0) {
            alumnosAprobados++;
        } else {
            alumnosSuspensos++;
        }

        Alumno alumno = new Alumno(id, nombre, apellidos, ciclo, notaActual);

        if (mejorNota == null || notaActual > mejorNota.nota) {
            mejorNota = alumno;
        }

        if (peorNota == null || notaActual < peorNota.nota) {
            peorNota = alumno;
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("Total de alumnos: " + totalAlumnos);

        double media = 0.0;
        if (totalAlumnos > 0) {
            media = sumaNotas / totalAlumnos;
        }

        System.out.println("Nota media: "+ media);

        if (totalAlumnos > 0) {
            System.out.println("Nota mas alta: "
                    +mejorNota.nombreCompleto() + " " +mejorNota.nota);
            System.out.println("Nota mas baja: "
                    +peorNota.nombreCompleto() + " " +peorNota.nota);
        }

        System.out.println("Aprobados: " + alumnosAprobados);
        System.out.println("Suspensos: " + alumnosSuspensos);
    }

    private static class Alumno {
        private final String id;
        private final String nombre;
        private final String apellidos;
        private final String ciclo;
        private final double nota;

        private Alumno(String id, String nombre, String apellidos, String ciclo, double nota) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.ciclo = ciclo;
            this.nota = nota;
        }

        private String nombreCompleto() {
            return "[" + id + "] " + apellidos + ", " + nombre + " (" + ciclo + ")";
        }
    }
}