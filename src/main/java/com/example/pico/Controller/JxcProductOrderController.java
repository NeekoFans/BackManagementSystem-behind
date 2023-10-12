package com.example.pico.Controller;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.Result;
import com.example.pico.service.JxcProductOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/order")
public class JxcProductOrderController {
    @Resource
    private JxcProductOrderService jxcOrderService;

    @RequestMapping("/list")
    public Result<List<JxcProductOrder>> getOrderList(JxcProductOrder jxcProductOrder){
        List<JxcProductOrder> ordersList=jxcOrderService.getOrderList(jxcProductOrder);
        return Result.success(ordersList);
    }
    @RequestMapping("/addList")
    public Result<List<JxcProductOrder>> getAddList(JxcProductOrder jxcProductOrder){
        List<JxcProductOrder> ordersList=jxcOrderService.getAddList(jxcProductOrder);
        return Result.success(ordersList);
    }
    @RequestMapping("/reviewList")
    public Result<List<JxcProductOrder>> reviewList(JxcProductOrder jxcProductOrder){
        List<JxcProductOrder> ordersList=jxcOrderService.reviewList(jxcProductOrder);

        return Result.success(ordersList);
    }
//    @RequestMapping("/getSellTotal")
//    public Result<List<Integer>> total(){
//        List<Integer> total=jxcOrderService.total();
//        return Result.success(total);
//    }
//    @RequestMapping("/getAddTotal")
//    public Result<List<Integer>> getAddTotal(){
//        List<Integer> total=jxcOrderService.getAddTotal();
//        return Result.success(total);
//    }
//    @RequestMapping("/reviewTotal")
//    public Result<List<Integer>> reviewTotal(Integer orderType){
//
//        List<Integer> total=jxcOrderService.reviewTotal(orderType);
//
//        return Result.success(total);
//    }
    @RequestMapping("/delete")
    public Result<JxcProductOrder> delete(String id){
        jxcOrderService.delete(id);
        return Result.success("删除成功");
    }
    @RequestMapping("/deleteBytypeId")
    public Result<JxcProductOrder> deleteBytypeId(String typeId){
        jxcOrderService.deleteBytypeId(typeId);
        return Result.success("删除成功");
    }
    @RequestMapping("/getById")
    public Result<List<JxcProductOrder>> getById(Long id){
        List<JxcProductOrder> list= jxcOrderService.getById(id);
        return Result.success(list.get(0));
    }
    @RequestMapping("/update")
    public Result update(JxcProductOrder jxcRole){
        jxcOrderService.update(jxcRole);
        return Result.success("修改成功");
    }
    @RequestMapping("/editBytypeId")
    public Result editBytypeId(String typeId){
        jxcOrderService.editBytypeId(typeId);
        return Result.success("修改成功");
    }
    @RequestMapping("/refuseBytypeId")
    public Result refuseBytypeId(String typeId){
        jxcOrderService.refuseBytypeId(typeId);
        return Result.success("库存不足，请先采购");
    }
    @RequestMapping("/endByTypeId")
    public Result endByTypeId(String typeId,String orderType,String reason){
        jxcOrderService.endByTypeId(typeId,orderType,reason);
        return Result.success("驳回成功");
    }
    @RequestMapping("/reason")
    public Result reason(String reason,String typeId,String orderType){
        jxcOrderService.reason(reason,typeId,orderType);
        return Result.success("驳回原因");
    }
    @RequestMapping("/editOutBytypeId")
    public Result editOutBytypeId(String typeId){
        jxcOrderService.editOutBytypeId(typeId);
        return Result.success("修改成功");
    }

}
