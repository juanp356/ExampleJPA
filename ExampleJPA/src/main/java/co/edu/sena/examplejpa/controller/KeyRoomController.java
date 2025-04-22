/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistences.DAOFactory;
import co.edu.sena.examplejpa.persistences.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class KeyRoomController implements IKeyRoomController{
    

    
    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null){
            throw new Exception("la llave es nula");
        }
        if(keyRoom.getId() == 0){
             throw new Exception("El id es oblogatorio");
        }
        if("".equals(keyRoom.getName())){
            throw new Exception("El nombre es oblogatorio");
        }
        if("".equals(keyRoom.getRoom())){
            throw new Exception("El salon es oblogatorio");
        }
        if(keyRoom.getCount() == -1){
             throw new Exception("la cantidad de llaves es incorrecta");
        }
         EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if(keyRoom == null){
            throw new Exception("la llave es nula");
        }
        if(keyRoom.getId() == 0){
             throw new Exception("El id es oblogatorio");
        }
        if("".equals(keyRoom.getName())){
            throw new Exception("El nombre es oblogatorio");
        }
        if("".equals(keyRoom.getRoom())){
            throw new Exception("El salon es oblogatorio");
        }
        if(keyRoom.getCount() == -1){
             throw new Exception("la cantidad de llaves es incorrecta");
        }
        
        KeyRoom kExist = DAOFactory.getKeyRoomDAO().findById(keyRoom.getId());
        if(kExist == null){
             throw new Exception("la llave no existe");
        }
        
        kExist.setCount(keyRoom.getCount());
        kExist.setName(keyRoom.getName());
        kExist.setObservation(keyRoom.getObservation());
        kExist.setRoom(keyRoom.getRoom());
        
          EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().update(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
     if(id == 0){
         throw new Exception("el id es obligatorio");
     }
       KeyRoom kExist = DAOFactory.getKeyRoomDAO().findById(id);
        if(kExist == null){
             throw new Exception("el id no existe en la bd");
        }
       EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(kExist);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().findAll();
    }

    @Override
    public KeyRoom findById(Integer id) throws Exception {
        if(id == 0){
         throw new Exception("el id es obligatorio");
     }
       KeyRoom kExist = DAOFactory.getKeyRoomDAO().findById(id);
        if(kExist == null){
             throw new Exception("el id no existe en la bd");
        }
        return DAOFactory.getKeyRoomDAO().findById(id);
    }
    
}
