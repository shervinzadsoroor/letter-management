package ir.mctab.java32.projects.lettermanegement;

import ir.mctab.java32.projects.lettermanegement.features.archiveletter.impl.SubmitLetterByOfficialEmployeeUseCaseImpl;
import ir.mctab.java32.projects.lettermanegement.features.archiveletter.usecases.SubmitLetterByOfficialEmployeeUseCase;
import ir.mctab.java32.projects.lettermanegement.model.Letter;

import java.util.Scanner;

public class LetterManagementApplication {

    public static void main(String[] args) {

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (! exit) {

            System.out.println("what do you want?");
            String command = scanner.nextLine();

            if (command.equals("exit")) {
                exit = true;
            }

            if (command.equals("submit")) {
                SubmitLetterByOfficialEmployeeUseCase submitLetterByOfficialEmployeeUseCase
                        = new SubmitLetterByOfficialEmployeeUseCaseImpl();
                System.out.println("Title: ");
                String title = scanner.nextLine();
                System.out.println("Indicator: ");
                Long indicator = Long.parseLong(scanner.nextLine());
                System.out.println("Sender: ");
                String sender = scanner.nextLine();
                System.out.println("Submit Date[YYYY-MM-DD]: ");
                String submitDate = scanner.nextLine();
                System.out.println("Privacy[Public|Private]: ");
                String privacy = scanner.nextLine();

                try {
                    Letter letter = submitLetterByOfficialEmployeeUseCase.submit(
                          title,
                          indicator,
                          privacy,
                          sender,
                          submitDate
                    );
                    System.out.println(letter);
                } catch (SubmitLetterByOfficialEmployeeUseCase.SubmitLetterByOfficialEmployeeFailedException e) {
                    // e.printStackTrace();
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }

    }
}
