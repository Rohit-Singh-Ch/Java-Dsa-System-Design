package design_patterns.observer_pattern.observer;

import java.util.Observable;

public class MobileNotificationAlertObserver implements NotificationAlterObserver{

    private String userName;
    private Observable observable;

    public MobileNotificationAlertObserver(String userName, Observable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "Hurry! product is stock");
    }

    private void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to: "+ userName);
    }
}
