package StockList;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }
    public int addStock(StockItem item){
        if(item != null){
            // get or default get item if exists, if not use item.
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust quantity
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        if(inStock != null && inStock.quantityInStock() >= quantity && quantity > 0){
            inStock.adjustStock(quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s += stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            // String.format with %.2f fixes output to 2 decimal points!
            s += String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + String.format("%.2f",totalCost);
    }
}
