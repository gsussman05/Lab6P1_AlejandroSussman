/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_alejandrosussman;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class Lab6P1_AlejandroSussman {

    static Random rnd = new Random();
    static Scanner read = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner og = new Scanner(System.in);
        int opcion_m;
        System.out.println("****MENU****");
        System.out.println("1. Conjuntos");
        System.out.println("2. Cuantos primos tienes?");
        System.out.println("Ingrese una opcion: ");
        opcion_m = og.nextInt();
        while (opcion_m != 3) {
            switch (opcion_m) {
                case 1:
                    System.out.println("Size SET1: ");
                    int size1 = og.nextInt();
                    System.out.println("Size SET2: ");
                    int size2 = og.nextInt();
                    char[] SET1 = getRandCharArray(size1);
                    char[] SET2 = getRandCharArray(size2);
                    System.out.print("SET1: ");
                    print(SET1);
                    System.out.print("SET2: ");
                    print(SET2);
                    System.out.println("1. Interseccion");
                    System.out.println("2. DIferencia");
                    System.out.println("Ingrese una opcion: ");
                    int opc2 = read.nextInt();
                    if (opc2 == 1) {
                        System.out.print("INTERSECTION(SET1, SET2): ");
                        print(interseccion(SET1, SET2));
                    } else if (opc2 == 2) {
                        System.out.print("DIFFERENCE(SET1, SET2): ");
                        print(diferencia(SET1, SET2));
                    } else {
                        System.out.println("Opcion invalida.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el tamano del arreglo a generar: ");
                    int tam2 = read.nextInt();
                    System.out.println("Ingrese el limite inferior: ");
                    int min = read.nextInt();
                    System.out.println("Ingrese el limite superior: ");
                    int max = read.nextInt();
                    int[] arrInt = genRandArray(tam2, min, max);
                    System.out.println("Arreglo generado: ");
                    print_int(arrInt);
                    System.out.println("No. Divisores Primos: ");
                    print_int(getTotalPrimeCount(arrInt));
                    break;
                default:
                    System.out.println("El numero ingresado debe de ser 1 o 2");
                    break;

            }
            System.out.println("****MENU****");
            System.out.println("1. Conjuntos");
            System.out.println("2. Cuantos primos tienes?");
            System.out.println("Ingrese una opcion: ");
            opcion_m = og.nextInt();
        }
    }

    public static void print_int(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println();
    }
    
    public static void print(char array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println();
    }

    public static char[] getRandCharArray(int size) {
        char temp1[] = new char[size];
        int conteo = 1;
        conteo = rnd.nextInt(8);
        for (int i = 0; i < temp1.length; i++) {
            conteo = rnd.nextInt(8);
            conteo++;
            switch (conteo) {
                case 1:
                    temp1[i] = 'A';
                    break;
                case 2:
                    temp1[i] = 'B';
                    break;
                case 3:
                    temp1[i] = 'C';
                    break;
                case 4:
                    temp1[i] = 'D';
                    break;
                case 5:
                    temp1[i] = 'E';
                    break;
                case 6:
                    temp1[i] = 'F';
                    break;
                case 7:
                    temp1[i] = 'G';
                    break;
                case 8:
                    temp1[i] = 'H';
                    break;
                case 9:
                    temp1[i] = 'I';
                    break;
                default:
                    temp1[i] = 'X';
                    break;
            }

        }
        return temp1;
    }

    public static char[] interseccion(char[] arr1, char[] arr2) {
        int tam = arr1.length;

        if (arr2.length > tam) {
            tam = arr2.length;
        }

        char[] resp = new char[tam];
        tam = 0;

        for (int i = 0; i < arr1.length; i++) {
            char letra = arr1[i];
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == letra) {
                    resp[tam] = letra;
                    tam++;
                }
            }
        }

        char[] resp2 = new char[tam];
        for (int i = 0; i < tam; i++) {
            resp2[i] = resp[i];
        }

        return resp2;
    }

    public static char[] diferencia(char[] arr1, char[] arr2) {
        int tam = arr1.length;

        if (arr2.length > tam) {
            tam = arr2.length;
        }

        char[] resp = new char[tam];
        tam = 0;

        for (int i = 0; i < arr1.length; i++) {
            char letra = arr1[i];
            boolean existe = false;
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] == letra) {
                    existe = true;
                }
            }
            if (existe == false) {
                resp[tam] = letra;
                tam++;
            }
        }

        char[] resp2 = new char[tam];
        for (int i = 0; i < tam; i++) {
            resp2[i] = resp[i];
        }

        return resp2;
    }

    public static int[] genRandArray(int tam, int min, int max) {
        int[] resp = new int[tam];
        int diff = max - min;
        for (int i = 0; i < tam; i++) {
            resp[i] = rnd.nextInt(min) + diff;
        }
        return resp;
    }

    public static boolean isPrime(int num) {
        boolean resp = true;
        int mult = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                mult = i * j;
                if (mult == num) {
                    resp = false;
                } else if (mult > num) {
                    break;
                }
            }
        }
        return resp;
    }

    
    public static int countPrimeFactors(int num)
    {
        int resp = 0;
        for (int i = 1; i < num; i++)
        { 
            if (num % i == 0) //Es Factor
            {
                if (isPrime(i))
                {
                    resp++;
                }
            }
        }
        return resp;
    }
    
    public static int[] getTotalPrimeCount(int[] arr1)
    {
        int[] resp = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
            resp[i] = countPrimeFactors(arr1[i]);
        }
        return resp;
    }
}
