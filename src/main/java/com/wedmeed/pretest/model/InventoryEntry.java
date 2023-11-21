package com.wedmeed.pretest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InventoryEntry {
    String productId;
    String prodName;
    String UOM;
    Double availQty;
    Date availDate;
}
