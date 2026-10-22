public class FeePaymentBatch {

    static class FeeAccount {
        private String accountType;

        public FeeAccount(String accountType) {
            this.accountType = accountType;
        }

        public String getAccountType() {
            return accountType;
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        public HostelFeeAccount() {
            super("Hostel");
        }
    }

    public void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
        } else {
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static void main(String[] args) {
        FeePaymentBatch batch = new FeePaymentBatch();
        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount("DayScholar"),
                new FeeAccount("DayScholar")
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        double amount = 60000;
        for (FeeAccount account : accounts) {
            batch.processPayment(account, amount);
            if (account instanceof HostelFeeAccount) {
                hostelCount++;
            } else {
                dayScholarCount++;
            }
        }

        System.out.println("Hostel accounts processed: " + hostelCount
                + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
