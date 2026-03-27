/*
 * LearnerRepository.java
 * LearnerRepository class
 * Author: Ethan Williams (221454780)
 * Date: 27 March 2026
 */
package za.ac.cput.repository;

import za.ac.cput.domain.Learner;

import java.util.ArrayList;
import java.util.List;

public class LearnerRepository implements IRepository<Learner, String>{
    private static LearnerRepository repository = null;

    private List<Learner>learnerList;
    private LearnerRepository(){
        learnerList= new ArrayList<>();
    }

    public static LearnerRepository getRepository(){
        if(repository == null){
            repository= new LearnerRepository();
        }
        return repository;
    }
    @Override
    public Learner create(Learner learner) {
        boolean success = learnerList.add(learner);

        if(success){
            return learner;
        }
        return null;
    }

    @Override
    public Learner read(String learnerId) {
       for(Learner learner : learnerList){
           if(learner.getLearnerId().equals(learnerId)){
               return learner;
           }
       }
       return null;
    }

    @Override
    public Learner update(Learner learner) {
        String id = learner.getLearnerId();
        Learner oldLearner = read(id);

        if(oldLearner!= null){
            learnerList.remove(oldLearner);
            learnerList.add(learner);
            return learner;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Learner learnerToDelete =read(id);
         if(learnerToDelete!=null){
             learnerList.remove(learnerToDelete);
             return true;
         }
         return false;
    }

    @Override
    public List<Learner> getAll() {
        return learnerList;
    }
}
