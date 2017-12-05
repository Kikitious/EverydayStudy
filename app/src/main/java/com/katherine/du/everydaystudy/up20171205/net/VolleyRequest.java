package com.katherine.du.everydaystudy.up20171205.net;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

/**
 * Created by du on 17/12/5.
 */

public class VolleyRequest {

    private static RequestQueue mRequestQueue;

    private VolleyRequest() {
    }

    public static void buildRequestQueue(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static VolleyRequest newInstance() {
        if (mRequestQueue == null) {
            throw new NullPointerException("Call buildRequestQueue method first.");
        }
        return new VolleyRequest();
    }

    public <T> GsonRequest<T> newGsonRequest(String url, Class<T> clazz,
                                             Response.Listener<T> listener,
                                             Response.ErrorListener errorListener) {
        GsonRequest<T> request = new GsonRequest<T>(url, clazz, listener, errorListener);
        mRequestQueue.add(request);
        return request;
    }

}
