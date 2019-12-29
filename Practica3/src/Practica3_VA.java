
/**
 *
 * @author Pablo
 */
public class Practica3_VA {
    
    static int nodos = 0;
    public static int trabajosVA(int[] a, int[] b) {
        int[] solParcial = new int[a.length];
        int[] solOpt = new int[a.length];
        boolean descanso = false;
        int beneficio = buscar(a, b, 0 , 0, 0, descanso,solParcial, solOpt);
        imprimir(solOpt);
     return beneficio;
    }

    private static int buscar(int[] a, int[] b, int i, int beneficioParcial, int beneficioMax,boolean descanso, int[] solParcial, int[] solOpt){
    	for (int k=0; k<=1; k++) {
    		boolean aux = false;
    		if (k==1 && !aux){
    			beneficioParcial=0;
    			aux=true;
    		}
    		if (descanso==false){
    			if (i<a.length-1){
	    			if (a[i]>=b[i]+b[i+1]){
	    				solParcial[i]=a[i];
	    				beneficioParcial+=a[i];
	    				descanso=true;
	    			} else {
	    				solParcial[i]=b[i];
	    				beneficioParcial+=b[i];
	    			}
    			} else {
                                if (a[i]>=b[i]+b[0]){
                                    solParcial[i]=a[i];
                                    beneficioParcial+=a[i];
                                    descanso=false;   
                                }
                                else{
                                    solParcial[i]=b[i];
                                    beneficioParcial+=b[i];
                                }
    			}
    		}else{
    			solParcial[i]=b[i];
    			descanso=false;
    		}
    		 if (i==a.length-1) {
                     nodos++;
    			 if (beneficioParcial>beneficioMax){
    				 beneficioMax=beneficioParcial;
    				 for (int j=0;j<a.length;j++){
    					 solOpt[j] = solParcial[j];
    				 }
    			 }
    		 } else {
    			 beneficioMax = buscar(a, b, i+1, beneficioParcial, beneficioMax,descanso, solParcial, solOpt);
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
        int a [] = {10, 15, 15, 15, 15};
        int b [] = {10, 10, 10, 10, 10};
        System.out.println( "Suma total: " + trabajosVA(a, b));
    }
}