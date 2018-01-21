package com.zhuinden.myapplication;

import android.app.Application;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Zhuinden on 2018.01.21..
 */

public class CustomApplication
        extends Application {
    private static final byte[] ENCRYPTION_KEY = {75, -4, -97, 124, -33, -24, 125, -55, -26, 97, -116, -21, -2, -48, -23, 90, -98, 69, -23, 124, -4, -92, 89, 71, -19, -11, -67, -86, 87, 121, 73, 42, 23, 114, 17, -9, 19, -34, -80, 45, -15, -97, 42, -29, 16, 71, 17, -52, -108, 4, -8, 18, -65, -79, 38, 65, 54, 96, 91, 14, -45, 22, -23, -28};

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder()
                                              .encryptionKey(ENCRYPTION_KEY)
                                              .deleteRealmIfMigrationNeeded()
                                              .initialData(realm -> {
                                                  Random random = new Random();
                                                  Person person = realm.createObject(Person.class);
                                                  person.setDummyField1(String.valueOf(random.nextLong()));
                                                  person.setDummyField2(String.valueOf(random.nextLong()));
                                                  person.setDummyField3(String.valueOf(random.nextLong()));
                                                  person.setDummyField4(String.valueOf(random.nextLong()));
                                                  person.setDummyField5(String.valueOf(random.nextLong()));
                                                  person.setDummyField6(String.valueOf(random.nextLong()));
                                                  person.setDummyField7(String.valueOf(random.nextLong()));
                                                  person.setDummyField8(String.valueOf(random.nextLong()));
                                                  person.setDummyField9(String.valueOf(random.nextLong()));
                                                  person.setDummyField10(String.valueOf(random.nextLong()));
                                                  person.setDummyField11(String.valueOf(random.nextLong()));
                                                  person.setDummyField12(String.valueOf(random.nextLong()));
                                                  person.setDummyField13(String.valueOf(random.nextLong()));
                                                  person.setDummyField14(String.valueOf(random.nextLong()));
                                                  person.setDummyField15(String.valueOf(random.nextLong()));
                                              })
                                              .build());
    }
}
