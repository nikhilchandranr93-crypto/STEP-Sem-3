public class StudentDemo {

    static class Student {
        private String name;
        private int attendance;
        private static String collegeName = "SRM Institute of Science and Technology";
        private static int studentCount = 0;

        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Ravi", 95);
        Student student2 = new Student("Anitha", 98);

        System.out.println("2 Student objects created");
        Student.printCollegeInfo();
    }
}
