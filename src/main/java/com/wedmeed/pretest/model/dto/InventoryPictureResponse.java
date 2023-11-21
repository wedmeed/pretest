package com.wedmeed.pretest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryPictureResponse {
    String productId;
    String prodName;
    Double availQty;
}
