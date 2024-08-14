package design_patterns.observer_pattern.observabal;

import design_patterns.observer_pattern.observer.NotificationAlterObserver;

public interface StockObservable {

    void add(NotificationAlterObserver notificationAlterObserver);  //register

    void remove(NotificationAlterObserver notificationAlterObserver); //unregister

    void notifySubscribes();

    void setStockCount(int newStockCount);

    int getStockCount();
}
