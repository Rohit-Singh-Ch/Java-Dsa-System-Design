package design_patterns.observer_pattern;

import design_patterns.observer_pattern.observabal.IPhoneObservableImpl;
import design_patterns.observer_pattern.observabal.StockObservable;
import design_patterns.observer_pattern.observer.EmailNotificationAlertObserver;
import design_patterns.observer_pattern.observer.NotificationAlterObserver;

public class Store {

    public static void main(String[] args) {
        StockObservable iPhoneObservable = new IPhoneObservableImpl();

        NotificationAlterObserver observer1 = new EmailNotificationAlertObserver("xyz.@gnail.com", iPhoneObservable);
        NotificationAlterObserver observer2 = new EmailNotificationAlertObserver("pqr.@gnail.com", iPhoneObservable);
        NotificationAlterObserver observer3 = new EmailNotificationAlertObserver("myr.@gnail.com", iPhoneObservable);


        iPhoneObservable.add(observer1);
        iPhoneObservable.add(observer2);
        iPhoneObservable.add(observer3);

        iPhoneObservable.setStockCount(10);

    }
}
