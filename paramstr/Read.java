package paramstr;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("paramstr.ini"));
        System.out.println(p.get("user"));
        System.out.println(p.get("password"));
    }
}
