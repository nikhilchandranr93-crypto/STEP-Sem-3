public class EmployeeCompanyDemo {

    static class Employee {
        private String empName;
        private double salary;
        private static String companyName = "Bright Horizon Technologies";
        private static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Divya", 65000);
        Employee emp2 = new Employee("Arjun", 0);
        Employee emp3 = new Employee("Karthik", 58000);

        System.out.println("3 Employee objects created");
        Employee.printCompanyInfo();
    }
}
