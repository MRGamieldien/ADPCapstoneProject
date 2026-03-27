/* MockTestFactory.java  
MockTestFactory model class 
Author Angelo Adams (230450431) 
Date: 27 March 2026 */
package za.ac.cput.factory;

//Imports
import za.ac.cput.domain.MockTest;
import za.ac.cput.util.Helper;

import java.time.LocalDate;


//MockTest class
 
 // Responsible for creating MockTest objects with validation.
public class MockTestFactory {

 // Validate testId , dateTaken, score & pass (must not be null or empty)
    public static MockTest createMockTest(String testId,String learnerId, LocalDate dateTaken, int score, boolean pass){
        if (Helper.isNullOrEmpty(testId)) {
            return null;
        }

         if(dateTaken == null){
            return null;
        }
     
        if (score < 0) {
            return null;
        }
        //build and return MockTest object using builder pattern

        return new MockTest.Builder().setTestId(testId)
                .setLearnerId(learnerId)
                .setDateTaken(dateTaken)
                .setScore(score)
                .setPassed(pass)
                .build();
    }


}
