class TimeMap {

    private Map<String, List<ValTime>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<ValTime> list = map.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(new ValTime(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<ValTime> list = map.get(key);
        int L = 0, R = list.size()-1, max=0;
        String closestVal = "";
        while(L <= R) {
            int m = (L+R)/2;
            int t = list.get(m).timestamp;
            if(t < timestamp) {
                L = m+1;
                if(t > max) {
                    max = t;
                    closestVal = list.get(m).value;
                }
            } else if(t > timestamp) {
                R = m-1;
            } else {
                return list.get(m).value;
            }
        }
        return closestVal;
    }
}

//10, 20, 30 t

//15, 25, 35 timestamp

class ValTime {
    public String value;
    public int timestamp;

    public ValTime(String v, int t) {
        value = v;
        timestamp = t;
    }
}

