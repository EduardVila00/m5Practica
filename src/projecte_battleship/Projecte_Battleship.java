/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte_battleship;

import java.util.Scanner;

/**
 *
 * @author edu
 */
public class Projecte_Battleship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int files = 11;
        int columnes = 11;
        String[][] dades = new String[files][columnes];
        String[][] mapa = new String[files][columnes];
        int shipTamany = 0;
        boolean shipBoolean = false;
        String direccio = null;
        boolean direccioBoolean = false;
        int coordenadaX = 0;
        int coordenadaY = 0;
        int coordenadaDispararX = 0;
        int coordenadaDispararY = 0;
        boolean coordenadesCorrecte = false;
        int disparsEfectuats = 0;
        int numVaixells = 0;
        boolean vaixell1 = false;
        boolean vaixell2 = false;
        boolean vaixell3 = false;
        int numVaixells2 = 0;
        //Omplir array
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa.length; j++) {
                mapa[i][j] = "~";
            }
        }
        for (int i = 0; i < dades.length; i++) {
            for (int j = 1; j < dades[i].length; j++) {
                mapa[0][j] = Integer.toString(j);
                dades[0][j] = Integer.toString(j);
            }
        }
        for (int i = 0; i < dades.length; i++) {
            for (int j = i; j < dades[i].length; j++) {
                if (j < dades.length - 1) {
                    mapa[j][0] = " " + Integer.toString(j);
                    dades[j][0] = " " + Integer.toString(j);
                } else {
                    mapa[j][0] = Integer.toString(j);
                    dades[j][0] = Integer.toString(j);
                }
            }
        }
        mapa[0][0] = "  ";
        dades[0][0] = "  ";
        System.out.println("\nBattleship\n==========");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j] + " ");
            }
        }
        System.out.println("Quants vaixells vols introduïr?\n1. 1 Vaixell\n2. 2 Vaixells\n 3. 3 Vaixells");
        while (!sc.hasNextInt()) {
            System.out.println("Només numeros");
            sc.hasNextInt();
            sc.nextLine();
        }
        numVaixells = sc.nextInt();
        switch (numVaixells) {
            case 1:
                vaixell2 = true;
                vaixell3 = true;
                break;
            case 2:
                vaixell3 = true;
                break;
            case 3:
                break;
            default:
                System.out.println("Introdueix numeros entre 1 i 3");
        }
        while (vaixell1 == false && vaixell2 == false && vaixell3 == false) {

        }
        //Tamany
        System.out.println("Introdueix el vaixell " + numVaixells2 + ":\nDe quantes caselles el vols? (entre 2 i 4)");
        while (shipBoolean == false) {
            shipTamany = sc.nextInt();
            if (shipTamany == 2 || shipTamany == 3 || shipTamany == 4) {
                shipBoolean = true;
            } else {
                System.err.println("==Error==\nIntrodueix un tamany corecte");
            }
        }
        //Direccio
        System.out.println("El vols en horitzontal(h) o vertical(v)?");
        while (direccioBoolean == false) {
            direccio = sc.next();
            if ("v".equals(direccio) || "h".equals(direccio)) {
                direccioBoolean = true;
            } else {
                System.err.println("==Error==\nIntrodueix una direcció corecte");
            }
        }
        //array vaixel
        String[][] shipVert = new String[shipTamany][1];
        String[][] shipHor = new String[1][shipTamany];
        //Posicio
        System.out.println("A quines coordenades ho vols possar?");
        while (coordenadesCorrecte == false) {
            System.out.println("Introdueix la fila:");
            while (!sc.hasNextInt()) {
                System.out.println("Només numeros");
                sc.hasNextInt();
                sc.nextLine();
            }
            coordenadaX = sc.nextInt();
            System.out.println("Introduix la columna:");
            while (!sc.hasNextInt()) {
                System.out.println("Només numeros");
                sc.hasNextInt();
                sc.nextLine();
            }
            coordenadaY = sc.nextInt();
            if (coordenadaX < 11 && coordenadaX > 0 && coordenadaY < 11 && coordenadaY > 0) {
                //coordenadesCorrecte = true;
                if (shipTamany == 2 && coordenadaX <= 9 || shipTamany == 2 && coordenadaY <= 9) {
                    switch (direccio) {
                        case "h":
                            for (int i = 0; i < shipVert.length; i++) {
                                for (int j = 0; j < shipVert[i].length; j++) {
                                    dades[coordenadaX][coordenadaY + i] = "O";
                                }
                            }
                            break;
                        case "v":
                            for (int i = 0; i < shipHor.length; i++) {
                                for (int j = 0; j < shipHor[i].length; j++) {
                                    dades[coordenadaX + j][coordenadaY] = "O";
                                }
                            }
                            break;
                    }
                    coordenadesCorrecte = true;
                } else if (shipTamany == 3 && coordenadaX <= 8 || shipTamany == 3 && coordenadaY <= 8) {

                    switch (direccio) {
                        case "h":
                            for (int i = 0; i < shipVert.length; i++) {
                                for (int j = 0; j < shipVert[i].length; j++) {
                                    dades[coordenadaX][coordenadaY + i] = "O";
                                }
                            }
                            break;
                        case "v":
                            for (int i = 0; i < shipHor.length; i++) {
                                for (int j = 0; j < shipHor[i].length; j++) {
                                    dades[coordenadaX + j][coordenadaY] = "O";
                                }
                            }
                            break;
                    }
                    coordenadesCorrecte = true;
                } else if (shipTamany == 4 && coordenadaX < 6 || shipTamany == 4 && coordenadaY < 6) {

                    switch (direccio) {
                        case "h":
                            for (int i = 0; i < shipVert.length; i++) {
                                for (int j = 0; j < shipVert[i].length; j++) {
                                    dades[coordenadaX][coordenadaY + i] = "O";
                                }
                            }
                            break;
                        case "v":
                            for (int i = 0; i < shipHor.length; i++) {
                                for (int j = 0; j < shipHor[i].length; j++) {
                                    dades[coordenadaX + j][coordenadaY] = "O";
                                }
                            }
                            break;
                    }
                    coordenadesCorrecte = true;
                }
            } else {
                System.err.println("==Error==\nIntrodueix unes coordenades valides");
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nJugador 2:\nAra toca enfonsar els vaixells");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j] + " ");
            }
        }
        while (shipTamany != 0) {
            System.out.println("\nA quina coordenada vols disparar?");
            System.out.println("Introdueix la fila:");
            while (!sc.hasNextInt()) {
                System.out.println("Només numeros");
                sc.hasNextInt();
                sc.nextLine();
            }
            coordenadaDispararX = sc.nextInt();
            System.out.println("Introdueix la columna:");
            while (!sc.hasNextInt()) {
                System.out.println("Només numeros");
                sc.hasNextInt();
                sc.nextLine();
            }
            coordenadaDispararY = sc.nextInt();
            if (coordenadaDispararX < 11 && coordenadaDispararX > 0 && coordenadaDispararY < 11 && coordenadaDispararY > 0) {
                if (dades[coordenadaDispararX][coordenadaDispararY] == "O") {
                    System.out.println("Tocat");
                    disparsEfectuats++;
                    mapa[coordenadaDispararX][coordenadaDispararY] = "X";
                    dades[coordenadaDispararX][coordenadaDispararY] = "X";
                    shipTamany--;
                } else if (dades[coordenadaDispararX][coordenadaDispararY] == "X") {
                    System.out.println("Aquesta posició ja està tocada\nApunta millor");
                } else if (dades[coordenadaDispararX][coordenadaDispararY] == ".") {
                    System.out.println("Aquesta posició ja ha estat introduïda i és aigüa\nApunta millor");
                } else {
                    System.out.println("Aigua");
                    dades[coordenadaDispararX][coordenadaDispararY] = ".";
                    disparsEfectuats++;
                }
                System.err.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPortes " + disparsEfectuats + " dispars efectuats");
                for (int i = 0; i < mapa.length; i++) {
                    System.out.println("  ");
                    for (int j = 0; j < mapa.length; j++) {
                        System.out.print(" " + mapa[i][j] + " ");
                    }
                }
            } else {
                System.err.println("==Error==\nIntrodueix unes coordenades valides");
            }
        }
        System.out.println("El vaixell ha estat enfonsat");
        // TODO code application logic here
    }
}
