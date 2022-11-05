package com.example.demo.dao;

import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees =null;//创建一个部门表
@Autowired
    private DepartmentDao departmentDao;
    static{
        employees=new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001,"AA","E123456789",1,new Department(101,"教学部"),new Date()));
        employees.put(1002, new Employee(1002,"BB","C123456789",0,new Department(102,"市场部"),new Date()));
        employees.put(1003, new Employee(1003,"CC","B123456789",1,new Department(103,"教研部"),new Date()));
        employees.put(1004, new Employee(1004,"DD","A123456789",0,new Department(104,"运营部"),new Date()));
        employees.put(1005, new Employee(1005,"EE","D123456789",1,new Department(105,"后勤部"),new Date()));
    }
    private static Integer initId=1006;
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }

}
