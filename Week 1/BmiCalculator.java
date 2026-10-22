public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (Double.isNaN(bmi) || Double.isInfinite(bmi) || bmi <= 0) {
            return "Invalid";
        }
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25.0) {
            return "Normal";
        }
        if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null) {
            System.out.println("No wellness data available.");
            return;
        }
        int count = Math.min(heights.length, weights.length);
        System.out.printf("%-8s | %-10s | %-11s | %-6s | %s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = height > 0 ? weight / (height * height) : Double.NaN;
            System.out.printf("Person %-1d | %-10.2f | %-11.2f | %-6.2f | %s%n",
                    i + 1, height, weight, bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.68, 1.82, 1.55, 1.71, 1.90, 1.63, 1.78, 1.66};
        double[] weights = {70.0, 90.0, 55.0, 85.0, 48.0, 66.0, 95.0, 60.0, 78.0, 52.0};

        printWellnessReport(heights, weights);
    }
}
