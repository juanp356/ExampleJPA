/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;


import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistences.DAOFactory;
import co.edu.sena.examplejpa.persistences.EntityManagerHelper;
import java.util.List;

/**
 * fecha:25/03/2025
 * @author Aprendiz
 * objetivo: implementar la interface para controlar el modelo employeetype
 */
public class EmployeeTypeController  implements IEmployeeTypeController{

 
    
    @Override
    public void insert(EmployeeType employeeType) throws Exception {
        if(employeeType == null)
        {
            throw new Exception("El tipo de emepleado es nulo");
        }
        if("".equals(employeeType.getDescript())){
             throw new Exception("la descripcion es obligatoria");
        }
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory .getEmployeeTypeDAO().insert(employeeType);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(EmployeeType employeeType) throws Exception {
        if(employeeType == null){
            throw new Exception("El tipo de emepleado es nulo");
        }
        if(employeeType.getId() == 0)
        {
            throw new Exception("el id es obligatorio");
        }
        if("".equals(employeeType.getDescript())){
             throw new Exception("la descripcion es obligatoria");
        }
        
        //consultar si el empleado existe en la bd
        
        EmployeeType employeeTypeExist = DAOFactory.getEmployeeTypeDAO().findById(employeeType.getId());
        if(employeeTypeExist == null){
            throw new Exception("el tipo de empleado no existe");
        }
        
        //merge: todos los campos de la fk
        employeeTypeExist.setDescript(employeeType.getDescript());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().update(employeeTypeExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
       if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       //consultar si el empleado existe en la bd
        
        EmployeeType employeeTypeExist = DAOFactory.getEmployeeTypeDAO().findById(id);
        if(employeeTypeExist == null){
            throw new Exception("el tipo de empleado no existe");
        }
        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getEmployeeTypeDAO().delete(employeeTypeExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<EmployeeType> findAll() throws Exception {
      return DAOFactory.getEmployeeTypeDAO().findAll();
    }

    @Override
    public EmployeeType finById(Integer id) throws Exception {
         if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       return DAOFactory.getEmployeeTypeDAO().findById(id);
    }
    
}
