package com.katherine.du.everydaystudy.up20171220.api;

import com.katherine.du.everydaystudy.up20171220.request.LoginRequest;
import com.katherine.du.everydaystudy.up20171220.request.RegisterRequest;
import com.katherine.du.everydaystudy.up20171220.request.UserBaseInfoRequest;
import com.katherine.du.everydaystudy.up20171220.request.UserExtraInfoRequest;
import com.katherine.du.everydaystudy.up20171220.response.LoginResponse;
import com.katherine.du.everydaystudy.up20171220.response.RegisterResopnse;
import com.katherine.du.everydaystudy.up20171220.response.UserBaseInfoResponse;
import com.katherine.du.everydaystudy.up20171220.response.UserExtraInfoResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * Created by du on 17/12/20.
 */

public interface Api {

    @GET
    Observable<LoginResponse> login(@Body LoginRequest request);

    @GET
    Observable<RegisterResopnse> register(@Body RegisterRequest request);

    @GET
    Observable<UserBaseInfoResponse> getUserBaseInfo(@Body UserBaseInfoRequest request);

    @GET
    Observable<UserExtraInfoResponse> getUserExtraInfo(@Body UserExtraInfoRequest request);

}
