package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTestSuit {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        Task task = new Task(1L, "title", "content");
        TaskDto taskDto = new TaskDto(1L, "title", "content");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(taskDto.getId(),mappedTask.getId());
        assertEquals(taskDto.getTitle(), mappedTask.getTitle());
        assertEquals(taskDto.getContent(), mappedTask.getContent());
    }

    @Test
    void testMapToTaskDto() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        Task task = new Task(1L, "title", "content");

        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(task.getId(),mappedTask.getId());
        assertEquals(task.getTitle(), mappedTask.getTitle());
        assertEquals(task.getContent(), mappedTask.getContent());
    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task = new Task(1L, "title", "content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        TaskDto taskDto = new TaskDto(1L, "title", "content");
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(taskDto);

        //When
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskDtoList.size(),mappedTaskDtoList.size());
        assertEquals(taskDtoList.get(0).getId(),mappedTaskDtoList.get(0).getId());
        assertEquals(taskDtoList.get(0).getTitle(),mappedTaskDtoList.get(0).getTitle());
        assertEquals(taskDtoList.get(0).getContent(),mappedTaskDtoList.get(0).getContent());
    }


}
