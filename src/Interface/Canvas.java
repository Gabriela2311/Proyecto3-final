package Interface;

import Domain.Maze;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Canvas extends javax.swing.JPanel implements Runnable {

    int[][] matrixGeneral;
    Maze maze;

    public Canvas() {
        initComponents();
        this.maze = new Maze(matrixGeneral);
        facil();
        medium();
        dificult();
    
        
    }

    Thread threadFast, threadItem;
    

    BufferedImage figure, exitDoor, wall, dona;
    URL pers = getClass().getResource("/imagenes/Stitch.png");
    URL mu = getClass().getResource("/imagenes/muroo.jpg");
    URL door = getClass().getResource("/imagenes/puerta.png");
    URL don = getClass().getResource("/imagenes/donaHomero.png");
    
    
    public void medium() {
        maze.setRows(16);
        maze.setColumns(16);
        maze.setExit(15);
        maze.setInput(3);
        maze.setRowInput(3);
        maze.setColumnsInput(0);
        maze.setRowExit(14);
        maze.setColmnsExit(15);
        maze.setX(0);
        maze.setY(0);
        maze.setEnd(0);
        maze.setDona(9);

        int[][] copia = 
        {{0, 0,0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
        {3, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
        {1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
        {1, 0, 0, 0, 0, 1, 1,   maze.getDona(), 1, 1, 0, 1, 1, 0, 1, 0},
        {1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0},
        {1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, maze.getExit()},
        {1, 0, 1, 1, 1,0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0}};

        try {
            figure = ImageIO.read(pers);
            exitDoor = ImageIO.read(door);
            wall = ImageIO.read(mu);
            dona=ImageIO.read(don);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrixGeneral = copia;
        threadFast = new Thread(this);
        threadItem = new Thread(this);
        maze.setRowInput(3);
        maze.setColumnsInput(0);
        maze.setRowExit1(14);
        maze.setColumnsExit1(15);
        maze.setF(1);
        maze.setEnd(0);
        repaint();
    }

    public void facil() {
        maze.setRows(13);
        maze.setColumns(13);
        maze.setExit(4);
        maze.setInput(3);
        maze.setRowInput(12);
        maze.setColumnsInput(0);
        maze.setRowExit(4);
        maze.setColumnsExit1(12);
        maze.setX(0);
        maze.setY(0);
        maze.setEnd(0);
        int[][] copia = 
           {{1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, maze.getExit()},
            {1, 1, 1, 1, 1, 1, 1, maze.getDona(), 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0,1, 0, 0, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
  {maze.getInput(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}};
        try {
            figure = ImageIO.read(pers);
            exitDoor = ImageIO.read(door);
            wall = ImageIO.read(mu);
             dona=ImageIO.read(don);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrixGeneral = copia;
        threadFast = new Thread(this);

        maze.setRowInput(12);

        maze.setColumnsInput(0);
        maze.setRowExit(4);
        maze.setColumnsExit1(12);
        maze.setF(1);
        maze.setEnd(0);

        repaint();
    }

    public void dificult() {
        maze.setRows(19);
        maze.setColumns(19);
        maze.setExit(4); 
        maze.setInput(3);  
        maze.setRowInput(3);
        maze.setColumnsInput(3); 
        maze.setRowExit(1);
        maze.setColmnsExit(18);
        maze.setX(0);
        maze.setY(0);
        maze.setEnd(0);
         maze.setDona(9);
        int[][] copia = 
       {{0, 0, 0, maze.getInput(), 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1,1},
        {0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, maze.getExit()},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0},
        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0},
        {1, 1, 1, 0, 1, 0, 1, maze.getDona(), 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0},
        {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
        {0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
        {1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0},
        {1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
        {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1},
        {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1}};


        try {
            figure = ImageIO.read(pers);
            exitDoor = ImageIO.read(door);
            wall = ImageIO.read(mu);
             dona=ImageIO.read(don);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen " + e.getMessage());

        }
        matrixGeneral = copia;
        threadFast = new Thread(this);
        maze.setRowInput(0); //
        maze.setColumnsInput(3);  //
        maze.setRowExit(1);  //
        maze.setColmnsExit(18);  //
       
        
        
        maze.setF(1);
        maze.setEnd(0);
        
        repaint();
    }

   

    public void paint(Graphics g) {
        if (maze.getF() >= 1) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < matrixGeneral.length; i++) {
                for (int j = 0; j < matrixGeneral.length; j++) {
                    g.setColor(Color.DARK_GRAY);
                    if (matrixGeneral[i][j] == 0 || matrixGeneral[i][j] == 8) {
                        g.drawRect(j * 35, i * 35, 35, 35); // tama;o del rectangulo, modificar

                    } else if (matrixGeneral[i][j] == 1) {
                        g.drawImage(wall, j * 35, i * 35, 35, 35, this);
                    }else if (matrixGeneral[i][j] == maze.getDona()) {
                        g.drawImage(dona, j * 35, i * 35, 35, 35, this);
                    } else if (matrixGeneral[i][j] == maze.getInput()) {
                        g.drawImage(figure, j * 35, i * 35, 35, 35, this);
                    } else if (matrixGeneral[i][j] == maze.getE1()) {
                        g.drawImage(figure, j * 35, i * 35, 35, 35, this);
                    } else if (matrixGeneral[i][j] == maze.getExit()) {
                        g.drawImage(exitDoor, j * 35, i * 35, 35, 35, this);
                    } else if (matrixGeneral[i][j] == maze.getExit1()) {
                        g.drawImage(exitDoor, j * 35, i * 35, 35, 35, this);
                    } else if (matrixGeneral[i][j] == 5 ) {
                   
                        g.setColor(Color.yellow);
                        g.fillRect(j * 35, i * 35, 35, 35);
                        g.setColor(Color.BLUE);
                        g.drawRect(j * 35, i * 35, 35, 35);
                    }
                    

                }
            }

        }
    }

    public boolean existeCamino(int fila, int columna) {
        if (fila < 0 || fila >= maze.getRows() || columna < 0 || columna >= maze.getColumns()) {
            return false;

        }
        if (matrixGeneral[fila][columna] == 5 || matrixGeneral[fila][columna] == 1) {
            return false;
        }
        return true;
    }
    
    public boolean existeCaminoItem(int fila, int columna) {
        if (fila < 0 || fila >= maze.getRows()|| columna < 0 || columna >= maze.getColumns()) {
            return false;

        }
        if (matrixGeneral[fila][columna] == 1 || matrixGeneral[fila][columna] == 5 ) {// sin esta linea las dibuja en diagonal
            return false;
        }
        return true;
    }

    public boolean resolver(int fil, int col) throws InterruptedException {
        boolean salida = false;
      
        
        if(matrixGeneral[10][15] == 5){
            threadFast.sleep(1500);
            for (int seg = 1; seg <= 100; seg++) {
                Visual.barra.setValue(seg);
                threadFast.sleep(65);
            }
        }
        
        
        if (matrixGeneral[6][7] ==5 ) { 
                        
             try {
                 threadFast.sleep(65);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
             }
                           
                        
         }else{
             try {
                 threadFast.sleep(250);
             } catch (InterruptedException ex) {
                 Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
             }
          
        }
              
        
        matrixGeneral[fil][col] = 5;
        if (fil == maze.getRowExit() && col == maze.getColumnsExit1()) {
            return true;
        }
           if (!salida && existeCamino(fil - 1, col)) {
            matrixGeneral[fil - 1][col] = maze.getInput();
            repaint();
            salida = resolver(fil - 1, col);

        }
        //abajo
        if (!salida && existeCamino(fil + 1, col)) {
            matrixGeneral[fil + 1][col] = maze.getInput();;
            repaint();
            salida = resolver(fil + 1, col);
        }
        //derecha
        if (!salida && existeCamino(fil, col + 1)) {
            matrixGeneral[fil][col + 1] = maze.getInput();;
            repaint();
            salida = resolver(fil, col + 1);
        }
        //izquierda
        if (!salida && existeCamino(fil, col - 1)) {
            matrixGeneral[fil][col - 1] = maze.getInput();;
            repaint();
            salida = resolver(fil, col - 1);
        }
        //arriba

     
        return salida;
    }
    
    public boolean item(int col, int fil){
         boolean salida = false;

        try {
            threadItem.sleep(80);

        } catch (Exception e) {

        }
         Thread j=new Thread(this);
        
      matrixGeneral[fil][col] = 5;
        if (fil == maze.getRowExit() && col == maze.getColumnsExit1()) {
           
            return true;
        }
        //abajo
        if (!salida && existeCaminoItem(fil + 1, col)) {
            matrixGeneral[fil + 1][col] = maze.getDona();
             matrixGeneral[fil + 1][col] =9;
            repaint();
//            salida = item(fil + 1, col);
       }
        //derecha
        if (!salida && existeCaminoItem(fil, col+1)) {
          matrixGeneral[fil][col + 1] = maze.getDona();
          matrixGeneral[fil][col + 1] =9;
            repaint();
//         salida = item(fil, col + 1);
        }
//        //izquierda
        if (!salida && existeCaminoItem(fil, col - 1)) {
            matrixGeneral[fil][col - 1] = maze.getDona();
             matrixGeneral[fil][col - 1] =9; 
            repaint();         
//           salida = item(fil, col - 1);
        }
//        arriba

        if (!salida && existeCaminoItem(fil - 1, col)) {
            matrixGeneral[fil - 1][col] = maze.getDona();
         matrixGeneral[fil][col - 1] =9;
            repaint();
//                        salida = item(fil - 1, col);
      }
        return salida;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1291, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        maze.setX(evt.getX() / 35);
        maze.setY(evt.getY() / 35);

        if (matrixGeneral[maze.getY()][maze.getX()] != maze.getInput()&& matrixGeneral[maze.getY()][maze.getX()] != maze.getExit()&& maze.getF() == 1) {
            if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 3) {
                matrixGeneral[maze.getY()][maze.getX()] = 1;

            } else if (evt.getButton() == evt.BUTTON3 && maze.getRadioBotones() == 3) {
                matrixGeneral[maze.getY()][maze.getX()] = 0;

            } else if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 1) {
                matrixGeneral[maze.getRowInput()][maze.getColumnsInput()] = 0;
                matrixGeneral[maze.getY()][maze.getX()] = maze.getInput();
                maze.setRowInput(maze.getY());
                maze.setColumnsInput(maze.getX());

            } else if (evt.getButton() == evt.BUTTON1 && maze.getRadioBotones() == 2) {
                matrixGeneral[maze.getRowExit()][maze.getColumnsExit1()] = 0;
                matrixGeneral[maze.getY()][maze.getX()] = maze.getExit();
                maze.setRowExit(maze.getY());
                maze.setColumnsExit1(maze.getX());

            }
            repaint();
        }

    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
         maze.setX(evt.getX() / 35);
        maze.setY(evt.getY() / 35);

        if (matrixGeneral[maze.getY()][maze.getX()] != maze.getInput()&& matrixGeneral[maze.getY()][maze.getX()] != maze.getExit()) {
            if (evt.getButton() == evt.BUTTON1 ) {
                matrixGeneral[maze.getY()][maze.getX()] = 1;

            } else if (evt.getButton() == evt.BUTTON3 ) {
                matrixGeneral[maze.getY()][maze.getX()] = 0;

            }
            repaint();
        }

                            
    }//GEN-LAST:event_formMousePressed

    @Override
    public void run() {
            
        try {
            //           if(item(15,5)){
////         maze.setTermino(1);
//            //JOptionPane.showMessageDialog(null, "Felicidades, lo lograste");
//        } else {
////            maze.setTermino(1);
//           // JOptionPane.showMessageDialog(null, "No hay salida");
//        }
//  




if (resolver(maze.getRowInput(), maze.getColumnsInput())) {
    maze.setEnd(1);
    
    JOptionPane.showMessageDialog(null, "Felicidades, lo lograste");
} else {
    maze.setEnd(1);
    JOptionPane.showMessageDialog(null, "No hay salida");
}
        } catch (InterruptedException ex) {
            Logger.getLogger(Canvas.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
  
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
