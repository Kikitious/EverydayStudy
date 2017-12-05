package com.katherine.du.everydaystudy.up20171205.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.Charset;

/**
 * Created by du on 17/12/5.
 */
public class GsonRequest<T> extends Request<T> {

    private Class<T> clazz;
    private Response.Listener<T> listener;
    private TypeToken<T> typeToken;
    private Gson gson = new Gson();

    public GsonRequest(int method, String url, Class<T> clazz,
                       Listener<T> listener,
                       ErrorListener errorListener) {
        super(method, url, errorListener);
        this.clazz = clazz;
        this.listener = listener;
    }

    public GsonRequest(int method, String url, TypeToken<T> typeToken,
                       Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.typeToken = typeToken;
        this.listener = listener;
    }

    public GsonRequest(String url, Class<T> clazz,
                       Listener<T> listener,
                       ErrorListener errorListener) {
        this(Method.GET, url, clazz, listener, errorListener);
    }

    public GsonRequest(String url, TypeToken<T> typeToken,
                       Listener<T> listener,
                       ErrorListener errorListener) {
        this(Method.GET, url, typeToken, listener, errorListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            //String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            String jsonString = new String(response.data, Charset.defaultCharset());
            if (typeToken == null) {
                return Response.success(gson.fromJson(jsonString, clazz),
                        HttpHeaderParser.parseCacheHeaders(response));
            } else {
                return (Response<T>) Response.success(gson.fromJson(jsonString, typeToken.getType()),
                        HttpHeaderParser.parseCacheHeaders(response));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);
    }
}
