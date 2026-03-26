/* LessonType.java
LessonType model class
Author: Rameez Karriem (222357320)
Date: 25 March 2026
*/
package za.ac.cput.domain;

/**
 * Represents a lesson type entity in the system.
 * Defines different categories of lessons available (e.g., "Beginner Guitar", "Advanced Piano").
 * This class is immutable - once created, its state cannot be changed.
 * Uses the Builder pattern for flexible object construction.
 */
public class LessonType {
    private int lessonId;           // Unique identifier for the lesson type
    private String typeName;        // Name of the lesson type (e.g., "Guitar Basics")
    private double price;           // Price per lesson for this lesson type
    private int duration;           // Duration of the lesson in minutes
    private String description;     // Detailed description of the lesson type

    /**
     * Public default constructor.
     */
    public LessonType() {
    }

    /**
     * Constructor that accepts a Builder object and initializes the LessonType.
     * This constructor is called by the Builder's build() method.
     *
     * @param builder The Builder object containing the lesson type data
     */
    private LessonType(LessonType.Builder builder) {
        this.lessonId = builder.lessonId;
        this.typeName = builder.typeName;
        this.price = builder.price;
        this.duration = builder.duration;
        this.description = builder.description;
    }

    // Getters - no setters provided to maintain immutability
    // Once a LessonType object is created, its properties cannot be modified

    /**
     * Gets the lesson type ID.
     * @return The unique identifier for this lesson type
     */
    public int getLessonId() {
        return lessonId;
    }

    /**
     * Gets the lesson type name.
     * @return The name of the lesson type
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Gets the lesson price.
     * @return The price per lesson for this lesson type
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the lesson duration.
     * @return The duration of the lesson in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the lesson description.
     * @return A detailed description of the lesson type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Builder class for constructing LessonType objects.
     * Implements the Builder design pattern to allow flexible, readable object creation
     * while maintaining immutability of the final LessonType object.
     *
     */
    public static class Builder {
        private int lessonId;           // Unique identifier for the lesson type
        private String typeName;        // Name of the lesson type
        private double price;           // Price per lesson
        private int duration;           // Duration in minutes
        private String description;     // Detailed description

        /**
         * Sets the lesson type ID.
         *
         * @param lessonId The unique identifier for the lesson type
         * @return The current Builder instance (for method chaining)
         */
        public Builder setLessonId(int lessonId) {
            this.lessonId = lessonId;
            return this;  // Returns the Builder object for fluent interface
        }

        /**
         * Sets the lesson type name.
         *
         * @param typeName The name of the lesson type
         * @return The current Builder instance (for method chaining)
         */
        public Builder setTypeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        /**
         * Sets the lesson price.
         *
         * @param price The price per lesson for this lesson type
         * @return The current Builder instance (for method chaining)
         */
        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the lesson duration.
         *
         * @param duration The duration of the lesson in minutes
         * @return The current Builder instance (for method chaining)
         */
        public Builder setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        /**
         * Sets the lesson description.
         *
         * @param description A detailed description of the lesson type
         * @return The current Builder instance (for method chaining)
         */
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Copies values from an existing LessonType object to the Builder.
         * This method is useful for creating modified copies of existing lesson types.
         * For example, to create a new lesson type with the same properties but
         * a different price.
         *
         * @param lessontype The existing LessonType object to copy from
         * @return The current Builder instance (for method chaining)
         */
        public Builder copy(LessonType lessontype) {
            this.lessonId = lessontype.lessonId;
            this.typeName = lessontype.typeName;
            this.price = lessontype.price;
            this.duration = lessontype.duration;
            this.description = lessontype.description;
            return this;
        }

        /**
         * Builds and returns a new LessonType object.
         * This method validates (if needed) and creates the immutable LessonType
         * instance using the values configured in the Builder.
         *
         * @return A new LessonType object with the configured properties
         */
        public LessonType build() {
            return new LessonType(this);
        }
    }
}

