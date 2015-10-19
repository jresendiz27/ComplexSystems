package mx.ipn.escom.complexsystems.scripts.diffusion

import mx.ipn.escom.complexsystems.engine.definition.Diffusion
import mx.ipn.escom.complexsystems.engine.history.AutomataNode
import com.gmongo.GMongo


def mongo = new GMongo()
def db = mongo.getDB("DiffusionRuleHistory");

// db.DiffusionHistory.insert([])
String nineZeros = "";
def size = 5
db["states_$size"].drop()
(0..size * size - 1).each { it ->
    nineZeros = nineZeros.concat("0");
}
Integer maxValue = (Math.pow(2, size * size) - 1)
List<Integer> allStates = (0..(Integer) maxValue / 4)
//
Diffusion diffusion = new Diffusion()
AutomataNode node = new AutomataNode();
for (state in allStates) {
    String binaryNumber = Integer.toString(state, 2);
    //
    diffusion.init((nineZeros.concat(binaryNumber)).substring(binaryNumber.length()).toList().each { it -> Integer.parseInt(it) }.collate(size) as int[][]);
    //
    node.decimalState = state
    node.binaryState = binaryNumber
    node.isFinal = false
    node.hits = 0
    node.neighborhood = diffusion.neighborhood
    //
    diffusion.task();
    //
    node.contains = Integer.parseInt(diffusion.neighborhood.flatten().join(""), 2)
    node.calculated = 2;
    def properties = node.properties.findAll { property ->
        if (!(property.key in ["metaClass", "class"])) {
            return true
        } else {
            return false
        }
    }
    db["states_$size"].insert(properties)
}
println "Done"
