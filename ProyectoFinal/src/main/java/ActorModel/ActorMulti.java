package ActorModel;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorMulti extends AbstractActor{
    private MAtrizWithActor m1;
    private MAtrizWithActor m2;
    private MAtrizWithActor output;
    private int rowIndex;
    private int colIndex;
    private int element;
    private ActorSystem actorMultiplicar;

    public static Props props(MAtrizWithActor m1, MAtrizWithActor m2, MAtrizWithActor output, int rowIndex, int colIndex, ActorSystem actorMultiplicar) {
        return Props.create(ActorMulti.class, () -> new ActorMulti(m1, m2, output, rowIndex, colIndex, actorMultiplicar));
    }

    public ActorMulti ( MAtrizWithActor m1, MAtrizWithActor m2, MAtrizWithActor output, int rowIndex, int colIndex, ActorSystem actorMultiplicar) {
        this.m1 = m1;
        this.m2 = m2;
        this.output = output;
        this.rowIndex = rowIndex;
        this.colIndex = colIndex;
        this.actorMultiplicar = actorMultiplicar;
    }

    @Override
    public AbstractActor.Receive createReceive() {
        element = calcValue(m1.getRow(rowIndex), m2.getColumn(colIndex));
        for (var k = 0; k < output.getValues().length; k++) {
            for (var m = 0; m < output.getValues()[k].length; m++) {
                output.getValues()[rowIndex][colIndex] = element;
                //Para Observarlo en Visual MV
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        actorMultiplicar.terminate();
        return receiveBuilder().build();
    }


    private int calcValue(int[] row, int[] col) {
        int element = 0;
        for (var i = 0; i < row.length; i++) {
            element += row[i] * col[i];
        }
        return element;
    }
}
