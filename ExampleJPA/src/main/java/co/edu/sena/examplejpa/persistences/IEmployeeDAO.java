/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistences;

import co.edu.sena.examplejpa.model.Employee;
import java.util.List;

/**
 * fecha: 8/04/2025
 * @author Aprendiz
 * objetivo: interface para DAO de empleado
 */
public interface IEmployeeDAO {
    
    public void insert(Employee employee) throws Exception; 
    public void update(Employee employee) throws Exception; 
    public void delete(Employee employee) throws Exception; 
    public  Employee findById(Long document) throws Exception; 
    public List <Employee> findAll() throws Exception; 
}
