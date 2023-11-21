package com.wedmeed.pretest.controllers;

import com.wedmeed.pretest.model.dto.InventoryPictureRequest;
import com.wedmeed.pretest.model.dto.InventoryPictureResponse;
import com.wedmeed.pretest.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/getInvPicture")
    @ResponseBody
    public InventoryPictureResponse getInvPicture(
            @RequestBody InventoryPictureRequest input) {
        Double qty = service.getInvPicture(
                input.getProductId(),
                input.getProdName(),
                input.getReqDate());

        return new InventoryPictureResponse(input.getProductId(), input.getProdName(), qty);
    }
}
