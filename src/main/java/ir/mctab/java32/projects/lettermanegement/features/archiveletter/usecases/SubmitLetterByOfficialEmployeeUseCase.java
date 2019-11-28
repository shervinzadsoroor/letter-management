package ir.mctab.java32.projects.lettermanegement.features.archiveletter.usecases;

import ir.mctab.java32.projects.lettermanegement.core.annotations.UseCase;
import ir.mctab.java32.projects.lettermanegement.model.Letter;

@UseCase(code = "808")
public interface SubmitLetterByOfficialEmployeeUseCase {
    Letter submit(String title,
                  Long indicator,
                  String privacy,
                  String sender,
                  String submitDate
    )
            throws SubmitLetterByOfficialEmployeeFailedException;


    class SubmitLetterByOfficialEmployeeFailedException extends Exception {
        private String message;

        public SubmitLetterByOfficialEmployeeFailedException(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}


