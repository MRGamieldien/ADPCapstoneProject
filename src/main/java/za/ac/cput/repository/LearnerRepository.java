/*
 * LearnerRepository.java
 * LearnerRepository class - handles CRUD operations for Learner objects
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Learner;

import java.util.ArrayList;
import java.util.List;

public class LearnerRepository implements IRepository<Learner, String>{
    
    // Singleton instance of LearnerRepository
    private static LearnerRepository repository = null;

    // List to store Learner objects
    private List<Learner>learnerList;

    // Private constructor to prevent external instantiation
    private LearnerRepository(){
        learnerList= new ArrayList<>();
    }

    // Method to get the singleton instance of LearnerRepository
    public static LearnerRepository getRepository(){
        if(repository == null){
            repository= new LearnerRepository();
        }
        return repository;
    }

    // Create a new Learner and add to the list
    @Override
    public Learner create(Learner learner) {
        boolean success = learnerList.add(learner);

        if(success){
            return learner;
        }
        return null;
    }

    // Read a Learner by its ID
    @Override
    public Learner read(String learnerId) {
       for(Learner learner : learnerList){
           if(learner.getLearnerId().equals(learnerId)){
               return learner;
           }
       }
       return null;
    }

    // Update an existing Learner
    @Override
    public Learner update(Learner learner) {
        String id = learner.getLearnerId();
        Learner oldLearner = read(id);

        if(oldLearner!= null){
            learnerList.remove(oldLearner); // Remove old entry
            learnerList.add(learner);       // Add updated entry
            return learner;
        }
        return null;
    }

    // Delete a Learner by ID
    @Override
    public boolean delete(String id) {
        Learner learnerToDelete =read(id);
         if(learnerToDelete!=null){
             learnerList.remove(learnerToDelete);
             return true;
         }
         return false;
    }

    // Get all Learner objects
    @Override
    public List<Learner> getAll() {
        return learnerList;
    }
}
