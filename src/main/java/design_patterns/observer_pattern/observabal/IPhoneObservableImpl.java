package design_patterns.observer_pattern.observabal;

import design_patterns.observer_pattern.observer.NotificationAlterObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservableImpl implements StockObservable{

    List<NotificationAlterObserver> observerList = new ArrayList<>();
    int stockCount = 0;

    @Override
    public void add(NotificationAlterObserver notificationAlterObserver) {
        observerList.add(notificationAlterObserver);
    }

    @Override
    public void remove(NotificationAlterObserver notificationAlterObserver) {
      observerList.remove(notificationAlterObserver);
    }

    @Override
    public void notifySubscribes() {
        for (NotificationAlterObserver notificationAlterObserver : observerList) {
            notificationAlterObserver.update(); //update(object obj)
        }

    }

    @Override
    public void setStockCount(int newStockCount) {
        if(stockCount == 0) notifySubscribes();
        stockCount = stockCount + newStockCount;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
