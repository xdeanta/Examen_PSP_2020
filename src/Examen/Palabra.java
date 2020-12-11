package Examen;

public class Palabra extends Thread{
    protected String str;
    protected int tid;
    protected Contenedor c;

    public Palabra(String name, int id){
        super(name);
        tid=id;
    }
    public Palabra(){
        this(null,0);
    }
    public void setStr(String str){
        this.str=str;
    }

    public void setC(Contenedor c) {
        this.c = c;
    }

    @Override
    public void run(){
        String[] strs;
        strs=str.split(" ");
        switch(tid){
            case 1:
                if(strs.length > 3) {
                    c.insertPalabra(1,strs[2]);
                }
                break;
            case 2:
                int cont=0;
                for(int i = 0; i < str.length(); i++){
                    if(Character.isDefined(str.charAt(i))){
                        cont++;
                    }
                }
                c.setContLetras(cont);
                break;
            case 3:
                int contPal=0;
                contPal=strs.length;
                c.setContPalabra(contPal);
                break;
            case 4:
                c.insertPalabra(2,strs[strs.length-2]);
                break;
            case 5:
                System.out.println("El numero total de caracteres es: " + c.getContLetras() + ",y el numero de palabras es: " + c.getContPalabra());
                break;
            case 6:
                String[] impPalabras;
                impPalabras=c.getPalabras();
                System.out.println("La tercera palabra es: " + impPalabras[0] + ",y la penúltima palabra es: " + impPalabras[1]);
                break;
        }
    }

}
