public class Draw {
    public static void hangmanArt(int tries){

        try{
            if (tries == 4){
                System.out.print(" +---+\n      |\n      |\n      |\n     ===\n");
            }else if(tries == 3){
                System.out.print(" +---+\n O    |\n      |\n      |\n     ===\n");
            } else if (tries == 2){
                System.out.print(" +---+\n O    |\n |    |\n      |\n     ===\n");
            } else if (tries == 1){
                System.out.print(" +---+\n O    |\n |    |\n |    |\n    ===\n");
            } else{
                System.out.print(" +---+\n O    |\n |    |\n |    |\n |  ===\n");
            }
        }catch (Exception e){
            System.out.println("Something went wrong in Draw.hangmanArt() method.");
        }
    }
}
