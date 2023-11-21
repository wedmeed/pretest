package com.wedmeed.pretest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AvailabilityEntry {
    String storeNo;
    String productId;
    Date date;
    Double availQty;
}
