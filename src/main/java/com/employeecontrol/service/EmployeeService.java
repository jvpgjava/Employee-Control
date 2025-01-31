package com.employeecontrol.service;

import com.employeecontrol.dto.EmployeeDTO;
import com.employeecontrol.model.Employee;
import com.employeecontrol.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //Definindo como serviço
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee create(EmployeeDTO dto) {
        //Converte DTO para Entidade
        Employee employee = new Employee(null, dto.name(), dto.cpf(), dto.position(), dto.department());
        return repository.save(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
