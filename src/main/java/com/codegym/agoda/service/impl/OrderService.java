package com.codegym.agoda.service.impl;

import com.codegym.agoda.dto.OrderDto;
import com.codegym.agoda.model.House;
import com.codegym.agoda.model.HouseAccount;
import com.codegym.agoda.repository.IAccountRepo;
import com.codegym.agoda.repository.IHouseRepository;
import com.codegym.agoda.repository.IOrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private IAccountRepo iAccountRepo;

    @Autowired
    private IHouseRepository iHouseRepository;

    public List<HouseAccount> findAllHistory(int id) {
        return iOrderRepository.findAllHistory(id);
    }


    public HouseAccount saveOrder(OrderDto orderDto) throws ParseException {

        // lấy ngày từ daterager picker
        Date str = orderDto.getStartTime();
        Date ed = orderDto.getEndTime();

        // ép kiểu từ date -> local date
        LocalDate dateNow = LocalDate.now();
        LocalDate localDate = str.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // check ngày xem đặt ngày ở quá khứ
        boolean dated = localDate.isBefore(dateNow);
        if (dated) {
            // ngày đặt không hợp lệ
        }


        SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-DD", Locale.ENGLISH);
        SimpleDateFormat start = new SimpleDateFormat("HH", Locale.ENGLISH);
        SimpleDateFormat end = new SimpleDateFormat("mm", Locale.ENGLISH);

        String dateStart = dateOnlyFormat.format(str);
        String dateEnd = dateOnlyFormat.format(ed);


        orderDto.setTimeStart(dateStart);
        orderDto.setTimeEnd(dateEnd);


        HouseAccount houseAccount = orderDto.toHouseAccount();
        houseAccount.setAccount(iAccountRepo.findById(orderDto.getIdAccount()).get());
        houseAccount.setHouse(iHouseRepository.findById(orderDto.getIdHouse()).get());

        houseAccount = iOrderRepository.save(houseAccount);

        return houseAccount;

    }
}
