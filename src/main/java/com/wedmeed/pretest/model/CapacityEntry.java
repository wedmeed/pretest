package com.wedmeed.pretest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CapacityEntry {
    String storeNo;
    Date date;
    Double noOfOrdersAccepted;
}
