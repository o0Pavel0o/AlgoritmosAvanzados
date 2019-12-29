/**
*
* @author Universidad Rey Juan Carlos
* Course: Advanced Algorithms, Degree in Computer Science
* @version (Curso 2019-20)
*
**/

public class Practica2 {

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

	
    public static void main(String[] args) {
        int a [] = {10, 15, 15, 15, 15};
        int b [] = {10, 10, 10, 10, 10};
        
        int total = trabajosH1(a, b);
        System.out.println("Total: " + total);
        
        int total2 = trabajosH2(a, b);
        System.out.println("Total2: " + total2);
        
    }
    
}

