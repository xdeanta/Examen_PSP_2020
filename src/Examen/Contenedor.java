package Examen;

import java.util.ArrayList;

public class Contenedor{
    private int contLetras;
    private int contPalabra;
    private String[] Palabras;
    private boolean availableL;
    private boolean availableP;

    public Contenedor(){
        contLetras = contPalabra = 0;
        Palabras = new String[2];
        availableL=false;
        availableP=false;
    }

    public synchronized void setContLetras(int cont){
        contLetras=cont;
        availableL=true;
        notify();
    }

    public synchronized void setContPalabra(int cont){
        contPalabra=cont;
        availableP=true;
        notify();
    }

    public synchronized int getContLetras(){
        while(contLetras==0 || !availableL){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Hilo interrumpido");
            }
        }
        return contLetras;
    }

    public synchronized int getContPalabra(){
        while(contPalabra==0 || !availableP){
            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Hilo interrumpido");
            }
        }
        return contPalabra;
    }

    public synchronized String[] getPalabras() {
        while(Palabras[0]==null && Palabras[1]==null){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("Hilo interrumpido");
            }
        }
        return Palabras;
    }

    public synchronized void insertPalabra(int pos,String palabra) {
        if(pos == 1){
            Palabras[0]=palabra;
        }else{
            Palabras[1]=palabra;
        }
        notify();
    }
}
