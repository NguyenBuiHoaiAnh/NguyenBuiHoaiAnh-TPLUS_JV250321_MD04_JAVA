package entity;

import java.util.Scanner;

public class BookType {
    private int typeId;
    private String typeName;
    private String typeDescription;
    private boolean bookTypeStatus;

    public BookType() {
    }

    public BookType(int typeId, String typeName, String typeDescription, boolean bookTypeStatus) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.typeDescription = typeDescription;
        this.bookTypeStatus = bookTypeStatus;
    }

    // ----------------------------------------------------------------
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public boolean getBookTypeStatus() {
        return bookTypeStatus;
    }

    public void setBookTypeStatus(boolean bookTypeStatus) {
        this.bookTypeStatus = bookTypeStatus;
    }
    // -------------------------------------------------------------


    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Description: %s, Status: %b"
                ,this.typeId, this.typeName, this.typeDescription, this.bookTypeStatus);
    }
}
