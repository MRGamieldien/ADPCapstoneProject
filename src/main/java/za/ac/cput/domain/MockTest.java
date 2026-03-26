/* MockTest.java 
MockTest model class
Author Angelo Adams (230450431)
Date: 25 March 2026 */
package za.ac.cput.domain;

//imports
import java.time.LocalDate;
import java.util.Objects;

public class MockTest {
    private int testId;
    private LocalDate dateTaken;
    private int score;
    private boolean passed;

    
//default contructor
    public MockTest{
    }
    //constructor arg
    private MockTest(Builder builder) {
        this.testId = builder.testId;
        this.dateTaken = builder.dateTaken;
        this.score = builder.score;
        this.passed = builder.passed;
    }


    public int getTestId() { return testId; }
    public LocalDate getDateTaken() { return dateTaken; }
    public int getScore() { return score; }
    public boolean isPassed() { return passed; }

//Builder pattern
    public static class Builder {
        private int testId;
        private LocalDate dateTaken;
        private int score;
        private boolean passed;
//setters
        public Builder setTestId(int testId) {
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

        public MockTest build() {

            return new MockTest(this);
        }
    }

    @Override
    public String toString() {
        return "MockTest{" +
                "testId=" + testId +
                ", dateTaken=" + dateTaken +
                ", score=" + score +
                ", passed=" + passed +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, dateTaken, score, passed);
    }
}

