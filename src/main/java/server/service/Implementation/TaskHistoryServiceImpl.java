package server.service.Implementation;

import org.springframework.stereotype.Service;
import server.domain.Task;
import server.domain.TaskHistory;
import server.dto.TaskHistoryDTO;
import server.service.TaskHistoryService;
import server.service.TaskService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {


private final TaskService taskService;

    public TaskHistoryServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public TaskHistoryDTO viewTaskHistory(String title) {
        Task task = taskService.getTaskByTitle(title);
        if (task != null) {
            TaskHistory history = task.getHistory();

            Instant timestamp = history.getTimestamp();
            LocalDateTime localDateTime = timestamp.atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);

            String oldStatus = history.getOldStatus().toString();
            String newStatus = history.getNewStatus().toString();
            String movedBy = history.getMovedBy().getFirstName() + " " + history.getMovedBy().getLastName();

            TaskHistoryDTO taskHistoryDTO = new TaskHistoryDTO();
            taskHistoryDTO.setMovedBy(movedBy);
            taskHistoryDTO.setOldStatus(Task.Status.valueOf(oldStatus));
            taskHistoryDTO.setNewStatus(Task.Status.valueOf(newStatus));
            taskHistoryDTO.setMovedAt(formattedDateTime);
            return taskHistoryDTO;


        }

    else
    {
        return null;
    }

}}
