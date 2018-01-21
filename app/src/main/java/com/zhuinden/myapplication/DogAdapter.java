package com.zhuinden.myapplication;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.ObjectChangeSet;
import io.realm.OrderedRealmCollection;
import io.realm.RealmObjectChangeListener;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by Zhuinden on 2018.01.21..
 */

public class DogAdapter
        extends RealmRecyclerViewAdapter<Dog, DogAdapter.ViewHolder> {
    public DogAdapter(@Nullable OrderedRealmCollection<Dog> data) {
        super(data, true, false);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getData().get(position));
    }

    public class ViewHolder
            extends RecyclerView.ViewHolder {
        Dog dog;

        @BindView(R.id.dummyField1)
        TextView dummyField1;
        @BindView(R.id.dummyField2)
        TextView dummyField2;
        @BindView(R.id.dummyField3)
        TextView dummyField3;
        @BindView(R.id.dummyField4)
        TextView dummyField4;
        @BindView(R.id.dummyField5)
        TextView dummyField5;
        @BindView(R.id.dummyField6)
        TextView dummyField6;
        @BindView(R.id.dummyField7)
        TextView dummyField7;
        @BindView(R.id.dummyField8)
        TextView dummyField8;
        @BindView(R.id.dummyField9)
        TextView dummyField9;
        @BindView(R.id.dummyField10)
        TextView dummyField10;
        @BindView(R.id.dummyField11)
        TextView dummyField11;
        @BindView(R.id.dummyField12)
        TextView dummyField12;
        @BindView(R.id.dummyField13)
        TextView dummyField13;
        @BindView(R.id.dummyField14)
        TextView dummyField14;
        @BindView(R.id.dummyField15)
        TextView dummyField15;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Dog dog) {
            this.dog = dog;
            dog.addChangeListener(new RealmObjectChangeListener<Dog>() {
                @Override
                public void onChange(@NonNull Dog dog, @Nullable ObjectChangeSet changeSet) {
                    if(changeSet == null || changeSet.isDeleted()) {
                        return;
                    }
                    String[] changedFields = changeSet.getChangedFields();
                    for(String fieldName : changedFields) {
                        if("dummyDogField1".equals(fieldName)) {
                            dummyField1.setText(dog.getDummyDogField1());
                        }
                        if("dummyDogField2".equals(fieldName)) {
                            dummyField2.setText(dog.getDummyDogField2());
                        }
                        if("dummyDogField3".equals(fieldName)) {
                            dummyField3.setText(dog.getDummyDogField3());
                        }
                        if("dummyDogField4".equals(fieldName)) {
                            dummyField4.setText(dog.getDummyDogField4());
                        }
                        if("dummyDogField5".equals(fieldName)) {
                            dummyField5.setText(dog.getDummyDogField5());
                        }
                        if("dummyDogField6".equals(fieldName)) {
                            dummyField6.setText(dog.getDummyDogField6());
                        }
                        if("dummyDogField7".equals(fieldName)) {
                            dummyField7.setText(dog.getDummyDogField7());
                        }
                        if("dummyDogField8".equals(fieldName)) {
                            dummyField8.setText(dog.getDummyDogField8());
                        }
                        if("dummyDogField9".equals(fieldName)) {
                            dummyField9.setText(dog.getDummyDogField9());
                        }
                        if("dummyDogField10".equals(fieldName)) {
                            dummyField10.setText(dog.getDummyDogField10());
                        }
                        if("dummyDogField11".equals(fieldName)) {
                            dummyField11.setText(dog.getDummyDogField11());
                        }
                        if("dummyDogField12".equals(fieldName)) {
                            dummyField12.setText(dog.getDummyDogField12());
                        }
                        if("dummyDogField13".equals(fieldName)) {
                            dummyField13.setText(dog.getDummyDogField13());
                        }
                        if("dummyDogField14".equals(fieldName)) {
                            dummyField14.setText(dog.getDummyDogField14());
                        }
                        if("dummyDogField15".equals(fieldName)) {
                            dummyField15.setText(dog.getDummyDogField15());
                        }
                    }
                    dummyField1.setText(dog.getDummyDogField1());
                    dummyField2.setText(dog.getDummyDogField2());
                    dummyField3.setText(dog.getDummyDogField3());
                    dummyField4.setText(dog.getDummyDogField4());
                    dummyField5.setText(dog.getDummyDogField5());
                    dummyField6.setText(dog.getDummyDogField6());
                    dummyField7.setText(dog.getDummyDogField7());
                    dummyField8.setText(dog.getDummyDogField8());
                    dummyField9.setText(dog.getDummyDogField9());
                    dummyField10.setText(dog.getDummyDogField10());
                    dummyField11.setText(dog.getDummyDogField11());
                    dummyField12.setText(dog.getDummyDogField12());
                    dummyField13.setText(dog.getDummyDogField13());
                    dummyField14.setText(dog.getDummyDogField14());
                    dummyField15.setText(dog.getDummyDogField15());
                }
            });
        }
    }
}
