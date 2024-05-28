package com.codegym.agoda.dto;

import com.codegym.agoda.model.HouseAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDto {

    private String date;

    private String timeStart;
    private String timeEnd;
    private String total ;
    private String status;
    private int idHouse;
    private int idAccount;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public HouseAccount toHouseAccount() {
        HouseAccount houseAccount = new HouseAccount();
        houseAccount.setTimeStart(timeStart);
        houseAccount.setTimeEnd(timeEnd);
        houseAccount.setTotal(total);
        houseAccount.setStatus(status);
        return houseAccount;
    }

    // láy dữ liệu từ daterager picker
    public Date getStartTime() throws ParseException {
        // ngày bắt đầu
        String str = date.split("--")[0].trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = dateFormat.parse(str);
        return date;
    }

    public Date getEndTime() throws ParseException {
        // ngày kết thúc
        String str = date.split("--")[1].trim();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = dateFormat.parse(str);
        return date;
    }


}
