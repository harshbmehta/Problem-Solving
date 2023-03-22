class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> visits = new HashMap<>();

        for(List<String> ticket: tickets) {
            visits.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                .offer(ticket.get(1));
        }

        Stack<String> tripOrder = new Stack<>();
        tripOrder.push("JFK");

        // Enter the locations in the stack after polling from the PriorityQueue
        // till we reach the last location from which there are no further flights
        while(!tripOrder.isEmpty()) {
            String destination = tripOrder.peek(); // just peek
            if(visits.getOrDefault(destination, new PriorityQueue()).isEmpty()) {
                itinerary.addFirst(tripOrder.pop()); // if there are no more destinations from destination, pop from stack and add it at the front of the LinkedList
            } else {
                // Keep pushing in stack until there is a next lag of journey from destination
                tripOrder.push(visits.get(destination).poll());
            }
        }
        return itinerary;
    }
}