/* InstructorRepository.java
InstructorRepository model class
Author: Qaasim Isaacs (222544422)
Date: 27 March 2026
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorRepository implements IRepository<Instructor, String> {

    // Singleton instance
    private static InstructorRepository repository = null;

    // In memory list
    private List<Instructor> instructorList;

    // Private constructor
    private InstructorRepository() {
        instructorList = new ArrayList<>();
    }

    // Get singleton instance
    public static InstructorRepository getRepository() {
        if (repository == null) {
            repository = new InstructorRepository();
        }
        return repository;
    }

    @Override
    public Instructor create(Instructor instructor) {
         // Add Instructor to list
        boolean success = instructorList.add(instructor);

        if (success) {
            return instructor;
        }
        return null;
    }

    @Override
    public Instructor read(String instructorId) {
        // Find Instructor by ID
        for (Instructor instructor : instructorList) {
            if (instructor.getInstructorId().equals(instructorId)) {
                return instructor;
            }
        }
        return null;
    }

    @Override
    public Instructor update(Instructor instructor) {
        // Replace existing Instructor
        String id = instructor.getInstructorId();
        Instructor oldInstructor = read(id);

        if (oldInstructor != null) {
            instructorList.remove(oldInstructor);
            instructorList.add(instructor);
            return instructor;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        // Remove Instructor if found
        Instructor instructorToDelete = read(id);

        if (instructorToDelete != null) {
            instructorList.remove(instructorToDelete);
            return true;
        }
        return false;
    }

    @Override
    public List<Instructor> getAll() {
        // Return all Instructors
        return instructorList;
    }
}
