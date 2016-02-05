package com.example.akki.thenewshour.eventBus;

/**
 * Created by akki on 19/1/16.
 */
public class ClearListEvent {
    private int listType;

    public ClearListEvent(int listType) {
        this.listType = listType;
    }

    public int getListType() {
        return listType;
    }


}
