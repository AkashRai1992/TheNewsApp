package com.example.akki.thenewshour.network;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.akki.thenewshour.utils.LogUtils;


/**
 * Controls and initializes Volley framework components to communicate with application server
 * on network.
 *
 * @author Gagandeep Singh
 * @version 1.0
 * @since 1.0
 */
public class NetworkController {

    private final static String TAG = LogUtils.makeLogTag(NetworkController.class);

    private Context mAppContext;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private static NetworkController mInstance;

    private NetworkController(Context context) {
        this.mAppContext = context;
    }

    public static NetworkController getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new NetworkController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mAppContext);
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


}
