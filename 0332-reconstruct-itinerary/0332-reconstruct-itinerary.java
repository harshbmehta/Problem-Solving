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

        while(!tripOrder.isEmpty()) {
            String destination = tripOrder.peek();
            if(visits.getOrDefault(destination, new PriorityQueue()).isEmpty()) {
                itinerary.addFirst(tripOrder.pop());
            } else {
                tripOrder.push(visits.get(destination).poll());
            }
        }
        return itinerary;
    }
}