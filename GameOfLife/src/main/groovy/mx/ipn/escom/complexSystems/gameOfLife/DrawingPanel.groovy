package mx.ipn.escom.complexSystems.gameOfLife

import mx.ipn.escom.complexSystems.gameOfLife.engine.GameOfLife
import javax.swing.JPanel
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

/**
 * Created by alberto on 28/09/15.
 */
class DrawingPanel extends JPanel implements ActionListener {

    final int DELAY = 777;
    int rows = 0
    int columns = 0
    Timer timer;
    GameOfLife gameOfLifeInstance

    public DrawingPanel(GameOfLife gameOfLifeInstance) {
        this.gameOfLifeInstance = gameOfLifeInstance
        rows = gameOfLifeInstance.rows ?: 200;
        columns = gameOfLifeInstance.columns ?: 200;
        initTimer();
    }

    private void initTimer() {
        timer = new Timer(DELAY, this);
    }

    public Timer getTimer() {

        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.white)
        g2d.setPaint(Color.black);

        if (gameOfLifeInstance.generation == 1) {
            this.drawEntireNeighborhood(g2d);
        }

        if(gameOfLifeInstance.generation > 1){
            this.drawAlive(g2d)
            this.drawDeath(g2d)
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameOfLifeInstance.gameOfLife()
        repaint();
    }

    public void drawEntireNeighborhood(Graphics2D g2d) {
        for (short row = 0; row < rows; row++) {
            for (short column = 0; column < columns; column++) {
                if (gameOfLifeInstance.neighborhood[row][column] == 1) {
                    g2d.drawLine(row, column, row, column)
                }
            }
        }
    }

    public void drawAlive(Graphics2D g2d) {
        for (cell in gameOfLifeInstance.newAlive) {
            g2d.drawLine(cell[0], cell[1], cell[0], cell[1])
        }
    }

    public void drawDeath(Graphics2D g2d) {
        for (cell in gameOfLifeInstance.newDeath) {
            g2d.drawLine(cell[0], cell[1], cell[0], cell[1])
        }
    }
}