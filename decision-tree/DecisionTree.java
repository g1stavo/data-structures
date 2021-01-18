package decisiontree;

import decisiontree.control.Controller;

public class DecisionTree {
    private static Controller controller;
   
    public static void main(String[] args) {
        Controller.getInstance().initialize();
    }  
}