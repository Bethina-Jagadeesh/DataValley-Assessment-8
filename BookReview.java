import java.util.ArrayList;
import java.util.List;

public class BookReview {
    static class Book {
        String title;
        int rating;
        String review;

        Book(String title, int rating, String review) {
            this.title = title;
            this.rating = rating;
            this.review = review;
        }

        boolean isPositive() {
            return review.contains("good") || review.contains("excellent");
        }

        boolean isNeutral() {
            return review.contains("average") || review.contains("fair");
        }

        boolean isNegative() {
            return review.contains("bad") || review.contains("poor");
        }
    }

    public static void analyzeReviews(List<Book> books) {
        int positive = 0, neutral = 0, negative = 0;
        int[] ratingRanges = new int[10]; // Assuming 1-10 rating scale

        for (Book book : books) {
            if (book.isPositive()) positive++;
            if (book.isNeutral()) neutral++;
            if (book.isNegative()) negative++;
            ratingRanges[book.rating - 1]++;
        }

        System.out.println("Positive: " + positive + ", Neutral: " + neutral + ", Negative: " + negative);
        for (int i = 0; i < ratingRanges.length; i++) {
            System.out.println("Rating " + (i + 1) + ": " + ratingRanges[i]);
        }
    }

    public static void main(String[] args) {
        // Example list of book reviews
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", 5, "An excellent read"));
        books.add(new Book("Book2", 7, "Good story"));
        books.add(new Book("Book3", 4, "Average plot"));

        // Analyze the book reviews
        analyzeReviews(books);
    }
}