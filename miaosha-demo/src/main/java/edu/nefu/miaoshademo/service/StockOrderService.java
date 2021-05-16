package edu.nefu.miaoshademo.service;

import edu.nefu.miaoshademo.entity.Stock;
import edu.nefu.miaoshademo.entity.StockOrder;
import edu.nefu.miaoshademo.mapper.StockMapper;
import edu.nefu.miaoshademo.mapper.StockOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockOrderService {
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private StockOrderMapper stockOrderMapper;

    public int add(int sid) {
        // 检验库存
        Stock stock = checkStock(sid);
        // 扣库存
        saleStock(stock);
        // 创建订单
        int id = createOrder(stock);

        return id;
    }

    private int createOrder(Stock stock) {
        StockOrder stockOrder = StockOrder.builder()
                .sid(stock.getId())
                .name(stock.getName())
                .build();
        int id = stockOrderMapper.insert(stockOrder);
        return id;
    }

    private void saleStock(Stock stock) {
        stock.setSale(stock.getSale() + 1);
        int update = stockMapper.updateById(stock);
        if (update <= 0) {
            throw new RuntimeException("竞争失败, 请重新抢购");
        }
    }

    private Stock checkStock(int sid) {
        Stock stock = stockMapper.selectById(sid);
        if (stock.getSale().equals(stock.getCount())) {
            throw new RuntimeException("库存不足");
        }
        return stock;
    }
}
