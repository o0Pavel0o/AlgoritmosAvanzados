public class Practica4{

    public static int f (int x, int y) {
        if (y==0)
            return x;
        else
        return f(x,y-1) + f(x+1,y-1);
    }

    public static int fMem(int x, int y) {
        int[][] t = new int[y + 1][y + 1];
        for (int[] t1 : t) {
            for (int j = 0; j < t[0].length; j++) {
                t1[j] = 0;
            }
        }
        fMemAux(x, y, t, x);
        return t[y][x - x];
    }

    private static void fMemAux(int x, int y, int[][] t, int aux) {
        if (t[y][x-aux]==0)
          if (y==0)
                t[y][x-aux]=x;
          else{
               fMemAux(x, y-1, t, aux);
               fMemAux(x+1, y-1, t, aux);
               t[y][x-aux] = t[y-1][x-aux]+t[y-1][x-aux+1];
         } 
    }

    public static int fTab(int x, int y) {
        var t = new int[y+1][y+1];// definición de la tabla y profundidad +1 
        for(int i=x; i<=x+y; i++) {// 
           t[0][i-x]=i;
        }
        for(int i=1; i<=y; i++) {
           for(int j=0; j<=y-i; j++) {
             t[i][j]=t[i-1][j]+t[i-1][j+1];
          }
        }
        return t[y][x-x];
    }

    public static int fTabOpt(int x, int y) {
        int[] t = new int[y+1];
        for(int i=x; i<=x+y; i++) {
                t[i-x]=i;
        }
        for(int i=0; i<y; i++) {
           for (int j=0; j<y-i; j++) {
              t[j]=t[j]+t[j+1];
           }
        }
        return t[0];
    }

    public static void main(String[] args) {
        System.out.println("f=" + f(6, 3));
        System.out.println("fMem=" + fMem(6, 3));
        System.out.println("fTab=" + fTab(6, 3));
        System.out.println("fTabOpt=" + fTabOpt(6, 3));
    }
}
