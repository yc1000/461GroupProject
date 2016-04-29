package com.example.zack.pokepvp;
import java.util.Random;

public class BattleStateMachine {
    private Player p1;
    private Player p2;
    private boolean finish;
    private Player winner;
    private Player loser;

    public BattleStateMachine(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        finish = false;

    }

    public void selectPokemon(Player p){
        Pokemon pm = p.getInUse();
        boolean flag = false;
        for (Pokemon newpm : p.getPokemonTeam()){
            if (flag) {
                p.setInUse(newpm);
                return;
            }
            if (newpm.equals(pm))
                flag = true;
        }

    }

    private int calculateType(Attack atk, Pokemon defender){

    }

    public int calcuateDamage(Attack atk, Player attacker, Player defender){
        if (! attacker.getInUse().alive()) {

            return 0;
        }
        int power = Atk.getPower();
        int damage = (2 + 0.84 * attacker.getAttack() * power / defender.getDefense()) * calculateType() * (0.85 + Random.nextFloat(0.15));

        return damage;
    }

    public whatever whoGoesFirst(){

    }

    public void checkSync(){

    }

    public void surrender(Player p){
        finish = true;
        determineWinner(p);
    }

    public void determineWinner(){
        boolean p1l = true;
        boolean p2l = true;
        for (Pokemon pm : p1.getPokemonTeam()){
            if (pm.getHP() != 0) {
                p1l = false;
                break;
            }
        }

        for (Pokemon pm : p2.getPokemonTeam()){
            if (pm.getHP() != 0) {
                p2l = false;
                break;
            }
        }

        if (p1l)
             determineWinner(p1);
        if (p2l)
            determineWinner(p2);
    }

    public void determineWinner(Player p){
        if (p.equals(p1)){
            winner = p2;
            loser = p1;
        }else{
            winner = p1;
            loser = p2;
        }


    }
}
