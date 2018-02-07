
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author edu
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] dades = new String[11][11];
        String[][] mapa = new String[11][11];
        String[][] dades2 = new String[11][11];
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
        int numVaixells = 3;
        boolean vaixell1 = false;
        boolean vaixell2 = false;
        boolean vaixell3 = false;
        int numVaixells2 = 1;
        boolean posicioBuida = false;
        int contadorTamanys = 0;
        int[] tamanyVaixells = new int[3];
        int contadorVaixell1 = 0;
        int contadorVaixell2 = 0;
        int contadorVaixell3 = 0;
        boolean menu = false;
        String mesVaixells2;
        boolean mesVaixells = false;
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
        System.out.println("\nBenvingut al\nBattleship\n==========");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j] + " ");
            }
        }
        System.out.println("Per a començar a jugar has d'introduïr 3 vaixells de mides diferents.");
        while (numVaixells != 0) {

            //Tamany
            System.out.println("Introdueix el vaixell " + numVaixells2 + ":\nDe quantes caselles el vols? (entre 2 i 4)");
            while (shipBoolean == false) {
                shipTamany = sc.nextInt();
                if (shipTamany == 2 || shipTamany == 3 || shipTamany == 4 && tamanyVaixells[0] != tamanyVaixells[1] && tamanyVaixells[1] != tamanyVaixells[2] && tamanyVaixells[2] != tamanyVaixells[0]) {
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
            while (posicioBuida == false) {
                if (shipTamany == 2) {
                    switch (direccio) {
                        case "h":
                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX][coordenadaY + 1] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                        case "v":

                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX + 1][coordenadaY] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                    }
                } else if (shipTamany == 3) {
                    switch (direccio) {
                        case "h":
                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX][coordenadaY + 1] == "O" || dades[coordenadaX][coordenadaY + 2] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                        case "v":

                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX + 1][coordenadaY] == "O" || dades[coordenadaX + 2][coordenadaY] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                    }
                } else if (shipTamany == 4) {
                    switch (direccio) {
                        case "h":
                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX][coordenadaY + 1] == "O" || dades[coordenadaX][coordenadaY + 2] == "O" || dades[coordenadaX][coordenadaY + 3] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                        case "v":

                            if (dades[coordenadaX][coordenadaY] == "O" || dades[coordenadaX + 1][coordenadaY] == "O" || dades[coordenadaX + 2][coordenadaY] == "O" || dades[coordenadaX + 3][coordenadaY] == "O") {
                                System.err.println("==Error==\nIntrodueix unes coordenades on no hi hagui cap vaixell");
                            } else {
                                posicioBuida = true;
                            }
                    }
                }
            }
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
                    if (shipTamany == 2 && coordenadaX <= 9 || shipTamany == 2 && coordenadaY <= 9) {
                        switch (direccio) {
                            case "h":
                                for (int i = 0; i < shipVert.length; i++) {
                                    for (int j = 0; j < shipVert[i].length; j++) {
                                        dades[coordenadaX][coordenadaY + i] = "O";
                                        dades2[coordenadaX][coordenadaY + i] = "2";
                                    }
                                }
                                break;
                            case "v":
                                for (int i = 0; i < shipHor.length; i++) {
                                    for (int j = 0; j < shipHor[i].length; j++) {
                                        dades[coordenadaX + j][coordenadaY] = "O";
                                        dades2[coordenadaX + j][coordenadaY] = "2";
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
                                        dades2[coordenadaX][coordenadaY + i] = "3";
                                    }
                                }
                                break;
                            case "v":
                                for (int i = 0; i < shipHor.length; i++) {
                                    for (int j = 0; j < shipHor[i].length; j++) {
                                        dades[coordenadaX + j][coordenadaY] = "O";
                                        dades[coordenadaX + j][coordenadaY] = "3";
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
                                        dades2[coordenadaX][coordenadaY + i] = "4";
                                    }
                                }
                                break;
                            case "v":
                                for (int i = 0; i < shipHor.length; i++) {
                                    for (int j = 0; j < shipHor[i].length; j++) {
                                        dades[coordenadaX + j][coordenadaY] = "O";
                                        dades2[coordenadaX + j][coordenadaY] = "O";
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
            contadorTamanys = contadorTamanys + shipTamany;

            System.out.println("Vols introduir un altre vaixell? (s/n)");
            mesVaixells2 = sc.next();
            //es reinicien les variables que es fan servir en el while, per aixi quan torni a entrar tots els valors seran nous
            direccioBoolean = false;
            shipBoolean = false;
            numVaixells--;
            coordenadesCorrecte = false;
            coordenadaX = 0;
            coordenadaY = 0;
            sc.nextLine();

        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nJugador 2:\nAra toca enfonsar els vaixells");
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("  ");
            for (int j = 0; j < mapa.length; j++) {
                System.out.print(" " + mapa[i][j] + " ");
            }
        }
        while (contadorTamanys != 0) {
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
                    if (dades2[coordenadaDispararX][coordenadaDispararY] == "2") {
                        contadorVaixell1++;
                        dades2[coordenadaDispararX][coordenadaDispararY] = null;
                        if (contadorVaixell1 == 2) {
                            System.out.println("Vaixell de dos posicions enfonsat");
                        }
                    } else if (dades2[coordenadaDispararX][coordenadaDispararY] == "3") {
                        contadorVaixell2++;
                        dades2[coordenadaDispararX][coordenadaDispararY] = null;
                        if (contadorVaixell2 == 3) {
                            System.out.println("El vaixell de tres posicions enfonsat");
                        }
                    } else if (dades2[coordenadaDispararX][coordenadaDispararY] == "4") {
                        contadorVaixell3++;
                        dades2[coordenadaDispararX][coordenadaDispararY] = null;
                        if (contadorVaixell3 == 4) {
                            System.out.println("Vaixell de quatre posicions enfonsat");
                        }
                    }
                    System.out.println("Tocat");
                    disparsEfectuats++;
                    mapa[coordenadaDispararX][coordenadaDispararY] = "X";
                    dades[coordenadaDispararX][coordenadaDispararY] = "X";
                    contadorTamanys--;
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
        if (contadorVaixell1 == 2 && contadorVaixell2 >= 3 && contadorVaixell3 >= 4) {
            System.out.println("Tots els vaixells han estat enfonsats");
        }
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
        // TODO code application logic here
    }
}
