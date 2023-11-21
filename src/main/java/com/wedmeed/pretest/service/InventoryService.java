package com.wedmeed.pretest.service;

import com.wedmeed.pretest.model.InventoryEntry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class InventoryService {
    List<InventoryEntry> repo = new LinkedList<>();
    Date today = new Date();

    @PostConstruct
    private void init() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        repo.add(new InventoryEntry("Prod1", "Shirt", "EACH", 10.0, sdf.parse("2021-03-20")));
        repo.add(new InventoryEntry("Prod1", "Shirt", "EACH", 20.0, sdf.parse("2021-03-21")));
        repo.add(new InventoryEntry("Prod1", "Shirt", "EACH", 20.0, sdf.parse("2021-03-28")));
        today = sdf.parse("2021-03-19");
    }

    public Double getInvPicture(
            String productId,
            String prodName,
            Date reqDate) {
        log.info("{}, {}, {}", today, reqDate, getDiffInDays(today, reqDate));
        if (today.getTime() > reqDate.getTime()
                || getDiffInDays(reqDate, today) >= 10) {
            throw new IllegalArgumentException();
        }
        return repo.stream()
                .filter(entry -> entry.getProductId().equals(productId))
                .filter(entry -> entry.getProdName().equals(prodName))
                .filter(entry -> {
                    long diffInDays = getDiffInDays(entry.getAvailDate(), reqDate);
                    log.info("{}, {}, {}", reqDate, entry.getAvailDate(), diffInDays);
                    return diffInDays >= 0 && diffInDays < 10;
                })
                .mapToDouble(InventoryEntry::getAvailQty)
                .sum();
    }

    private static long getDiffInDays(Date date1, Date date2) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }


}
