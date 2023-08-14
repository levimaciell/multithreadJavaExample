import java.util.Arrays;
import java.util.List;

public class verificaNumerosPrimos {

    public static void main(String [] args){
        try{
            List<Integer> intList = Arrays.stream(args).map(Integer::parseInt).toList();

            List<Thread> threads = intList.stream().map(x -> (Runnable) () -> {
                if(verificarPrimo(x)){
                    System.out.println("O número " + x + " é primo!");
                }
                else{
                    System.out.println("O número " + x + " não é primo!");
                }
            }).toList().stream().map(Thread::new).toList();

            threads.forEach(Thread::run);

        }
        catch (NumberFormatException e){
            System.err.println("Devem ser informados números inteiros para o programa");
            System.err.println("Detalhes:" + e.getMessage());
        }

    }

    /**
     *
     * @param num
     * @return false if num % 2 == 0, true if num % 2 != 0
     *
     */
    public static boolean verificarPrimo(int num){
        double raiz = Math.sqrt(num);

        for(int i = 2; i <= raiz; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

}
