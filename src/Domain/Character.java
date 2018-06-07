package Domain;


import Domain.Maze;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Character implements Runnable {

    String name;
    int sleepTime;
    int x, y;
    int energia;
    int direc;
    Maze matriz;

    Character(String name, int sleepTime, Maze matriz) {
        this.name = name;
        this.sleepTime = sleepTime;
        this.x = (int) (Math.random() * 10 + 1);
        this.y = (int) (Math.random() * 10 + 1);
        this.direc = (int) ((Math.random() * 4) + 1);
        matriz = matriz;
    }

    public void run() {
        
         System.out.println("    si");
        while (true) {
            /*
            Tengo energia?
            Si
                Puedo caminar?
                    Si
                        Camino y reviso si hay dona
                    No
                        Cambio de direccion
            No
                Duermo por un tiempo
            Repito.
             */
            if (energia > 0) {
                if (!esta_chocando()) {
                    System.out.println("    si");
                } else {
                    // cambie de direccion;
                }

            } else {
                try {
                    Thread.sleep(sleepTime * 1000);
                    energia = 100;
                } catch (InterruptedException ex) {
                    System.err.println("El hilo no se duerme " + name);
                }
            }
            try {
                System.out.println("Ejecutando el hilo " + name);
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException ex) {
                System.err.println("El hilo no se duerme " + name);
            }
        }
    }

    public boolean esta_chocando() {
        return matriz.esta_chocando(x, y);
    }

    public void setPos() {
        this.matriz.getPlayer(x, y);
    }

    public int[] siguientCelda() {
        switch (direc) {
            case 1://Arriba
                int[] arr = {x, y - 1};
                return arr;
            case 2://Arriba
                int[] abj = {x, y + 1};
                return abj;
            case 3://Arriba
                int[] izq = {x + 1, y};
                return izq;
            case 4://Arriba
                int[] der = {x - 1, y};
                return der;
        }
        return null;
    }
    public void display(){
        //Se encarga de pintar el player.
    }
    public static void main(String[] args) {

//        Character per = new Character("1", 1);
//
//        Character perso = new Character("2", 2);
//        Thread hilo = new Thread(per);
//        Thread hilo2 = new Thread(perso);
//        hilo.start();
//        hilo2.start();
    }

}
