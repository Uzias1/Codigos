/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CMatriz;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Uzías
 */
@WebServlet(name = "Invierte", urlPatterns = {"/Invierte"})
public class Invierte extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String error = "error.jsp";//pagina a donde irá en caso de error

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //invertir una matriz
        //n = request.getParameter("nombree");
        //solo será para matrices de 3x3
        int numeros[] = new int[100];// arreglo de enteros que contendrá los numeros a descifrar
        int arreglo[][] = new int[3][3];// arreglo de enteros que contendrá la matriz
        
        int xd=0; //aqui deberá ir el tamaño del arreglo de numeros enviado
        if(comprobarDimensiones(xd)){
            //significa que es posible calcular la inversa y además es posible descifrar el mensaje
            try {
                //para obtener los valores introducidos de la matriz
                arreglo[0][0] = Integer.parseInt(request.getParameter("m11"));
                arreglo[0][1] = Integer.parseInt(request.getParameter("m12"));
                arreglo[0][2] = Integer.parseInt(request.getParameter("m13"));
                arreglo[1][0] = Integer.parseInt(request.getParameter("m21"));
                arreglo[1][1] = Integer.parseInt(request.getParameter("m22"));
                arreglo[1][2] = Integer.parseInt(request.getParameter("m23"));
                arreglo[2][0] = Integer.parseInt(request.getParameter("m31"));
                arreglo[2][1] = Integer.parseInt(request.getParameter("m32"));
                arreglo[2][2] = Integer.parseInt(request.getParameter("m33"));
                //Obtener los datos a descifrar
                numeros[1] = Integer.parseInt(request.getParameter("d1"));
                numeros[2] = Integer.parseInt(request.getParameter("d2"));
                numeros[3] = Integer.parseInt(request.getParameter("d3"));
                numeros[4] = Integer.parseInt(request.getParameter("d4"));
                numeros[5] = Integer.parseInt(request.getParameter("d5"));
                numeros[6] = Integer.parseInt(request.getParameter("d6"));
                numeros[7] = Integer.parseInt(request.getParameter("d7"));
                numeros[8] = Integer.parseInt(request.getParameter("d8"));
                numeros[9] = Integer.parseInt(request.getParameter("d9"));
                numeros[10] = Integer.parseInt(request.getParameter("d10"));
                numeros[11] = Integer.parseInt(request.getParameter("d11"));
                numeros[12] = Integer.parseInt(request.getParameter("d12"));
                numeros[13] = Integer.parseInt(request.getParameter("d13"));
                numeros[14] = Integer.parseInt(request.getParameter("d14"));
                numeros[15] = Integer.parseInt(request.getParameter("d15"));
                numeros[16] = Integer.parseInt(request.getParameter("d16"));
                numeros[17] = Integer.parseInt(request.getParameter("d17"));
                numeros[18] = Integer.parseInt(request.getParameter("d18"));
                numeros[19] = Integer.parseInt(request.getParameter("d19"));
                numeros[20] = Integer.parseInt(request.getParameter("d20"));
                numeros[21] = Integer.parseInt(request.getParameter("d21"));
                numeros[22] = Integer.parseInt(request.getParameter("d22"));
                numeros[23] = Integer.parseInt(request.getParameter("d23"));
                numeros[24] = Integer.parseInt(request.getParameter("d24"));
                numeros[25] = Integer.parseInt(request.getParameter("d25"));
                numeros[26] = Integer.parseInt(request.getParameter("d26"));
                numeros[27] = Integer.parseInt(request.getParameter("d27"));
                numeros[28] = Integer.parseInt(request.getParameter("d28"));
                numeros[29] = Integer.parseInt(request.getParameter("d29"));
                numeros[30] = Integer.parseInt(request.getParameter("d30"));
                
                int inversa[][] = new int[3][3];
                inversa = creaInversa(arreglo); //regresa la inversa de la matriz creada anteriormente
                
                //multiplicar inversa por el arreglo y descifrar
                String fin = damePalabras(inversa, numeros);
                // System.out.println("La cadena final es: "+fin); ya funciona :)
                HttpSession sesion = request.getSession();
                sesion.setAttribute("matriz",inversa);
                sesion.setAttribute("mensaje",fin);
                response.sendRedirect("succes.jsp");
            } catch(Exception e){
                response.sendRedirect(error); 
                e.printStackTrace();
            }
        } else {
            //no es necesario en este caso, minimo se envía un 0
        }
        
    }
    public boolean comprobarDimensiones(int x){
        return true;
    }
    
    public int[][] creaIdentidad(){
        int x[][] = new int[3][3];
        x[0][0] = 1;
        x[0][1] = 0;
        x[0][2] = 0;
        x[1][0] = 0;
        x[1][1] = 1;
        x[1][2] = 0;
        x[2][0] = 0;
        x[2][1] = 0;
        x[2][2] = 1;
        return x;
    }
    
    public int[][] creaInversa(int x[][]){ //x es la matriz original
        int identidad[][] = new int[3][3];// matriz identidad
        identidad = creaIdentidad();
        int aux[][] = new int[4][4];
        //TODO inversion
        //Multiplicar el primer renglon por el coeficiente de la posicion 2 1
        aux[1][1] = (x[0][0])*(x[1][0]);
        aux[1][2] = (x[0][1])*(x[1][0]);
        aux[1][3] = (x[0][2])*(x[1][0]);
            //Ahora multimplicar el primer renglon de la identidad por el coeficiente de la posicion 2 1
        aux[2][1] = (identidad[0][0])*(x[1][0]);
        aux[2][2] = (identidad[0][1])*(x[1][0]);
        aux[2][3] = (identidad[0][2])*(x[1][0]);
        //Multiplicar el segundo renglon por el coeficiente de la posicion 1 1
        aux[3][1] = (x[1][0])*(x[0][0]);
        aux[3][2] = (x[1][1])*(x[0][0]);
        aux[3][3] = (x[1][2])*(x[0][0]);
            //Obtener nuevo valor del renglon 2 de la identidad
        identidad[1][0] = -aux[2][1]+(identidad[1][0])*(x[0][0]);
        identidad[1][1] = -aux[2][2]+(identidad[1][1])*(x[0][0]);
        identidad[1][2] = -aux[2][3]+(identidad[1][2])*(x[0][0]);
        //obtener los nuevos valores del renglon 2
        x[1][0] = -aux[1][1]+aux[3][1];
        x[1][1] = -aux[1][2]+aux[3][2];
        x[1][2] = -aux[1][3]+aux[3][3];
        
        
        
        //AHORA CON EL TERCER RENGLON**************************************************
        if(x[2][0]!=0){
            aux[1][1] = (x[1][0])*(x[2][0]);
            aux[1][2] = (x[1][1])*(x[2][0]);
            aux[1][3] = (x[1][2])*(x[2][0]);

            aux[2][1] = (identidad[1][0])*(x[2][0]);
            aux[2][2] = (identidad[1][1])*(x[2][0]);
            aux[2][3] = (identidad[1][2])*(x[2][0]);

            aux[3][1] = (x[2][0])*(x[1][0]);
            aux[3][2] = (x[2][1])*(x[1][0]);
            aux[3][3] = (x[2][2])*(x[1][0]);

            identidad[2][0] = -aux[2][1]+(identidad[2][0])*(x[1][0]);
            identidad[2][1] = -aux[2][2]+(identidad[2][1])*(x[1][0]);
            identidad[2][2] = -aux[2][3]+(identidad[2][2])*(x[1][0]);

            x[2][0] = -aux[1][1]+aux[3][1];
            x[2][1] = -aux[1][2]+aux[3][2];
            x[2][2] = -aux[1][3]+aux[3][3];
        }
        
        
        //AHORA CON EL TERCER RENGLON SEGUNDO ELEMENTO**************************************************
        aux[1][1] = (x[1][0])*(x[2][1]);
        aux[1][2] = (x[1][1])*(x[2][1]);
        aux[1][3] = (x[1][2])*(x[2][1]);
        
        aux[2][1] = (identidad[1][0])*(x[2][1]);
        aux[2][2] = (identidad[1][1])*(x[2][1]);
        aux[2][3] = (identidad[1][2])*(x[2][1]);
        
        aux[3][1] = (x[2][0])*(x[1][1]);
        aux[3][2] = (x[2][1])*(x[1][1]);
        aux[3][3] = (x[2][2])*(x[1][1]);
        
        identidad[2][0] = -aux[2][1]+(identidad[2][0])*(x[1][1]);
        identidad[2][1] = -aux[2][2]+(identidad[2][1])*(x[1][1]);
        identidad[2][2] = -aux[2][3]+(identidad[2][2])*(x[1][1]);
        
        x[2][0] = -aux[1][1]+aux[3][1];
        x[2][1] = -aux[1][2]+aux[3][2];
        x[2][2] = -aux[1][3]+aux[3][3];
        
        
        //PARA ELIMINAR LA POSICION 2,3 **************************************************************************
        if(x[1][2]!=0){
            aux[1][1] = (x[1][0])*(x[2][2]);
            aux[1][2] = (x[1][1])*(x[2][2]);
            aux[1][3] = (x[1][2])*(x[2][2]);

            aux[2][1] = (identidad[1][0])*(x[2][2]);
            aux[2][2] = (identidad[1][1])*(x[2][2]);
            aux[2][3] = (identidad[1][2])*(x[2][2]);

            aux[3][1] = (x[2][0])*(x[1][2]);
            aux[3][2] = (x[2][1])*(x[1][2]);
            aux[3][3] = (x[2][2])*(x[1][2]);

            identidad[1][0] = -aux[2][1]+(identidad[2][0])*(x[1][2]);
            identidad[1][1] = -aux[2][2]+(identidad[2][1])*(x[1][2]);
            identidad[1][2] = -aux[2][3]+(identidad[2][2])*(x[1][2]);

            x[1][0] = -aux[1][1]+aux[3][1];
            x[1][1] = -aux[1][2]+aux[3][2];
            x[1][2] = -aux[1][3]+aux[3][3];
        }
        
        
        //AHORA SE ELIMINA LA POSICION 1,3 **************************************+++++++++++
        aux[1][1] = (x[0][0])*(x[2][2]);
        aux[1][2] = (x[0][1])*(x[2][2]);
        aux[1][3] = (x[0][2])*(x[2][2]);
        
        aux[2][1] = (identidad[0][0])*(x[2][2]);
        aux[2][2] = (identidad[0][1])*(x[2][2]);
        aux[2][3] = (identidad[0][2])*(x[2][2]);
        
        aux[3][1] = (x[2][0])*(x[0][2]);
        aux[3][2] = (x[2][1])*(x[0][2]);
        aux[3][3] = (x[2][2])*(x[0][2]);
        
        identidad[0][0] = -aux[2][1]+(identidad[2][0])*(x[0][2]);
        identidad[0][1] = -aux[2][2]+(identidad[2][1])*(x[0][2]);
        identidad[0][2] = -aux[2][3]+(identidad[2][2])*(x[0][2]);
        
        x[0][0] = -aux[1][1]+aux[3][1];
        x[0][1] = -aux[1][2]+aux[3][2];
        x[0][2] = -aux[1][3]+aux[3][3];
        
        
        //AHORA SE ELIMINA LA POSICION 1,2 **************************************+++++++++++
        aux[1][1] = (x[0][0])*(x[1][1]);
        aux[1][2] = (x[0][1])*(x[1][1]);
        aux[1][3] = (x[0][2])*(x[1][1]);
        
        aux[2][1] = (identidad[0][0])*(x[1][1]);
        aux[2][2] = (identidad[0][1])*(x[1][1]);
        aux[2][3] = (identidad[0][2])*(x[1][1]);
        
        aux[3][1] = (x[1][0])*(x[0][1]);
        aux[3][2] = (x[1][1])*(x[0][1]);
        aux[3][3] = (x[1][2])*(x[0][1]);
        
        identidad[0][0] = -aux[2][1]+(identidad[1][0])*(x[0][1]);
        identidad[0][1] = -aux[2][2]+(identidad[1][1])*(x[0][1]);
        identidad[0][2] = -aux[2][3]+(identidad[1][2])*(x[0][1]);
        
        x[0][0] = -aux[1][1]+aux[3][1];
        x[0][1] = -aux[1][2]+aux[3][2];
        x[0][2] = -aux[1][3]+aux[3][3];
        
        
        //ahora solo queda dividir cada renglon entre sí mismo para que del lado izquierdo quede la matriz identidad
        
        identidad[0][0] = (identidad[0][0])/(x[0][0]);
        identidad[0][1] = (identidad[0][1])/(x[0][0]);
        identidad[0][2] = (identidad[0][2])/(x[0][0]);
        x[0][0] = (x[0][0])/(x[0][0]);
        
        identidad[1][0] = (identidad[1][0])/(x[1][1]);
        identidad[1][1] = (identidad[1][1])/(x[1][1]);
        identidad[1][2] = (identidad[1][2])/(x[1][1]);
        x[1][1] = (x[1][1])/(x[1][1]);
        
        identidad[2][0] = (identidad[2][0])/(x[2][2]);
        identidad[2][1] = (identidad[2][1])/(x[2][2]);
        identidad[2][2] = (identidad[2][2])/(x[2][2]);
        x[2][2] = (x[2][2])/(x[2][2]);
        
        
        return identidad;
    }
    
    public void imprimeMatriz(int x[][]){
        System.out.println("--------------");
        System.out.println("["+x[0][0]+", "+x[0][1]+", "+x[0][2]+"]");
        System.out.println("["+x[1][0]+", "+x[1][1]+", "+x[1][2]+"]");
        System.out.println("["+x[2][0]+", "+x[2][1]+", "+x[2][2]+"]");
        System.out.println("--------------");
    }
    
    public String damePalabras(int inversa[][], int numeros[]){
        String cad="";
        char[] abc = new char[27];
        abc=abcArreglo();
        char aux = ' ';
        int x =0;
        //numeros empieza en 1
        for (int i = 1; i <= 30; i++) {
            x = (inversa[0][0]*numeros[i])+(inversa[0][1]*numeros[i+1])+(inversa[0][2]*numeros[i+2]);
            System.out.println("El numero"+ i +" es: "+x);
            aux = abc[x];
            cad = cad + aux;
            x = (inversa[1][0]*numeros[i])+(inversa[1][1]*numeros[i+1])+(inversa[1][2]*numeros[i+2]);
            System.out.println("El numero"+ i+1 +" es: "+x);
            aux = abc[x];
            cad = cad + aux;
            x = (inversa[2][0]*numeros[i])+(inversa[2][1]*numeros[i+1])+(inversa[2][2]*numeros[i+2]);
            System.out.println("El numero"+ i+2 +" es: "+x);
            aux = abc[x];
            cad = cad + aux;
            i = i+2;
        }
        
        return cad;
    }
    
    public char[] abcArreglo (){
        char[] abc = new char[27];
        abc[0] = ' ';
        abc[1] = 'a';
        abc[2] = 'b';
        abc[3] = 'c';
        abc[4] = 'd';
        abc[5] = 'e';
        abc[6] = 'f';
        abc[7] = 'g';
        abc[8] = 'h';
        abc[9] = 'i';
        abc[10] = 'j';
        abc[11] = 'k';
        abc[12] = 'l';
        abc[13] = 'm';
        abc[14] = 'n';
        abc[15] = 'o';
        abc[16] = 'p';
        abc[17] = 'q';
        abc[18] = 'r';
        abc[19] = 's';
        abc[20] = 't';
        abc[21] = 'u';
        abc[22] = 'v';
        abc[23] = 'w';
        abc[24] = 'x';
        abc[25] = 'y';
        abc[26] = 'z';
        return abc;
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
