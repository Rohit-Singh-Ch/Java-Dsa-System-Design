package design_patterns.observer_pattern.observer;

import design_patterns.observer_pattern.observabal.StockObservable;

public class EmailNotificationAlertObserver implements NotificationAlterObserver{

    private String email;
    private StockObservable observable;

    public EmailNotificationAlertObserver(String email, StockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
     email(email, "Hurry! product is stock");
    }
    private void email(String email, String msg){
        System.out.println("mail sent to: "+ email);
    }
}
