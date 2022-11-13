/* 2034. Stock Price Fluctuation

You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
Finds the maximum price the stock has been based on the current records.
Finds the minimum price the stock has been based on the current records.
Implement the StockPrice class:

StockPrice() Initializes the object with no price records.
void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
int current() Returns the latest price of the stock.
int maximum() Returns the maximum price of the stock.
int minimum() Returns the minimum price of the stock.
 */
class StockPrice 
{
    TreeMap<Integer, Integer> tstamps; // timestamp -> stock
    TreeMap<Integer, Integer> stocks; // stock -> count

    public StockPrice() 
    {
        tstamps = new TreeMap<>();
        stocks = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) 
    {
        if (tstamps.containsKey(timestamp)) // fix previous value
        {
            int oldPrice = tstamps.get(timestamp);
            
            if (stocks.get(oldPrice) == 1)
                stocks.remove(oldPrice);
            else
                stocks.put(oldPrice, stocks.get(oldPrice) - 1);
        }
        tstamps.put(timestamp, price);
        stocks.put(price, stocks.getOrDefault(price, 0) + 1); // update count
    }
    
    public int current() 
    {
        return tstamps.get(tstamps.lastKey());
    }
    
    public int maximum() 
    {
        return stocks.lastKey();
    }
    
    public int minimum() 
    {
        return stocks.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
