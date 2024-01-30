package com.example.backend2.service;

import com.example.backend2.dto.EmployDTO;
import com.example.backend2.entity.Employee;
import com.example.backend2.repo.EmployRepo;
import com.example.backend2.utill.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployService {

    @Autowired
    private EmployRepo employRepo;
    @Autowired
    private ModelMapper modelMapper;
    public String saveEmploy(EmployDTO employDTO){
        if(employRepo.existsById(employDTO.getEmpId())){
            return VarList.RSP_DUPLICATED;
        }else {
              employRepo.save(modelMapper.map(employDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }

    }

    public List<EmployDTO> getAllEmplyees(){
        List<Employee> employeeList = employRepo.findAll();
        return modelMapper.map(employeeList,new TypeToken<List<EmployDTO>>(){}.getType());
    }

    public String updateEmployee(EmployDTO employDTO){
        if(employRepo.existsById(employDTO.getEmpId())){
            employRepo.save(modelMapper.map(employDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
        else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }


    public String deleteEmployee(int id){
        if(employRepo.existsById(id)){
            employRepo.deleteById(id);
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
