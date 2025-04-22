/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.Utils.MessageUtils;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistences.DAOFactory;
import java.util.List;

/**
 *fecha: 22/04/2025
 * @author Aprendiz
 * Objetivo: probar el controlador de tipo de empleado
 */
public class TestEmployeeType {
    
    public void insert(){
        try {
            EmployeeType employeeType = new EmployeeType();
            employeeType.setDescript("NUEVO TIPO");
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.insert(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado creado exitosamente");
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void update(){
        try {
             EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(11);
             employeeType.setDescript("ALGUIEN NUEVO");
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.update(employeeType);
            MessageUtils.showInfoMessage("Tipo de empleado actualizado exitosamente");
        } catch (Exception e) {
               MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void delete(){
         try {
             EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findById(11);
           
            
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.delete(employeeType.getId());
            MessageUtils.showInfoMessage("Tipo de empleado eliminado exitosamente");
        } catch (Exception e) {
               MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void findAll(){
        try {
             IEmployeeTypeController controller = new EmployeeTypeController();
             List<EmployeeType> types = controller.findAll();
             String messages = "";
             for (EmployeeType type : types) {
                messages += "Id:  "+type.getId() +"  Descripcion: "+type.getDescript() +"\n";
            }
             MessageUtils.showInfoMessage(messages);
            
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
        
    }
    
    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
//        test.insert();
//          test.update();
//          test.delete();
           test.findAll();
    }
}
