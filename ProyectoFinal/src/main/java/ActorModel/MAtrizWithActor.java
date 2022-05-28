package ActorModel;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class MAtrizWithActor  {
    private int[][] values;
    private ActorSystem actorPadre;

    public MAtrizWithActor(int[][] values) {
        this.values = values;
    }

    public MAtrizWithActor multiplicacionWithActors(MAtrizWithActor matriz2, ActorSystem actorPadre) throws InterruptedException {
        if (values.length == matriz2.values[0].length) {
            int[][] output = new int[values.length][matriz2.values[0].length];
            MAtrizWithActor out = new MAtrizWithActor(output);
            for (var i = 0; i < output.length; i++) {
                for (var j = 0; j < output[i].length; j++) {
                    ActorRef resu = actorPadre.actorOf(ActorMulti.props(this, matriz2, out,i,j,actorPadre), "ActorHijo"+i+j);
                }
            }
            return out;
            //return new MatrizWithActors(output);
        } else {
            throw new IllegalArgumentException("No se puede multiplicar");
        }
    }
    public int[] getRow(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < values.length) {
            return values[rowIndex];
        } else {
            throw new IllegalArgumentException("Indice no válido");
        }
    }

    public int[] getColumn(int colIndex) {
        int[] output = new int[values.length];
        if (colIndex < values[0].length) {
            for (var i = 0; i < values.length; i++) {
                output[i] = values[i][colIndex];
            }
        }
        return output;
    }

    public int[][] getValues() {
        return values;
    }

    public String toString() {
        String output = "";
        for (var fila : values) {
            output += "{";
            for (var value : fila) {
                output += value + "\t";
            }
            output += "}\n";
        }
        return "\n" + output;
    }
}

