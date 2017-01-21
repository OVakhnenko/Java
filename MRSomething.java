/**
 * needed for MRDepartmentsAndEmployees
 */
class MRSomething {
    private String name;
    private MRSomething next;
    private MRSomething prev;

    MRSomething(String name, MRSomething something) {
        this.name = name.trim();

        if (something != null) {
            something.setNext(this);
            setPrev(something);
        }
    }

    private boolean hasPrev() {
        return prev != null;
    }

    private MRSomething getFirst() {
        MRSomething tmp = this;

        while (tmp.hasPrev()) {
            tmp = tmp.getPrev();
        }
        return tmp;
    }

    private boolean hasNext() {
        return next != null;
    }

    private MRSomething getNext() {
        return next;
    }

    private MRSomething getPrev() {
        return next;
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

    private void setNext(MRSomething tmp) {
        next = tmp;
    }

    private void setPrev(MRSomething tmp) {
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
}
