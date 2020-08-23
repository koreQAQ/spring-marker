package org.example.spring.marker.web.exception;


import org.example.spring.marker.domain.Note;

/**
 * Created by lishubin on 2020/8/22 10:05 下午
 * @author lishubin
 */

public class DuplicateNoteException extends RuntimeException {

    private Note note;
    private String message;

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
