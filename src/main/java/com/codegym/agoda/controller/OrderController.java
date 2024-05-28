package com.codegym.agoda.controller;

import com.codegym.agoda.dto.OrderDto;
import com.codegym.agoda.model.House;
import com.codegym.agoda.model.HouseAccount;
import com.codegym.agoda.model.TypeRoom;
import com.codegym.agoda.service.impl.OrderService;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController("apiOrderController")
@RequestMapping("/api/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<HouseAccount> saveOrder(@RequestBody OrderDto orderDto) throws ParseException {
        return new ResponseEntity<>(orderService.saveOrder(orderDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<HouseAccount>> findOrderById(@PathVariable int id) {
        List<HouseAccount> houseAccounts = orderService.findAllHistory(id);
        if (houseAccounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(houseAccounts, HttpStatus.OK);
    }
}
