package mx.ipn.escom.complexsystems.scripts.statistics

import mx.ipn.escom.complexsystems.microworld.definition.MicroWorld
import mx.ipn.escom.complexsystems.microworld.definition.impl.WorldElement

/**
 * Created by alberto on 14/01/16.
 */

/**
 * Created by alberto on 19/10/15.
 */
def epsilon = 2
MicroWorld microWorld = MicroWorld.instance
WorldElement[][] world = microWorld.operation.getMapFromImage("/home/alberto/Desktop/Huge.png")
microWorld.world = world
microWorld.operation.generateMicroWorldAnimals(0.0001, microWorld.world)
microWorld.init(world);

def file = new File("/home/alberto/Desktop/MicroWorld-0_0001.csv")
file.write("generation, Herbivore, Carnivore, Scavenger, Corpse, Plant\n")
while (true) {
    Map prevStatistics = microWorld.getStatistics()
    file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
    microWorld.task()
    Map currentStatistics = microWorld.getStatistics()
    if (
    (Math.abs(prevStatistics.Herbivore - currentStatistics.Herbivore) < epsilon) ||
            (Math.abs(prevStatistics.Carnivore - currentStatistics.Carnivore) < epsilon) ||
            (Math.abs(prevStatistics.Scavenger - currentStatistics.Scavenger) < epsilon) ||
            (Math.abs(prevStatistics.Corpse - currentStatistics.Corpse) < epsilon) ||
            (Math.abs(prevStatistics.Plant - currentStatistics.Plant) < epsilon) ||
            microWorld.generation > 1500) {
        file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
        break;
    }
}

microWorld.generation = 0
world = microWorld.operation.getMapFromImage("/home/alberto/Desktop/Huge.png")
microWorld.world = world
microWorld.operation.generateMicroWorldAnimals(0.001, microWorld.world)
microWorld.init(world);
file = new File("/home/alberto/Desktop/MicroWorld-0_001.csv")
file.write("generation, Herbivore, Carnivore, Scavenger, Corpse, Plant\n")
while (true) {
    Map prevStatistics = microWorld.getStatistics()
    file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
    microWorld.task()
    Map currentStatistics = microWorld.getStatistics()
    if (
    (Math.abs(prevStatistics.Herbivore - currentStatistics.Herbivore) < epsilon) ||
            (Math.abs(prevStatistics.Carnivore - currentStatistics.Carnivore) < epsilon) ||
            (Math.abs(prevStatistics.Scavenger - currentStatistics.Scavenger) < epsilon) ||
            (Math.abs(prevStatistics.Corpse - currentStatistics.Corpse) < epsilon) ||
            (Math.abs(prevStatistics.Plant - currentStatistics.Plant) < epsilon) ||
            microWorld.generation > 1500) {
        file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
        break;
    }
}

microWorld.generation = 0
world = microWorld.operation.getMapFromImage("/home/alberto/Desktop/Huge.png")
microWorld.world = world
microWorld.operation.generateMicroWorldAnimals(0.01, microWorld.world)
microWorld.init(world);
file = new File("/home/alberto/Desktop/MicroWorld-0_01.csv")
file.write("generation, Herbivore, Carnivore, Scavenger, Corpse, Plant\n")
while (true) {
    Map prevStatistics = microWorld.getStatistics()
    file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
    microWorld.task()
    Map currentStatistics = microWorld.getStatistics()
    if (
    (Math.abs(prevStatistics.Herbivore - currentStatistics.Herbivore) < epsilon) ||
            (Math.abs(prevStatistics.Carnivore - currentStatistics.Carnivore) < epsilon) ||
            (Math.abs(prevStatistics.Scavenger - currentStatistics.Scavenger) < epsilon) ||
            (Math.abs(prevStatistics.Corpse - currentStatistics.Corpse) < epsilon) ||
            (Math.abs(prevStatistics.Plant - currentStatistics.Plant) < epsilon) ||
            microWorld.generation > 1500) {
        file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
        break;
    }
}

microWorld.generation = 0
world = microWorld.operation.getMapFromImage("/home/alberto/Desktop/Huge.png")
microWorld.world = world
microWorld.operation.generateMicroWorldAnimals(0.1, microWorld.world)
microWorld.init(world);
file = new File("/home/alberto/Desktop/MicroWorld-0_1.csv")
file.write("generation, Herbivore, Carnivore, Scavenger, Corpse, Plant\n")
while (true) {
    Map prevStatistics = microWorld.getStatistics()
    file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
    microWorld.task()
    Map currentStatistics = microWorld.getStatistics()
    if (
    (Math.abs(prevStatistics.Herbivore - currentStatistics.Herbivore) < epsilon) ||
            (Math.abs(prevStatistics.Carnivore - currentStatistics.Carnivore) < epsilon) ||
            (Math.abs(prevStatistics.Scavenger - currentStatistics.Scavenger) < epsilon) ||
            (Math.abs(prevStatistics.Corpse - currentStatistics.Corpse) < epsilon) ||
            (Math.abs(prevStatistics.Plant - currentStatistics.Plant) < epsilon) ||
            microWorld.generation > 1500) {
        file.append("${microWorld.generation},${prevStatistics.Herbivore}, ${prevStatistics.Carnivore}, ${prevStatistics.Scavenger}, ${prevStatistics.Corpse}, ${prevStatistics.Plant}\n")
        break;
    }
}