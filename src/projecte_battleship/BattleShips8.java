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
public class BattleShips8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] dades = new String[11][11];
        String[][] mapa = new String[11][11];
        System.out.println("hello");
        boolean shipBoolean = false;
        int shipTamany = 0;
        boolean direccioBoolean = false;
        String direccio = null;
        boolean coordenadesCorrecte = false;
        int coordenadaX = 0;
        int coordenadaY = 0;
        int coordenadaDispararX = 0;
        int coordenadaDispararY = 0;
        int disparsEfectuats = 0;
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
        System.out.println(" ____                                                         __      \n"
                + "/\\  _`\\                           __                         /\\ \\__   \n"
                + "\\ \\ \\L\\ \\     __    ___   __  __ /\\_\\    ___      __   __  __\\ \\ ,_\\  \n"
                + " \\ \\  _ <'  /'__`\\/' _ `\\/\\ \\/\\ \\\\/\\ \\ /' _ `\\  /'_ `\\/\\ \\/\\ \\\\ \\ \\/  \n"
                + "  \\ \\ \\L\\ \\/\\  __//\\ \\/\\ \\ \\ \\_/ |\\ \\ \\/\\ \\/\\ \\/\\ \\L\\ \\ \\ \\_\\ \\\\ \\ \\_ \n"
                + "   \\ \\____/\\ \\____\\ \\_\\ \\_\\ \\___/  \\ \\_\\ \\_\\ \\_\\ \\____ \\ \\____/ \\ \\__\\\n"
                + "    \\/___/  \\/____/\\/_/\\/_/\\/__/    \\/_/\\/_/\\/_/\\/___L\\ \\/___/   \\/__/\n"
                + "                                                  /\\____/             \n"
                + "                                                  \\_/__/              \n"
                + "        ___      \n"
                + "       /\\_ \\     \n"
                + "   __  \\//\\ \\    \n"
                + " /'__`\\  \\ \\ \\   \n"
                + "/\\ \\L\\.\\_ \\_\\ \\_ \n"
                + "\\ \\__/.\\_\\/\\____\\\n"
                + " \\/__/\\/_/\\/____/\n"
                + "                 \n"
                + "                 \n"
                + " ____              __    __    ___                   __                            \n"
                + "/\\  _`\\           /\\ \\__/\\ \\__/\\_ \\                 /\\ \\      __                   \n"
                + "\\ \\ \\L\\ \\     __  \\ \\ ,_\\ \\ ,_\\//\\ \\      __    ____\\ \\ \\___ /\\_\\  _____     ____  \n"
                + " \\ \\  _ <'  /'__`\\ \\ \\ \\/\\ \\ \\/ \\ \\ \\   /'__`\\ /',__\\\\ \\  _ `\\/\\ \\/\\ '__`\\  /',__\\ \n"
                + "  \\ \\ \\L\\ \\/\\ \\L\\.\\_\\ \\ \\_\\ \\ \\_ \\_\\ \\_/\\  __//\\__, `\\\\ \\ \\ \\ \\ \\ \\ \\ \\L\\ \\/\\__, `\\\n"
                + "   \\ \\____/\\ \\__/.\\_\\\\ \\__\\\\ \\__\\/\\____\\ \\____\\/\\____/ \\ \\_\\ \\_\\ \\_\\ \\ ,__/\\/\\____/\n"
                + "    \\/___/  \\/__/\\/_/ \\/__/ \\/__/\\/____/\\/____/\\/___/   \\/_/\\/_/\\/_/\\ \\ \\/  \\/___/ \n"
                + "                                                                     \\ \\_\\         \n"
                + "                                                                      \\/_/         ");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j] + " ");
            }
        }
        System.out.println("Introdueix el tamany del vaixell");
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
                if (shipTamany == 2 && coordenadaX <= 9 && shipTamany == 2 && coordenadaY <= 9) {

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
                } else if (shipTamany == 3 && coordenadaX <= 8 && shipTamany == 3 && coordenadaY <= 8) {

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
                } else if (shipTamany == 4 && coordenadaX < 6 && shipTamany == 4 && coordenadaY < 6) {

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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" _____                               __                         ___     \n"
                + "/\\___ \\                             /\\ \\                      /'___`\\   \n"
                + "\\/__/\\ \\  __  __     __      __     \\_\\ \\    ___   _ __      /\\_\\ /\\ \\  \n"
                + "   _\\ \\ \\/\\ \\/\\ \\  /'_ `\\  /'__`\\   /'_` \\  / __`\\/\\`'__\\    \\/_/// /__ \n"
                + "  /\\ \\_\\ \\ \\ \\_\\ \\/\\ \\L\\ \\/\\ \\L\\.\\_/\\ \\L\\ \\/\\ \\L\\ \\ \\ \\/        // /_\\ \\\n"
                + "  \\ \\____/\\ \\____/\\ \\____ \\ \\__/.\\_\\ \\___,_\\ \\____/\\ \\_\\       /\\______/\n"
                + "   \\/___/  \\/___/  \\/___L\\ \\/__/\\/_/\\/__,_ /\\/___/  \\/_/       \\/_____/ \n"
                + "                     /\\____/                                            \n"
                + "                     \\_/__/                                             ");
        System.out.println(" ____               ___                                   \n"
                + "/\\  _`\\           /'___\\                                  \n"
                + "\\ \\ \\L\\_\\    ___ /\\ \\__/  ___     ___     ____     __     \n"
                + " \\ \\  _\\L  /' _ `\\ \\ ,__\\/ __`\\ /' _ `\\  /',__\\  /'__`\\   \n"
                + "  \\ \\ \\L\\ \\/\\ \\/\\ \\ \\ \\_/\\ \\L\\ \\/\\ \\/\\ \\/\\__, `\\/\\ \\L\\.\\_ \n"
                + "   \\ \\____/\\ \\_\\ \\_\\ \\_\\\\ \\____/\\ \\_\\ \\_\\/\\____/\\ \\__/.\\_\\\n"
                + "    \\/___/  \\/_/\\/_/\\/_/ \\/___/  \\/_/\\/_/\\/___/  \\/__/\\/_/\n"
                + "                                                          \n"
                + "                                                          \n"
                + "      ___      \n"
                + "     /\\_ \\     \n"
                + "   __\\//\\ \\    \n"
                + " /'__`\\\\ \\ \\   \n"
                + "/\\  __/ \\_\\ \\_ \n"
                + "\\ \\____\\/\\____\\\n"
                + " \\/____/\\/____/\n"
                + "               \n"
                + "               \n"
                + "                                    ___    ___      \n"
                + "                  __               /\\_ \\  /\\_ \\     \n"
                + " __  __     __   /\\_\\   __  _    __\\//\\ \\ \\//\\ \\    \n"
                + "/\\ \\/\\ \\  /'__`\\ \\/\\ \\ /\\ \\/'\\ /'__`\\\\ \\ \\  \\ \\ \\   \n"
                + "\\ \\ \\_/ |/\\ \\L\\.\\_\\ \\ \\\\/>  <//\\  __/ \\_\\ \\_ \\_\\ \\_ \n"
                + " \\ \\___/ \\ \\__/.\\_\\\\ \\_\\/\\_/\\_\\ \\____\\/\\____\\/\\____\\\n"
                + "  \\/__/   \\/__/\\/_/ \\/_/\\//\\/_/\\/____/\\/____/\\/____/\n"
                + "                                                    \n"
                + "                                                    ");
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
                    System.out.println("Aquesta posició ja està enfonsada\nApunta millor");
                } else if (dades[coordenadaDispararX][coordenadaDispararY] == ".") {
                    System.out.println("Aquesta posició ja ha estat introduïda i és aigüa\nApunta millor");
                } else {
                    System.out.println("Aigua");
                    dades[coordenadaDispararX][coordenadaDispararY] = ".";
                    disparsEfectuats++;
                }
                System.err.println("Portes " + disparsEfectuats + " dispars efectuats");
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
        System.out.println("\nHas enfonsat el vaixell");
        System.out.println(" ____    ______   __  __  ______  __        \n"
                + "/\\  _`\\ /\\__  _\\ /\\ \\/\\ \\/\\  _  \\/\\ \\       \n"
                + "\\ \\ \\L\\_\\/_/\\ \\/ \\ \\ `\\\\ \\ \\ \\L\\ \\ \\ \\      \n"
                + " \\ \\  _\\/  \\ \\ \\  \\ \\ , ` \\ \\  __ \\ \\ \\  __ \n"
                + "  \\ \\ \\/    \\_\\ \\__\\ \\ \\`\\ \\ \\ \\/\\ \\ \\ \\L\\ \\\n"
                + "   \\ \\_\\    /\\_____\\\\ \\_\\ \\_\\ \\_\\ \\_\\ \\____/\n"
                + "    \\/_/    \\/_____/ \\/_/\\/_/\\/_/\\/_/\\/___/ \n"
                + "                                            \n"
                + "                                            \n"
                + " ____    ____    __        \n"
                + "/\\  _`\\ /\\  _`\\ /\\ \\       \n"
                + "\\ \\ \\/\\ \\ \\ \\L\\_\\ \\ \\      \n"
                + " \\ \\ \\ \\ \\ \\  _\\L\\ \\ \\  __ \n"
                + "  \\ \\ \\_\\ \\ \\ \\L\\ \\ \\ \\L\\ \\\n"
                + "   \\ \\____/\\ \\____/\\ \\____/\n"
                + "    \\/___/  \\/___/  \\/___/ \n"
                + "                           \n"
                + "                           \n"
                + " _____  _____   ____      \n"
                + "/\\___ \\/\\  __`\\/\\  _`\\    \n"
                + "\\/__/\\ \\ \\ \\/\\ \\ \\ \\/\\_\\  \n"
                + "   _\\ \\ \\ \\ \\ \\ \\ \\ \\/_/_ \n"
                + "  /\\ \\_\\ \\ \\ \\_\\ \\ \\ \\L\\ \\\n"
                + "  \\ \\____/\\ \\_____\\ \\____/\n"
                + "   \\/___/  \\/_____/\\/___/ \n"
                + "                          \n"
                + "                          ");
    }

}
