package org.kurylin.apptask.observer;

public interface ArrayObservable {
    void attach(ArrayObserver observer);
    void detach(ArrayObserver observer);
    void notifyObservers();
}
