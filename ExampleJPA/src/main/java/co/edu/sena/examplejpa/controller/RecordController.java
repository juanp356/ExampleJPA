/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistences.DAOFactory;
import co.edu.sena.examplejpa.persistences.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class RecordController implements IRecordController {

    
    
    @Override
    public void insert(Record record) throws Exception {
       if(record == null){
           throw new Exception("El registro es obligatorio");
       }
       if(record.getId() == 0){
           throw new Exception("El ID es obligatorio");
       }
       if(record.getDateRecord() == null){
           throw new Exception("la fecha de registro es obligatoria");
       }
       if(record.getStartTime() == null){
           throw new Exception("la hora de inicio del registro es obligatoria");
       }
       //FK
        if(record.getEmployeeId() == null){
           throw new Exception("el registro del empleado es obigatorio");
       }
       if(record.getKeyId() == null){
           throw new Exception("el registro de la llave es obigatorio");
       }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Record record) throws Exception {
         if(record == null){
           throw new Exception("El registro es obligatorio");
       }
       if(record.getId() == 0){
           throw new Exception("El ID es obligatorio");
       }
       if(record.getDateRecord() == null){
           throw new Exception("la fecha de registro es obligatoria");
       }
       if(record.getStartTime() == null){
           throw new Exception("la hora de inicio del registro es obligatoria");
       }
       //FK
        if(record.getEmployeeId()== null){
           throw new Exception("el registro del empleado es obigatorio");
       }
       if(record.getKeyId()== null){
           throw new Exception("el registro de la llave es obigatorio");
       }
       
       Record rExists = DAOFactory  .getRecordDAO().findById(record.getId());
       if(rExists == null){
           throw new Exception("el registro no existe");
       }       
      rExists.setDateRecord(record.getDateRecord());
      rExists.setStartTime(record.getStartTime());
      rExists.setEndTime(record.getEndTime());
      rExists.setEmployeeId(record.getEmployeeId());
      rExists.setKeyId(record.getKeyId());
      
       EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().update(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if(id == 0){
           throw new Exception("El ID es obligatorio");
       }
       Record rExists = DAOFactory.getRecordDAO().findById(id);
       if(rExists == null){
           throw new Exception("el registro no existe");
       }  
       EntityManagerHelper.beginTransaction();
        DAOFactory.getRecordDAO().delete(rExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Record> findAll() throws Exception {
        return DAOFactory.getRecordDAO().findAll();
    }

    @Override
    public Record findById(Integer id) throws Exception {
       if(id == 0){
           throw new Exception("el id es obligatorio");
       }
       return DAOFactory.getRecordDAO().findById(id);
    }
    
}
