package utils;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class UtilsGenerarXml {
	
	private UtilsGenerarXml() {
		throw new IllegalStateException("UtilGenerarXml class");
	}

	public static Document crearDocumentoXml(String nombreDocumento, String versionDocumento)
			throws ParserConfigurationException {

		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document documento = implementation.createDocument(null, nombreDocumento, null);
		documento.setXmlVersion(versionDocumento);
		documento.setXmlStandalone(true);

		return documento;

	}

	public static Element crearCabecera(Document documento, String nombreAtributo, String valorAtributo) {
		Element elemento = documento.getDocumentElement();
		elemento.setAttribute(nombreAtributo, valorAtributo);
		return elemento;
	}

	public static Element crearNodo(Document documento, String nombreRaiz) {
		return documento.createElement(nombreRaiz);
	}

	public static void agregarNodoCabecera(Element cabecera, Element nodoRaiz) {
		cabecera.appendChild(nodoRaiz);
	}

	public static void agregarParametroNodo(Document documento, Element nodoRaiz, String nombreParametro,
			String valorParametro) {

		Element parametro = documento.createElement(nombreParametro);
		Text textoParametro = documento.createTextNode(valorParametro != null ? valorParametro : "");
		parametro.appendChild(textoParametro);
		nodoRaiz.appendChild(parametro);

	}

	public static String convertirXmlAString(Document documento)
			throws TransformerFactoryConfigurationError, TransformerException {
		StringWriter writer = new StringWriter();
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(documento), new StreamResult(writer));
		return writer.getBuffer().toString();
	}
}
