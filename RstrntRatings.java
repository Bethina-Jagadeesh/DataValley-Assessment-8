import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RstrntRatings {
    static class Restaurant {
        String name;
        int rating;

        Restaurant(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public static void analyzeRatings(List<Restaurant> restaurants) {
        Map<Integer, Integer> countByRange = new HashMap<>();
        Map<Integer, Double> totalRatingByRange = new HashMap<>();

        for (Restaurant restaurant : restaurants) {
            int range = (restaurant.rating - 1) / 5; // Assuming 1-10 rating scale
            countByRange.merge(range, 1, Integer::sum);
            totalRatingByRange.merge(range, (double) restaurant.rating, Double::sum);
        }

        for (Integer range : countByRange.keySet()) {
            double averageRating = totalRatingByRange.get(range) / countByRange.get(range);
            System.out.println("Rating Range " + (range * 5 + 1) + "-" + ((range + 1) * 5) + ": Count = " + countByRange.get(range) + ", Average Rating = " + averageRating);
        }
    }

    public static void main(String[] args) {
        // Example list of restaurant ratings
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant1", 8));
        restaurants.add(new Restaurant("Restaurant2", 5));
        restaurants.add(new Restaurant("Restaurant3", 7));

        // Analyze the restaurant ratings
        analyzeRatings(restaurants);
    }
}