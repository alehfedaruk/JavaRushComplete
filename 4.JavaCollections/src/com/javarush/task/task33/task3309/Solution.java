package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj, document);

            NodeList nodeList = document.getElementsByTagName("*");

            Comment comment1;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeName().equals(tagName)) {
                    comment1 = document.createComment(comment);
                    node.getParentNode().insertBefore(comment1, node);
                }
                if (node.getFirstChild().getNodeType() == node.TEXT_NODE) {
                    if (node.getTextContent().matches(".*[<>&'\"].*")) {
                        CDATASection cdataSection = document.createCDATASection(node.getTextContent());
                        node.setTextContent("");
                        node.appendChild(cdataSection);
                    }
                }
            }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.MEDIA_TYPE, "text/xml");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(new DOMSource(document), result);
        return writer.toString();
    }

    public static void main(String[] args) throws TransformerException, JAXBException, ParserConfigurationException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }

    @XmlRootElement(name = "first")
    public static class First {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";
    }

    public static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}
