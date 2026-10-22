public class LibraryBook {

    private String title;
    private String isbn;
    private boolean catalogued;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        if (isbn == null || isbn.trim().isEmpty()) {
            this.isbn = "PENDING";
        } else {
            this.isbn = isbn.trim();
        }
        this.catalogued = true;
    }

    public LibraryBook(String title) {
        this(title, "");
    }

    public void displayEntry() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            String isbn = i < isbns.length ? isbns[i] : "";
            new LibraryBook(titles[i], isbn).displayEntry();
        }
    }
}
