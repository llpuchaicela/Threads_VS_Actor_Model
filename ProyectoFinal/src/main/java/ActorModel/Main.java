package ActorModel;
import akka.actor.ActorSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] mat1Values = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        MAtrizWithActor m1 = new MAtrizWithActor(mat1Values);
        int[][] mat2Values = {
                {1, 2, 3},
                {3, 4, 5}
        };
        MAtrizWithActor m2 = new MAtrizWithActor(mat2Values);
        // Actor del System
        System.out.println("actor.App Started");
        ActorSystem akkaSystem = ActorSystem.create("system");
        MAtrizWithActor resultado = m1.multiplicacionWithActors(m2,akkaSystem);
        System.out.printf("La primera matriz es:\n%s",m1);
        System.out.printf("\nLa Segunda matriz es:\n%s",m2);
        System.out.printf("\nEl resultado de la matriz es:\n%s",resultado);
    }
}
