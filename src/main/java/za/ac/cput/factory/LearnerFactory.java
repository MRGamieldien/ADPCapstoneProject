/* LearnerFactory.java
LearnerFactory model class
Author: Ethan Williams(221454780)
Date: 26 March 2026
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Learner;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

//LearnerFactory class
// Responsible for creating Learner objects with validation.

public class LearnerFactory {

    public static Learner createLearner(String learnerId ,
                                        String learnerNumber,
                                        String licenseType,
                                        LocalDate dateRegistered,
                                        String userId){

        // Validate learnerId , learnerNumber, licenseType & userId (must not be null or empty)
        if(Helper.isNullOrEmpty(learnerId)
                || Helper.isNullOrEmpty(learnerNumber)
                || Helper.isNullOrEmpty(licenseType)
                || Helper.isNullOrEmpty(userId)){
            return null;
        }

        // Build and return Learner object using Builder pattern
        return new Learner.Builder().setLearnerId(learnerId)
                .setLearnerNumber(learnerNumber)
                .setLicenseType(licenseType)
                .setDateRegistered(dateRegistered)
                .setUserId(userId)
                .build();
    }
}
