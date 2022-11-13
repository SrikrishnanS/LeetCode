/*
692. Top K Frequent Words

Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

*/

class Solution
{
    public List<String> topKFrequent(String[] words, int k)
    {
        Map<String, Integer> map = new HashMap<>();
        Queue<Pair<String, Integer>> Q;
        List<String> result;

        // obtain the count of each words
        for (String w : words)
            map.put(w, map.getOrDefault(w, 0) + 1);

        // min heap, ordered based on count, then string lex
        Q = new PriorityQueue<Pair<String, Integer>>((a, b) -> {
                if (a.getValue() != b.getValue())
                    return a.getValue() - b.getValue();
                else
                    return b.getKey().compareTo(a.getKey());
            });

        // add string, count to heap
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            Q.offer(new Pair<String, Integer>(pair.getKey(), pair.getValue()));
            if (Q.size() > k)
                Q.poll();
        }

        // populate result list
        result = new LinkedList<>();
        while (!Q.isEmpty())
            result.add(0, Q.poll().getKey());

        return result;
    }
}
