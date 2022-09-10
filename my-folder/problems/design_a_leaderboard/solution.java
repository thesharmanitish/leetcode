class Leaderboard {
    Map<Integer, Integer> map;
    
    public Leaderboard() {
            map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        int sc = map.getOrDefault(playerId,0);
        map.put(playerId, score+sc);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {return b-a;});
        pq.addAll(map.values());
        int sum = 0;
        for(int i=0;i<K;i++)
            sum+=pq.poll();
        return sum;
    }
    
    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */