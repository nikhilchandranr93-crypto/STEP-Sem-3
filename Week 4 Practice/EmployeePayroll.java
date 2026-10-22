public class EmployeePayroll {

    private String empId;
    private double salary;

    public EmployeePayroll(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void display() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        EmployeePayroll[] employees = {
                new EmployeePayroll("E-101", 40000),
                new EmployeePayroll("E-102", 55000),
                new EmployeePayroll("E-103", 62000),
                new EmployeePayroll("E-104", 48000)
        };

        for (EmployeePayroll employee : employees) {
            employee.raiseSalary(5000);
            employee.display();
        }
    }
}
