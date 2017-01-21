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
}
