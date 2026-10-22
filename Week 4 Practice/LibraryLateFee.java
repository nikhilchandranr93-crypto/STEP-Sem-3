public class LibraryLateFee {

    private String regNo;
    private double totalFee;
    private int daysLate;

    public LibraryLateFee(String regNo, double totalFee, int daysLate) {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.daysLate = daysLate;
    }

    public final double calculateLateFee(int daysLate) {
        if (daysLate <= 0) {
            return 0.0;
        }
        return totalFee * 0.10;
    }

    public final void printSummary(int daysLate) {
        if (daysLate <= 0) {
            System.out.println(regNo + " - On time, no late fee");
            return;
        }
        double lateFee = calculateLateFee(daysLate);
        if (lateFee < 0) {
            lateFee = 0;
        }
        System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        for (int i = 0; i < regNos.length; i++) {
            new LibraryLateFee(regNos[i], totalFees[i], daysLate[i]).printSummary(daysLate[i]);
        }
    }
}
