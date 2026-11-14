import java.util.Scanner;

public class Main {
    private static String addCommand = "add Василий Петров " +
            "vasily.petrov@gmail.com +79787775747";
    private static String commandExamples = "\t" + addCommand + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static String commandError = "Wrong command! Available command examples: \n" +
            commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentStorage executor = new StudentStorage();
        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            try {
                // Проверка, что введено хоть что-то
                if (tokens.length == 0 || tokens[0].isEmpty()) {
                    System.out.println("Введите команду (help для списка команд)");
                    continue;
                }

                if (tokens[0].equals("add")) {
                    // Проверка, что есть аргумент для добавления
                    if (tokens.length < 2) {
                        System.out.println("Ошибка: укажите данные студента после 'add'");
                        continue;
                    }
                    executor.addStudent(tokens[1]);
                } else if (tokens[0].equals("list")) {
                    executor.listStudent();
                } else if (tokens[0].equals("get")) {
                    if (tokens.length < 2) {
                        System.out.println("Ошибка: укажите имя студента после 'get'");
                        continue;
                    }
                    Student student = executor.getStudentByName(tokens[1]);
                    if (student != null) {
                        System.out.println(student.toString());
                    } else {
                        System.out.println("Студент не найден");
                    }
                } else if (tokens[0].equals("remove")) {
                    if (tokens.length < 2) {
                        System.out.println("Ошибка: укажите имя студента после 'remove'");
                        continue;
                    }
                    executor.removeStudent(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                } else {
                    System.out.println(commandError);
                }
            } catch (Exception e) {

                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }}