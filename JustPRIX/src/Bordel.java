import java.util.Random;
import java.util.SplittableRandom;

public class Bordel {
    int chance;
    int rdmB;
    int reponse;




    //----------------------------------CONSTRUCTEUR
    public Bordel(int chance) {
        this.chance = chance;
    }
//---------------------------------------ACCESSEURS

    public int getReponse() {
        return reponse;
    }

    public void setReponse(int reponse) {
        this.reponse = reponse;
    }

    public int getRdmB() {
        return rdmB;
    }

    public void setRdmB(int rdmB) {
        this.rdmB = rdmB;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    //-----------------------------------FONCTIONS

    public void initialisation(){

        Random obj = new Random();
        this.rdmB = obj.nextInt(100);



    }
    public String compteur(){
       setChance(getChance()-1);

       return "Il vous reste "+getChance()+" chances";
    }

    public String comparRep(){

        String leretour;


    if(reponse==getRdmB()){
        leretour="Vous avez gagné";

    }else{
        if(reponse<rdmB){
            leretour="C'est plus grand";
        }else{
            leretour="C'est plus petit";
        }
    }
    return leretour;
    }




    }

