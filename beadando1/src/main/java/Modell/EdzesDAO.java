/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author darrnel
 */
public class EdzesDAO {

    public static Edzesterv getSablonEdzesterv(String filename) throws SAXException, IOException, ParserConfigurationException {
        File inputFile = new File("src/main/resources/xml/" + filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nl = doc.getElementsByTagName("nap");

        List<Nap> napok = new ArrayList<>();

        for (int i = 0; i < nl.getLength(); i++) {
            List<Gyakorlat> gyakorlatok = new ArrayList<>();

            Element nap = (Element) nl.item(i);

            Element edzese = (Element) nap.getElementsByTagName("edzes").item(0);

            NodeList nl2 = edzese.getElementsByTagName("gyakorlat");

            for (int j = 0; j < nl2.getLength(); j++) {
                Element gyakorlate = (Element) edzese.getElementsByTagName("gyakorlat").item(j);

                String nev = gyakorlate.getAttribute("nev");

                int suly = parseInt(gyakorlate.getElementsByTagName("suly").item(0).getTextContent());
                int sorozat = parseInt(gyakorlate.getElementsByTagName("sorozat").item(0).getTextContent());
                int ismetles = parseInt(gyakorlate.getElementsByTagName("ismetles").item(0).getTextContent());

                Gyakorlat gyakorlat = new Gyakorlat(nev, suly, sorozat, ismetles);

                gyakorlatok.add(gyakorlat);
            }

            String tipus = edzese.getAttribute("tipus");

            Edzes edzes = new Edzes(tipus, gyakorlatok);

            String napnev = nap.getAttribute("nap");

            Nap aktualis_nap = new Nap(napnev, edzes);

            napok.add(aktualis_nap);

        }

        Edzesterv edzesterv = new Edzesterv(napok);

        return edzesterv;
    }

    public static List<Etrend> getEtrend(String filename) throws ParserConfigurationException, SAXException, IOException {

        File inputFile = new File("src/main/resources/xml/" + filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nl = doc.getElementsByTagName("étrend");

        List<Etrend> etrendek = new ArrayList<>();

        for (int i = 0; i < nl.getLength(); i++) {
            Element etrende = (Element) nl.item(i);

            String reggeli = etrende.getElementsByTagName("reggeli").item(0).getTextContent();
            String tizorai = etrende.getElementsByTagName("tízórai").item(0).getTextContent();
            String ebed = etrende.getElementsByTagName("ebéd").item(0).getTextContent();
            String uzsonna = etrende.getElementsByTagName("uzsonna").item(0).getTextContent();
            String vacsora = etrende.getElementsByTagName("vacsora").item(0).getTextContent();

            Etrend etrend = new Etrend(reggeli, tizorai, ebed, uzsonna, vacsora);

            etrendek.add(etrend);
        }

        return etrendek;
    }

    public static void createFelhasznalo(String felhNev, String felhMagassag, String felhSuly) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        File inputFile = new File("src/main/resources/xml/dataXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        Element root = doc.getDocumentElement();

        Element felhasznaloE = doc.createElement("felhasznalo");

        Felhasznalo f = new Felhasznalo(felhNev, parseInt(felhMagassag), parseInt(felhSuly));

        long felhTtindex = f.getTtindex();

        long felhKcal = f.getKcal();

        Attr nev = doc.createAttribute("nev");
        Attr ttindex = doc.createAttribute("ttindex");
        Attr kcal = doc.createAttribute("kcal");

        nev.setNodeValue(felhNev);
        ttindex.setNodeValue(String.valueOf(felhTtindex));
        kcal.setNodeValue(String.valueOf(felhKcal));

        felhasznaloE.setAttributeNode(kcal);
        felhasznaloE.setAttributeNode(nev);
        felhasznaloE.setAttributeNode(ttindex);

        root.appendChild(felhasznaloE);

        Element edzestervE = doc.createElement("edzesterv");

        felhasznaloE.appendChild(edzestervE);

        DOMSource source = new DOMSource(doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult("src/main/resources/xml/dataXML.xml");
        t.transform(source, result);

    }

    public static void createNap(String felhNev, String felhKcal, String napNev, String edzesTipus) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        File inputFile = new File("src/main/resources/xml/dataXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        Element root = doc.getDocumentElement();

        NodeList felhNl = root.getElementsByTagName("felhasznalo");

        for (int i = 0; i < felhNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhNl.item(i);

            if (String.valueOf(felhasznaloE.getAttribute("nev")).equals(felhNev) && String.valueOf(felhasznaloE.getAttribute("kcal")).equals(felhKcal)) {

                Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

                Element napE = doc.createElement("nap");

                Attr napnev = doc.createAttribute("nev");
                napnev.setNodeValue(napNev);
                napE.setAttributeNode(napnev);

                edzestervE.appendChild(napE);

                Element edzesE = doc.createElement("edzes");

                Attr edzestipus = doc.createAttribute("tipus");
                edzestipus.setNodeValue(edzesTipus);
                edzesE.setAttributeNode(edzestipus);

                napE.appendChild(edzesE);

            }
        }

        DOMSource source = new DOMSource(doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult("src/main/resources/xml/dataXML.xml");
        t.transform(source, result);

    }

    public static void createGyakorlat(String felhNev, String felhKcal, String napNev, String gyakNev, String gyakSuly, String gyakSorozat, String gyakIsmetles) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        File inputFile = new File("src/main/resources/xml/dataXML.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(inputFile);
        Element root = doc.getDocumentElement();

        NodeList felhNl = root.getElementsByTagName("felhasznalo");

        for (int i = 0; i < felhNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhNl.item(i);

            if (String.valueOf(felhasznaloE.getAttribute("nev")).equals(felhNev) && String.valueOf(felhasznaloE.getAttribute("kcal")).equals(felhKcal)) {

                Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

                NodeList napNl = edzestervE.getElementsByTagName("nap");

                for (int j = 0; j < napNl.getLength(); j++) {
                    Element napE = (Element) napNl.item(j);

                    if (String.valueOf(napE.getAttribute("nev")).equals(napNev)) {
                        Element edzesE = (Element) napE.getElementsByTagName("edzes").item(0);

                        Element gyakE = doc.createElement("gyakorlat");

                        Attr gyaknev = doc.createAttribute("nev");
                        gyaknev.setValue(gyakNev);

                        Element sulyE = doc.createElement("suly");
                        Element sorozatE = doc.createElement("sorozat");
                        Element ismetlesE = doc.createElement("ismetles");

                        sulyE.appendChild(doc.createTextNode(gyakSuly));
                        sorozatE.appendChild(doc.createTextNode(gyakSorozat));
                        ismetlesE.appendChild(doc.createTextNode(gyakIsmetles));

                        gyakE.setAttributeNode(gyaknev);
                        gyakE.appendChild(sulyE);
                        gyakE.appendChild(sorozatE);
                        gyakE.appendChild(ismetlesE);

                        edzesE.appendChild(gyakE);
                    }

                }
            }
        }

        DOMSource source = new DOMSource(doc);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult("src/main/resources/xml/dataXML.xml");
        t.transform(source, result);

    }

    public static List<Felhasznalo> getFelhasznalok() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        File inputFile = new File("src/main/resources/xml/dataXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList felhasznaloNl = doc.getElementsByTagName("felhasznalo");

        List<Felhasznalo> felhasznalok = new ArrayList<>();

        for (int i = 0; i < felhasznaloNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhasznaloNl.item(i);

            Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

            NodeList napNl = edzestervE.getElementsByTagName("nap");

            List<Nap> napok = new ArrayList<>();

            for (int j = 0; j < napNl.getLength(); j++) {
                Element napE = (Element) napNl.item(j);

                Element edzesE = (Element) napE.getElementsByTagName("edzes").item(0);

                NodeList gyakorlatNl = edzesE.getElementsByTagName("gyakorlat");

                List<Gyakorlat> gyakorlatok = new ArrayList<>();

                for (int k = 0; k < gyakorlatNl.getLength(); k++) {
                    Element gyakorlatE = (Element) gyakorlatNl.item(k);

                    String gyaknev = gyakorlatE.getAttribute("nev");
                    int gyaksuly = parseInt(gyakorlatE.getElementsByTagName("suly").item(0).getTextContent());
                    int gyaksorozat = parseInt(gyakorlatE.getElementsByTagName("sorozat").item(0).getTextContent());
                    int gyakismetles = parseInt(gyakorlatE.getElementsByTagName("ismetles").item(0).getTextContent());

                    Gyakorlat gyakorlat = new Gyakorlat(gyaknev, gyaksuly, gyaksorozat, gyakismetles);

                    gyakorlatok.add(gyakorlat);
                }

                Edzes edzes = new Edzes(edzesE.getAttribute("tipus"), gyakorlatok);

                Nap nap = new Nap(napE.getAttribute("nev"), edzes);

                napok.add(nap);
            }

            Edzesterv edzesterv = new Edzesterv(napok);

            Felhasznalo felhasznalo = new Felhasznalo(felhasznaloE.getAttribute("nev"), edzesterv, Long.parseLong(felhasznaloE.getAttribute("ttindex")), Long.parseLong(felhasznaloE.getAttribute("kcal")));
            felhasznalok.add(felhasznalo);
        }

        return felhasznalok;
    }

    public static List<Felhasznalo> getNevek() throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {

        File inputFile = new File("src/main/resources/xml/dataXML.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList felhasznaloNl = doc.getElementsByTagName("felhasznalo");

        List<Felhasznalo> felhasznalok = new ArrayList<>();
        for (int i = 0; i < felhasznaloNl.getLength(); i++) {
            Element felhasznaloE = (Element) felhasznaloNl.item(i);

            Element edzestervE = (Element) felhasznaloE.getElementsByTagName("edzesterv").item(0);

            Felhasznalo felhasznalo = new Felhasznalo(felhasznaloE.getAttribute("nev"), parseInt(felhasznaloE.getAttribute("ttindex")), parseInt(felhasznaloE.getAttribute("kcal")));

            felhasznalok.add(felhasznalo);
        }

        return felhasznalok;
    }
}
