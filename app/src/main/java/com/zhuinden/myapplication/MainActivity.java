package com.zhuinden.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity
        extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    DogAdapter dogAdapter;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        realm = Realm.getDefaultInstance();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dogAdapter = new DogAdapter(realm.where(Person.class).findFirst().getDogs().where().findAllAsync());
        recyclerView.setAdapter(dogAdapter);

        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Observable.interval(1000, TimeUnit.MILLISECONDS) //
                                        .observeOn(AndroidSchedulers.mainThread()) //
                                        .subscribe(
                                                aLong -> {
                                                    System.gc();
                                                    Runtime.getRuntime().gc();
                                                    try(Realm realm = Realm.getDefaultInstance()) {
                                                        realm.refresh();
                                                    }
                                                }));
        compositeDisposable.add(Observable.interval(125, TimeUnit.MILLISECONDS) //
                                        .subscribeOn(Schedulers.io()) //
                                        .subscribe( //
                                                    aLong -> {
                                                        //try(Realm r = Realm.getDefaultInstance()) {
                                                        Realm r = Realm.getDefaultInstance(); // LET'S BREAK THE WORLD
                                                            Random random = new Random();
                                                            int bound = random.nextInt(50) + 50;
                                                            r.executeTransaction(realm -> {
                                                                for(int i = 0; i < bound; i++) {
                                                                    Dog dog = new Dog();
                                                                    dog.setDummyDogField1(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField2(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField3(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField4(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField5(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField6(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField7(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField8(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField9(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField10(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField11(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField12(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField13(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField14(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField15(String.valueOf(random.nextLong()));
                                                                    Dog proxyDog = realm.copyToRealm(dog);
                                                                    Person person = realm.where(Person.class).findFirst(); // let's break the world
                                                                    //noinspection ConstantConditions
                                                                    person.getDogs().add(proxyDog);
                                                                }
                                                            });
                                                        //}
                                                    }));

        compositeDisposable.add(Observable.interval(400, TimeUnit.MILLISECONDS) //
                                        .subscribeOn(Schedulers.io()) //
                                        .subscribe( //
                                                    aLong -> {
                                                        //try(Realm r = Realm.getDefaultInstance()) {
                                                        Realm r = Realm.getDefaultInstance(); // LET'S BREAK THE WORLD
                                                            r.executeTransaction(realm -> {
                                                                Random random = new Random();
                                                                int bound = random.nextInt(25) + 25;
                                                                for(int i = 0; i < bound; i++) {
                                                                    RealmResults<Dog> dogs = realm.where(Dog.class).findAll(); // let's break the world
                                                                    int size = dogs.size();
                                                                    int index = random.nextInt(size);
                                                                    //noinspection ConstantConditions
                                                                    dogs.get(index).deleteFromRealm();
                                                                }
                                                            });
                                                        //}
                                                    }));

        compositeDisposable.add(Observable.interval(250, TimeUnit.MILLISECONDS) //
                                        .delay(125, TimeUnit.MILLISECONDS)
                                        .subscribeOn(Schedulers.io()) //
                                        .subscribe( //
                                                    aLong -> {
                                                        //try(Realm r = Realm.getDefaultInstance()) {
                                                        Realm r = Realm.getDefaultInstance(); // LET'S BREAK THE WORLD
                                                            Random random = new Random();
                                                            int bound = random.nextInt(100) + 100;
                                                            r.executeTransaction(realm -> {
                                                                for(int i = 0; i < bound; i++) {
                                                                    RealmResults<Dog> dogs = realm.where(Dog.class).findAll(); // let's break the world
                                                                    int size = dogs.size();
                                                                    int index = random.nextInt(size);
                                                                    Dog dog = dogs.get(index);
                                                                //for(Dog dog : realm.where(Dog.class).findAll()) {
                                                                    //noinspection ConstantConditions
                                                                    dog.setDummyDogField1(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField2(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField3(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField4(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField5(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField6(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField7(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField8(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField9(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField10(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField11(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField12(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField13(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField14(String.valueOf(random.nextLong()));
                                                                    dog.setDummyDogField15(String.valueOf(random.nextLong()));
                                                                }
                                                            });
                                                        //}
                                                    }));
    }

    @Override
    protected void onDestroy() {
        // compositeDisposable.clear(); // let's break the world!
        super.onDestroy();
        realm.close();
        realm = null;
    }
}
