
/**
 *
 * @author Pablo
 */
public class Practica3_RyP {
    
    static int nodos = 0;
    public static int trabajosRyP(int[] a, int[] b) {
        int cota = 0;
        for (int i = 0; i < a.length; i++) { 
           cota += Math.max(a[i], b[i]);
        }
        int[] solParcial = new int[a.length];
        int[] solOpt = new int[a.length];
        int i = 0;
        boolean descanso = false;
        int beneficio = buscarRyP(a, b, 0 , 0, 0, descanso, solParcial, solOpt, cota);
        imprimir(solOpt);
     return beneficio;
    }
	
    private static int buscarRyP(int[] a, int[] b, int i, int beneficioParcial, int beneficioMax, boolean descanso, int[] solParcial, int[] solOpt, int cota){
    	for (int k=0; k<=1; k++) {
    		boolean aux = false;
                int nCota = 0;
		int sParcial = 0;
    		if (k==1 && !aux){
    			beneficioParcial=0;
    			aux=true;
    		}
    		if (descanso==false){
    			if (i<a.length-1){
	    			if (a[i]>=b[i]+b[i+1]){
	    				solParcial[i]=a[i]; beneficioParcial+=a[i]; descanso=true;
	    			} else {
	    				solParcial[i]=b[i]; beneficioParcial+=b[i];
	    			}
    			} else {
                                if (a[i]>=b[i]+b[0]){
                                    solParcial[i]=a[i]; beneficioParcial+=a[i]; descanso=false;   
                                }
                                else{
                                    solParcial[i]=b[i]; beneficioParcial+=b[i];
                                }
    			}
    		}else{
    			solParcial[i]=b[i]; descanso=false;
    		}
                nCota = beneficioParcial;
                for (int j = i + 1; j < a.length; j++) {
			nCota += Math.max(a[i], b[i]);
		}
    		if (i==a.length-1) {
                        nodos++;
    			if (nCota>beneficioMax){
    				 beneficioMax=nCota;
    				 for (int j=0;j<a.length;j++){
                                    solOpt[j] = solParcial[j];
    				 }
    			}
    		} else {

    			 beneficioMax = buscarRyP(a ,b, i+1, beneficioParcial, beneficioMax, descanso, solParcial, solOpt, nCota);
    		}
    	}
    	return beneficioMax;
    }
    
    
    private static void imprimir (int [] sol){
        System.out.print("Beneficio máximo: { "); 
        for (int i=0; i<sol.length; i++){
		System.out.print (sol[i]+" ");		
        }
        System.out.println("} \nTotal soluciones: " + nodos);
    }


    public static void main(String[] args) {
        int a [] = {35, 15, 15, 15, 25};
        int b [] = {10, 10, 10, 10, 10};
        System.out.println( "Suma total: " + trabajosRyP(a, b));
    }
}