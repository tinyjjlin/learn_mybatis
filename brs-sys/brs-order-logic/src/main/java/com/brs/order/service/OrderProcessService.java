package com.brs.order.service;

import com.brs.order.service.model.TaskRepresentation;
import org.flowable.task.api.Task;
import java.util.List;


/**
 * @author tiny lin
 * @date 2019/2/21
 */
public interface OrderProcessService {
    /**
     * 启动订单流程
     * @return
     */
    public String startProcess(String orderId);

    /**
     * 获取用户任务
     * @param assignee
     * @return
     */
    public List<Task> getTaskList(String assignee);
    /**
     * 获取用户任务
     * @param assignee
     * @return
     */
    public List <TaskRepresentation> getTasks(String assignee);

    /**
     * 客户，或总经理启动订单流程（通过新生成的内部订单号）
     */
    public String startProcess(Long orderId);

    /**
     * 确认订单
     * @param taskId
     */
    public void confirmOrder(String taskId,Integer editorialDirectorId);
    /**
     * 分发订单（编辑主管向编辑人员分发订单）
     * @param taskId
     * @param editorialStaffId
     */
    public void dispatchOrder(String taskId,Integer editorialStaffId);

    /**
     * 编辑写草稿
     * @param taskId
     * @param laboratoryStaffId
     */
    public void writeDraft(String taskId,Integer laboratoryStaffId);

    /**
     * 编辑完成文章
     * @param taskId
     */
    public void completeArticle(String taskId);

    /**
     * 实验人员处理数据
     * @param taskId
     */
    public void handleData(String taskId);

    /**
     * 根据用户任务id获取指导的任务
     * @param taskId
     * @return
     */
    public Task getTaskByTaskId(String taskId );

}
