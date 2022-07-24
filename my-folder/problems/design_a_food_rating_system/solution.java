class Pair{
    String food;
    String cuisine;
    int rating;
    public Pair(String food, String cuisine, int rating){
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class FoodRatings {
    Map<String, Pair> foodMap;
    Map<String, PriorityQueue<Pair>> cuisineMap;
    PriorityQueue<Pair> pq;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();
        pq = new PriorityQueue<>((a,b)->{return a.rating == b.rating? a.food.compareTo(b.food):b.rating-a.rating;});
        for(int i=0;i<foods.length;i++){
            Pair p = new Pair(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], p);   
            
            PriorityQueue<Pair>  pqp=  cuisineMap.get(cuisines[i]);
            if(pqp ==null)
                pqp = new PriorityQueue<Pair>(pq);
            pqp.offer(p);
            cuisineMap.put(cuisines[i], pqp);
        }
       
        
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = foodMap.get(food);
        String cuisine =p.cuisine;
        PriorityQueue<Pair> pqp = cuisineMap.get(cuisine);
        pqp.remove(p);
        p.rating = newRating;
        pqp.add(p);
        cuisineMap.put(cuisine, pqp);
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pqp = cuisineMap.get(cuisine);
        if(pqp ==null || pqp.isEmpty())
            return null;
        return pqp.peek().food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */