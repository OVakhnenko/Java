package paramstr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Read {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();

        for (Field field : p.getClass().getFields()) {
            System.out.println(field.getName());
            field.setAccessible(true);
        }

        p.load(new FileInputStream("paramstr.ini"));
        System.out.println(p);
        System.out.println(p.get("user"));
        System.out.println(p.get("password"));

        //p.loadFromXML(new FileInputStream("paramstr.xml"));
        //System.out.println(p);
    }
}
