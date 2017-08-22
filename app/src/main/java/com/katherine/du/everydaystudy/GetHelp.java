package com.katherine.du.everydaystudy;

/**
 * Created by du on 17/8/22.
 */

class GetHelp {
    private static final GetHelp ourInstance = new GetHelp();

    static GetHelp getInstance() {
        return ourInstance;
    }

    private GetHelp() {
    }
}
