package com.em.utils;

import com.em.entity.basketPlayer;
import com.em.entity.handMadePlayer;
import com.em.entity.sportsBallPlayer;
import com.em.utils.entity.basketPosition;
import com.em.utils.entity.handBallPossition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class readerAndCalcs {

    List<sportsBallPlayer>basketPlayerList = new ArrayList<sportsBallPlayer>();
    List<sportsBallPlayer> handMadePlayerList = new ArrayList<sportsBallPlayer>();

    //Carpeta en sistema Windows
    final static String PATH = "C:/match";

    //Inicio de procesado de ficheros si existen en carpeta correspondiente al path
    public void readFromFolder() throws Exception {
        try{
            File folder = new File(PATH);
            File[] listOfFiles = folder.listFiles();
            if(listOfFiles != null) {
                for (File file : listOfFiles) {
                    //Se evalua si el fichero es de un partido de baloncesto o balonmano
                    if (file.isFile()) {
                        System.out.println(file.getName());
                        if (file.getName().contains("BASKET"))
                            //Se procesa el fichero de partido de baloncesto
                            processBasketFile(file);
                        else if (file.getName().contains("HANDBALL"))
                            //Se procesa el fichero de partido de baloncesto
                            processHandMadeFile(file);
                    }
                }
            }
        }catch(Exception e){
            throw new Exception("PROBLEMAS CON LA LECTURA DE ALGUN FICHERO");
        }finally{
            //despues de procesados los ficheros, se muestran los resultados de los calculos
            //para los dos tipos de deporte de balón
            presentBasketMPV();
            presentHandBallMPV();

        }
    }

    private void presentHandBallMPV() {
        Map<String, Integer> maxPoints = new HashMap<String, Integer>();
        handMadePlayerList.forEach(f->{
            if(maxPoints.get(f.getTeamName())==null){
                maxPoints.put(f.getTeamName(),f.getFinalScore());
            }else{
                int p = maxPoints.get(f.getTeamName())+f.getFinalScore();
                maxPoints.put(f.getTeamName(),p);
            }
        });
        Map.Entry<String, Integer> maxEntry = Collections.max(maxPoints.entrySet(), (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        String winTeam = maxEntry.getKey();
        System.out.println("El equipo con mayor puntuacion en balonmano es: "+maxEntry.getKey() +" con un total de puntos de: " +maxEntry.getValue() );
        Map<String, Integer> maxPoints2 = new HashMap<String, Integer>();
        handMadePlayerList.forEach(f->{
            if(maxPoints2.get(f.getNickname())==null){
                maxPoints2.put(f.getNickname(),f.getFinalScore());
            }else{
                int p = maxPoints2.get(f.getNickname())+f.getFinalScore();
                maxPoints2.put(f.getNickname(),p);
            }
        });
        Map.Entry<String, Integer> maxEntry2 = Collections.max(maxPoints2.entrySet(), (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        System.out.println("El jugador  con mayor puntuacion en balonmano es: "+maxEntry2.getKey() +" con un total de puntos de: " +maxEntry2.getValue()  );

        if(winTeam.equals(handMadePlayerList.stream()
                .filter(e-> e.getNickname().equals(maxEntry2.getKey())).findFirst().get().getTeamName()))
            System.out.println("Como pertenece al equipo ganador, ademas se lleva 10 puntos extra");

    }
    private void presentBasketMPV() {
        Map<String, Integer> maxPoints = new HashMap<String, Integer>();
        basketPlayerList.forEach(f->{
            if(maxPoints.get(f.getTeamName())==null){
                maxPoints.put(f.getTeamName(),f.getFinalScore());
            }else{
                int p = maxPoints.get(f.getTeamName())+f.getFinalScore();
                maxPoints.put(f.getTeamName(),p);
            }
        });
        Map.Entry<String, Integer> maxEntry = Collections.max(maxPoints.entrySet(), (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        String winTeam = maxEntry.getKey();
        System.out.println("El equipo  con mayor puntuacion en baloncesto es: "+maxEntry.getKey() +" con un total de puntos de: " +maxEntry.getValue() );

        Map<String, Integer> maxPoints2 = new HashMap<String, Integer>();
        basketPlayerList.forEach(f->{
            if(maxPoints2.get(f.getNickname())==null){
                maxPoints2.put(f.getNickname(),f.getFinalScore());
            }else{
                int p = maxPoints2.get(f.getNickname())+f.getFinalScore();
                maxPoints2.put(f.getNickname(),p);
            }
        });
        Map.Entry<String, Integer> maxEntry2 = Collections.max(maxPoints2.entrySet(), (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        System.out.println("El jugador  con mayor puntuacion en baloncesto es: "+maxEntry2.getKey() +" con un total de puntos de: " +maxEntry2.getValue()  );

        if(winTeam.equals(basketPlayerList.stream()
                .filter(e-> e.getNickname().equals(maxEntry2.getKey())).findFirst().get().getTeamName()))
            System.out.println("Como pertenece al equipo ganador, ademas se lleva 10 puntos extra");
    }

    public void processHandMadeFile(File file) throws FileNotFoundException {
        Scanner read = new Scanner (file);
        read.useDelimiter(";");
        String title, category, runningTime, year, price;
        //Se lee linea por linea y se calcula el resultado por jugador
        while (read.hasNext())
        {
            String playerName = read.next();
            String nickName = read.next();
            int number = read.nextInt();
            String teamName = read.next();
            String position = read.next();
            int goalsMade = read.nextInt();
            int goalsReceived = read.nextInt();
            //Se calcula el resultado teniendo en cuenta las tablas de calculos estaticas definidas en la aplicación
            int calculatedScore = handMadePlayerMatchScore(position,goalsMade,goalsReceived);
            this.handMadePlayerList.add(new handMadePlayer(playerName,nickName,number,teamName,position,calculatedScore,goalsMade,goalsReceived));
        }
        read.close();
    }

    public void processBasketFile(File file) throws FileNotFoundException {
        Scanner read = new Scanner (file);
        read.useDelimiter(";");
        //Se obtienen los jugadores del partido
        while (read.hasNext())
        {
            String playerName = read.next();
            String nickName = read.next();
            int number = read.nextInt();
            String teamName = read.next();
            String position = read.next();
            int scoredPoints = read.nextInt();
            int rebounds = read.nextInt();
            int assists = read.nextInt();
            int calculatedScore = BasketPlayerMatchScore(position,scoredPoints,rebounds,assists);
            this.basketPlayerList.add(new basketPlayer(playerName,nickName,number,teamName,position,scoredPoints,rebounds,assists,calculatedScore));
        }
        read.close();
    }
    //Calculos a partir de los valores obtenidos y los valores estaticos en funcion del tipo de jugador
    private static int BasketPlayerMatchScore(String position, int scoredPoints, int rebounds, int assists) {
            basketPosition posDef = (basketPosition) positionScores.BASKET_POSITIONS_DEFINITION_LIST.stream().filter(a -> a.getPossition().equals(position)).findFirst().orElse(null);
            return (scoredPoints*posDef.getScorePoint())+(rebounds*posDef.getRebound())+(assists*posDef.getAssist());

    };
    //Calculos a partir de los valores obtenidos y los valores estaticos en funcion del tipo de jugador
    private int handMadePlayerMatchScore(String position,int goalsMade, int goalsReceived) {
            handBallPossition posDef = (handBallPossition) positionScores.HANDBALL_POSITIONS_DEFINITION_LIST.stream().filter(a -> a.getPossition().equals(position)).findFirst().orElse(null);
            return goalsMade*posDef.getInitialRatingPoints()*posDef.getGoalMade()-goalsReceived*posDef.getGoalReceived();
    }
}