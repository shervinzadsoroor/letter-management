package ir.mctab.java32.projects.lettermanegement.features.archiveletter.impl;

import ir.mctab.java32.projects.lettermanegement.core.annotations.Service;
import ir.mctab.java32.projects.lettermanegement.features.archiveletter.usecases.SubmitLetterByOfficialEmployeeUseCase;
import ir.mctab.java32.projects.lettermanegement.model.Letter;

@Service
public class SubmitLetterByOfficialEmployeeUseCaseImpl implements SubmitLetterByOfficialEmployeeUseCase {

    public Letter submit(String title, Long indicator, String privacy, String sender, String submitDate) throws SubmitLetterByOfficialEmployeeFailedException {

        validate(title);

        Letter letter = new Letter(
                null,
                indicator,
                title,
                privacy,
                sender,
                submitDate
        );
        // Todo: insert into database
        insertIntoDatabase(letter);

        return letter;
    }

    private void insertIntoDatabase(Letter letter) {

    }

    private void validate(String title) throws SubmitLetterByOfficialEmployeeFailedException {
        if (title.length() <= 3) {
            throw new SubmitLetterByOfficialEmployeeFailedException(
                    "Title has to be more than 3 characters. "
            );
        }
    }
}
