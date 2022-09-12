package io.orkes.samples.workers;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;


@Component
public class RejectionDesignRequest implements Worker {
    @Override
    public String getTaskDefName() {
        return "rejection_design_request";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        try {
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("emailContent", "The design creation has been rejected by the designer");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
