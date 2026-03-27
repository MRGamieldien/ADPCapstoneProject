/*
 * LessonTypeFactory.java
 * LessonTypeFactory class
 * Author: Rameez Karriem (222357320)
 * Date: 26 March 2026
 */
package za.ac.cput.factory;

import za.ac.cput.domain.LessonType;
import za.ac.cput.util.Helper;

// Factory class for creating LessonType objects with validation
public class LessonTypeFactory {

    public static LessonType createLessonType(String lessonId,
                                              String typeName,
                                              double price,
                                              int duration,
                                              String description){

        // Validate String inputs
        if(Helper.isNullOrEmpty(lessonId)
                || Helper.isNullOrEmpty(typeName)
                || Helper.isNullOrEmpty(description)){
            return null;
        }

        // Validate price must be >= 0
        if(price < 0){
            return null;
        }

        // Validate duration must be > 0
        if(duration <= 0){
            return null;
        }

        // Build and return LessonType object
        return new LessonType.Builder()
                .setLessonId(lessonId)
                .setTypeName(typeName)
                .setPrice(price)
                .setDuration(duration)
                .setDescription(description)
                .build();
    }
}
