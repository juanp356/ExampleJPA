/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistences;

/**
 *fecha: 8/0472025
 * @author Aprendiz
 * objetivo: instanciar los DAO' S creados en la persistencia
 */
public class DAOFactory {
    private static IEmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
    private static IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static IKeyRoomDAO keyRoomDAO = new KeyRoomDAO();
    private static IRecordDAO recordDAO = new RecordDAO();

    public static IEmployeeTypeDAO getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public static IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static IKeyRoomDAO getKeyRoomDAO() {
        return keyRoomDAO;
    }

    public static IRecordDAO getRecordDAO() {
        return recordDAO;
    }
    
    
    
    
}
