package departments;

import java.io.FileWriter;
import java.io.IOException;

/**
 * needed for MRDepartmentsAndEmployees
 */
class MRSomething {
    private String name;
    private MRSomething next;
    private MRSomething prev;
    MRSomething composition;

    MRSomething(String name, MRSomething something) {
        this.name = name.trim();

        if (something != null) {
            something.setNext(this);
            setPrev(something);
        }
    }

    boolean hasPrev() {
        return prev != null;
    }

    MRSomething getFirst() {
        MRSomething tmp = this;

        while (tmp.hasPrev()) {
            tmp = tmp.getPrev();
        }
        return tmp;
    }

    boolean hasNext() {
        return next != null;
    }

    MRSomething getNext() {
        return next;
    }

    MRSomething getPrev() {
        return prev;
    }

    MRSomething getLast() {
        MRSomething tmp = this;

        while (tmp.hasNext()) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    boolean isLast() {
        return next == null;
    }

    void setNext(MRSomething tmp) {
        next = tmp;
    }

    void setPrev(MRSomething tmp) {
        prev = tmp;
    }

    String getName() {
        name = name.trim();
        return name;
    }

    MRSomething search(String name) {
        MRSomething tmp = getFirst();

        do {
            if (tmp.getName().equals(name))
                break;
            tmp = tmp.getNext();

        } while (!(tmp == null));

        return tmp;
    }

    void setName(String name) {
        this.name = name;
    }

    void update(String name) {
        setName(name);
    }

    void printAll() {
        MRSomething tmp = getFirst();

        do {
            System.out.println(tmp);
            tmp = tmp.getNext();

        } while (!(tmp == null));
    }

    boolean save(FileWriter writer, String prefix) throws IOException {
        return false;
    }

    boolean saveAll(FileWriter writer, String prefix) throws IOException {
        MRSomething tmp = getFirst();

        do {
            if (!tmp.save(writer, prefix)) {
                return false;
            }

            tmp = tmp.getNext();

        } while (!(tmp == null));

        return true;
    }

}
