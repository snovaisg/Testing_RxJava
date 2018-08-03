package com.example.simaonovais.testing_rxjava;

import android.util.Log;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class testRx {
    ManageMainActivity mma = new ManageMainActivity(null);
    Observable<String> observable = Observable.fromCallable(thatReturnsStringHello());


    //Create Callable

    public Callable<String> thatReturnsStringHello(){
        return () ->{return "Hello";};
    }

    //Consumer is new Action1
    public Consumer<String> append(){
        Log.d("debi","Consumer has been called");
        return text -> {
            text = text + " hi";
            mma.setText(text);
        };
    }
    public void begin() {

        DisposableObserver<String> disposable = observable.subscribeOn(Schedulers.newThread())
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String text) {
                        String textAfterChanges = text + " world!";
                        Log.d("debi", "result: " + textAfterChanges);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Show the user that an error has occurred
                        Log.d("erri", "Error has unfortunately occured...");
                    }

                    @Override
                    public void onComplete() {
                        // Show the user that the operation is complete } });
                    }
                });
    }



}
