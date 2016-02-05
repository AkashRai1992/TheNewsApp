package com.example.akki.thenewshour.viewHolders;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.example.akki.thenewshour.R;
import com.example.akki.thenewshour.adapters.HomePageListFragementAdapter;
import com.example.akki.thenewshour.eventBus.TextSizeEvent;
import com.example.akki.thenewshour.interfaces.OnItemClickListener;
import com.example.akki.thenewshour.utils.LogUtils;

import de.greenrobot.event.EventBus;


/**
 * Created by akki on 24/9/15.
 */
public class NewsFeedItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnTouchListener {
    public TextView titleText, summaryText;
    public ImageView newsThumbnail;
    private OnItemClickListener itemClickListener;
    public LinearLayout tupleContainer;
    private EventBus mEventBus = EventBus.getDefault();
    private boolean isAnimationShowing = false;


    public NewsFeedItemViewHolder(View itemView, OnItemClickListener itemClickListener) {
        super(itemView);
        this.titleText = (TextView) itemView.findViewById(R.id.tv_header);
        this.summaryText = (TextView) itemView.findViewById(R.id.tv_summary);
        this.newsThumbnail = (ImageView) itemView.findViewById(R.id.iv_news_thumbnail);
        this.tupleContainer = (LinearLayout) itemView.findViewById(R.id.ll_news_feed_tuple_container);
        itemView.setOnClickListener(this);
        titleText.setOnClickListener(this);
        summaryText.setOnClickListener(this);
        newsThumbnail.setOnClickListener(this);
        newsThumbnail.setOnTouchListener(this);
        this.itemClickListener = itemClickListener;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_news_thumbnail:
                showDialogwithAnimation();
                break;
            case R.id.ll_news_feed_tuple_container:
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(getAdapterPosition(), this);
                }
                break;

        }

    }

    private void showDialogwithAnimation() {
        Bitmap bitmap = ((GlideBitmapDrawable) newsThumbnail.getDrawable()).getBitmap();
        mEventBus.post(bitmap);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        LogUtils.makeLogTag("x coord" + event.getX() + "y coord" + event.getY());

          /*  newsThumbnail.setPivotX(event.getX());
            newsThumbnail.setPivotY(event.getY());*/
            showDialogwithAnimation();


        return true;
    }
}