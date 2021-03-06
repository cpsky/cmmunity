package cpsky.community.community;

import cpsky.community.dto.KeyDto;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {

    @Test
    public void contextLoads() {
        try {
            File f = new File("d:/key.xml");
            SAXReader reader = new SAXReader();
            Document doc = reader.read(f);
            Element root = doc.getRootElement();
            Element foo = null;
            Element gg = null;
            for (Iterator i = root.elementIterator("cloud"); i.hasNext();){
                foo = (Element)i.next();
                if (foo.attributeValue("name").equals("ali")) {
                    break;
                }
            }
            for (Iterator i = foo.elementIterator("product"); i.hasNext();){
                gg = (Element)i.next();
                if (gg.attributeValue("name").equals("oss")) {
                    break;
                }
            }
            KeyDto keyDto = new KeyDto();
            keyDto.setKeyid(gg.element("keyid").getText());
            keyDto.setKeysecert(gg.element("keysecret").getText());
            System.out.println(keyDto.getKeysecert());
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
