import java.util.*;

class MovieRentingSystem {
    Map<String, Integer> price;
    Map<Integer, TreeSet<int[]>> available;  // movie -> (price, shop)
    TreeSet<int[]> rented;                   // (price, shop, movie)

    public MovieRentingSystem(int n, int[][] entries) {
        price = new HashMap<>();
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> a[0]!=b[0]?a[0]-b[0]:a[1]!=b[1]?a[1]-b[1]:a[2]-b[2]);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], p = e[2];
            price.put(shop + "," + movie, p);
            available.computeIfAbsent(movie, k -> new TreeSet<>(
                (a, b) -> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]
            )).add(new int[]{p, shop});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        int cnt = 0;
        for (int[] x : available.get(movie)) {
            if (cnt++ == 5) break;
            res.add(x[1]);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int p = price.get(shop + "," + movie);
        available.get(movie).remove(new int[]{p, shop});
        rented.add(new int[]{p, shop, movie});
    }

    public void drop(int shop, int movie) {
        int p = price.get(shop + "," + movie);
        rented.remove(new int[]{p, shop, movie});
        available.get(movie).add(new int[]{p, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int cnt = 0;
        for (int[] x : rented) {
            if (cnt++ == 5) break;
            res.add(Arrays.asList(x[1], x[2]));
        }
        return res;
    }
}
