package io.orkes.samples.workers;
import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;
import org.springframework.stereotype.Component;

@Component
public class DesignRequest implements Worker {
    @Override
    public String getTaskDefName() {
        return "design_request_approval_<ID>";
    }

    @Override
    public TaskResult execute(Task task) {

        TaskResult result = new TaskResult(task);
        String client = (String) task.getInputData().get("client");
        String description = (String) task.getInputData().get("description");
        String audience = (String) task.getInputData().get("audience");
        String country = (String) task.getInputData().get("country");
        String theme = (String) task.getInputData().get("theme");

        try {
            boolean approved = Math.random() < 0.3;
            result.setStatus(TaskResult.Status.COMPLETED);
            result.addOutputData("approved", true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
