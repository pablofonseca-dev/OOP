import java.io.IOException;

public class LogicLayer {

    static int[] students_scores;
    static String[] student_names;
    static int global_queues_size;
    static int index_counter = 0;
    static int matrix_index_counter = 0;

    /**
     * Starts all the main queues.
     *
     * @param queues_size
     */
    static void initialize_program(int queues_size) {
        //Initialize queues size variable with the same value of the arg
        global_queues_size = queues_size;
        students_scores = new int[queues_size];
        student_names = new String[queues_size];
    }

    /**
     * Returns the students queue
     *
     * @return student_names
     */
    static String[] get_student_queue() {
        return student_names;
    }

    /**
     * Returns the scores queue
     *
     * @return students_scores;
     */
    static int[] get_scores_queue() {
        return students_scores;
    }

    /**
     * Returns the global queues size, which is a mirror for all data structures.
     *
     * @return global_queues_size
     */
    static int get_queues_size() {
        return global_queues_size;
    }

    /**
     * Logs each student name in the students queue.
     *
     * @param student_name
     */
    static void log_students(String student_name) {
        queues_counter_validation();
        student_names[index_counter] = student_name;
        index_counter++;
    }

    /**
     * If the student doesn't exist the function returns true.
     * Else, the function returns false.
     *
     * @param student_name: Gets the user name to validate its existence in the queue.
     * @return student_existence: Validates if a student exist in the queue.
     */
    static boolean student_existence(String student_name) {
        boolean existence_verification = true;
        for (int index = 0; index < global_queues_size; index++) {
            if (student_name.equals(student_names[index])) {
                existence_verification = false;
                break; //Exit to return false.
            }
        }
        return existence_verification;
    }

    /**
     * Search the student index
     *
     * @param student_name
     */
    public static int search_student_index(String student_name) {
        int student_index;
        for (int index = 0; index < global_queues_size; index++) {
            if (student_name.equals(student_names[index])) {
                student_index = index;
                return student_index;
            }
        }
        return -1;
    }

    /**
     * Injects for each row the ID of the student.
     *
     * @param matrix
     * @param student_index
     * @return
     */
    public static int[][] inject_student_index(int[][] matrix, int student_index) {
        for (int index = 0; index < matrix.length; index++) {
            matrix[index][0] = student_index;
        }
        return matrix;
    }


    /**
     * Injects each question value in matrix.
     *
     * @param matrix
     * @return Integer
     * @throws IOException
     */
    public static int[][] inject_question_points(int[][] matrix, int question_points) throws IOException {
        matrix_counter_validation();
        matrix[matrix_index_counter][1] = question_points;
        matrix_index_counter++;

        return matrix;
    }

    /**
     * Injects each student obtained points in matrix
     *
     * @param student_points
     * @param matrix
     * @param student_points
     */
    public static int[][] inject_student_points(int[][] matrix, int student_points) {
        matrix_counter_validation();
        matrix[matrix_index_counter][2] = student_points;
        matrix_index_counter++;
        return matrix;
    }

    /**
     * Logs each student obtained score in the scores queue
     */
    static void log_points(int student_points, int student_index) {
        students_scores[student_index] = student_points;
        index_counter++;
    }

    /**
     * Validates if the queues index counter is greater than the length of the global queues size.
     */
    static void queues_counter_validation() {
        if (index_counter >= global_queues_size) {
            index_counter = 0; // Reset and start again
        }
    }

    /**
     * Validates if the matrix counter is greater than the length of the bi-dimensional array size.
     */
    static void matrix_counter_validation() {
        if (matrix_index_counter >= 5) {
            matrix_index_counter = 0; // Reset and start again
        }
    }
}
