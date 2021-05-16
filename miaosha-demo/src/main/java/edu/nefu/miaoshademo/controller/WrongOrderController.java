package edu.nefu.miaoshademo.controller;

import com.google.common.util.concurrent.RateLimiter;
import edu.nefu.miaoshademo.service.StockOrderService;
import edu.nefu.miaoshademo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/wrong/")
@Slf4j
public class WrongOrderController {
    @Autowired
    private StockOrderService stockOrderService;

    /**
     * 仅仅使用乐观锁更新库存
     *
     * @param sid
     * @return
     */
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

    // 每秒放行10个请求
    RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * 通过令牌桶和限流算法更新库存
     *
     * @param sid
     * @return
     */
    @PostMapping("orderByLimit/{sid}")
    public ResultVO buyByLimit(@PathVariable("sid") int sid) {
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            log.debug("你被限流了, 真不幸");
            return ResultVO.fail(400, "购买失败, 库存不足");
        }
        log.debug("购买的商品编号: {}", sid);
        int id = 0;
        try {
            id = stockOrderService.add(sid);
            log.debug("创建订单id: {}", id);
        } catch (Exception e) {
            return ResultVO.fail(400, "购买失败, 库存不足");
        }
        return ResultVO.success(Map.of("id", id));
    }

    // TODO: 实现悲观锁+令牌桶更新库存

}
