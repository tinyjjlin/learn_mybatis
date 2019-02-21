package com.brs.order.rest.api;

import com.brs.order.service.OrderProcessService;
import com.brs.order.service.model.TaskRepresentation;
import com.brs.sys.common.model.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/14
 */
@RestController
@Api
public class OrderProcessController {

    @Autowired
    private OrderProcessService orderProcessService;

    /**
     * 当客户创建新的订单后便开启了订单流程
     * @param orderId
     * @return
     */
    @ApiOperation("启动订单流程")
    @PostMapping("/api/order/startProcess")
    public RestResult startProcessInstance(Long orderId){
       String processInstanceId = orderProcessService.startProcess(orderId);
        return new RestResult(200,"start process success!" ,processInstanceId);
    }

    @ApiOperation("获取订单列表")
    @GetMapping("/api/order/task")
    public RestResult getTaskList(@RequestParam("assignee") String assignee){
        List<TaskRepresentation> tasks = orderProcessService.getTasks(assignee);
        return new RestResult(200,"获取订单列表",tasks );
    }
    /**
     * 经理确认订单
     * @return
     */
    @ApiOperation("确认订单")
    @GetMapping("/api/order/confirmOrder")
    public RestResult confirmOrder(@RequestParam("taskId")String taskId, @RequestParam("editorialDirectorId")Integer editorialDirectorId ){
         orderProcessService.confirmOrder(taskId,editorialDirectorId);
        return new RestResult(200,"confirm order" );
    }



    /**
     * 编辑主管分派订单
     * @return
     */
    @ApiOperation("分派订单")
    @GetMapping("/api/order/dispatchOrder")
    public RestResult dispatchOrder(@RequestParam("taskId")String taskId, @RequestParam("editorialStaffId")Integer editorialStaffId ){
            orderProcessService.dispatchOrder(taskId, editorialStaffId);
        return new RestResult(200,"dispatch order" );
    }


    /**
     * 编辑出草稿
     * @return
     */
    @ApiOperation("编辑出草稿")
    @GetMapping("/api/writeDraft")
    public RestResult writeDraft(@RequestParam("taskId")String taskId, @RequestParam("laboratoryStaffId")Integer laboratoryStaffId ){
        orderProcessService.writeDraft(taskId,laboratoryStaffId );
        return new RestResult(200,"write a draft");
    }

    /**
     * 编辑完成文章
     * @return
     */
    @ApiOperation("编辑完成文章")
    @GetMapping("/api/completeArticle")
    public RestResult completeArticle(@RequestParam("taskId")String taskId ){
        orderProcessService.completeArticle(taskId);
        return new RestResult(200,"completeArticle");
    }

    /**
     * 实验人员处理数据
     * @param taskId
     * @return
     */
    @ApiOperation("实验人员处理数据")
    @GetMapping("/api/handleData")
    public RestResult handleData(@RequestParam("taskId")String taskId){
        orderProcessService.handleData(taskId);
        return new RestResult(200,"handle data");
    }
}
