package com.cgi.wealth.lib.oops;

import lombok.Data;

@Data
final class Colony extends Community{
    private final int id;

    private boolean privateFlag;

    String communityVariable = "communityVariable";

    Colony(int id){
        super();
        this.id = id;
    }

    void layRoads(){
        if(this.isRoadsLaid()){
            System.out.println("Raids are not laid");
        }
    }

    void layRoads(boolean doIt){
        if(this.isRoadsLaid()){
            System.out.println("Raids are not laid");
        }
    }

    @Override
    protected boolean isDrinkingWaterRequired() {
        return true;
    }

}
