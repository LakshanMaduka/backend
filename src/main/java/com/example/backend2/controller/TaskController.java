package com.example.backend2.controller;

import com.example.backend2.dto.EmployDTO;
import com.example.backend2.dto.ResponseDTO;
import com.example.backend2.dto.TaskDTO;
import com.example.backend2.service.EmployService;
import com.example.backend2.service.TaskService;
import com.example.backend2.utill.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/tasks")
@CrossOrigin
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private ResponseDTO responseDTO;
    @PostMapping("/saveTask")
    public ResponseEntity saveTask(@RequestBody TaskDTO taskDTO){
        try{
            String res = taskService.saveTask(taskDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(taskDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Task already added");
                responseDTO.setContent(taskDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getTasks")
    public ResponseEntity getTasks(){
        try{
            List<TaskDTO> taskDTOList =  taskService.getAllTasks();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(taskDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getEmployeeTasks/{empId}")
    public ResponseEntity getEmployeeTasks(@PathVariable String empId){
        try{
            List<TaskDTO> taskDTOList =  taskService.getEmployeeTasks(empId);
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(taskDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateTask")
    public ResponseEntity updateEmployee(@RequestBody TaskDTO taskDTO){
        try{
            String res = taskService.updateTask(taskDTO);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(taskDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("Data not found");
                responseDTO.setContent(taskDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity deleteTasks(@PathVariable int taskId){
        try{
            String res  = taskService.deleteTasks(taskId);
            if(res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("No Task availabale for this Task Id");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(ex.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
