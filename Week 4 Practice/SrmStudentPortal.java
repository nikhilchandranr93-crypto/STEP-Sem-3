public class SrmStudentPortal {

    static class SrmStudent {
        private String name;

        static {
            System.out.println("College info loaded");
        }

        public SrmStudent(String name) {
            this.name = name;
        }

        public void printConfirmation() {
            System.out.println("Student record created: " + name);
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String name : names) {
            new SrmStudent(name).printConfirmation();
        }
    }
}
