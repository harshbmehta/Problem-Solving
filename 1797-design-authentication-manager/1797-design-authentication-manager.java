class AuthenticationManager {
    
    Map<String, Integer> tokenTTLMap;
    int ttl;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        tokenTTLMap = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        tokenTTLMap.put(tokenId, currentTime + ttl);
    }
    
    public void renew(String tokenId, int currentTime) {
        int expiry = tokenTTLMap.getOrDefault(tokenId, 0);
        if(expiry>currentTime) {
            tokenTTLMap.put(tokenId, currentTime+ttl);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Map.Entry<String, Integer> entry: tokenTTLMap.entrySet()) {
            if(entry.getValue() > currentTime) {
                count++;
            }
        }        
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */