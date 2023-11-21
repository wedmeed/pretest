package com.wedmeed.pretest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class InventoryPictureRequest {
        String productId;
        String prodName;
        Date reqDate;
}
