/*
 * AdminRepository.java
 * AdminRepository class - handles CRUD operations for Admin objects
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements IRepository<Admin,String>{
    
    // Singleton instance of AdminRepository
    public static AdminRepository repository = null;

    // List to store Admin objects
    private List<Admin> adminList;

    // Private constructor to prevent external instantiation
    private AdminRepository(){
        adminList= new ArrayList<>();
    }

    // Method to get the singleton instance of AdminRepository
    public static AdminRepository getRepository(){
        if(repository == null){
            repository= new AdminRepository();
        }
        return repository;
    }

    // Create a new Admin and add to the list
    @Override
    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);
        if(success){
            return admin;
        }
        return null;
    }

    // Read an Admin by its ID
    @Override
    public Admin read(String adminId) {
        for(Admin admin : adminList){
            if(admin.getAdminId().equals(adminId)){
                return admin;
            }
        }
        return null;
    }

    // Update an existing Admin
    @Override
    public Admin update(Admin admin) {
       String id = admin.getAdminId();
       Admin oldAdmin = read(id);

       if(oldAdmin != null){
           adminList.remove(oldAdmin); // Remove old entry
           adminList.add(admin);       // Add updated entry
           return admin;
       }
       return null;
    }

    // Delete an Admin by ID
    @Override
    public boolean delete(String id) {
       Admin adminToDelete = read(id);

       if(adminToDelete !=null){
           adminList.remove(adminToDelete);
           return true;
       }
       return false;
    }

    // Get all Admin objects
    @Override
    public List<Admin> getAll() {
        return adminList;
    }
}
