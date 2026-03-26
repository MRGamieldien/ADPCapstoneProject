/* AdminFactory.java
AdminFactory model class
Author: Ethan Williams(221454780)
Date: 26 March 2026
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;


 //AdminFactory class
 // Responsible for creating Admin objects with validation.

public class AdminFactory {

    public static Admin createAdmin(String adminId,
                                    String department,
                                    int accessLevel,
                                    String userId){

        // Validate adminId,department & userId (must not be null or empty)
        if(Helper.isNullOrEmpty(adminId)
                ||Helper.isNullOrEmpty(department)
                || Helper.isNullOrEmpty(userId)){
            return null;
        }

        // Validate accessLevel (Prevents it being negative)
        if(accessLevel < 0){
            return null;
        }

        // Build and return Admin object using Builder pattern
        return new Admin.Builder()
                .setAdminId(adminId)
                .setDepartment(department)
                .setAccessLevel(accessLevel)
                .setUserId(userId)
                .build();
    }
}