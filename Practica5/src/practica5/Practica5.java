/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica5;

import java.util.Arrays;

/**
 *
 * @author Pablo
 */
public class Practica5 {
    
        public static int trabajosH1(int[] a, int[] b) {
	boolean descanso = false;
        int beneficio=0;
        for (int i=0; i<=1; i++) {
    		boolean aux = false;
    		if (i==1 && !aux){
    			aux=true;
    		}
    		if (descanso==false){
    			if (i<a.length-1){
	    			if (a[i]>=b[i]+b[i+1]){
	    				beneficio+=a[i]; descanso=true;
	    			} else {
	    				beneficio+=b[i];
	    			}
    			} else {
                                if (a[i]>=b[i]+b[0]){
                                    beneficio+=a[i]; descanso=false;   
                                }
                                else{
                                    beneficio+=b[i];
                                }
    			}
    		}else{
    			descanso=false;
    		}
        }
	return beneficio;
    }
    
    public static int trabajosH2(int[] a, int[] b) {
	boolean descanso = false;
        int beneficio=0;
        for (int i=0; i<=1; i++) {
    		boolean aux = false;
    		if (i==1 && !aux){
    			aux=true;
    		}
    		if (descanso==false){
    			if (i<a.length-1){
	    			if (a[i]>=b[i]+b[i+1]){
	    				beneficio+=a[i];
	    				descanso=true;
	    			} else {
	    				beneficio+=b[i];
	    			}
    			} else {                             
                            beneficio+=b[i];     
    			}
    		}else{
    			descanso=false;
    		}
        }
	return beneficio;
    }

    static int nodos = 0;
    public static int trabajosVA(int[] a, int[] b) {
        int[] solParcial = new int[a.length];
        int[] solOpt = new int[a.length];
        boolean descanso = false;
        int beneficio = buscar(a, b, 0 , 0, 0, descanso, solParcial, solOpt);
        imprimir(solOpt);
     return beneficio;
    }

    
    private static void imprimir (int [] sol){
        System.out.print("Beneficio máximo: { "); 
        for (int i=0; i<sol.length; i++){
		System.out.print (sol[i]+" ");		
        }
        System.out.println("} \nTotal soluciones: " + nodos);
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

    
    private static void imprimir2 (int [] sol){
        System.out.print("Beneficio máximo: { "); 
        for (int i=0; i<sol.length; i++){
		System.out.print (sol[i]+" ");		
        }
        System.out.println("} \nTotal soluciones: " + nodos);
    }
    
    
    

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
    
    
    
    
    public static int trabajosRec(int[] a, int[] b) {
	return Math.max(trabajosAux(a, b, 0, false), trabajosAux(a, b, 0, true));
    }


     private static int trabajosAux(int[] a, int[] b, int i, boolean descanso){
        // versión recursiva hacia adelante
       if(i==a.length-1){ 
            //si es la última semana y no ha descansado
            if(descanso==false && a[i]<=b[i]+b[0]){
                return b[0];
            }else{
                return a[i];
            }
        }else{
            if (a[i]>=b[i]+b[i+1]){ 
            	 return Math.max((trabajosAux(a, b, i+1, false)), (trabajosAux(a, b, i+1, true) + a[i]));
              
            }else{ 
                return Math.max((trabajosAux(a, b, i+1, false) + b[i]), (trabajosAux(a, b, i+1, true)));
            }                
           
        }
        
    }

    public static int trabajosTab(int[] a, int[] b) {
           boolean descanso = false;
           int tabla[][] = new int[3][a.length];
           String decisiones[] = new String[a.length];
           tabla[0][a.length-1] = a[a.length-1];
           tabla[1][a.length-1] = b[a.length-1];
           tabla[2][a.length-1] = b[a.length-1];
           for (int i= a.length-2; i>=0; i--) {
               tabla[0][i] = Math.max(tabla[0][i+1], tabla[1][i+1] + a[i]);
               tabla[1][i] = Math.max(tabla[0][i+1] + b[i], tabla[1][i+1]);
           }
           for(int i=0; i<a.length-1; i++){
               decisiones[i] = tabla[0][i]<=tabla[1][i]?"baja":"alta";
               System.out.println("tabla[0]["+ i +"] -> "+tabla[0][i]);
               System.out.println("tabla[1][["+ i +"] -> "+tabla[1][i]);
           }
           if(a.length>1){
               if(decisiones[a.length-2]=="baja" && descanso==false){//caso base
                   if (a[a.length-1]<=b[a.length-1]){ 
                      descanso = false; 
                      decisiones[a.length-1]="baja";
                   }else{
                      descanso = true;
                      decisiones[a.length-1]="alta";
                   }
               }else{
                   if(a[a.length-1]<=a[a.length-1] && descanso==true){
                      descanso = true;
                      decisiones[a.length-1]="alta";
                   }else{
                      descanso = false;
                      decisiones[a.length-1]="baja";
                   }
               }
           }
           tabla[2][0] = Math.max(tabla[0][1], tabla[0][2]);
           System.out.println("Beneficio máximo: " + tabla[2][0]);
           System.out.println(Arrays.toString(decisiones));
           return tabla[2][0];
       }    
    
    public static void main(String[] args) {
        int a [] = {10, 15, 15, 15, 15};
        int b [] = {10, 10, 10, 10, 10};
        
        
        int total2 = trabajosTab(a, b);
        System.out.println("Total: " + total2);
    }
    
}