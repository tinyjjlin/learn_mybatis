package com.brs.order.service;

import com.brs.order.service.model.TaskRepresentation;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tiny lin
 * @date 2019/2/21
 */
@Service
public class OrderProcessServiceImpl implements  OrderProcessService {
    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Override
    public String startProcess(String orderId) {
        return null;
    }

    @Override
    public List<Task> getTaskList(String assignee) {
        return null;
    }

    @Override
    public List <TaskRepresentation> getTasks(String assignee) {
        return null;
    }

    @Override
    public String startProcess(Long orderId) {
        return null;
    }

    @Override
    public void confirmOrder(String taskId, Integer editorialDirectorId) {

    }

    @Override
    public void dispatchOrder(String taskId, Integer editorialStaffId) {

    }

    @Override
    public void writeDraft(String taskId, Integer laboratoryStaffId) {

    }

    @Override
    public void completeArticle(String taskId) {

    }

    @Override
    public void handleData(String taskId) {

    }

    @Override
    public Task getTaskByTaskId(String taskId) {
        return null;
    }
}
