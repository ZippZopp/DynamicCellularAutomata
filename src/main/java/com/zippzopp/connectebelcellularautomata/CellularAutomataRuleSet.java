package com.zippzopp.connectebelcellularautomata;

import com.zippzopp.connectebelcellularautomata.Worlds.BooleanWorld;

public enum CellularAutomataRuleSet {
    EMPTY,GAME_OF_LIVE;

    public void changeWorld(BooleanWorld oldBooleanWorld, BooleanWorld newBooleanWorld, int x, int y) {
        switch(this){
            case GAME_OF_LIVE -> gameOfLife(oldBooleanWorld, newBooleanWorld,x,y);
            // add new Rulesets here
        }
    }



    public static void gameOfLife(BooleanWorld oldBooleanWorld, BooleanWorld newBooleanWorld, int x, int y) {
        int liveNeighbors = 0;

        // Check all the neighbors around the cell
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip checking the cell itself
                if (i == 0 && j == 0) continue;
                // Check if the neighbor is alive
                if (oldBooleanWorld.doesElementExist(x + i, y + j)) {
                    liveNeighbors++;
                }
            }
        }
        // Apply the rules of Game of Life
        boolean isAlive = oldBooleanWorld.doesElementExist(x, y);
        boolean shouldLive = isAlive && (liveNeighbors == 2 || liveNeighbors == 3) ||
                !isAlive && liveNeighbors == 3;

        // Update the state in the new world
        newBooleanWorld.setValue(x, y, shouldLive);
    }

    public boolean isEmpty(){
        return this == EMPTY;
    }
}
