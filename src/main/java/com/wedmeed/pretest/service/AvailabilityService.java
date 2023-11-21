package com.wedmeed.pretest.service;

import com.wedmeed.pretest.model.AvailabilityEntry;
import com.wedmeed.pretest.model.CapacityEntry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
@Slf4j
public class AvailabilityService {
    List<AvailabilityEntry> arepo = new LinkedList<>();
    List<CapacityEntry> crepo = new LinkedList<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);

    @PostConstruct
    private void init() throws ParseException {

        arepo.add(new AvailabilityEntry("Store001", "Prod1", new Date(2021 - 02 - 19), 1.0));
        arepo.add(new AvailabilityEntry("Store001", "Prod1", new Date(2021 - 02 - 20), 3.0));
        arepo.add(new AvailabilityEntry("Store001", "Prod1", new Date(2021 - 02 - 21), 0.0));

        crepo.add(new CapacityEntry(" Store001", new Date(2021 - 02 - 19), 0.0));
        crepo.add(new CapacityEntry(" Store001", new Date(2021 - 02 - 20), 2.0));
        crepo.add(new CapacityEntry("Store001", new Date(2021 - 02 - 21), 2.0));
        crepo.add(new CapacityEntry("Store001", new Date(2021 - 02 - 22), 0.0));

    }

    public Double getProdAvailability(
            String storeNo,
            String productId,
            Date reqDate) {
        Double qty = 0.0;
        Future<Optional<AvailabilityEntry>> availability = executor.submit(() -> arepo.stream()
                .filter(entry -> entry.getStoreNo().equals(storeNo))
                .filter(entry -> entry.getProductId().equals(productId))
                .filter(entry -> entry.getDate().equals(reqDate))
                .findFirst());

        Future<Optional<CapacityEntry>> capacity = executor.submit(() -> crepo.stream()
                .filter(entry -> entry.getStoreNo().equals(storeNo))
                .filter(entry -> entry.getDate().equals(reqDate))
                .findFirst());


        // More code should be here =(

        return qty;
    }


}
