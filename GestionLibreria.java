import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class GestionLibreria extends DefaultHandler {

    private String isbn;
    private String idioma;
    private String titulo;
    private List<String> autores = new ArrayList<>();
    private String editorial;
    private int anio;
    private double precio;
    private String moneda;
    

    private StringBuilder texto = new StringBuilder();

    private int totalLibros;
    private int totalLibros2010;
    private int totalLibrosES;
    private int totalLibrosEN;
    private int totalLibrosGL;
    private double precioTotal;
    private int libroMasAutores;
    private double precioTotalEUR;
    private int totalLibrosEUR;
    private double precioMedioEUR;
    private String tituloLibroMasAutores;
    private int anioLibroMasAutores;
    private List<String> librosDesde2010 = new ArrayList<>();
    private List<String> librosES = new ArrayList<>();
    private List<String> librosEN = new ArrayList<>();
    private List<String> librosGL = new ArrayList<>();

    public static void main(String[] args)
            throws ParserConfigurationException, SAXException, IOException {

        String fichero = "libreria.xml";

        SAXParserFactory fabrica = SAXParserFactory.newInstance();
        XMLReader lector = fabrica.newSAXParser().getXMLReader();
        GestionLibreria gestor = new GestionLibreria();
        lector.setContentHandler(gestor);
        lector.setErrorHandler(gestor);
        lector.parse(fichero);
    }

    @Override
    public void warning(SAXParseException excepcion) {
        mostrarError("Advertencia", excepcion);
    }

    @Override
    public void error(SAXParseException excepcion) throws SAXException {
        mostrarError("Error", excepcion);
        throw excepcion;
    }

    @Override
    public void fatalError(SAXParseException excepcion) throws SAXException {
        mostrarError("Error fatal", excepcion);
        throw excepcion;
    }

    private void mostrarError(String tipo, SAXParseException excepcion) {
        System.err.println(tipo + " XML en línea " + excepcion.getLineNumber()
                + ", columna " + excepcion.getColumnNumber() + ": "
                + excepcion.getMessage());
    }

    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atributos) {
        String etiqueta = (localName != null && !localName.isEmpty()) ? localName : qName;

        if ("libro".equals(etiqueta)) {
            isbn = atributos.getValue("isbn");
            idioma = atributos.getValue("idioma");
            titulo = "";
            autores = new ArrayList<>();
            editorial = "";
            anio = 0;
            precio = 0;
        }
        if ("precio".equals(etiqueta)) {
            moneda = atributos.getValue("moneda");
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
            case "titulo":
                titulo = valor;
                break;
            case "autor":
                autores.add(valor);
                break;
            case "editorial":
                editorial = valor;
                break;
            case "anio":
                anio = Integer.parseInt(valor);
                break;
            case "precio":
                precio = Double.parseDouble(valor);
                    break;
            case "libro":
                guardarLibro();
                System.out.println(titulo + " (" + anio + ") - "
                        + String.join(", ", autores) + " - " + editorial + " - "
                        + precio + " " + moneda.toUpperCase() + " - [" + isbn
                        + "] - " + idioma);
                break;
            default:
                break;
        }
    }




    private void guardarLibro() {
        totalLibros++;
        precioTotal+=precio;
        if(moneda.equalsIgnoreCase("EUR")){
        precioTotalEUR += precio;
        totalLibrosEUR ++;
            }
        String nombreYAnio = titulo + " (" + anio + ")";

        if (anio >= 2010) {
            totalLibros2010++;
            librosDesde2010.add(nombreYAnio);
        }

        if (idioma != null) {
            switch (idioma.toLowerCase()) {
                case "es":
                    totalLibrosES++;
                    librosES.add(nombreYAnio);
                    break;
                case "en":
                    totalLibrosEN++;
                    librosEN.add(nombreYAnio);
                    break;
                case "gl":
                    totalLibrosGL++;
                    librosGL.add(nombreYAnio);
                    break;
                default:
                    break;
            }
        }

        if (autores.size() > libroMasAutores) {
            libroMasAutores = autores.size();
            tituloLibroMasAutores = titulo;
            anioLibroMasAutores = anio;
        }
    }
    @Override 
    public void endDocument(){
        mostrarEstadisticas();
    }

    private void mostrarEstadisticas() {
        if( totalLibros != 0 ){
        precioMedioEUR = precioTotalEUR / totalLibrosEUR ;
        }
        System.out.println("Total de libros: " + totalLibros);
        System.out.println("Precio total: " +precioTotal);
        System.out.println("Libro con más autores: " + tituloLibroMasAutores
                + " (" + anioLibroMasAutores + ") - " + libroMasAutores + " autores");
        System.out.println("Libros publicados a partir de 2010: " + totalLibros2010);
        mostrarLibros("Libros publicados a partir de 2010", librosDesde2010);
        System.out.println("Libros en español: " + totalLibrosES);
        mostrarLibros("Libros en español", librosES);
        System.out.println("Libros en inglés: " + totalLibrosEN);
        mostrarLibros("Libros en inglés", librosEN);
        System.out.println("Libros en gallego: " + totalLibrosGL);
        mostrarLibros("Libros en gallego", librosGL);
        System.out.println("Precio total ( EUR ): " +precioTotalEUR);
        System.out.println("Precio medio ( EUR ): " + precioMedioEUR);
        System.out.println("Máximo de autores en un libro: " + libroMasAutores);
    }

    private void mostrarLibros(String titulo, List<String> libros) {
        System.out.println(titulo + ":");
        for (String libro : libros) {
            System.out.println("  " + libro);
        }
    }

    // si leemos libreria_erronea.xml nos dará error en la linea 23 y columna 13 
    // porque no acaba por la misma etiqueta que empieza(libreria)

}