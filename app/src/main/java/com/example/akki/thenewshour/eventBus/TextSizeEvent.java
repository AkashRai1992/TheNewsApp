package com.example.akki.thenewshour.eventBus;

/**
 * Created by akki on 23/12/15.
 */
public class TextSizeEvent {
    private float smallTextsize;
    private float largeTextsize;

    public TextSizeEvent(float smallTextsize, float largeTextSize) {
        this.smallTextsize = smallTextsize;
        this.largeTextsize = largeTextSize;
    }

    public float getSmallTextsize() {
        return smallTextsize;
    }

    public float getlargeTextsize() {
        return largeTextsize;
    }
}
