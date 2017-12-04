package com.katherine.du.everydaystudy.up20171027;

/**
 * Created by du on 17/11/9.
 */
public class TerminalsBean implements S2cParamInf {

    /**
     * deptAirportName : 机场名称
     * deptAirportCode : 机场三字码
     * deptTerminal : 航站楼
     * terminalId : 航站楼id
     */

    private String deptAirportName;
    private String deptAirportCode;
    private String deptTerminal;
    private String terminalId;

    public String getDeptAirportName() {
        return deptAirportName;
    }

    public void setDeptAirportName(String deptAirportName) {
        this.deptAirportName = deptAirportName;
    }

    public String getDeptAirportCode() {
        return deptAirportCode;
    }

    public void setDeptAirportCode(String deptAirportCode) {
        this.deptAirportCode = deptAirportCode;
    }

    public String getDeptTerminal() {
        return deptTerminal;
    }

    public void setDeptTerminal(String deptTerminal) {
        this.deptTerminal = deptTerminal;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}
