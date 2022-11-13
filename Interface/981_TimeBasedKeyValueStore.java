/* 981. Time Based Key-Value Store

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key''s value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 */
class TimeMap 
{
    private Map<String, TreeMap<Integer, String>> kMap;
    // <key -> <timestamp -> msg>>

    public TimeMap() 
    {
        this.kMap = new HashMap<String, TreeMap<Integer, String>>();
    }

    public void set(String key, String value, int timestamp) 
    {
        this.kMap.putIfAbsent(key, new TreeMap<Integer, String>());
        this.kMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) 
    {
        TreeMap<Integer, String>   tMap = this.kMap.get(key);
        Map.Entry<Integer, String> vMap = null;
        
        if (tMap == null)
            return "";

        vMap = tMap.floorEntry(timestamp);
        return vMap != null ? vMap.getValue() : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
