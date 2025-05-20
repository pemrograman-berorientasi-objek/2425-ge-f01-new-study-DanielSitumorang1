package pbo;
import pbo.model.Enrollment;
import pbo.model.Executor;
import javax.persistence.*;
import java.util.Scanner;
/**
 * 12S23009Dina Marlina Siagian
 * 12S23028_Daniel Situmorang
 *
 */
public class App {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] _args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("coursy_pu");
        entityManager = entityManagerFactory.createEntityManager();
        
        Executor executor = new Executor(entityManager);
        executor.cleanUpTables();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String input = sc.nextLine();
            if(input.equals("---")){
                break;
            }else{
                String data[] = input.split("#");
                switch (data[0]){
                    case "course-add":
                        executor.addCourse(data);
                        break;
                    case "student-add":
                        executor.addStudent(data);
                        break;
                    case "course-show-all":
                        executor.displayAllCourse();
                        break;
                    case "enroll":
                        Enrollment enrollment = new Enrollment();
                        break;
                    case "student-show":
                        executor.displayAllStudent();
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        }
        sc.close();
        entityManager.close();
        entityManagerFactory.close();
    }

}
