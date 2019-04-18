package marketWithPatternCommand.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Bucket> listOfOrders = new ArrayList<>();

    public List<Bucket> getListOfOrders() {
        return listOfOrders;
    }

    public void addOrder(Bucket bucket) {
        listOfOrders.add(bucket);
    }

    public void showOrders() {
        for (int i = 0; i < listOfOrders.size(); i++) {
            System.out.println("order №" + (i+1) + ": ");
            listOfOrders.get(i).show();
        }
    }

    public void clear() {
        listOfOrders.clear();
    }
}
