import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class ParserSAX {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new ParserSAX2();
            try {
               // parser.parse("src/main/java/resources/dota.xml", handler);
                parser.parse("pom.xml", handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        DefaultHandler handler = new ParserSAX2();
    }
}
 class ParserSAX2 extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("/////StartSAX//////");
        super.startDocument();
    }
     public void characters(char[] ch, int start, int length) throws SAXException {
         String value="";
         for (int i = start; i <start+length ; i++) {
             value+=ch[i];
         }
         value=value.trim();
         if (value.length()>0){
             System.out.println(value);
         }
     }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("/////EndSAX/////");
        super.endDocument();
    }
}