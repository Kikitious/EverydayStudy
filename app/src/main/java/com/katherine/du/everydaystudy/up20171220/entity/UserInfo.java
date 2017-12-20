package com.katherine.du.everydaystudy.up20171220.entity;

import com.katherine.du.everydaystudy.up20171220.response.UserBaseInfoResponse;
import com.katherine.du.everydaystudy.up20171220.response.UserExtraInfoResponse;

/**
 * Created by du on 17/12/20.
 */

public class UserInfo {


    private UserBaseInfoResponse baseInfo;
    private UserExtraInfoResponse extraInfo;

    public UserInfo(UserBaseInfoResponse baseInfo, UserExtraInfoResponse extraInfo) {
        this.baseInfo = baseInfo;
        this.extraInfo = extraInfo;
    }
}
