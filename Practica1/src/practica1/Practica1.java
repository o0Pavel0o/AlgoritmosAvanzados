package Practica1;

public class Practica1{

    public static int tareas (int ts[], int n){
        int totalCoste=0;
        int costeParcial[] = new int[n];
        for (int i = 0; i<ts.length ; i++){
            int proc = 0;
            if(i%2==0){
                costeParcial[proc] = costeParcial[proc] + ts[i];
                //System.out.println( "CosteProcesador impar: " + costeParcial[proc]);
            }else{
                proc++;
                costeParcial[proc] = costeParcial[proc] + ts[i];
                //System.out.println( "CosteProcesador par: " + costeParcial[proc]);
            }
            System.out.println("Tarea " + i +" con duracion: " + ts[i] + " para el procesador: " + proc);
            totalCoste += costeParcial[proc];
        }
    return totalCoste;
    }  

   public static int[] ordenarEnVectorI (int[] v) {
      for (int i=1; i<v.length; i++) {
         int aux = v[i];
         int j;
         for (j=i-1; j>=0 && v[j]>aux; j--)
            v[j+1] = v[j];
         v[j+1] = aux;
      }
      return v;
   }

    public static void main(String[] args){
        int ts [] = {5, 3, 2, 4, 1, 6, 7};
        int n = 2;
        ordenarEnVectorI(ts);
        for(int i=0; i<ts.length; i++){
            System.out.println(ts);
        }
        int total = tareas(ts, n);
        System.out.println("Coste total: " + total);
    }
}