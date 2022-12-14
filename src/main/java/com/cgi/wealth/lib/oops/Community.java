package com.cgi.wealth.lib.oops;

/***
 * There is no protected classes in Java
 * Abstract class is class with incomplete implementations
 * Only extend one abstract class
 * A class can not be both abstract and final
 * A abstract method can not be private
 * A abstract class can not be instantiated
 * Default constructor is created by JVM if there is no constructor defined
 *
 */


abstract class Community implements Sociology, Anthropology {
    String communityVariable;

    Community(){

    }

    /**
    To pass value into object state
     */
    protected Community(String communityVariable) {
        this.communityVariable = communityVariable;
    }


    protected boolean isRoadsLaid(){
       return false;
    }

    protected abstract boolean isDrinkingWaterRequired();

    @Override
    public void doHumanStudy() {
        Sociology.super.defaultStudy();
        Sociology.super.secondDefaultStudy();
        Sociology.staticStudy();
        Anthropology.super.defaultStudy();
        Anthropology.super.secondDefaultStudy();
        Anthropology.staticStudy();
        System.out.println("Do Human study");
    }

    @Override
    public void defaultStudy() {
        Sociology.super.defaultStudy();
    }

    @Override
    public void secondDefaultStudy() {
        Anthropology.super.secondDefaultStudy();
    }
}
