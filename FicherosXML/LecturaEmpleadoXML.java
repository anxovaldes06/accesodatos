package FicherosXML;
import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXML {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("empleados.xml"));

            document.getDocumentElement().normalize();
            System.out.println("Elemento raiz: "
                    + document.getDocumentElement().getNodeName());

            // crear una lista con todos los nodos empleado
            NodeList empleados = document.getElementsByTagName("empleado");
            System.out.println("Nodos empleado a recorrer: "
                    + empleados.getLength());

            // recorrer la lista de empleados
            for (int i = 0; i < empleados.getLength(); i++) {

                Node emple = empleados.item(i);

                if (emple.getNodeType() == Node.ELEMENT_NODE) {

                    Element elemento = (Element) emple;

                    System.out.println("ID: "
                            + getNodo("id", elemento));
                    System.out.println("Apellido: "
                            + getNodo("apellido", elemento));
                    System.out.println("Departamento: "
                            + getNodo("dep", elemento));
                    System.out.println("Salario: "
                            + getNodo("salario", elemento));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem) {

        NodeList nodos =
                elem.getElementsByTagName(etiqueta).item(0).getChildNodes();

        Node nodo = (Node) nodos.item(0);

        return nodo.getNodeValue();
    }
}

