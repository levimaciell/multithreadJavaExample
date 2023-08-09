import java.util.Arrays;
import java.util.List;

public class verificaNumerosPrimos {

    public static void main(String [] args){
        try{
            List<Integer> intList = Arrays.stream(args).map(Integer::parseInt).toList();

            List<Thread> threads = intList.stream().map(x -> (Runnable) () -> {
                if(verificarPrimo(x)){
                    System.out.println("O número " + x + " é par!");
                }
                else{
                    System.out.println("O número " + x + " é impar!");
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
     * @return true if num % 2 == 0, false if num % 2 != 0
     *
     */
    public static boolean verificarPrimo(int num){
        return num % 2 == 0;
    }

}
