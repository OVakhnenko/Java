/**
 * needed for MRDepartmentsAndEmployees
 */
class MRSomething {
    String name;
    MRSomething next;
    MRSomething prev;

    void createSomething(String name) {
        this.name = name;
        System.out.println(this.name);
    }
}
