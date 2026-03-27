/* MockTest.java 
MockTest model class
Author Angelo Adams (230450431)
Date: 25 March 2026 */
package za.ac.cput.domain;

//imports
import java.time.LocalDate;

public class MockTest {
    private String testId;
    private LocalDate dateTaken;
    private int score;
    private boolean passed;

    
//default contructor
    public MockTest() {
    }
    //constructor arg
    private MockTest(Builder builder) {
        this.testId = builder.testId;
        this.dateTaken = builder.dateTaken;
        this.score = builder.score;
        this.passed = builder.passed;
    }


    public String getTestId() { return testId; }
    public LocalDate getDateTaken() { return dateTaken; }
    public int getScore() { return score; }
    public boolean isPassed() { return passed; }

//Builder pattern
    public static class Builder {
        private String testId;
        private LocalDate dateTaken;
        private int score;
        private boolean passed;
//setters
        public Builder setTestId(String testId) {
            this.testId = testId;
            return this;
        }

        public Builder setDateTaken(LocalDate dateTaken) {
            this.dateTaken = dateTaken;
            return this;
        }

        public Builder setScore(int score) {
            this.score = score;
            return this;
        }

        public Builder setPassed(boolean passed) {
            this.passed = passed;
            return this;
        }

        public Builder copy(MockTest mockTest) {
            this.testId = mockTest.testId;
            this.dateTaken = mockTest.dateTaken;
            this.score = mockTest.score;
            this.passed = mockTest.passed;
            return this;
        }
 /**
         * Builds and returns a newMockTest object.
         * This method validates  and creates the immutable Schedule
         
         * @return A new MockTest object with the properties configured
         */
        public MockTest build() {

            return new MockTest(this);
        }
    }
}

