package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository repository;

    @Test
    void getAllTasksTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        when(repository.findAll()).thenReturn(taskList);

        //When
        List<Task> theList = dbService.getAllTasks();

        //Then
        assertEquals(1, theList.size());
        assertNotNull(theList);
    }

    @Test
    void getTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        when(repository.findById(1L)).thenReturn(Optional.of(task));

        //When
        Optional<Task> theTask = dbService.getTask(1L);

        //Then
        assertEquals(Optional.of(task), theTask);
    }

    @Test
    void saveTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        when(repository.save(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        assertEquals(task.getId(), savedTask.getId());
        assertEquals(task.getTitle(), savedTask.getTitle());
        assertEquals(task.getContent(), savedTask.getContent());

    }

    @Test
    void deleteTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        Long id = task.getId();

        dbService.deleteTask(id);
        //When
        Optional<Task> taskOptional = dbService.getTask(id);
        //Then
        assertTrue(taskOptional.isEmpty());

    }
}