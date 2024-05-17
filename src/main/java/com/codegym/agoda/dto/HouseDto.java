package com.codegym.agoda.dto;

import com.codegym.agoda.model.Account;
import com.codegym.agoda.model.House;
import com.codegym.agoda.model.Room;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public class HouseDto {

    private int id;
    private String name;
    private String address;
    private String description;
    private double price;
    private int numberOfBedRoom;
    private int numberOfBathRoom;
    //doanh thu
    private List<RoomDto> rooms;
    private double revenue;

    private int accountId;


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    private MultipartFile[] image;

    public MultipartFile[] getImage() {
        return image;
    }

    public void setImage(MultipartFile[] image) {
        this.image = image;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> roomDtos) {
        this.rooms = roomDtos;
    }

    public HouseDto() {
    }

    public House toHouse() {
        House house = new House();
        house.setId(id);
        house.setName(name);
        house.setAddress(address);
        house.setDescription(description);
        house.setPrice(price);
        house.setNumberOfBedRoom(numberOfBedRoom);
        house.setNumberOfBathRoom(numberOfBathRoom);
        house.setRevenue(revenue);
        return house;

    }

    public HouseDto(int id, String name, String address, String description, double price, int numberOfBedRoom, int numberOfBathRoom, double revenue) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.price = price;
        this.numberOfBedRoom = numberOfBedRoom;
        this.numberOfBathRoom = numberOfBathRoom;
        this.revenue = revenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfBedRoom() {
        return numberOfBedRoom;
    }

    public void setNumberOfBedRoom(int numberOfBedRoom) {
        this.numberOfBedRoom = numberOfBedRoom;
    }

    public int getNumberOfBathRoom() {
        return numberOfBathRoom;
    }

    public void setNumberOfBathRoom(int numberOfBathRoom) {
        this.numberOfBathRoom = numberOfBathRoom;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }


}
