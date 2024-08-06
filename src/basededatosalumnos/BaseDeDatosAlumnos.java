package basededatosalumnos;

import java.util.Scanner;

public class BaseDeDatosAlumnos {

    public static void main(String[] args) {
        //Creando arreglo del estudiante
        estudiante datos[] = new estudiante[10];
        int op = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (op != 5) {
            System.out.println("------------MENU----------");
            
                System.out.println("1. Nuevo Alumno");
            System.out.println("2. Ver alumnos");
            System.out.println("3. Buscar alumno");
            System.out.println("4. Modificar alumno");
            System.out.println("5. Salir");
            System.out.println("Ingrese el numero de opcion");
            op = teclado.nextInt();

            if (op == 1) {
                System.out.println("----------------------------");
                System.out.println("Ingrese clave");
                int clave = teclado.nextInt();
                System.out.println("Ingrese el nombre");
                String nombre = letras.nextLine();
                System.out.println("Ingrese el grado");
                String grado = letras.nextLine();
                System.out.println(nuevoAlumno(clave, nombre, grado, datos));
            }else if(op == 2){
                System.out.println(imprimirTodo(datos));
            }
        }
    }
    public static String nuevoAlumno(int clave, String nombre, String grado, estudiante arreglo[]){
        boolean lleno= true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new estudiante(clave, nombre, grado);
                lleno = false;
                break;
            }else if(arreglo[i].getClave()== clave){
                return "Ya existe la clave";
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        }else{
            return "Ya no hay espacio";
        }
        
    }
    
    public static String imprimirTodo(estudiante arreglo[]){
        String cadena = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena = cadena + arreglo[i].getClave() + "|" + arreglo[i].getNombre() + "|" + arreglo[i].getGrado() + "\n";
            }
        }
        return cadena;
    }
}
