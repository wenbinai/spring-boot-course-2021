package edu.nefu.miaoshademo.controller;

import edu.nefu.miaoshademo.service.StockOrderService;
import edu.nefu.miaoshademo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/wrong/")
@Slf4j
public class WrongOrderController {
    @Autowired
    private StockOrderService stockOrderService;

    @PostMapping("order/{sid}")
    public ResultVO buy(@PathVariable("sid") int sid) {
        log.debug("购买的商品编号: {}", sid);
        int id = 0;
        try {
            id = stockOrderService.add(sid);
            log.debug("创建订单id: {}", id);
        } catch (Exception e) {
            log.debug("Exception: {}", e);
        }
        return ResultVO.success(Map.of("id", id));
    }
}
