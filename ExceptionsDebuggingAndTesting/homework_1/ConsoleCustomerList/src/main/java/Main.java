import java.util.Scanner;
import org.apache.logging.log4j.*;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String HELP_TEXT = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        logger.log(Level.ERROR, "Неправильно введенная команда");
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            try {
                String command = scanner.nextLine();
                String[] tokens = command.split("\\s+", 2);
                if(tokens[0].equals("add") && tokens.length == 1 || tokens[0].equals("remove") && tokens.length == 1){
                    throw new IllegalArgumentException("Wrong format. Input command: help");
                }else {
                    if (tokens[0].equals("add") ) {
                        executor.addCustomer(tokens[1]);
                        logger.info("Успешно добавлена новая запись");
                    } else if (tokens[0].equals("list")) {
                        executor.listCustomers();
                        logger.info("Успешно выведен список покупателей");
                    } else if (tokens[0].equals("remove")) {
                        executor.removeCustomer(tokens[1]);
                        logger.info("Успешно удалена запись");
                    } else if (tokens[0].equals("count")) {
                        System.out.println("There are " + executor.getCount() + " customers");
                        logger.info("Успешно выведено количество покупателей");
                    } else if (tokens[0].equals("help")) {
                        System.out.println(HELP_TEXT);
                    } else {
                        System.out.println(COMMAND_ERROR);
                    }
                }
            }catch (IllegalArgumentException e){
                logger.error(e.getMessage());
                System.out.println(e.getMessage());


            }
        }
    }
}
