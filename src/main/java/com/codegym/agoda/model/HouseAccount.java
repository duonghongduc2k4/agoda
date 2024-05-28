package com.codegym.agoda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "house_account")
public class HouseAccount {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id ;
    private String timeStart;
    private String timeEnd;
    private String total ;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonIgnore
    private HouseAccount houseAccount;


}
