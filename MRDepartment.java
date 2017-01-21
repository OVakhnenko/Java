import java.io.FileWriter;
import java.io.IOException;

/**
 * needed for MRDepartmentsAndEmployees
 */
class MRDepartment extends MRSomething {
    private MREmployee employees;

    MRDepartment(String name, MRSomething dep) {
        super(name, dep);
    }

    @Override
    public String toString() {
        return "Department \"" + getName() + "\"";
    }

    boolean save(FileWriter writer, String prefix) throws IOException {
        try {
            writer.write(prefix + getName() + "\n");
            writer.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Write error!");
            return false;
        }
    }
}
