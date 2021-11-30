package cn.mybatisplus.number.service.impl;

import cn.mybatisplus.number.entity.Goods;
import cn.mybatisplus.number.mapper.GoodsMapper;
import cn.mybatisplus.number.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
