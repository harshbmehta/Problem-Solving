class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>(); // to return the result
        Map<String, PriorityQueue<String>> visits = new HashMap<>(); // create map of to and from while maintaining lexical order using priority queue
        
        // create map of source -> priority queue
        for(List<String> airports: tickets) {
            String source = airports.get(0); // source
            String dest = airports.get(1);
            
            visits.computeIfAbsent(source, k -> new PriorityQueue<>())
                .offer(dest);
        }
        
        // Create the stack to keep the track of all the airports
        Stack<String> airportStk = new Stack<>();
        // start airport is JFK
        airportStk.push("JFK");
        
        while(!airportStk.isEmpty()) {
            String startLoc = airportStk.peek();
            if(visits.getOrDefault(startLoc, new PriorityQueue()).isEmpty()) {
                itinerary.addFirst(airportStk.pop());
            } else {
                airportStk.push(visits.get(startLoc).poll());
            }
        }        
        return itinerary;    
    }
}