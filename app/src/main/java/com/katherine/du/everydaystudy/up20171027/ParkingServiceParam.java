package com.katherine.du.everydaystudy.up20171027;


import java.io.Serializable;
import java.util.List;

/**
 * Created by yliu on 2017/11/1 14:54.
 * Description :
 */

public class ParkingServiceParam implements Serializable {

    private String carBrand;
    private String carColor;
    private String licensePlateNo;
    private String orderId;
    private String std;//计划起飞时间
    private String orderParkTime;//预约泊车时间
    private List<TerminalsBean> terminals;//航站楼列表
    private TerminalsBean terminal;//航站楼

    public TerminalsBean getTerminal() {
        return terminal;
    }

    public void setTerminal(TerminalsBean terminal) {
        this.terminal = terminal;
    }

    public List<TerminalsBean> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<TerminalsBean> terminals) {
        this.terminals = terminals;
    }

    public String getOrderParkTime() {
        return orderParkTime;
    }

    public void setOrderParkTime(String orderParkTime) {
        this.orderParkTime = orderParkTime;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }

    private String userPhone;//联系方式(电话)
    private String userName;//用户姓名
    private String agentName;//服务商名称
    private String backFlight;//返程航班号
    private String preHandOverTime;//预约交车时间
    private String preHandOverLocation;//预约地点

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getLicensePlateNo() {
        return licensePlateNo;
    }

    public void setLicensePlateNo(String licensePlateNo) {
        this.licensePlateNo = licensePlateNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getBackFlight() {
        return backFlight;
    }

    public void setBackFlight(String backFlight) {
        this.backFlight = backFlight;
    }

    public String getPreHandOverTime() {
        return preHandOverTime;
    }

    public void setPreHandOverTime(String preHandOverTime) {
        this.preHandOverTime = preHandOverTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPreHandOverLocation() {
        return preHandOverLocation;
    }

    public void setPreHandOverLocation(String preHandOverLocation) {
        this.preHandOverLocation = preHandOverLocation;
    }
}
