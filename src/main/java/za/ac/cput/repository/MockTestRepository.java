/*
 * MockTestRepository.java
 * MockTestRepository model class
 * Author: Angelo Adams (230450431)
 * Date: 27 March 2026
 */

package za.ac.cput.repository;

import za.ac.cput.domain.MockTest;

import java.util.ArrayList;
import java.util.List;

public class MockTestRepository implements IRepository<MockTest, String> {


    // Singleton instance of MockTestRepository
    public static za.ac.cput.repository.MockTestRepository repository = null;

    // List to store MockTest objects
    private List<MockTest> mockTestList;

    // Private constructor to prevent external instantiation
    private MockTestRepository() {
        mockTestList = new ArrayList<>();
    }

    // Method to get the singleton instance of MockTestRepository
    public static za.ac.cput.repository.MockTestRepository getRepository() {
        if (repository == null) {
            repository = new za.ac.cput.repository.MockTestRepository();
        }
        return repository;
    }

    // Create a new MockTest and add to the list
    @Override
    public MockTest create(MockTest mockTest) {
        boolean success = mockTestList.add(mockTest);
        if(success){
            return mockTest;
        }
        return null;
    }


    // Read an MockTest by its ID
    @Override
    public MockTest read(String testId) {
        for(MockTest mockTest : mockTestList){
            if(mockTest.getTestId().equals(testId)){
                return mockTest;
            }
        }
        return null;
    }

    // Update an existing Admin
    @Override
    public MockTest update(MockTest mockTest) {
        String id = mockTest.getTestId();
        MockTest oldMockTest = read(id);

        if(oldMockTest != null){
            mockTestList.remove(oldMockTest); // Remove old entry
            mockTestList.add(mockTest);       // Add updated entry
            return mockTest;
        }
        return null;
    }

    // Delete an Admin by ID
    @Override
    public boolean delete(String id) {
        MockTest mockTestToDelete = read(id);

        if(mockTestToDelete !=null){
            mockTestList.remove(mockTestToDelete);
            return true;
        }
        return false;
    }

    // Get all Admin objects
    @Override
    public List<MockTest> getAll() {
        return mockTestList;
    }
}



