/*
 * AdminRepository.java
 * AdminRepository class
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements IRepository<Admin,String>{
    public static AdminRepository repository = null;

    private List<Admin> adminList;

    private AdminRepository(){
        adminList= new ArrayList<>();
    }
    public static AdminRepository getRepository(){
        if(repository == null){
            repository= new AdminRepository();
        }
        return repository;
    }
    @Override
    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);
        if(success){
            return admin;
        }
        return null;
    }

    @Override
    public Admin read(String adminId) {
        for(Admin admin : adminList){
            if(admin.getAdminId().equals(adminId)){
                return admin;
            }
        }
        return null;
    }

    @Override
    public Admin update(Admin admin) {
       String id = admin.getAdminId();
       Admin oldAdmin = read(id);

       if(oldAdmin != null){
           adminList.remove(oldAdmin);
           adminList.add(admin);
           return admin;
       }
       return null;
    }

    @Override
    public boolean delete(String id) {
       Admin adminToDelete = read(id);

       if(adminToDelete !=null){
           adminList.remove(adminToDelete);
           return true;
       }
       return false;
    }

    @Override
    public List<Admin> getAll() {
        return adminList;
    }
}
