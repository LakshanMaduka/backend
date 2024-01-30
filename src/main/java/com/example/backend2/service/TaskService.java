package com.example.backend2.service;

import com.example.backend2.dto.EmployDTO;
import com.example.backend2.dto.TaskDTO;
import com.example.backend2.entity.Employee;
import com.example.backend2.entity.Task;
import com.example.backend2.repo.EmployRepo;
import com.example.backend2.repo.TaskRepo;
import com.example.backend2.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveTask(TaskDTO taskDTO){
        if(taskRepo.existsById(taskDTO.getTaskId())){
            return VarList.RSP_DUPLICATED;
        }else {
            taskRepo.save(modelMapper.map(taskDTO, Task.class));
            return VarList.RSP_SUCCESS;
        }

    }

    public List<TaskDTO> getAllTasks(){
        List<Task> tasksList = taskRepo.findAll();
        return modelMapper.map(tasksList,new TypeToken<List<TaskDTO>>(){}.getType());
    }
    public List<TaskDTO> getEmployeeTasks(String empId){
        List<Task> tasksList = taskRepo.getTasksByEmpId(empId);
        return modelMapper.map(tasksList,new TypeToken<List<TaskDTO>>(){}.getType());
    }

    public String updateTask(TaskDTO taskDTO){
        if(taskRepo.existsById(taskDTO.getTaskId())){
            taskRepo.save(modelMapper.map(taskDTO, Task.class));
            return VarList.RSP_SUCCESS;
        }
        else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
    public String deleteTasks(int id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
