package Examen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Palabra[] palabras;
        String entrada;
        Scanner sc = new Scanner(System.in);
        entrada=sc.nextLine();
        palabras=new Palabra[6];
        Contenedor c=new Contenedor();
        for(int i = 0; i < 6; i++){
            palabras[i]=new Palabra("Hilo " + i, i+1);
            palabras[i].setC(c);
            palabras[i].setStr(entrada);
        }
        for(int i = 0; i < 6; i++){
            palabras[i].start();
        }
        for(int i = 0; i < 6; i++){
            try {
                palabras[i].join();
            }catch (InterruptedException e){
                System.out.println("Hilo interrumpido");
            }
        }
    }
}
