package com.t6.bksys.controller;

import com.alibaba.fastjson.JSONObject;
import com.t6.bksys.service.AlterBonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
public class AlterBonusController {

    private final AlterBonusService alterBonusService;

    @Autowired
    public AlterBonusController(AlterBonusService alterBonusService) {
        this.alterBonusService = alterBonusService;
    }

    @PostMapping("/alter_bonus")
    public JSONObject alterBonus(@RequestBody String body) {
        JSONObject request = JSONObject.parseObject(body);
        return alterBonusService.updateSeatBonus(request);
    }
}
