package mx.ipn.escom.complexsystems.scripts.insertion.GoL

import mx.ipn.escom.complexsystems.engine.definition.GameOfLife
import com.gmongo.GMongo


def mongo = new GMongo()
def db = mongo.getDB("GameOfLifeHistory");

String nineZeros = "";
def size = 5

db["states_$size"].drop()

(0..size * size - 1).each { it ->
    nineZeros = nineZeros.concat("0");
}

def maxValue = Math.pow(2, size * size) - 1
List<Integer> allStates = (0..(Integer) (maxValue / 4))
//List<Integer> allStates = 0 .. 1000;

//
GameOfLife gol = new GameOfLife()
//def node = [:];
println "Started Diffusion_5x5_1 ${new Date()}"
for (state in allStates) {
    def node = [:]
    String binaryNumber = Integer.toString(state, 2);
    //
    gol.init((nineZeros.concat(binaryNumber)).substring(binaryNumber.length()).toList().each { it -> Integer.parseInt(it) }.collate(size) as int[][]);
    //
    node.decimalState = state
    //
    gol.task();
    //
    node.contains = Integer.parseInt(gol.neighborhood.flatten().join(""), 2)
    //println node
    db["states_$size"].insert(node)
    //println "done insert";
}
println "Done"
